package org.skypro.skyshop_2_0.service;

import org.skypro.skyshop_2_0.model.basket.BasketItem;
import org.skypro.skyshop_2_0.model.basket.ProductBasket;
import org.skypro.skyshop_2_0.model.basket.UserBasket;
import org.skypro.skyshop_2_0.model.product.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class BasketService {

    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public ProductBasket getProductBasket() {
        return productBasket;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public void addProductByID(UUID id) {
        Optional<Product> product = storageService.getProductById(id);
        if (product.isPresent()) {
            productBasket.addProduct(id);
        } else {
            throw new IllegalArgumentException("parameter is null");
        }
    }

    public List<UserBasket> getUserBasket() {
        List<BasketItem> basketItems = productBasket.getAllProducts().entrySet().stream()
                .map(item -> new BasketItem(storageService.getProducts().get(item.getKey()), item.getValue()))
                .toList();
        List<UserBasket> userBasket = Collections.singletonList(new UserBasket(basketItems));
        return userBasket;
    }
}
