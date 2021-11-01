package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.model.entity.*;
import com.kodluyoruz.weekFourHomework.repository.BasketRepository;
import com.kodluyoruz.weekFourHomework.repository.CategoryRepository;
import com.kodluyoruz.weekFourHomework.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    int num = 3000;
    public Basket test(Integer id){
        Basket basket;
//        basket = basketRepository.getById(id);
//
//        basket = basketRepository.findById(id).get();
//        User user = basket.getUser();

        basket = basketRepository.findByUserIdEquals(id).get();
       List<Item> items = basket.getItems();
        basket.getItems().clear();

        basket.getItems().add(Item.builder().quantity(1955).productId(2).build());

       // basket.getItems().remove(0);
        //basket.setItems(null);
//       basketRepository.save(basket);


//        Item addItem = Item.builder().productId(2).quantity(num).build();
//        items.add(addItem);
//        items.remove(0);
//        List<Item> items2 = basket.getItems();
//        addItem.setQuantity(num+10);
//        Item addItem2 = Item.builder().productId(2).quantity(num).build();
//        addItem2.setQuantity(num+20);
//        basket.getItems().add(addItem2);



//        items.add(Item.builder().quantity(5890).productId(2).build());
//        items.add(Item.builder().quantity(9800).productId(2).build());
//
//
//        //basket.setItems(items);
//        items.remove(1);
//        items.remove(2);
//        items.removeAll(items);
//        List<Item> item2 = basket.getItems();
//
//        Integer kk = basket.getUserId();
//        kk = Integer.valueOf(2);
//
//        kk = basket.getUserId();
//        kk = 2;
//
//        String ismi = basket.getUser().getMail();
//        ismi = ismi.toUpperCase();
//        String ismi2 = "kemalettinString";
//        basket.getUser().setName(ismi2);










        return null;
    }

    public Product testPro(Integer id){
//        Product product =  productRepository.getById(id);
//        Category category = product.getCategory();
//        String str = category.getName();

//        Category category =  categoryRepository.getById(id);
//        List<Product> products  =  category.getProducts();
//        String str1 = category.getName();
//        String str2 = products.get(0).getName();
        Category newCat3 = categoryRepository.findById(23).get();
        Category category = new Category(null,"catEkledim", null,null,null,null);
        Category newCat1 = categoryRepository.save(category);
        newCat3 = categoryRepository.findById(newCat1.getId()).get();
        Product product = new Product(null,"benEkledimPro","disccrt",9.9,null, 1, null);
        newCat1.getProducts().add(product);
        Category newCat2 = categoryRepository.save(newCat1);

        return null;

    }


}
