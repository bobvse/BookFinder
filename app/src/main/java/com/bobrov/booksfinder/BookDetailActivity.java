package com.bobrov.booksfinder;

import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bobrov.booksfinder.responses.BookResponse;

public class BookDetailActivity extends MvpAppCompatActivity implements BookDetailView {

    private TextView titleText;
    private TextView descText;
    private BookResponse currentBook;

    @InjectPresenter
    BookDetailPresenter bookDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_activity);

        initComponents();
        getData();
    }

    private void initComponents(){
        titleText = findViewById(R.id.book_detail_title_tv);
        descText = findViewById(R.id.book_detail_desc_tv);
    }

    private void getData() {
        currentBook = (BookResponse) getIntent().getSerializableExtra(SearchActivity.EXTRA_BOOK_KEY);
        bookDetailPresenter.loadData(currentBook);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showData(String title, String desc) {
        titleText.setText(title);
        descText.setText(desc);
    }

    @Override
    public void showError() {

    }
}
