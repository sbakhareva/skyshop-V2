package org.skypro.skyshop_2_0.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop_2_0.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {
    private final UUID id;
    private final String title;
    private final String text;

    public Article(UUID id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return title + "\n" + text;
    }

    @Override @JsonIgnore
    public String getSearchTerm() {
        return title + text;
    }

    @Override
    public String getObjName() {
        return this.title;
    }

    @Override @JsonIgnore
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public UUID getID() {
        return this.id;
    }
}
