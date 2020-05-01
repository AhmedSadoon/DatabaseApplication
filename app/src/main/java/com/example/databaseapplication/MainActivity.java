package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBConnection dataBase;
    EditText etName,etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etname);
        etUserName=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);

        dataBase=new DBConnection(this);
    }

    public void Save(View view) {

        String fullName=etName.getText().toString();
        String username=etUserName.getText().toString();
        String Password=etPassword.getText().toString();

        long id= dataBase.datainsert(fullName,username,Password);
        if (id<0){

            Toast.makeText(this,"Error Not Inserted",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Successfully Inserted",Toast.LENGTH_SHORT).show();

        }

    }

    public void view_data(View view) {
        Intent intent=new Intent(this,ViewDataActivity.class);
        startActivity(intent);
    }

    public void Next(View view) {
        Intent intent=new Intent(this,SearchActivity.class);
        startActivity(intent);
    }

    public void Update(View view) {
        Intent intent=new Intent(this,UpdateActivity.class);
        startActivity(intent);
    }

    public void Delete(View view) {
        Intent intent=new Intent(this,DeleteActivity.class);
        startActivity(intent);
    }
}
