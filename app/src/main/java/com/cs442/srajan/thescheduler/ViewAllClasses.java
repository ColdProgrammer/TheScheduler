package com.cs442.srajan.thescheduler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cs442.srajan.thescheduler.Adapter.RecycleAdapter;
import com.cs442.srajan.thescheduler.Adapter.User_sem_details;

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
        RecycleAdapter recycleAdapter = new RecycleAdapter(user_sem_details.initializeData());
        recyclerView.setAdapter(recycleAdapter);
    }
}
