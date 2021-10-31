package com.kodluyoruz.weekFourHomework.service;

import com.kodluyoruz.weekFourHomework.exceptions.errors.UnsuccessfulProcces;
import com.kodluyoruz.weekFourHomework.model.Bill;
import com.kodluyoruz.weekFourHomework.model.dto.CheckoutDto;
import com.kodluyoruz.weekFourHomework.model.entity.Basket;
import com.kodluyoruz.weekFourHomework.model.entity.Item;
import com.kodluyoruz.weekFourHomework.model.entity.Order;
import com.kodluyoruz.weekFourHomework.model.entity.User;
import com.kodluyoruz.weekFourHomework.model.request.CheckoutRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.kodluyoruz.weekFourHomework.model.mapper.CheckoutMapper.CHECKOUT_MAPPER;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final UserService userService;
    private final OrderService orderService;


    public CheckoutDto checkoutBasket(CheckoutRequest checkoutRequest) {
        Bill bill = createBill(checkoutRequest);
        CheckoutDto checkoutDto = CHECKOUT_MAPPER.billToCheckoutDto(bill);
        return checkoutDto;
    }

    private Bill createBill(CheckoutRequest checkoutRequest) {
        User user = userService.getUserEntity(checkoutRequest.getUserId());
        Bill bill = CHECKOUT_MAPPER.BasketToBill(user.getBasket());
        bill.setPrice(calculatePriceAndDiscounts(user.getBasket()));
        return bill;
    }

    private double calculatePriceAndDiscounts(Basket basket){
        double total = 0;
        for (Item item: basket.getItems()) {
            total += (double)item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    public Order pay(CheckoutRequest checkoutRequest) throws UnsuccessfulProcces {
        Bill bill = createBill(checkoutRequest);
        Order order;
        if (payservice(bill)){
            order = orderService.createOrder(bill);
            User user = userService.getUserEntity(bill.getUserId());
            user.getBasket().setItems(null);
            userService.updateUserEntity(user);
        }
        else {
            throw (new UnsuccessfulProcces());
        }
        return order;
    }

    public boolean payservice(Bill bill){
        return true;
    }
}
