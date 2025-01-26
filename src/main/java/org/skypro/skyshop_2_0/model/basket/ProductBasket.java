package org.skypro.skyshop_2_0.model.basket;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@SessionScope
public class ProductBasket {

    private final Map<UUID, Integer> productBasket;


    public ProductBasket(Map<UUID, Integer> productBasket) {
        this.productBasket = productBasket;
    }

    public Map<UUID, Integer> getProductBasket() {
        return productBasket;
    }

    public void addProduct(UUID id) {
        int counter = 1;
        if (productBasket.containsKey(id)) {
            productBasket.put(id, ++counter);
        } else {
            productBasket.put(id, counter);
        }
    }

    public Map<UUID, Integer> getAllProducts() {
        return Collections.unmodifiableMap(productBasket);
    }
}
