package com.example.neo.andstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {

    ImageView shutdown, standby;
    boolean isSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        shutdown = (ImageView)findViewById(R.id.frame_img_shutdown);
        standby = (ImageView)findViewById(R.id.frame_img_standby);

        findViewById(R.id.frame_bt_imagechange).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if( isSelected ) {
                    shutdown.setVisibility(View.VISIBLE);
                    standby.setVisibility(View.GONE);
                } else {
                    shutdown.setVisibility(View.GONE);
                    standby.setVisibility(View.VISIBLE);
                }

                isSelected = !isSelected;
            }
        });
    }
}
