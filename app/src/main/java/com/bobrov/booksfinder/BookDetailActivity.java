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
    private ImageView placePicture;
    private CollapsingToolbarLayout collapsingToolbar;


    @InjectPresenter
    BookDetailPresenter bookDetailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail_activity);

        initWidgets();
        initData();
    }

    private void initWidgets() {
        titleText = findViewById(R.id.book_detail_title_tv);
        descText = findViewById(R.id.book_detail_desc_tv);
        authorText = findViewById(R.id.book_author_detail_tv);
        placePicture = findViewById(R.id.image);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);

    }

    private void initData() {
        BookResponse currentBook = (BookResponse) getIntent().getSerializableExtra(SearchActivity.EXTRA_BOOK_KEY);
        bookDetailPresenter.loadData(currentBook);
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
                    .fit()
                    .centerInside()
                    .into(placePicture);
        } else {
            placePicture.setImageResource(R.drawable.common_google_signin_btn_text_dark);

        }

    }

}
