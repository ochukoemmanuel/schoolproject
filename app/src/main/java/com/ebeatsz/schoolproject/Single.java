package com.ebeatsz.schoolproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ebeatsz.schoolproject.model.Question;

import java.util.ArrayList;

public class Single extends AppCompatActivity {

    ArrayList<Question> questionArrayList = new ArrayList<>();
    TextView titleName_single, school, session, course_title, class_, courseCode, courseUnit, timeAllowed, instruction, questionNumber, question;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_single);

        titleName_single = findViewById(R.id.titleName_single);
        view = findViewById(R.id.backView_single);

        school = findViewById(R.id.school);
        session = findViewById(R.id.session);
        course_title = findViewById(R.id.course_title);
        class_ = findViewById(R.id.class_);
        courseCode = findViewById(R.id.courseCode);
        courseUnit = findViewById(R.id.courseUnit);
        timeAllowed = findViewById(R.id.timeAllowed);
        instruction = findViewById(R.id.instruction);
        questionNumber = findViewById(R.id.questionNumber);
        question = findViewById(R.id.question);

        // Get string extra
        String getCourseTitle = getIntent().getStringExtra("courseTitle");
        String getCourseCategory = getIntent().getStringExtra("courseCategory");
        String getSchool = getIntent().getStringExtra("school");
        String getSession = getIntent().getStringExtra("session");
        String getCourse_title = getIntent().getStringExtra("course_title");
        String getClass_ = getIntent().getStringExtra("class_");
        String getCourseCode = getIntent().getStringExtra("courseCode");
        String getCourseUnit = getIntent().getStringExtra("courseUnit");
        String getTimeAllowed = getIntent().getStringExtra("timeAllowed");
        String getInstruction = getIntent().getStringExtra("instruction");
        String getQuestionNumber = getIntent().getStringExtra("questionNumber");
        String getQuestion = getIntent().getStringExtra("question");


        // Set
        titleName_single.setText(getCourseTitle);
        school.setText(getSchool);
        session.setText(getSession);
        course_title.setText(getCourse_title);
        class_.setText(getClass_);
        courseCode.setText(getCourseCode);
        courseUnit.setText(getCourseUnit);
        timeAllowed.setText(getTimeAllowed);
        instruction.setText(getInstruction);
        questionNumber.setText(getQuestionNumber);
        question.setText(getQuestion);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}