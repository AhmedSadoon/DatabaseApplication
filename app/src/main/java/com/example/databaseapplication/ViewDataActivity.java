package com.example.databaseapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ViewDataActivity extends AppCompatActivity {

    DBConnection dataBase;
    TextView tvView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        dataBase=new DBConnection(this);
        tvView=findViewById(R.id.tvshow);
    }

    public void view_data(View view) {

        String data=dataBase.viewData();

        tvView.setText(data);


    }
}
