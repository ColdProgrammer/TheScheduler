package com.cs442.srajan.thescheduler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * Created by IronMan on 11/28/2017.
 */

public class ClassListActivity extends AppCompatActivity {

    private SearchView mSearchView;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_list);
        mSearchView = (SearchView) findViewById(R.id.searchview);
        mListView = (ListView)findViewById(R.id.classlistfrag);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ClassStr));
        mListView.setTextFilterEnabled(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText){
                if(!TextUtils.isEmpty(newText)){
                    mListView.setFilterText(newText);
                }else{
                    mListView.clearTextFilter();
                }
                return false;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String name = (String)((TextView) view).getText();
                String CourseID =name.substring(3,6);
                Log.d("position"," sdfas"+position+"id is "+CourseID);
                Intent intent = new Intent(ClassListActivity.this,DetailActivity.class);
                DetailActivity.name = CourseID;
                startActivity(intent);
            }


        });
    }


    private String[] ClassStr = {"CS 100 - Introduction to the Profession",
            "CS 104 - Introduction to Computer Programming for Engineers",
            "CS 105 - Introduction to Computer Programming",
            "CS 110 - Computing Principles",
            "CS 115 - Object-Oriented Programming I",
            "CS 116 - Object-Oriented Programming II",
            "CS 201 - Accelerated Introduction to Computer Science",
            "CS 330 - Discrete Structures",
            "CS 331 - Data Structures and Algorithms",
            "CS 350 - Computer Organization and Assembly Language Programming",
            "CS 351 - Systems Programming",
            "CS 397 - Special Projects",
            "CS 401 - Introduction to Advanced Studies I",
            "CS 402 - Introduction to Advanced Studies II",
            "CS 403 - Foundations to Advanced Studies",
            "CS 406 - Introduction to Discrete Structures and Algorithms",
            "CS 411 - Computer Graphics",
            "CS 422 - Data Mining",
            "CS 425 - Database Organization",
            "CS 429 - Information Retrieval",
            "CS 430 - Introduction to Algorithms",
            "CS 440 - Programming Languages and Translators",
            "CS 442 - Mobile Applications Development",
            "CS 443 - Compiler Construction",
            "CS 445 - Object Oriented Design and Programming",
            "CS 447 - Distributed Objects",
            "CS 450 - Operating Systems",
            "CS 451 - Introduction to Parallel and Distributed Computing",
            "CS 455 - Data Communications",
            "CS 456 - Introduction to Wireless Networks and Performance",
            "CS 458 - Introduction to Information Security",
            "CS 470 - Computer Architecture",
            "CS 480 - Artificial Intelligence Planning and Control",
            "CS 481 - Artificial Intelligence Language Understanding",
            "CS 482 - Information and Knowledge Management Systems",
            "CS 485 - Computers and Society",
            "CS 487 - Software Engineering I",
            "CS 491 - Undergraduate Research",
            "CS 495 - Topics in Computer Science",
            "CS 497 - Special Projects"
    };

}
