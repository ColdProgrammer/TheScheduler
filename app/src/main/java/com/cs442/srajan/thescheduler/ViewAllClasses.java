package com.cs442.srajan.thescheduler;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cs442.srajan.thescheduler.Adapter.RecycleAdapter;
import com.cs442.srajan.thescheduler.Adapter.User_sem_details;
import com.cs442.srajan.thescheduler.database.DAO;

import java.util.ArrayList;

public class ViewAllClasses extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_classes);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        User_sem_details user_sem_details = new User_sem_details();

        SharedPreferences sharedPreferences = this.getSharedPreferences(StaticVariables.SHAREDPREFERENCE_USER_NAME, Context.MODE_PRIVATE);

        String userId = sharedPreferences.getString(StaticVariables.USER_ID_USER_ID,"");
        String userName = sharedPreferences.getString(StaticVariables.USER_ID_USER_NAME,"");

        DAO dao = new DAO(this);
        ArrayList arrayList = dao.getAllCourses(userId,userName);
        RecycleAdapter recycleAdapter = new RecycleAdapter(arrayList);
        recyclerView.setAdapter(recycleAdapter);
    }
}
