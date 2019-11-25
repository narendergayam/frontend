package com.example.frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText in1,in2,in3,in4,in5,in6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in1 =(EditText) findViewById(R.id.work);
        in2 =(EditText) findViewById(R.id.work1);
        in3 =(EditText) findViewById(R.id.work2);
        in4 =(EditText) findViewById(R.id.work3);
        in5 =(EditText) findViewById(R.id.work4);
        in6 =(EditText) findViewById(R.id.work5);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextPage(v);
            }
        });
    }
    public void nextPage(View myView){
        Intent myIntent = new Intent(this,Main2Activity.class);
        myIntent.putExtra("ID",Integer.parseInt(in1.getText().toString()));
        myIntent.putExtra("Firstname",(in2.getText().toString()));
        myIntent.putExtra("lastname",(in3.getText().toString()));
        myIntent.putExtra("email",(in4.getText().toString()));
        myIntent.putExtra("phone",Integer.parseInt(in5.getText().toString()));
        myIntent.putExtra("address",(in6.getText().toString()));

        startActivity(myIntent);

    }
}
