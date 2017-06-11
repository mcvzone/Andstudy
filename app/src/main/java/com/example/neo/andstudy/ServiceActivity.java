package com.example.neo.andstudy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void onServiceCall(View view){
        Intent intent = new Intent(getApplicationContext(), MyService.class);
        intent.putExtra("command", "start");
        startService(intent);
    }
}
