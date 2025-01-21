package org.skypro.skyshop_2_0.model.product;

import org.skypro.skyshop_2_0.model.product.Product;

import java.util.UUID;

public class DiscountedProduct extends Product {
    int basePrice;
    int discount;

    public DiscountedProduct(UUID id, String productName, int price, int discount){
        super(id, productName);
        if (price <= 0 || (discount < 0 || discount > 100)) {
            throw new IllegalArgumentException("Неверное значение цены и/или скидки!");
        } else {
            this.discount = discount;
            this.basePrice = price;
        }
    }

    @Override
    public int getPrice() {
        return (int) (basePrice - (basePrice * (this.discount / 100f)));
    }

    public void setPrice(int basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getProductName() + ": " + getPrice() + ", скидка " + discount + "%.";
    }
}
