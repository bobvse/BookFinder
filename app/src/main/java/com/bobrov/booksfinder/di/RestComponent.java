package com.bobrov.booksfinder.di;

import dagger.Component;
import retrofit2.Retrofit;

@Component(modules = RestModule.class)
public interface RestComponent {

    Retrofit getRetrofit();
}
