package org.skypro.skyshop_2_0.model.search;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getObjName();

    UUID getID();

    @JsonIgnore
    default String getStringRepresentation() {
        return "Объект " + getObjName() + " типа " + getType();
    }
}
