package org.skypro.skyshop_2_0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop_2_0.model.product.Product;
import org.skypro.skyshop_2_0.model.product.SimpleProduct;
import org.skypro.skyshop_2_0.model.search.SearchResult;
import org.skypro.skyshop_2_0.model.search.Searchable;
import org.skypro.skyshop_2_0.service.SearchService;
import org.skypro.skyshop_2_0.service.StorageService;

import java.util.Set;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void testSearchWithProductsInStorage() {
        String searchTerm = "Product";
        Product product = new SimpleProduct(UUID.randomUUID(), "Product", 50);
        when(storageService.getSearchableCollection()).thenReturn(Set.of(product));
        Set<Searchable> searchableSet = Set.of(product);
        when(storageService.getSearchableCollection()).thenReturn(searchableSet);
        Set<SearchResult> results = searchService.search(searchTerm);
        Assertions.assertEquals(1, results.size());
        SearchResult result = results.iterator().next();
        Assertions.assertEquals(product.getID().toString(), result.getId().toString()); // идея не хотела сравнивать два id в формате UUID
        Assertions.assertEquals("Product", result.getName());
    }

    @Test
    void testSearchWithEmptyStorage() {
        String searchTerm = "Product";
        when(storageService.getSearchableCollection()).thenReturn(Set.of());
        Set<SearchResult> results = searchService.search(searchTerm);
        Assertions.assertTrue(results.isEmpty(), "Хранилище пустое");
    }

    @Test
    void testSearchWithWrongSearchTerm() {
        String searchTerm = "pistachio";
        when(storageService.getSearchableCollection()).thenReturn(Set.of());
        Set<SearchResult> results = searchService.search(searchTerm);
        Assertions.assertTrue(results.isEmpty(), "Такого продука нет в хранилище.");
    }
}


