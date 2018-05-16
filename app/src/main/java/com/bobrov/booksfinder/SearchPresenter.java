package com.bobrov.booksfinder;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class SearchPresenter extends MvpPresenter<SearchView> {



    private SharedPreferences sp;

    public SearchPresenter() {

    }

    public SearchPresenter(SharedPreferences sp) {
        this.sp = sp;
    }



}
