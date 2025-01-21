package org.skypro.skyshop_2_0.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop_2_0.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private String productName;
    private final UUID id;

    public Product(UUID id, String productName) {
        this.id = id;
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        } else this.productName = productName;
    }

    public void setProductName(String productName) {
        if (productName.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым!");
        } else this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override @JsonIgnore
    public String getSearchTerm() {
        return productName;
    }

    @Override @JsonIgnore
    public String getObjName() {
        return productName;
    }

    @Override @JsonIgnore
    public String getType() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }

    @Override
    public UUID getID() {
        return this.id;
    }
}
