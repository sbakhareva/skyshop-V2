package org.skypro.skyshop_2_0.model.search;

import java.util.UUID;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getObjName();

    UUID getID();


    default String getStringRepresentation() {
        return "Объект " + getObjName() + " типа " + getType();
    }
}
