package com.example.productapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {


    static String Dbname="product.db";
    static String TableName="product";
    static String col1="id";
    static String col2="pcode";
    static String col3="pname";
    static String col4="price";

    public Dbhelper(Context context) {
        super(context,Dbname,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table "+TableName+"("+col1+" integer primary key autoincrement,"+
        col2+ " text,"+
        col3+ " text,"+
        col4+ " text)";
        db.execSQL(query);





        
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public boolean insertdata(String pcode,String pname,String price)
    {

         SQLiteDatabase db=this.getWritableDatabase();
        ContentValues c=new ContentValues();
        c.put(col2,pcode);
        c.put(col3,pname);
        c.put(col4,price);
        long status= db.insert(TableName,null,c);


        if(status==-1)
        {
            return  false;

        }

        else
        {
            return  true;
        }

    }

}
