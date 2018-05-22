package com.bobrov.booksfinder;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bobrov.booksfinder.responses.BookResponse;

import java.util.List;

import static android.support.v7.widget.RecyclerView.LayoutManager;

public class SearchActivity extends MvpAppCompatActivity implements SearchView, CustomItemClickListener {
    public static final String EXTRA_BOOK_KEY = "bookKey";

    private RelativeLayout progress;

    private RecyclerView recyclerView;
    private BooksListAdapter booksListAdapter;

    @InjectPresenter
    SearchPresenter searchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);

        progress = findViewById(R.id.books_list_relative_progress);

        recyclerView = findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener((LinearLayoutManager) mLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                searchPresenter.loadBooksPagination(page);
            }
        });
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
                if (query.length() < 3) {
                    return false;
                } else {
                    searchPresenter.loadBooks(query.trim());
                    return false;
                }
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
        booksListAdapter = new BooksListAdapter(bookResponses, this);
        recyclerView.setAdapter(booksListAdapter);

    }


    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void clearData() {
        booksListAdapter.clearData();
    }

    @Override
    public void loadPageBooks(List<BookResponse> bookResponses) {
        booksListAdapter.addData(bookResponses);
    }


    @Override
    public void onItemClick(BookResponse bookResponse) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra(EXTRA_BOOK_KEY, bookResponse);
        startActivity(intent);
    }

}
