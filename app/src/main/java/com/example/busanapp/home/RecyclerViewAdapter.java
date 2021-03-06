package com.example.busanapp.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.busanapp.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Course> mData;

    public RecyclerViewAdapter(Context mContext, List<Course> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.course_title.setText(mData.get(position).getTitle());
        holder.img_course_thumbnail.setImageResource(mData.get(position).getThumbnail());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Course_Activity.class);

                // passing data to the book course activity
                intent.putExtra("Title", mData.get(position).getTitle());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Category", mData.get(position).getCategory());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());

                // start the activity
                mContext.startActivity(intent);     // error 오류
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView course_title;
        ImageView img_course_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);

            course_title = (TextView) itemView.findViewById(R.id.title);
            img_course_thumbnail = (ImageView) itemView.findViewById(R.id.image);
            cardView = (CardView) itemView.findViewById(R.id.cardView_item);
        }
    }
}
