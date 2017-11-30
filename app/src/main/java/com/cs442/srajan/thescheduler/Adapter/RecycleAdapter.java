package com.cs442.srajan.thescheduler.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs442.srajan.thescheduler.R;

import java.util.ArrayList;

/**
 * Created by project on 29/11/17.
 *
 * Adapter for the recycler view
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.CourseViewHolder> {

    public static class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewCourse,textViewSem,textViewLoc;
        public CourseViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview_courses);
            textViewCourse = itemView.findViewById(R.id.tv_course_name);
            textViewSem = itemView.findViewById(R.id.tv_course_sem);
            textViewLoc = itemView.findViewById(R.id.tv_course_loc);
        }
    }

    ArrayList<User_sem_details> user_sem_list;

    public RecycleAdapter(ArrayList user_sem_list){
        this.user_sem_list = user_sem_list;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contains_view_all_classes, parent,false);
        CourseViewHolder viewHolder = new CourseViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

        holder.textViewCourse.setText("Course : "+user_sem_list.get(position).course_name.getCourseName());
        holder.textViewSem.setText("Sem : "+user_sem_list.get(position).sem);
        holder.textViewLoc.setText("Location : "+user_sem_list.get(position).course_name.getCourseLocation());

    }

    @Override
    public int getItemCount() {
        return user_sem_list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
