package com.example.raviraj.myapplication;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView userText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Button nextPage =(Button)findViewById(R.id.nextPage);
        userText=(TextView)findViewById(R.id.userText);

        Bundle bundle= getIntent().getExtras();
        String userName=bundle.getString(MainActivity.USER_NAME);
        if(!TextUtils.isEmpty(userName))
        {
            userText.setText(userName);
           // nextPage.setText(userName);
        }
        else
        {
            userText.setText("empty");
        }


        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),ThridActivity.class);
                startActivity(intent);
            }
        });
     }
}
