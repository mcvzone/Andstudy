package com.example.neo.andstudy;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACTIVITY_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int READ_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int RECEIVE_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        // Here, thisActivity is the current activity
        if (READ_SMS == PackageManager.PERMISSION_DENIED || RECEIVE_SMS == PackageManager.PERMISSION_DENIED) {
            //shouldShowRequestPermissionRationale 는 권한 요청을 했지만, 사용자가 거부 한 경우 true를 리턴 한다.
            //하지만 Don't ask again 을 체크한 상태에서 거부한 경우 false 를 리턴 한다.
            boolean isReadSms = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_SMS);
            Log.d("MYLOG", "isReadSms : " + isReadSms);

            boolean isReceiveSms = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS);
            Log.d("MYLOG", "isReceiveSms : " + isReceiveSms);

            if( isReadSms || isReceiveSms ) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 1);
            }

        }

        findViewById(R.id.main_bt_newscreen).setOnClickListener(this);
        findViewById(R.id.main_bt_relativelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_scrollview).setOnClickListener(this);
        findViewById(R.id.main_bt_tablelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_framelayout).setOnClickListener(this);
        findViewById(R.id.main_bt_inplration).setOnClickListener(this);
        findViewById(R.id.main_bt_intentdata).setOnClickListener(this);
        findViewById(R.id.main_bt_callphone).setOnClickListener(this);
        findViewById(R.id.main_bt_dynamic).setOnClickListener(this);
        findViewById(R.id.main_bt_lifecycle).setOnClickListener(this);
        findViewById(R.id.main_bt_service).setOnClickListener(this);
        findViewById(R.id.main_bt_permission).setOnClickListener(this);

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

            case R.id.main_bt_callphone:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-7400-2079"));
                startActivity(intent);
                break;

            case R.id.main_bt_dynamic:
                //intent = new Intent(getApplicationContext(), MenuActivity.class);
                //startActivityForResult(intent, ACTIVITY_MENU);

                intent = new Intent();
                ComponentName name = new ComponentName("com.example.neo.andstudy", "com.example.neo.andstudy.MenuActivity");
                intent.setComponent(name);
                intent.putExtra("title", "소녀시대");
                intent.putExtra("age", 10);

                Person per = new Person("걸스데이", 21);
                intent.putExtra("person", per);

                startActivityForResult(intent, ACTIVITY_MENU);
                break;

            case R.id.main_bt_lifecycle:
                intent = new Intent(getApplicationContext(), LifeCycleActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_service:
                intent = new Intent(getApplicationContext(), ServiceActivity.class);
                startActivity(intent);
                break;

            case R.id.main_bt_permission:
                intent = new Intent(getApplicationContext(), PermissionActivity.class);
                startActivity(intent);
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
