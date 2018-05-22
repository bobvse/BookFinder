package com.bobrov.booksfinder;

import android.app.Application;

import com.bobrov.booksfinder.di.DaggerRestComponent;
import com.bobrov.booksfinder.di.RestComponent;
import com.bobrov.booksfinder.di.RestModule;


public class BookFinderApp extends Application {

    private static RestComponent component;

    public static RestComponent getComponent(){
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected RestComponent buildComponent(){
        RestComponent component = DaggerRestComponent.builder()
                .restModule(new RestModule())
                .build();
        return component;
    }
}
