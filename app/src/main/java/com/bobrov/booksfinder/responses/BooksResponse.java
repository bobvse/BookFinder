package com.bobrov.booksfinder.responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BooksResponse implements Serializable {
    private String kind;
    @SerializedName("totalItems")
    private String totalItems;
    @SerializedName("items")
    private List<BookResponse> books;

    public String getKind() {
        return kind;
    }

    public String getTotalItems() {
        return totalItems;
    }

    public List<BookResponse> getBooks() {
        return books;
    }
}

