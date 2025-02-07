package org.skypro.skyshop_2_0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop_2_0.model.article.Article;
import org.skypro.skyshop_2_0.model.basket.BasketItem;
import org.skypro.skyshop_2_0.model.basket.ProductBasket;
import org.skypro.skyshop_2_0.model.basket.UserBasket;
import org.skypro.skyshop_2_0.model.errors.NoSuchProductException;
import org.skypro.skyshop_2_0.model.product.Product;
import org.skypro.skyshop_2_0.model.product.SimpleProduct;
import org.skypro.skyshop_2_0.service.BasketService;
import org.skypro.skyshop_2_0.service.StorageService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {
    @Mock
    private ProductBasket productBasket;
    @Mock
    private StorageService storageService;
    @InjectMocks
    private BasketService basketService;

    @Test
    void addNonExistentProductTest() {
        Product nonExistentProduct = new SimpleProduct(UUID.randomUUID(), "pistachio", 50);
        when(storageService.getProductById(nonExistentProduct.getID())).thenReturn(Optional.empty());
        Assertions.assertThrows(NoSuchProductException.class, () -> basketService.addProductByID(nonExistentProduct.getID()));
    }

    @Test
    void addExistingProductTest() {
        Product product = new SimpleProduct(UUID.randomUUID(), "milk", 50);
        when(storageService.getProductById(product.getID())).thenReturn(Optional.of(product));
        basketService.addProductByID(product.getID());
        Mockito.verify(productBasket).addProduct(product.getID());
    }

    @Test
    void getUserBasket_WhenBasketIsEmpty() {
        when(productBasket.getAllProducts()).thenReturn(Collections.EMPTY_MAP);
        UserBasket userBasket = basketService.getUserBasket();
        Assertions.assertTrue(userBasket.getUserBasket().isEmpty());
    }

    @Test
    void getUserBasket_WhenThereAreProductsInIt() {
        Product pistachio = new SimpleProduct(UUID.randomUUID(), "pistachio", 50);
        when(storageService.getProductById(pistachio.getID())).thenReturn(Optional.of(pistachio));
        basketService.addProductByID(pistachio.getID());
        Mockito.verify(productBasket).addProduct(pistachio.getID());
        UserBasket userBasket = basketService.getUserBasket();
        Assertions.assertEquals(basketService.getProductBasket().getProductBasket().size(), userBasket.getUserBasket().size());
    }
}
