package org.skypro.skyshop_2_0.controller;

import org.skypro.skyshop_2_0.model.Article;
import org.skypro.skyshop_2_0.model.Product;
import org.skypro.skyshop_2_0.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class ShopController {
    private final StorageService storageService = null;

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts(){
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles() {
        return storageService.getArticles();
    }
}
