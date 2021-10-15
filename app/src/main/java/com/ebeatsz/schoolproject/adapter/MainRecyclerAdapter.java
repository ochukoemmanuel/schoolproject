package com.ebeatsz.schoolproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ebeatsz.schoolproject.R;
import com.ebeatsz.schoolproject.model.AllCategory;
import com.ebeatsz.schoolproject.model.CategoryItem;

import java.util.List;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {

    private Context context;
    private List<AllCategory> allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.main_recycler_row_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerAdapter.MainViewHolder holder, int position) {
//        holder.categoryTitle.setText(allCategoryList.get(position).getCategoryTitle());
        setCatItemRecycler(holder.itemRecycler, allCategoryList.get(position).getCategoryItemList());
        holder.itemView.setTag(allCategoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        TextView categoryTitle;
        RecyclerView itemRecycler;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);

//            categoryTitle = itemView.findViewById(R.id.categoryTitle);
            itemRecycler = itemView.findViewById(R.id.item_recycler);        }
    }

    public void setCatItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        CategoryItemRecyclerAdapter itemRecyclerAdapter = new CategoryItemRecyclerAdapter(context, categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
