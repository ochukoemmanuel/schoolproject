package com.ebeatsz.schoolproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ebeatsz.schoolproject.model.CategoryItem;

import java.util.List;

public class CategoryItemRecyclerAdapter extends RecyclerView.Adapter<CategoryItemRecyclerAdapter.CategoryItemViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItemList;

    public CategoryItemRecyclerAdapter(Context context, List<CategoryItem> categoryItemList){
        this.context = context;
        this.categoryItemList = categoryItemList;
    }

    @NonNull
    @Override
    public CategoryItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoryItemViewHolder(LayoutInflater.from(context).inflate(R.layout.category_row_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemRecyclerAdapter.CategoryItemViewHolder holder, int position) {
        holder.itemView.setTag(categoryItemList.get(position));
        holder.itemImage.setImageResource(categoryItemList.get(position).getImageUrl());
        holder.schoolName.setText(categoryItemList.get(position).getDepartment());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, CourseScreen.class);
                intent.putExtra("department", categoryItemList.get(position).getDepartment());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }

    public class CategoryItemViewHolder extends RecyclerView.ViewHolder{

        ImageView itemImage;
        TextView schoolName;
        private final CardView cardView;

        public CategoryItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            schoolName = itemView.findViewById(R.id.schoolOf_name);
            cardView = itemView.findViewById(R.id.card);

        }
    }
}
