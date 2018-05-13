package com.bobrov.booksfinder;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {
    private Context context;

    public SearchPresenter() {

    }
}
