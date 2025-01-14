package org.skypro.skyshop_2_0.service;

import org.skypro.skyshop_2_0.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products;
    private final Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>();
        addProduct(new SimpleProduct(UUID.randomUUID(), "Творог", 120));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Сметана", 98, 20));
        addProduct(new FixPriceProduct(UUID.randomUUID(), "Крем для рук"));
        addProduct(new SimpleProduct(UUID.randomUUID(), "Варенье вишневое", 75));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Пппирог с малиной", 300, 20));

        this.articles = new HashMap<>();
        addArticle(new Article(UUID.randomUUID(), "Омлет с ветчиной", "Приготовлен из яиц и ветчины."));
        addArticle(new Article(UUID.randomUUID(), "Заголовок", "Текст"));
        addArticle(new Article(UUID.randomUUID(), "Статья про баклажаны", "Описание баклажанов"));
    }

    public Map<UUID, Product> getProducts() {
        return products;
    }

    public Map<UUID, Article> getArticles() {
        return articles;
    }

    private void addProduct(Product product) {
        UUID id = product.getID();
        String productName = product.getProductName();
        int price = product.getPrice();
        products.put(id, product);
    }

    private void addArticle(Article article) {
        UUID id = article.getID();
        String title = article.getTitle();
        String text = article.getText();
        articles.put(id, article);
    }
}
