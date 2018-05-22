package com.bobrov.booksfinder;

import com.arellomobile.mvp.MvpView;
import com.bobrov.booksfinder.responses.BookResponse;

import java.util.List;

public interface SearchView extends MvpView {
    void showProgress();

    void hideProgress();

    void showBooks(List<BookResponse> bookResponses);

    void showError(String error);

    void clearData();

    void loadPageBooks(List<BookResponse> bookResponses);
}
