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

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<BookResponse> booksList;
    private Context context;
    private CustomItemClickListener listener;


    public RecycleAdapter(Context context, List<BookResponse> booksList, CustomItemClickListener listener) {
        this.context = context;
        this.booksList = booksList;
        this.listener = listener;
    }

    public void setData(List<BookResponse> booksList) {
        this.booksList = booksList;
        notifyDataSetChanged();
    }

    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        final ViewHolder mViewHolder = new ViewHolder(mView);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, mViewHolder.getLayoutPosition());
            }
        });
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(booksList.get(position).getVolumeInfo().getTitle());
        holder.description.setText(booksList.get(position).getVolumeInfo().getDescription());

        if (booksList.get(position).getVolumeInfo().getImageLinks().getThumbnail() != null) {
        Picasso.get()
                .load(booksList.get(position).getVolumeInfo().getImageLinks().getThumbnail())
                .resize(80, 80)
                .centerCrop()
                .into(holder.avator);

        } else {
            holder.avator.setImageResource(R.drawable.common_google_signin_btn_text_dark);
        }
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public Object getItem(int position) {
        return booksList.get(position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView avator;
        public TextView title;
        public TextView description;


        ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.list_title);
            avator = v.findViewById(R.id.list_avatar);
            description = v.findViewById(R.id.list_desc);
        }
    }
}
