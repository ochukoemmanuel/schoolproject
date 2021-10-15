package com.ebeatsz.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Single extends AppCompatActivity {

    TextView titleName_single;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_single);

        titleName_single = findViewById(R.id.titleName_single);
        view = findViewById(R.id.backView_single);

        // Get string extra
        String getCourseTitle = getIntent().getStringExtra("courseTitle");
        String getCourseCategory = getIntent().getStringExtra("courseCategory");

        // Set
        titleName_single.setText(getCourseTitle);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}