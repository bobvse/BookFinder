package com.bobrov.booksfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bobrov.booksfinder.responses.BookResponse;

import java.util.Arrays;
import java.util.List;

public class BooksListAdapter extends BaseAdapter {

    private Context context;
    private List<BookResponse> booksList;

    public BooksListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<BookResponse> booksList) {
        this.booksList = booksList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return booksList == null ? 0 : booksList.size();
    }

    @Override
    public Object getItem(int position) {
        return booksList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.books_list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        BookResponse currentBook = (BookResponse) getItem(position);
        viewHolder.bookTitle.setText(currentBook.getVolumeInfo().getTitle());
        viewHolder.bookAuthors.setText(Arrays.toString(currentBook.getVolumeInfo().getAuthors()));

        return convertView;
    }

    private class ViewHolder {
        TextView bookTitle;
        TextView bookAuthors;

        public ViewHolder(View view) {
            bookTitle = view.findViewById(R.id.books_list_item_title_tv);
            bookAuthors = view.findViewById(R.id.books_list_item_author_tv);
        }
    }

}
