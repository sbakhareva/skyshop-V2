package org.skypro.skyshop_2_0.controller;

import org.skypro.skyshop_2_0.model.article.Article;
import org.skypro.skyshop_2_0.model.product.Product;
import org.skypro.skyshop_2_0.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
public class ShopController {
    private final StorageService storageService;

    public ShopController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles() {
        return storageService.getArticles();
    }
}
