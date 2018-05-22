package com.bobrov.booksfinder.responses;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BooksResponse implements Serializable {
    @SerializedName("kind")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BooksResponse that = (BooksResponse) o;
        return Objects.equal(kind, that.kind) &&
                Objects.equal(totalItems, that.totalItems) &&
                Objects.equal(books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(kind, totalItems, books);
    }
}

