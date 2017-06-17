package com.example.neo.andstudy;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class InplrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inplration);
    }

    public void onButtonClicked(View v){
        /* xml을 붙여줄때 사용하는 코드
        LinearLayout container = (LinearLayout)findViewById(R.id.inp_lay_container);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.inplration_sub, container, true);

        container.findViewById(R.id.inpsub_bt_click).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "서브화면의 버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
            }
        });
        */

        //java 로 로딩하는 방법.
        Sublayout layout1 = new Sublayout(this);
        LinearLayout container = (LinearLayout)findViewById(R.id.inp_lay_container);
        container.addView(layout1);


    }
}
