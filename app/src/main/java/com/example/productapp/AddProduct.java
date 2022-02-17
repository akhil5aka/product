package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
EditText e1,e2,e3;
AppCompatButton b1,b2;
String getpname,getpno,getpr;
Dbhelper Dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


        Dbhelper=new Dbhelper(this);
        Dbhelper.getWritableDatabase();


        e1=(EditText) findViewById(R.id.pname);
        e2=(EditText) findViewById(R.id.pno);
        e3=(EditText) findViewById(R.id.pr);

        b1=(AppCompatButton) findViewById(R.id.add);
        b2=(AppCompatButton) findViewById(R.id.btm);


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getpname=e1.getText().toString();
                getpno=e2.getText().toString();
                getpr=e3.getText().toString();
                boolean result=Dbhelper.insertdata(getpno,getpname,getpr);

                if(result==true)
                {
                    Toast.makeText(getApplicationContext(), "products are inserted", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();

                }



            }
        }) ;
    }
}