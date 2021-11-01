package com.kodluyoruz.weekFourHomework.service;


import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.BasketItem;
import com.kodluyoruz.weekFourHomework.model.request.AddUpdateBasketRequest;
import com.kodluyoruz.weekFourHomework.repository.BasketRepository;
import com.kodluyoruz.weekFourHomework.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.kodluyoruz.weekFourHomework.model.mapper.BasketMapper.BASKET_MAPPER;

@Service
@RequiredArgsConstructor
public class BasketService {
    private final BasketRepository basketRepository;
    private final ItemRepository itemRepository;
    private final ProductService productService;

    protected Basket createBasket(Integer userId){
        Basket basket = Basket.builder().userId(userId).build();
        return basketRepository.save(basket);

    }
    public BasketDto getBasket(AddUpdateBasketRequest request) {
        Basket basket = getBasketEntity(request.getUserId());
        return BASKET_MAPPER.basketToBasketDto(basket);
    }

    protected Basket getBasketEntity(Integer userId) {
        return basketRepository.findByUserIdEquals(userId).orElseThrow(
                () -> new NotFoundException("user ID not found")
        );
    }

    protected Basket removeAllBasketItem(Integer userId) {
        Basket basketDb =  basketRepository.findByUserIdEquals(userId).orElseThrow(
                () -> new NotFoundException("user ID not found")
        );
        basketDb.getBasketItems().clear();
        return basketRepository.save(basketDb);
    }

    public BasketDto putBasket(AddUpdateBasketRequest addUpdateBasketRequest) {
        basketRequestValid(addUpdateBasketRequest);
        Basket basketAddRequest = BASKET_MAPPER.requestToBasket(addUpdateBasketRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(addUpdateBasketRequest.getUserId()).get();
        basketDb.getBasketItems().clear();
        basketDb.getBasketItems().addAll(basketAddRequest.getBasketItems()); //setItems(basketAddRequest.getItems());
        basketDb.getBasketItems().stream().forEach(item ->item.setBasketId(basketDb.getId()) );
        return BASKET_MAPPER.basketToBasketDto(basketRepository.save(basketDb));

    }

    private void isProductsExist(List<Integer> productsId) {

        for (Integer productId:productsId) {
            if (!productService.checkProduct(productId)){
                throw new NotFoundException("Prodcut Not Found : " + productId);
            }
        }


    }

    private void basketRequestValid(AddUpdateBasketRequest request) {
        basketRepository.findByUserIdEquals(
                request.getUserId()).orElseThrow(() -> new NotFoundException("User not found"));
        isProductsExist(request.getBasketItems().stream()
                .map(item -> item.getProductId())
                .collect(Collectors.toList()));
    }


    public BasketDto addBasket(AddUpdateBasketRequest addRequest){
        basketRequestValid(addRequest);
        Basket basketAddRequest = BASKET_MAPPER.requestToBasket(addRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(addRequest.getUserId()).get();

        for (BasketItem basketItemRequest :basketAddRequest.getBasketItems()){
            Optional<BasketItem> isItemEqual =basketDb.getBasketItems().stream()
                    .filter(item -> item.getProductId() == basketItemRequest.getProductId())
                    .findFirst();
            if (isItemEqual.isPresent()) {
                isItemEqual.get().setQuantity(isItemEqual.get().getQuantity() + basketItemRequest.getQuantity());
            }else{
                basketItemRequest.setBasketId(basketDb.getId());
                basketDb.getBasketItems().add(basketItemRequest);
            }
        }
        return BASKET_MAPPER.basketToBasketDto(basketRepository.save(basketDb));
    }

    public BasketDto removeItemFromBasket(AddUpdateBasketRequest removeRequest){
        basketRequestValid(removeRequest);
        Basket basketRemoveRequest = BASKET_MAPPER.requestToBasket(removeRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(removeRequest.getUserId()).get();
        for (BasketItem basketItemRequest :basketRemoveRequest.getBasketItems()) {
            Optional<BasketItem> isQuantitylessZero = basketDb.getBasketItems().stream()
                    .filter(item -> item.getProductId() == basketItemRequest.getProductId() )
                    .peek(item -> item.setQuantity(item.getQuantity() - basketItemRequest.getQuantity()))
                    .filter(item -> item.getQuantity() <= 0)
                    .findFirst();//basketDb.getItems().remove(item)
            isQuantitylessZero.ifPresent(item -> basketDb.getBasketItems().remove(item));

        }
        return BASKET_MAPPER.basketToBasketDto(basketRepository.save(basketDb));
    }
}
