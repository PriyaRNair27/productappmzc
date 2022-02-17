package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProductActivity extends AppCompatActivity {
EditText e1,e2,e3;
AppCompatButton b1,b2;
String getcode,getname,getprice;
DatabaseHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        dbhelper=new DatabaseHelper(this);
        dbhelper.getWritableDatabase();

        e1=(EditText) findViewById(R.id.code);
        e2=(EditText) findViewById(R.id.name);
        e3=(EditText) findViewById(R.id.price);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.back);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getcode=e1.getText().toString();
                getname=e2.getText().toString();
                getprice=e3.getText().toString();
                boolean result=dbhelper.insertData(getcode,getname,getprice);
                if(result==true)
                {
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    Toast.makeText(getApplicationContext(), "Sucessfully inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Failed to inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}