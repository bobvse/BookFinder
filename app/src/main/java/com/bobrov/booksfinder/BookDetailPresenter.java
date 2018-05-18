package com.bobrov.booksfinder;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bobrov.booksfinder.responses.BookResponse;

@InjectViewState
public class BookDetailPresenter extends MvpPresenter<BookDetailView> {


    public BookDetailPresenter() {

    }

    public void loadData(BookResponse currentBook) {
        String desc;
        String title = currentBook.getVolumeInfo().getTitle();
        if (currentBook.getVolumeInfo().getDescription() != null) {
            desc = currentBook.getVolumeInfo().getDescription();
        } else {
            desc = "Описание отсутсвует";
        }

        getViewState().showData(title, desc);
    }
}
