package com.example.neo.andstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RelativeLayoutActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        findViewById(R.id.relative_bt_top).setOnClickListener(this);
        findViewById(R.id.relative_bt_bottom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView txtMain = (TextView)findViewById(R.id.relative_txt_main);
        String sText = (String) txtMain.getText();

        switch(v.getId()){
            case R.id.relative_bt_top: {
                txtMain.setText(sText + "\n이 문구가 들어가면 성공이고. setText");
                break;
            }
            case R.id.relative_bt_bottom: {
                if( sText.lastIndexOf("\n") != -1 ) {
                    txtMain.setText(sText.substring(0, sText.lastIndexOf("\n")));
                } else {
                    Toast.makeText(getApplicationContext(), "마지막 입니다.", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }
}
