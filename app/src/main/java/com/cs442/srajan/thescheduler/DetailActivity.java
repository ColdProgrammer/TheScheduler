package com.cs442.srajan.thescheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by IronMan on 11/28/2017.
 *
 */

public class DetailActivity extends Activity{
    protected static String name;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        String num = name;
//        Toast.makeText(this, "sajfd"+num, Toast.LENGTH_SHORT).show();
        String courseDes=checkDes(num);
        TextView tv= findViewById(R.id.detailClassHead);
        tv.setText(Html.fromHtml("<b> CS "+name+"</b>"));
        TextView tv1 = findViewById(R.id.detailClass);
        tv1.setText(courseDes);

        int postion = checkCou(num);
        String[][] courseTIme = StaticVariables.COURSE_TIMES;
        if( courseTIme[postion].length == 1 ){
            String[] course = {"There will be no course next semester"};
            mListView = (ListView)findViewById(R.id.detaillsit);
            mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,course));
        }
        else {
            String[] course = new String[courseTIme[postion].length-1];
            for(int a = 0; a < courseTIme[postion].length-1; a++){
                course[a] = courseTIme[postion][a+1];
            }
            mListView = (ListView) findViewById(R.id.detaillsit);
            mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, course));
        }



    }

    public String checkDes(String name){
        String[][] coursesString = StaticVariables.ALL_COURSES;
        String courseDes="--------------------------";
        for(int i=0; i < coursesString.length;i++){
            String[] detail = coursesString[i];
            String nameDes=detail[0];
            int a= Integer.parseInt(name.replaceAll("\\s+",""));
            int b =Integer.parseInt(nameDes.replaceAll("\\s+",""));
            if(a == b){
                courseDes = detail[3];
                return courseDes;
            }


        }
        return "cant find the course";
    }
    public int checkCou(String name){
        String[][] coursesString = StaticVariables.COURSE_TIMES;
        int postion = 0;
        for(int i=0; i < coursesString.length;i++){
            String[] detail = coursesString[i];
            String nameDes=detail[0];
            int a= Integer.parseInt(name.replaceAll("\\s+",""));
            int b =Integer.parseInt(nameDes.replaceAll("\\s+",""));
            if(a == b){
                postion = i;
                }

            }
        return postion;
        }


    public void openChooseLocationActivity(View view){
        LocationChooserActivity.name = name;
        startActivity(new Intent(this, LocationChooserActivity.class));

    }



}
