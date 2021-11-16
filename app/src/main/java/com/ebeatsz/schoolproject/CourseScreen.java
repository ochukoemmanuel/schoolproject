package com.ebeatsz.schoolproject;

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

import com.ebeatsz.schoolproject.adapter.CourseRecyclerViewAdapter;
import com.ebeatsz.schoolproject.model.Course;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CourseScreen extends AppCompatActivity {

    ArrayList<Course> courseList = new ArrayList<Course>();
//    ArrayList<Screen> screenCast = new ArrayList<Screen>();

    private TextView titleName;
    private View backView;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Quest");

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
        mAdapter = new CourseRecyclerViewAdapter(this, courseList);
        recyclerView.setAdapter(mAdapter);

        fillCourse();
    }

    private void fillCourse() {
        String getDepartment = getIntent().getStringExtra("department");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Course course = dataSnapshot.getValue(Course.class);
                    courseList.add(course);
                    Toast.makeText(CourseScreen.this, "DB CONNECTED " , Toast.LENGTH_SHORT).show();


                }

                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(CourseScreen.this, "DB FAILED " + error, Toast.LENGTH_SHORT).show();
            }
        });

//        for (int i = 0; i < 15; i++){
//            if (getDepartment.equals("Computer Engineering")) {
//                courseList.add(new Course("INTRODUCTION TO Engineering " + i, "Computer Engineering", "School of Science & Technology", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, "A. What is computer engineering \n B. List two component of a computer"));
//            } else if (getDepartment.equals("Civil Engineering")) {
//                courseList.add(new Course("INTRODUCTION TO Civil Engineering", "Civil Engineering",  "School of Science & Technology", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Electrical Electronics Engineering")) {
//                courseList.add(new Course("INTRODUCTION TO Electrical Electronics Engineering", "Electrical Electronics Engineering",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Architectural Technology")) {
//                courseList.add(new Course("INTRODUCTION TO Architectural Technology", "Architectural Technology",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Quantity Surveying")) {
//                courseList.add(new Course("INTRODUCTION TO Quantity Surveying", "Quantity Surveying",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Estate Management")) {
//                courseList.add(new Course("INTRODUCTION TO Estate Management", "Estate Management",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Computer Science")) {
//                courseList.add(new Course("INTRODUCTION TO Computer Science", "Computer Science",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Science Laboratory Technology")) {
//                courseList.add(new Course("INTRODUCTION TO Science Laboratory Technology", "Science Laboratory Technology",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Accountancy")) {
//                courseList.add(new Course("INTRODUCTION TO Accountancy", "Accountancy",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            } else if (getDepartment.equals("Business Administration")) {
//                courseList.add(new Course("Business Administration", "Business Administration",  "", "First Semester Examination 2020/2021 Session (FT)", "", "", "", "" + i, "" + i, "", "Question " + i, ""));
//            }
//        }
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
