package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    EditText etName,etName2;
    TextView tvSh,tvsh2;
    DBConnection database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        etName=findViewById(R.id.etName1);
        tvSh=findViewById(R.id.tvsh);
        etName2=findViewById(R.id.etName2);
        tvsh2=findViewById(R.id.tvsh2);
        database=new DBConnection(this);
    }

    public void Search(View view) {

        String str1=etName.getText().toString();
        String str2=database.searchData(str1);

        tvSh.setText(str2);

    }

    public void Back(View view) {
        Intent intent =new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void SearchName(View view) {

        String str1=etName2.getText().toString();
        String str2=database.searchName(str1);

        tvsh2.setText(str2);
    }
}
