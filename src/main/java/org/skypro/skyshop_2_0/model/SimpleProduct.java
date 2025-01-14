package org.skypro.skyshop_2_0.model;

import java.util.Objects;
import java.util.UUID;

public class SimpleProduct extends Product {
    int price;

    public SimpleProduct(UUID id, String productName, int price) {
        super(id, productName);
        if (price <= 0) {
            throw new IllegalArgumentException();
        } else this.price = price;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleProduct that = (SimpleProduct) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
