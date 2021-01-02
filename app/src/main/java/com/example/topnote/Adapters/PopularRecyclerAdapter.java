package com.example.topnote.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.topnote.Fragments.HomeFragment;
import com.example.topnote.Models.NoteModel;
import com.example.topnote.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;


public class PopularRecyclerAdapter extends FirebaseRecyclerAdapter<NoteModel, PopularRecyclerAdapter.PopularViewHolder> {
    Context mContext;
    public PopularRecyclerAdapter(@NonNull FirebaseRecyclerOptions<NoteModel> options, Context context) {
        super(options);
        mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull PopularViewHolder holder, int position, @NonNull NoteModel model) {
        holder.Heading.setText(model.getName());
        holder.Description.setText(model.getDescription());
        holder.branch.setText(model.getBranch());
        if (!model.getCoverImage().isEmpty() || model.getCoverImage() != null)
        Glide.with(mContext)
                .load(model.getCoverImage())
                .override(400,400)
                .into(holder.cover);


    }

    @NonNull
    @Override
    public PopularViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_display_item_home_recycler,parent,false);
        return new PopularRecyclerAdapter.PopularViewHolder(view);
    }


    public class PopularViewHolder extends RecyclerView.ViewHolder{
        ImageView cover;
        TextView Heading,Description,branch;

        public PopularViewHolder(@NonNull View itemView) {
            super(itemView);
            cover = itemView.findViewById(R.id.popular_item_imageView);
            Heading = itemView.findViewById(R.id.popular_item_HeadTexview);
            Description = itemView.findViewById(R.id.popular_item_descriptionTextView);
            branch = itemView.findViewById(R.id.popular_item_BranchTextView);
        }
    }
}
