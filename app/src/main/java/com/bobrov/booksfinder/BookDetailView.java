package com.bobrov.booksfinder;

import com.arellomobile.mvp.MvpView;

public interface BookDetailView extends MvpView {

    void showData(String author, String title, String desc,String URL);
}
