package com.example.productapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchProduct extends AppCompatActivity {
EditText ed1,ed2,ed3;
AppCompatButton b1,b2;
String getname,getpcode,getprice;
Dbhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_product);
        ed1=(EditText) findViewById(R.id.pn);
        ed2=(EditText) findViewById(R.id.pc);
        ed3=(EditText) findViewById(R.id.pp);
        b1=(AppCompatButton) findViewById(R.id.sc);
        b2=(AppCompatButton) findViewById(R.id.bcm);
        helper=new Dbhelper(this);
        helper.getWritableDatabase();
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


                getpcode = ed2.getText().toString();

                Cursor c = helper.viewdata(getpcode);

                if (c.getCount() == 0) {
                    ed1.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "invalid product code", Toast.LENGTH_SHORT).show();

                } else {
                    while (c.moveToNext()) {
                        getname = c.getString(2);
                        getprice = c.getString(3);

                    }
                    ed1.setText(getname);
                    ed3.setText(getprice);
                }
            }
        });

    }
}