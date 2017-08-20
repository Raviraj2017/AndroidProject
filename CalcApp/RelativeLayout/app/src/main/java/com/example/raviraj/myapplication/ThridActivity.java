package com.example.raviraj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThridActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);
        Button nextPage =(Button)findViewById(R.id.nextPage);
       // nextPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


    }
}
