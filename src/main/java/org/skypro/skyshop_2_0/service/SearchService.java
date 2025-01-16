package org.skypro.skyshop_2_0.service;

import org.skypro.skyshop_2_0.model.search.SearchResult;
import org.skypro.skyshop_2_0.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<Searchable> search(String search) {
        Set<SearchResult> searchResults = new HashSet<>();
        Set<Searchable> searchResults2 = storageService.getSearchableCollection().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().replace(" ", "")
                        .contains(search.toLowerCase().replace(" ", "")))
                .collect(Collectors.toCollection(HashSet::new));
        return searchResults2;
    }
}
