package com.example.musicplayer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

public class AvalancheDB extends SQLiteOpenHelper {
    private static String databaseName="AvalancheUsers";
    SQLiteDatabase usersDB;
    Register Reg=new Register();

    public AvalancheDB(Context context){
        super(context, databaseName,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table users (id integer primary key,"+
                "username text not null , password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldversion,int newVersion){
        db.execSQL("drop table if exists users");
        onCreate(db);
    }

    public void createNewUser (String name, String Pass)
    {
        ContentValues row= new ContentValues();
        row.put("username",name);
        row.put("password",Pass);
        usersDB=getWritableDatabase();
        usersDB.insert("users",null,row);
        usersDB.close();
    }

    public boolean isEmpty(EditText etText)
    {
        if (etText.getText().toString().trim().length()>0)
            return false;

        return true;
    }

    public boolean VerifyUser(String userN,String userP)
    {
        usersDB=getReadableDatabase();
        String Query="select username, password from users where username='"+userN+"' and password='"+userP+"'";
        Cursor cursor=null;
        try
        {
            cursor = usersDB.rawQuery(Query, null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        if (cursor!=null&&cursor.getCount()>0)
        {
            cursor.close();
            return true;
        }
        else
            {
                cursor.close();
                return false;
            }

    }

}
