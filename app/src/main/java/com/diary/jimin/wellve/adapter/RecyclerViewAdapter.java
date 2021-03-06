package com.diary.jimin.wellve.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.diary.jimin.wellve.R;
import com.diary.jimin.wellve.model.CommunityItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<CommunityItem> items;
    private LayoutInflater inflater;
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

    private OnItemClickListener mListener = null;


    public RecyclerViewAdapter(Context context, ArrayList<CommunityItem> items) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.community_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        String url = items.get(position).photo;
        holder.name.setText(items.get(position).name);
        holder.title.setText(items.get(position).title);
        holder.time.setText(items.get(position).time);
        holder.category.setText(items.get(position).category);
        holder.comment.setText(items.get(position).comment);

        Glide.with(context)
                .load(url)
                .into(holder.photo);

//        holder.photo.setImageURI(Uri.parse(items.get(position).photo));

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView photo;
        public TextView name;
        public TextView title;
        public TextView time;
        public TextView category;
        public TextView comment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = (ImageView) itemView.findViewById(R.id.communityItemPhotoText);
            name = (TextView) itemView.findViewById(R.id.communityItemNameText);
            title = (TextView) itemView.findViewById(R.id.communityItemTitleText);
            time = (TextView) itemView.findViewById(R.id.communityItemTimeText);
            category = (TextView) itemView.findViewById(R.id.communityItemCategoryText);
            comment = (TextView) itemView.findViewById(R.id.communityItemCommentText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(pos);
                        Log.d("position",""+pos);
                    }
                }
            });

        }
    }

}
