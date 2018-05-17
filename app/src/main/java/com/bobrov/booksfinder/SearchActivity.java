package com.bobrov.booksfinder;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bobrov.booksfinder.responses.BookResponse;

import java.util.List;

public class SearchActivity extends MvpAppCompatActivity implements SearchView {

    BooksListAdapter booksListAdapter;
    private RelativeLayout progress;

    @InjectPresenter
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        progress = findViewById(R.id.books_list_relative_progress);
        progress.setVisibility(RelativeLayout.GONE);

        ListView booksListView = findViewById(R.id.books_list_listView);
        booksListAdapter = new BooksListAdapter(this);
        booksListView.setAdapter(booksListAdapter);
        // booksListView.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.serach_menu, menu);
        final android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) menu.findItem(R.id.action_search).getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search Books");

        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchPresenter.loadBooks(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    @Override
    public void showProgress() {
        progress.setVisibility(RelativeLayout.VISIBLE);

    }

    @Override
    public void hideProgress() {
        progress.setVisibility(RelativeLayout.GONE);

    }

    @Override
    public void showBooks(List<BookResponse> bookResponses) {
        booksListAdapter.setData(bookResponses);
    }


    @Override
    public void showError() {

    }

}
