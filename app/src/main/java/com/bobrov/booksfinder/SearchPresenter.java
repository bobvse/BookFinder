package com.bobrov.booksfinder;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bobrov.booksfinder.di.DaggerRestComponent;
import com.bobrov.booksfinder.di.RestComponent;
import com.bobrov.booksfinder.di.RestModule;
import com.bobrov.booksfinder.responses.BooksResponse;
import com.bobrov.booksfinder.retrofit.GoogleBooksApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {
    private final static String API_KEY = "AIzaSyDYgqEsjNkKtFJtixnuJ7t_aWXEVb83VmI";
    String query;

    public SearchPresenter() {

    }

    public void loadBooks(String searchBook) {
        query = searchBook;
        RestComponent component = DaggerRestComponent.builder()
                .restModule(new RestModule())
                .build();

        GoogleBooksApi api = component.getRetrofit().create(GoogleBooksApi.class);

        getViewState().showProgress();
        //  api = RetrofitSingleton.getInstance().init().create(GoogleBooksApi.class);
        api.getBooksList(searchBook, API_KEY, 40).enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                BooksResponse booksResponse = response.body();
                if (booksResponse.getBooks() == null) {
                    getViewState().hideProgress();
                    getViewState().clearData();
                    getViewState().showError("Ничего не найдено");
                } else {
                    getViewState().showBooks(booksResponse.getBooks());
                    getViewState().hideProgress();
                }
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {
                String error = t.getMessage();
                getViewState().clearData();
                getViewState().showError(error);
            }
        });
    }

    public void loadBooksPagination(int index) {

        RestComponent component = DaggerRestComponent.builder()
                .restModule(new RestModule())
                .build();

        GoogleBooksApi api = component.getRetrofit().create(GoogleBooksApi.class);

        getViewState().showProgress();
        //  api = RetrofitSingleton.getInstance().init().create(GoogleBooksApi.class);
        api.getBooksListPagination(query, API_KEY, 40,index).enqueue(new Callback<BooksResponse>() {
            @Override
            public void onResponse(Call<BooksResponse> call, Response<BooksResponse> response) {
                BooksResponse booksResponse = response.body();
                if (booksResponse.getBooks() == null) {
                    //ничего не делать
                } else {
                    getViewState().loadPageBooks(booksResponse.getBooks());
                    getViewState().hideProgress();
                }
            }

            @Override
            public void onFailure(Call<BooksResponse> call, Throwable t) {
                String error = t.getMessage();
                getViewState().clearData();
                getViewState().showError(error);
            }
        });
    }


}
