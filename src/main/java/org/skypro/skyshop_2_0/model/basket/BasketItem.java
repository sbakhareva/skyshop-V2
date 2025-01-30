package org.skypro.skyshop_2_0.model.basket;

import org.skypro.skyshop_2_0.model.product.Product;

public final class BasketItem {

    private final Product product;
    private final int amt;

    public BasketItem(Product product, int amt) {
        this.product = product;
        this.amt = amt;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmt() {
        return amt;
    }
}

