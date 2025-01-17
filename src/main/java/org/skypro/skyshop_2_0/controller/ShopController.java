package org.skypro.skyshop_2_0.controller;
import org.skypro.skyshop_2_0.model.article.Article;
import org.skypro.skyshop_2_0.model.product.Product;
import org.skypro.skyshop_2_0.model.search.SearchResult;
import org.skypro.skyshop_2_0.service.SearchService;
import org.skypro.skyshop_2_0.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;

    public ShopController(StorageService storageService, SearchService searchService) {
        this.storageService = storageService;
        this.searchService = searchService;
    }

    @GetMapping("/products")
    public Map<UUID, Product> getAllProducts() {
        return storageService.getProducts();
    }

    @GetMapping("/articles")
    public Map<UUID, Article> getAllArticles() {
        return storageService.getArticles();
    }

    @GetMapping("/search")
    public Set<SearchResult> search(String pattern) {
        return searchService.search(pattern);
    }
}
