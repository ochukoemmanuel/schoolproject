package com.ebeatsz.schoolproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ebeatsz.schoolproject.R;
import com.ebeatsz.schoolproject.Single;
import com.ebeatsz.schoolproject.model.Course;

import java.util.ArrayList;

public class CourseRecyclerViewAdapter extends RecyclerView.Adapter<CourseRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Course> courseList;
    Context context;

    public CourseRecyclerViewAdapter (Context context, ArrayList<Course> courseList){
        this.courseList = courseList;
        this.context = context;
    }


    @NonNull
    @Override
    public CourseRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.one_line, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CourseRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.itemView.setTag(courseList.get(position));
        holder.course_title.setText(courseList.get(position).getCourseTitle());
        holder.course_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Single.class);
                intent.putExtra("courseTitle", courseList.get(position).getCourseTitle());
                intent.putExtra("courseCategory", courseList.get(position).getCategory());
                intent.putExtra("school", courseList.get(position).getSchool());
                intent.putExtra("session", courseList.get(position).getSession());
                intent.putExtra("course_title", courseList.get(position).getCourseTitle());
                intent.putExtra("class_", courseList.get(position).getClass_());
                intent.putExtra("courseCode", courseList.get(position).getCourseCode());
                intent.putExtra("courseUnit", courseList.get(position).getCourseUnit());
                intent.putExtra("timeAllowed", courseList.get(position).getTimeAllowed());
                intent.putExtra("instruction", courseList.get(position).getInstruction());
                intent.putExtra("questionNumber", courseList.get(position).getQuestionNumber());
                intent.putExtra("question", courseList.get(position).getQuestion());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView course_title;
        private final CardView course_card;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            course_title = itemView.findViewById(R.id.course_title);
            course_card = itemView.findViewById(R.id.course_card);

        }
    }
}
