package com.bobrov.booksfinder;

import android.view.View;

import com.bobrov.booksfinder.responses.BookResponse;

public interface CustomItemClickListener {
    void onItemClick(BookResponse bookResponse);
}
