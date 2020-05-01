package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    DBConnection dataBase;
    EditText etoldname,etNewName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etoldname=findViewById(R.id.et_Old_name);
        etNewName=findViewById(R.id.et_New_name);
        dataBase=new DBConnection(this);
    }

    public void Update(View view) {

        String newName=etNewName.getText().toString();
        String OldName=etoldname.getText().toString();
        dataBase.UpdateName(OldName,newName);
        

    }

    public void back(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
