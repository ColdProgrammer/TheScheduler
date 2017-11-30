package com.cs442.srajan.thescheduler.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cs442.srajan.thescheduler.R;

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

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
