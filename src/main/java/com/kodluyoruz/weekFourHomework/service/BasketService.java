package com.kodluyoruz.weekFourHomework.service;


import com.kodluyoruz.weekFourHomework.exceptions.errors.NotFoundException;
import com.kodluyoruz.weekFourHomework.model.dto.BasketDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Item;
import com.kodluyoruz.weekFourHomework.model.entity.Product;
import com.kodluyoruz.weekFourHomework.model.request.AddUpdateBasketRequest;
import com.kodluyoruz.weekFourHomework.repository.BasketRepository;
import com.kodluyoruz.weekFourHomework.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    protected Basket getBasketEntity(int userId) {
        return basketRepository.findByUserIdEquals(userId).orElseThrow(
                () -> new NotFoundException("user ID not found")
        );
    }

    public BasketDto putBasket(AddUpdateBasketRequest addUpdateBasketRequest) {
        basketRequestValid(addUpdateBasketRequest);
        Basket basketAddRequest = BASKET_MAPPER.requestToBasket(addUpdateBasketRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(addUpdateBasketRequest.getUserId()).get();
        basketDb.setItems(basketAddRequest.getItems());
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
        isProductsExist(request.getItems().stream()
                .map(item -> item.getProductId())
                .collect(Collectors.toList()));



    }


    public BasketDto addBasket(AddUpdateBasketRequest addRequest){
        basketRequestValid(addRequest);
        Basket basketAddRequest = BASKET_MAPPER.requestToBasket(addRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(addRequest.getUserId()).get();

        for (Item itemRequest:basketAddRequest.getItems()){
            for (Item itemDb:basketDb.getItems()) {
                if(itemRequest.getProductId() == itemDb.getProductId())
                    itemDb.setQuantity(itemDb.getQuantity() + itemRequest.getQuantity());
                else
                    basketDb.getItems().add(itemRequest);
            }
        }
        return BASKET_MAPPER.basketToBasketDto(basketRepository.save(basketDb));
    }

    public BasketDto removeItemFromBasket(AddUpdateBasketRequest removeRequest){
        basketRequestValid(removeRequest);
        Basket basketRemoveRequest = BASKET_MAPPER.requestToBasket(removeRequest);
        Basket basketDb = basketRepository.findByUserIdEquals(removeRequest.getUserId()).get();
        for (Item itemRequest:basketRemoveRequest.getItems()) {
            for (Item itemBasket:basketDb.getItems()) {
                if (itemBasket.getProductId() == itemRequest.getProductId())
                    basketDb.getItems().remove(itemBasket);
            }
        }
        return BASKET_MAPPER.basketToBasketDto(basketRepository.save(basketDb));
    }
}
