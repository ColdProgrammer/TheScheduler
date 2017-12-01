package com.cs442.srajan.thescheduler.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cs442.srajan.thescheduler.MainActivity;
import com.cs442.srajan.thescheduler.R;
import com.cs442.srajan.thescheduler.StaticVariables;
import com.cs442.srajan.thescheduler.database.DAO;

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
        Button delBtn;
        public CourseViewHolder(View itemView) {
            super(itemView);
            delBtn = itemView.findViewById(R.id.del_btn);
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
    public void onBindViewHolder(CourseViewHolder holder, final int position) {

        holder.textViewCourse.setText("Course : "+user_sem_list.get(position).course_name.getCourseName());
        holder.textViewSem.setText("Sem : "+user_sem_list.get(position).sem);
        holder.textViewLoc.setText("Location : "+user_sem_list.get(position).course_name.getCourseLocation());

        holder.delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Item Clicked " + position, Toast.LENGTH_LONG).show();
                //On click of delete button
                SharedPreferences sharedPreferences = view.getContext().getSharedPreferences(StaticVariables.SHAREDPREFERENCE_USER_NAME, Context.MODE_PRIVATE);
                new DAO(view.getContext()).delUsrCourse(user_sem_list.get(position).sem,user_sem_list.get(position).course_name.getCourseName(),user_sem_list.get(position).course_name.getCourseLocation(),sharedPreferences.getString(StaticVariables.USER_ID_USER_ID,""));
                view.getContext().startActivity(new Intent(view.getContext(), MainActivity.class));

            }
        });

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
