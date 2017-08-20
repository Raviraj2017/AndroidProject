package com.example.raviraj.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

public class DivisionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtion);
        Bundle bundle = getIntent().getExtras();
        String fristNumber = bundle.getString(MainActivity.KEY_FRIST_NUMBER);
        String seconfNumber = bundle.getString(MainActivity.KEY_SECOND_NUMBER);
        int ans=0;
        try {
            ans=Integer.parseInt(fristNumber)/Integer.parseInt(seconfNumber);
        }
        catch (Exception e)
        {
            Intent intent = new Intent();
            intent.putExtra("ans", e.toString());
            setResult(RESULT_CANCELED, intent);
          //  Toast.makeText(this,e.toString(),Toast.LENGTH_LONG).show();
            finish();
        }


        String answer=String.valueOf(ans);
        if (TextUtils.isEmpty(fristNumber)) {
            setResult(RESULT_CANCELED, null);
            finish();
        } else {
            // boolean isValidUser = fristNumber.equals("Vipul");

            // fristNumber.setText(isValidUser ? "Success" : "Failure");

            Intent intent = new Intent();
            intent.putExtra("ans", answer);
            setResult(RESULT_OK, intent);
            finish();

        }
    }
}
