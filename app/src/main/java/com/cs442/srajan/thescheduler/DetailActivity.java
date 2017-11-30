package com.cs442.srajan.thescheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by IronMan on 11/28/2017.
 *
 */

public class DetailActivity extends Activity{
    protected static String name;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);
        String num = name;
        Toast.makeText(this, "sajfd"+num, Toast.LENGTH_SHORT).show();
        String courseDes=checkDes(num);
        TextView tv= findViewById(R.id.detailClass);
        tv.setText(Html.fromHtml("<b> CS "+name+"</b>"+" :"+courseDes));

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
            }


        }
        return courseDes;
    }

    public void openChooseLocationActivity(View view){
        LocationChooserActivity.name = name;
        startActivity(new Intent(this, LocationChooserActivity.class));

    }



}
