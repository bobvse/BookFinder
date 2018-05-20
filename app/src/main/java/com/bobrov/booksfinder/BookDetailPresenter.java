package com.bobrov.booksfinder;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bobrov.booksfinder.responses.BookResponse;

import java.util.Arrays;

@InjectViewState
public class BookDetailPresenter extends MvpPresenter<BookDetailView> {


    public BookDetailPresenter() {

    }

    public void loadData(BookResponse currentBook) {
        String desc;
        String URL;

        String author = Arrays.toString(currentBook.getVolumeInfo().getAuthors());

        String title = currentBook.getVolumeInfo().getTitle();
        if (currentBook.getVolumeInfo().getDescription() != null) {
            desc = currentBook.getVolumeInfo().getDescription();
        } else {
            desc = "Описание отсутсвует";
        }


        if (currentBook.getVolumeInfo().getImageLinks().getExtraLarge() != null) {
            URL = currentBook.getVolumeInfo().getImageLinks().getExtraLarge();
        } else if (currentBook.getVolumeInfo().getImageLinks().getLarge() != null) {
            URL = currentBook.getVolumeInfo().getImageLinks().getLarge();
        } else if (currentBook.getVolumeInfo().getImageLinks().getMedium() != null) {
            URL = currentBook.getVolumeInfo().getImageLinks().getMedium();
        } else if (currentBook.getVolumeInfo().getImageLinks().getSmall() != null) {
            URL = currentBook.getVolumeInfo().getImageLinks().getSmall();
        } else URL = currentBook.getVolumeInfo().getImageLinks().getThumbnail();

        getViewState().showData(author, title, desc, URL);
    }
}
