package org.skypro.skyshop_2_0.model.basket;

import java.util.List;
import java.util.stream.IntStream;

public final class UserBasket {
    private final List<BasketItem> userBasket;
    private int total;


    public UserBasket(List<BasketItem> basketItem) {
        this.userBasket = basketItem;
    }

    public int getTotal() {
        return countTotal();
    }

    public List<BasketItem> getUserBasket() {
        return userBasket;
    }

    public int countTotal() {
        return total = userBasket.stream()
                .mapToInt(p -> {
                    int price = p.getProduct().getPrice();
                    int atm = p.getAmt();
                    return price * atm;
                })
                .sum();
    }
}
