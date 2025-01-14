package org.skypro.skyshop_2_0.service;

import org.skypro.skyshop_2_0.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private Map<UUID, Product> products;
    private Map<UUID, Article> articles;

    public StorageService() {
        this.products = new HashMap<>() {{
            addProduct(new SimpleProduct(UUID.randomUUID(), "Творог", 120));
            addProduct(new DiscountedProduct(UUID.randomUUID(), "Сметана", 98, 20));
            addProduct(new FixPriceProduct(UUID.randomUUID(), "Крем для рук"));
            addProduct(new SimpleProduct(UUID.randomUUID(), "Варенье вишневое", 75));
            addProduct(new DiscountedProduct(UUID.randomUUID(), "Пппирог с малиной", 300, 20));
        }};
        this.articles = new HashMap<>() {{
            addArticle(new Article(UUID.randomUUID(), "Омлет с ветчиной", "Приготовлен из яиц и ветчины."));
            addArticle(new Article(UUID.randomUUID(), "Заголовок", "Текст"));
            addArticle(new Article(UUID.randomUUID(), "Статья про баклажаны", "Описание баклажанов"));
        }};
    }

    public Map<UUID, Product> returnProducts() {
        return products;
    }

    public Map<UUID, Article> returnArticles() {
        return articles;
    }

    private void addProduct(Product product) {
        UUID id = product.getID();
        products.put(id, product);
    }

    private void addArticle(Article article) {
        UUID id = article.getID();
        articles.put(id, article);
    }
}
