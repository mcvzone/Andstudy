package com.example.neo.andstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class IntentDataPassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_data_pass);

        Intent intent = getIntent();
        if( intent != null ){
            String title = intent.getStringExtra("title");
            Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
        }
    }

    public void intentClick(View view){
        Intent intent = new Intent();
        intent.putExtra("name", "티아라");
        setResult(RESULT_OK, intent);
        finish();
    }
}
