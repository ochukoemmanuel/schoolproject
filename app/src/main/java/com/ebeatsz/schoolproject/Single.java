package com.ebeatsz.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Single extends AppCompatActivity {

    TextView tv_courseTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_single);

        tv_courseTitle = findViewById(R.id.tv_coursetitle);

        String getCourseTitle = getIntent().getStringExtra("courseTitle");
        String getCourseCategory = getIntent().getStringExtra("courseCategory");
        tv_courseTitle.setText(getCourseTitle);
    }
}