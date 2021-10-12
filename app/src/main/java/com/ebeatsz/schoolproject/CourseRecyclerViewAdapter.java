package com.ebeatsz.schoolproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

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
