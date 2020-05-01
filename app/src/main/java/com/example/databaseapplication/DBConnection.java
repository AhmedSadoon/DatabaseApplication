package com.example.databaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Currency;

public class DBConnection {

    DBInfo dbInfo;

    public DBConnection(Context context) {

        dbInfo = new DBInfo(context);

    }

    public long datainsert(String Name, String Username, String Password) {
        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBInfo.names, Name);
        contentValues.put(DBInfo.username, Username);
        contentValues.put(DBInfo.password, Password);

        long id = sqLiteDatabase.insert(DBInfo.tableName, null, contentValues);
        return id;
    }

    public String viewData() {

        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();
        String[] columns = {DBInfo.UID, DBInfo.names, DBInfo.username, DBInfo.password};
        Cursor cursor = sqLiteDatabase.query(DBInfo.tableName, columns, null, null, null, null, null, null);

        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {
            int uid = cursor.getInt(0);
            String name = cursor.getString(1);
            String username = cursor.getString(2);
            String password = cursor.getString(3);

            stringBuffer.append(uid + ".Name: " + name + " UN: " + username + " Pass: " + password + "\n");

        }
        return stringBuffer.toString();

    }

    public String searchData(String Name) {
        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();
        String[] columns = {DBInfo.names, DBInfo.username, DBInfo.password};
        Cursor cursor = sqLiteDatabase.query(DBInfo.tableName, columns, DBInfo.username + " = '" + Name + "'", null, null, null, null, null);

        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DBInfo.names);
            int index2 = cursor.getColumnIndex(DBInfo.username);
            int index3 = cursor.getColumnIndex(DBInfo.password);

            String FullName = cursor.getString(index1);
            String username = cursor.getString(index2);
            String password = cursor.getString(index3);

            stringBuffer.append(".Name: " + FullName + " UN: " + username + " Pass: " + password + "\n");

        }
        return stringBuffer.toString();

    }

    public String searchName(String Name) {
        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();
        String[] columns = {DBInfo.names, DBInfo.username, DBInfo.password};
        Cursor cursor = sqLiteDatabase.query(DBInfo.tableName, columns, DBInfo.names + " = '" + Name + "'", null, null, null, null, null);

        StringBuffer stringBuffer = new StringBuffer();

        while (cursor.moveToNext()) {

            int index1 = cursor.getColumnIndex(DBInfo.names);
            int index2 = cursor.getColumnIndex(DBInfo.username);
            int index3 = cursor.getColumnIndex(DBInfo.password);

            String FullName = cursor.getString(index1);
            String username = cursor.getString(index2);
            String password = cursor.getString(index3);

            stringBuffer.append(".Name: " + FullName + " UN: " + username + " Pass: " + password + "\n");

        }
        return stringBuffer.toString();

    }

    public int UpdateName(String old_Name, String New_Name) {
        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBInfo.names, New_Name);


        String[] whereArgs = {old_Name};

        int count = sqLiteDatabase.update(DBInfo.tableName, contentValues, DBInfo.names + " =? ", whereArgs);


        return count;

    }

    public int DeleteName(String user_Name) {
        SQLiteDatabase sqLiteDatabase = dbInfo.getWritableDatabase();


        String[] whereArgs = {user_Name};
        String del = DBInfo.username + " =? ";

        int count = sqLiteDatabase.delete(DBInfo.tableName, del, whereArgs);
        return count;

    }


    static class DBInfo extends SQLiteOpenHelper {

        private static final String dataBase_Name = "ahmed";
        private static final String tableName = "AHMED";
        private static final int dataBase_Version = 1;
        private static final String UID = "id";
        private static final String names = "Name";
        private static final String username = "Username";
        private static final String password = "Password";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + tableName;
        private static final String CREATE_TABLE = "CREATE TABLE " + tableName + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + names + " VARCHAR(255), " + username + " VARCHAR(255), " + password + " VARCHAR(255));";
        private Context context;


        public DBInfo(@Nullable Context context) {
            super(context, dataBase_Name, null, dataBase_Version);
            this.context = context;
            Toast.makeText(context, "this is Constructor ", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
                Toast.makeText(context, "onCreate Method ", Toast.LENGTH_SHORT).show();

            } catch (SQLException e) {
                Toast.makeText(context, "due to: " + e, Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

            try {
                Toast.makeText(context, "onUpgrade Method ", Toast.LENGTH_SHORT).show();
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                Toast.makeText(context, "due to: " + e, Toast.LENGTH_SHORT).show();
            }

        }


    }
}
