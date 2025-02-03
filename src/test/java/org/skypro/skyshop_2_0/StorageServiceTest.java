package org.skypro.skyshop_2_0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop_2_0.model.article.Article;
import org.skypro.skyshop_2_0.model.product.Product;
import org.skypro.skyshop_2_0.model.product.SimpleProduct;
import org.skypro.skyshop_2_0.service.StorageService;

import java.util.Map;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
public class StorageServiceTest {

    @Mock
    private Map<UUID, Product> products;

    @Mock
    private Map<UUID, Article> articles;

    @InjectMocks
    private StorageService storageService;

    @Test
    void addProductsTest() {
    }
}
