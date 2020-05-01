package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    DBConnection dataBase;
    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        etUserName = findViewById(R.id.et_user_name);
        dataBase = new DBConnection(this);
    }


    public void back(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Delete(View view) {


        String str = etUserName.getText().toString();
        int count = dataBase.DeleteName(str);
        Toast.makeText(this, count + " deleted", Toast.LENGTH_SHORT).show();

    }
}
