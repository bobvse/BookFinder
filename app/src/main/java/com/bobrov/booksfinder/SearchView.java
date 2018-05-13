package com.bobrov.booksfinder;

import com.arellomobile.mvp.MvpView;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public interface SearchView extends MvpView{
    void showProgress();

    void hideProgress();

    void showBooks();

    void showError();
}
