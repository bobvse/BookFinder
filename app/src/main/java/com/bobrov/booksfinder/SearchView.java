package com.bobrov.booksfinder;

import com.arellomobile.mvp.MvpView;

public interface SearchView extends MvpView {
    void showProgress();

    void hideProgress();

    void showBooks();

    void showError();
}
