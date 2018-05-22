package com.bobrov.booksfinder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bobrov.booksfinder.responses.BookResponse;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {
    private List<BookResponse> booksList;
    private CustomItemClickListener listener;


    public BooksListAdapter(List<BookResponse> booksList, CustomItemClickListener listener) {
        this.booksList = booksList;
        this.listener = listener;
    }

    public void setData(List<BookResponse> booksList) {
        this.booksList = booksList;
        notifyDataSetChanged();
    }

    public void addData(List<BookResponse> booksList) {
        this.booksList.addAll(booksList);
        notifyDataSetChanged();
    }

    public void clearData() {
        booksList.clear();
        notifyDataSetChanged();
    }

    @Override
    public BooksListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(mView);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(booksList.get(mViewHolder.getLayoutPosition()));
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(booksList.get(position).getVolumeInfo().getTitle());
        if(booksList.get(position).getVolumeInfo().getAuthors()==null){
            holder.author.setText("Автор неизвестен");
        }else{
            holder.author.setText(Arrays.toString(booksList.get(position).getVolumeInfo().getAuthors()));
        }

        if (booksList.get(position).getVolumeInfo().getImageLinks() != null) {
            Picasso.get()
                    .load(booksList.get(position).getVolumeInfo().getImageLinks().getThumbnail())
                    //.resize(80, 80)
                    .centerCrop()
                    .fit()
                    .into(holder.picture);

        } else {
            holder.picture.setImageResource(R.drawable.common_google_signin_btn_text_dark);
        }
    }

    @Override
    public int getItemCount() {
        if (booksList == null) {
            return 0;
        } else {
            return booksList.size();
        }
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView picture;
        public TextView title;
        public TextView author;


        ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.list_title);
            picture = v.findViewById(R.id.list_avatar);
            author = v.findViewById(R.id.list_desc);
        }
    }
}
