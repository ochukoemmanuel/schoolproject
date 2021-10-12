package com.ebeatsz.schoolproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import com.ebeatsz.schoolproject.model.AllCategory;
import com.ebeatsz.schoolproject.model.CategoryItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainCategoryRecycler;
    MainRecyclerAdapter mainRecyclerAdapter;
    List<AllCategory> allCategoryList;
    List<CategoryItem> categoryItemList3;
    List<CategoryItem> categoryItemList4;
    List<CategoryItem> categoryItemList;
    List<CategoryItem> categoryItemList2;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Category 3
        categoryItemList3 = new ArrayList<CategoryItem>();
        categoryItemList3.add(new CategoryItem(1, R.drawable.cs, "Computer Science"));
        categoryItemList3.add(new CategoryItem(2, R.drawable.lab, "Science Laboratory Technology"));

        // Category 4
        categoryItemList4 = new ArrayList<CategoryItem>();
        categoryItemList4.add(new CategoryItem(3, R.drawable.sch_man, "Accountancy"));
        categoryItemList4.add(new CategoryItem(4, R.drawable.sch_man, "Business Administration"));

        // Category 1
        categoryItemList = new ArrayList<CategoryItem>();
        categoryItemList.add(new CategoryItem(0, R.drawable.sch_tech, "Computer Engineering"));
        categoryItemList.add(new CategoryItem(1, R.drawable.sch_tech, "Civil Engineering"));
        categoryItemList.add(new CategoryItem(2, R.drawable.sch_tech, "Electrical Electronics Engineering"));

        // Category 2
        categoryItemList2 = new ArrayList<CategoryItem>();
        categoryItemList2.add(new CategoryItem(1, R.drawable.sch_env, "Architectural Technology"));
        categoryItemList2.add(new CategoryItem(2, R.drawable.sch_env, "Estate Management"));
        categoryItemList2.add(new CategoryItem(3, R.drawable.sch_env, "Quantity Surveying"));


        allCategoryList = new ArrayList<AllCategory>();
        allCategoryList.add(new AllCategory("School of Science & Technology", categoryItemList));
        allCategoryList.add(new AllCategory("School of Management Studies", categoryItemList2));
        allCategoryList.add(new AllCategory("School of Engineering Technology", categoryItemList3));
        allCategoryList.add(new AllCategory("School of Environmental Studies", categoryItemList4));

        setMainCategoryRecycler(allCategoryList);
    }

    private void setMainCategoryRecycler(List<AllCategory> allCategoryList){
        mainCategoryRecycler = findViewById(R.id.main_recycler);
        mainCategoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        mainRecyclerAdapter = new MainRecyclerAdapter(this, allCategoryList);
        mainCategoryRecycler.setAdapter(mainRecyclerAdapter);
    }

//    @Override
//    public void onItemClicked(int position){
//        // Intent to Single page
//        String categoryTitle3 = categoryItemList3.get(position).getDepartment();
//        String categoryTitle4 = categoryItemList4.get(position).getDepartment();
//        String categoryTitle2 = categoryItemList2.get(position).getDepartment();
//        String categoryTitle = categoryItemList.get(position).getDepartment();
//
//        // intent to department page
//        Intent intent = new Intent (MainActivity.this, CourseScreen.class);
//        intent.putExtra("categoryTitle3", categoryTitle3);
//        intent.putExtra("categoryTitle4", categoryTitle4);
//        intent.putExtra("categoryTitle2", categoryTitle2);
//        intent.putExtra("categoryTitle", categoryTitle);
//        startActivity(intent);
//    }

}