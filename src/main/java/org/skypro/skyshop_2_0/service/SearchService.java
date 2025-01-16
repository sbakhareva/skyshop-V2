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

    public Set<SearchResult> search(String search) {
        Set<SearchResult> searchResults = storageService.getSearchableCollection().stream()
                .filter(searchlist -> searchlist.getSearchTerm().toLowerCase().replace(" ", "")
                        .contains(search.toLowerCase().replace(" ", "")))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toCollection(HashSet::new));
        return searchResults;
    }
}
