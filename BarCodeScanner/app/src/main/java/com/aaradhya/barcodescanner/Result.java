package com.aaradhya.barcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent=getIntent();
        ListView listView=findViewById(R.id.lv_result);
        ArrayList<String> strings=intent.getStringArrayListExtra("scanned_result");
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.test_layout,strings);
        listView.setAdapter(adapter);
    }
}
