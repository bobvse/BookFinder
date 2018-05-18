package com.bobrov.booksfinder;

import com.arellomobile.mvp.MvpView;

public interface BookDetailView extends MvpView {

    void showProgress();

    void hideProgress();

    void showData(String title, String desc);

    void showError();
}
