package org.skypro.skyshop_2_0.model;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIXPRICE = 75;

    public FixPriceProduct(UUID id, String productName) {
        super(id, productName);
    }

    @Override
    public int getPrice() {
        return FIXPRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String toString() {
        return getProductName() + ", фиксированная цена: " + getPrice();
    }
}
