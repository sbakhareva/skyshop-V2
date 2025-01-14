package org.skypro.skyshop_2_0.service;

import org.springframework.stereotype.Service;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

//    public Set<SearchResult> search(String search) {
//        Set<SearchResult> searchResults = storageService.getSearchableCollection().stream()
//                .filter(searchable -> searchable.getSearchTerm().toLowerCase().replace(" ", "")
//                        .contains(search.toLowerCase().replace(" ", "")))
//                .collect(Collectors.toCollection();
//        return searchResults;
//    }
}
