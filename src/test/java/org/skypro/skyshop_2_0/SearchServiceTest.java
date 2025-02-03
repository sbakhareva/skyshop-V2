package org.skypro.skyshop_2_0;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop_2_0.service.SearchService;
import org.skypro.skyshop_2_0.service.StorageService;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    @Mock
    private StorageService storageService;

    @InjectMocks
    private SearchService searchService;

    @Test
    void testWithProductsInStorage() {
    }

    @Test
    void testWithNoProductsInStorage() {

    }

    @Test
    void testWithWrongSearchTerm() {
    }
}


