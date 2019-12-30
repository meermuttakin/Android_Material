package com.example.meer_.easypayment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Users.db";
    private static final String TABLE_NAME = "users_details";
    private static final String ID = "_id";
    private static final String NID = "nid";
    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String GENDER = "gender";
    private static final int VERSION_NUMBER = 1;
    private static final String USERS_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NID+" VARCHAR (20),"+NAME+" VARCHAR (20),"+GENDER+" VARCHAR (20),"+EMAIL+" VARCHAR (20),"+PASSWORD+" VARCHAR (20));";
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Toast.makeText(context,"ON CREATE is Called ",Toast.LENGTH_SHORT).show();

        try{
            db.execSQL(USERS_TABLE);
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Exception : "+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }


    public long insertData(userDetails ud){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NID, ud.getNid1());
        contentValues.put(NAME, ud.getName1());
        contentValues.put(GENDER, ud.getGender1());
        contentValues.put(EMAIL, ud.getEmail1());
        contentValues.put(PASSWORD, ud.getPassword1());

        long rowid= sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowid;

    }


    public Boolean findPassword(String uname,String pass){

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount()==0){
            Toast.makeText(context,"ON CREATE is Called ",Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){

                String username = cursor.getString(4);
                String password = cursor.getString(5);

                if(username.equals(uname) && password.equals(pass)){
                    result = true;
                    break;
                }

            }
        }
        return result;
    }
}
