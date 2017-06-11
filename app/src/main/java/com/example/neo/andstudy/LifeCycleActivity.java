package com.example.neo.andstudy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class LifeCycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle);

        Toast.makeText(getApplicationContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        Toast.makeText(getApplicationContext(), "onStart", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(getApplicationContext(), "onStop", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(getApplicationContext(), "onPause", Toast.LENGTH_SHORT).show();
        saveScore();
        super.onPause();
    }

    @Override
    protected void onResume() {
        Toast.makeText(getApplicationContext(), "onResume", Toast.LENGTH_SHORT).show();
        loadScore();
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Toast.makeText(getApplicationContext(), "onRestart", Toast.LENGTH_SHORT).show();
        super.onRestart();
    }


    private void saveScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("score", 10000);
        editor.commit();
    }

    private void loadScore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE);
        int score = pref.getInt("score", 0);

        Toast.makeText(getApplicationContext(), "load scroe : " + score, Toast.LENGTH_SHORT).show();
    }
}
