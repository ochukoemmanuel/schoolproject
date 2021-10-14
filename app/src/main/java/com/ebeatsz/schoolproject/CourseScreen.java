package com.ebeatsz.schoolproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ebeatsz.schoolproject.model.AllCategory;
import com.ebeatsz.schoolproject.model.Course;

import java.util.ArrayList;
import java.util.Arrays;

public class CourseScreen extends AppCompatActivity {

    ArrayList<Course> courseList = new ArrayList<Course>();
//    ArrayList<Screen> screenCast = new ArrayList<Screen>();

    private TextView titleName;
    private View backView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_course_screen);
        titleName = findViewById(R.id.titleName);
        backView = findViewById(R.id.backView);

        String getDepartment = getIntent().getStringExtra("department");
        titleName.setText(getDepartment);

        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        // RecyclerView
        recyclerView = findViewById(R.id.lv_exam);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CourseRecyclerViewAdapter(this, courseList));

        fillCourse();
    }

    private void fillCourse() {
        String getDepartment = getIntent().getStringExtra("department");

        for (int i = 0; i < 15; i++){
            if (getDepartment.equals("Computer Engineering")) {
                courseList.add(new Course("INTRODUCTION TO Engineering", "Computer Engineering"));
            } else if (getDepartment.equals("Civil Engineering")) {
                courseList.add(new Course("INTRODUCTION TO Civil Engineering", "Civil Engineering"));
            } else if (getDepartment.equals("Electrical Electronics Engineering")) {
                courseList.add(new Course("INTRODUCTION TO Electrical Electronics Engineering", "Electrical Electronics Engineering"));
            } else if (getDepartment.equals("Architectural Technology")) {
                courseList.add(new Course("INTRODUCTION TO Architectural Technology", "Architectural Technology"));
            } else if (getDepartment.equals("Quantity Surveying")) {
                courseList.add(new Course("INTRODUCTION TO Quantity Surveying", "Quantity Surveying"));
            } else if (getDepartment.equals("Estate Management")) {
                courseList.add(new Course("INTRODUCTION TO Estate Management", "Estate Management"));
            } else if (getDepartment.equals("Computer Science")) {
                courseList.add(new Course("INTRODUCTION TO Computer Science", "Computer Science"));
            } else if (getDepartment.equals("Science Laboratory Technology")) {
                courseList.add(new Course("INTRODUCTION TO Science Laboratory Technology", "Science Laboratory Technology"));
            } else if (getDepartment.equals("Accountancy")) {
                courseList.add(new Course("INTRODUCTION TO Accountancy", "Accountancy"));
            } else if (getDepartment.equals("Business Administration")) {
                courseList.add(new Course("Business Administration", "Business Administration"));
            }
        }
    }

    // onCreate toolbar menu code start here
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.notification_background:
                Toast.makeText(this, "Notification Opened", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    } // onCreate toolbar menu code ends here
}
