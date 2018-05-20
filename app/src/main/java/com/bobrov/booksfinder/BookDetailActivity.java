package com.bobrov.booksfinder;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bobrov.booksfinder.responses.BookResponse;
import com.squareup.picasso.Picasso;

public class BookDetailActivity extends MvpAppCompatActivity implements BookDetailView {

    private TextView titleText;
    private TextView descText;
    private TextView authorText;
    private CollapsingToolbarLayout collapsingToolbar;
    private ImageView placePicutre;
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

    private void initComponents() {
        titleText = findViewById(R.id.book_detail_title_tv);
        descText = findViewById(R.id.book_detail_desc_tv);
        authorText  = findViewById(R.id.book_author_detail_tv);
        placePicutre = findViewById(R.id.image);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
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
    public void showData(String author, String title, String desc, String URL) {
        titleText.setText(title);
        descText.setText(desc);
        authorText.setText(author);
        collapsingToolbar.setTitle(title);

        if (URL != null) {
            Picasso.get()
                    .load(URL)
                    .resize(2000, 2000)
                    .into(placePicutre);
        } else {
            placePicutre.setImageResource(R.drawable.common_google_signin_btn_text_dark);

        }

    }

    @Override
    public void showError() {

    }
}
