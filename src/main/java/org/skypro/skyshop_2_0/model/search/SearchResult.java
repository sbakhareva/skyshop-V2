package org.skypro.skyshop_2_0.model.search;

public class SearchResult {
    private final String id;
    private final String name;
    private final String contentType;

    public SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public static SearchResult fromSearchable(Searchable object) {
        String id = String.valueOf(object.getID());
        String name = object.getObjName();
        String contentType = object.getType();
        return new SearchResult(id, name, contentType);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }
}
