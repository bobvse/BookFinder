package com.bobrov.booksfinder.retrofit;

import com.bobrov.booksfinder.responses.BookResponse;
import com.bobrov.booksfinder.responses.BooksResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GoogleBooksApi {

    @GET("books/v1/volumes")
    Call<BooksResponse> getBooksList(@Query("q") String search, @Query("key") String apiKey, @Query("maxResults") int count);

    @GET("books/v1/volumes/{id}")
    Call<BookResponse> getBook(@Path("id") String bookId);

}
