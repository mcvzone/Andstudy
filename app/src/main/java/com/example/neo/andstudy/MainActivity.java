package com.example.neo.andstudy;

import android.Manifest;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int ACTIVITY_MENU = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //문자메시지의 내용을 가져오기 위해, 권한을 얻어야 한다
        //4.0 버전 이상 부터는 해당 기능을 통해 필요한 부분모두 권한을 사용자로 부터 얻어야
        //permission 값이 0이 되어 해당 기능을 사용할수 있게된다.
        int READ_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int RECEIVE_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);

        Log.d("MYLOG", "READ_SMS - RECEIVE_SMS - PackageManager.PERMISSION_DENIED : " + READ_SMS + " - " + RECEIVE_SMS + " - " + PackageManager.PERMISSION_DENIED);

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

                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, ACTIVITY_MENU);
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
        findViewById(R.id.main_bt_msgbox).setOnClickListener(this);
    }


    /**
     * 퍼미션 메소드를 호출후의 콜백함수.
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d("MYLOG", "onRequestPermissionsResult result. requestCode : " + requestCode);
        switch(requestCode){
            case ACTIVITY_MENU: {
                if (grantResults.length > 0 ) {
                    Log.d("MYLOG", "grantResults[0] result : " + grantResults[0]);
                    if( grantResults[0] == PackageManager.PERMISSION_GRANTED ){

                    }

                    Log.d("MYLOG", "grantResults[1] result : " + grantResults[1]);
                    if( grantResults[1] == PackageManager.PERMISSION_GRANTED ){

                    }
                }
                return;
            }
        }
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

            case R.id.main_bt_inplration:
                intent = new Intent(getApplicationContext(), InplrationActivity.class);
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
            case R.id.main_bt_msgbox:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("안내");
                builder.setMessage("종료하시겠습니까?");
                builder.setIcon(android.R.drawable.ic_dialog_alert);


                builder.setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "아니요 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "예 버튼이 클릭되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dial = builder.create();
                dial.show();

                //intent = new Intent(getApplicationContext(), MsgboxActivity.class);
                //startActivity(intent);
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
