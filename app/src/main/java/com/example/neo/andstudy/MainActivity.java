package com.example.neo.andstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_bt_newscreen).setOnClickListener(this);
        findViewById(R.id.main_bt_relativelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_scrollview).setOnClickListener(this);
        findViewById(R.id.main_bt_tablelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_framelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_inplration).setOnClickListener(this);
        findViewById(R.id.main_bt_intentdata).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent = null;

        switch (v.getId()){
            case R.id.main_bt_newscreen:
                Toast.makeText(this, "Toast", Toast.LENGTH_SHORT).show();
                intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_relativelayout:
                intent = new Intent(getApplicationContext(), RelativeLayoutActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_scrollview:
                intent = new Intent(getApplicationContext(), ScrollViewActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_tablelayout:
                intent = new Intent(getApplicationContext(), TableLayoutActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_framelayout:
                intent = new Intent(getApplicationContext(), FrameLayoutActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_intentdata:
                intent = new Intent(getApplicationContext(), IntentDataPassActivity.class);
                intent.putExtra("title", "소녀시대");
                startActivityForResult(intent, 1001);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( data != null ){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
