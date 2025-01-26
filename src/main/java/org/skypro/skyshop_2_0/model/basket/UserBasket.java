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
        return total;
    }

    public List<BasketItem> getUserBasket() {
        return userBasket;
    }

    public int countTotal() {
        return total = Math.toIntExact(userBasket.stream()
                .flatMapToInt(t -> IntStream.of((t.getProduct().getPrice() * t.getAmt())))
                .sum());
    }
}
