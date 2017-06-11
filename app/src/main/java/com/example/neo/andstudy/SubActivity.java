package com.example.neo.andstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        Button btn = (Button)findViewById(R.id.sub_bt_goback);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "서브", Toast.LENGTH_LONG).show();
            }
        });
    }


    public void onclickevent(View v){
        Toast.makeText(getApplicationContext(), "서브 두번째 버튼", Toast.LENGTH_LONG).show();
    }
}
