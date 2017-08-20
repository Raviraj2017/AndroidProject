package com.example.raviraj.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.MultiTapKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText fristNumberText,secondNumberText,answerText;
Button addButton,subButton,mulButton,divButton;
public  final  int REQUESRCODE=100;
public final static String USER_NAME="user";

    public static final String KEY_FRIST_NUMBER = "fristNum";
    public static final String KEY_SECOND_NUMBER = "secondNum";

    public  final int REQUEST_CODE_ADD=101;
    public  final int REQUEST_CODE_MULL=102;
    public  final int REQUEST_CODE_DIV=103;
    public  final int REQUEST_CODE_SUB=104;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fristNumberText=(EditText)findViewById(R.id.fristNumberText);
        secondNumberText=(EditText)findViewById(R.id.secondNumberText);
        answerText=(EditText)findViewById(R.id.answerText);
        addButton=(Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(this);
        subButton=(Button)findViewById(R.id.subButton);
        subButton.setOnClickListener(this);
        mulButton=(Button)findViewById(R.id.mulButton);
        mulButton.setOnClickListener(this);
        divButton=(Button)findViewById(R.id.divButton);
        divButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String fristNumber = fristNumberText.getText().toString();
        String secondNumber = secondNumberText.getText().toString();
        if(TextUtils.isEmpty(fristNumber))
        {
            fristNumberText.setError("Please Enter Frist Number");

        }
        else if(TextUtils.isEmpty(secondNumber))
        {
            secondNumberText.setError("please Enter second number");
        }
        else
        switch (view.getId()) {
           case R.id.addButton: {
               Intent intent = new Intent(this, AddtionActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString(MainActivity.KEY_FRIST_NUMBER, (fristNumberText.getText().toString()));
               bundle.putString(MainActivity.KEY_SECOND_NUMBER, (secondNumberText.getText().toString()));
               intent.putExtras(bundle);
               startActivity(intent);
               startActivityForResult(intent, REQUEST_CODE_ADD);
               break;
           }

           case R.id.subButton: {
               Intent intent = new Intent(this, SubractActitity.class);
               Bundle bundle = new Bundle();
               bundle.putString(MainActivity.KEY_FRIST_NUMBER, (fristNumberText.getText().toString()));
               bundle.putString(MainActivity.KEY_SECOND_NUMBER, (secondNumberText.getText().toString()));
               intent.putExtras(bundle);
               startActivity(intent);
               startActivityForResult(intent, REQUEST_CODE_SUB);
               break;
           }
           case R.id.mulButton: {
               Intent intent = new Intent(this, MultiplicatioActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString(MainActivity.KEY_FRIST_NUMBER, (fristNumberText.getText().toString()));
               bundle.putString(MainActivity.KEY_SECOND_NUMBER, (secondNumberText.getText().toString()));
               intent.putExtras(bundle);
               startActivity(intent);
               startActivityForResult(intent, REQUEST_CODE_MULL);
               break;
           }
           case R.id.divButton: {
               Intent intent = new Intent(this, DivisionActivity.class);
               Bundle bundle = new Bundle();
               bundle.putString(MainActivity.KEY_FRIST_NUMBER, (fristNumberText.getText().toString()));
               bundle.putString(MainActivity.KEY_SECOND_NUMBER, (secondNumberText.getText().toString()));
               intent.putExtras(bundle);
               startActivity(intent);
               startActivityForResult(intent, REQUEST_CODE_DIV);
               break;
           }
       }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE_ADD)
        {
            if(resultCode==RESULT_OK)
            {
                String ans=data.getStringExtra("ans");
                answerText.setText(ans);
            }
            else
            {
                Toast.makeText(this,"RequestCode "+requestCode,Toast.LENGTH_SHORT).show();
                answerText.setText("not found data");
            }
        }
        else if(requestCode==REQUEST_CODE_SUB)
        {
            if(resultCode==RESULT_OK)
            {
                String ans=data.getStringExtra("ans");
                answerText.setText(ans);
            }
            else {
              //  Toast.makeText(this,requestCode)
            }
        }
        else if(requestCode==REQUEST_CODE_MULL)
        {
            if(resultCode==RESULT_OK)
            {
                String ans=data.getStringExtra("ans");
                answerText.setText(ans);
            }
        }
        else if(requestCode==REQUEST_CODE_DIV)
        {
            if(resultCode==RESULT_OK)
            {
                String ans=data.getStringExtra("ans");
                answerText.setText(ans);
            }
            else if(resultCode==RESULT_CANCELED)
            {
                String errorMgs=data.getStringExtra("ans");
                Toast.makeText(this,"hii "+errorMgs,Toast.LENGTH_LONG).show();
                answerText.setText("");
            }
        }
    }
}
