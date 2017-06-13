package com.example.neo.andstudy;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class PermissionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        TextView textView = (TextView)findViewById(R.id.permission_tx);
        int BROADCAST_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.BROADCAST_SMS);
        int READ_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS);
        int RECEIVE_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
        int SEND_SMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);

        Log.d("MYLOG", "BROADCAST_SMS : " + BROADCAST_SMS);
        Log.d("MYLOG", "READ_SMS : " + READ_SMS);
        Log.d("MYLOG", "RECEIVE_SMS : " + RECEIVE_SMS);
        Log.d("MYLOG", "SEND_SMS : " + SEND_SMS);
        Log.d("MYLOG", "PackageManager.PERMISSION_DENIED : " + PackageManager.PERMISSION_DENIED);
        Log.d("MYLOG", "PackageManager.PERMISSION_GRANTED : " + PackageManager.PERMISSION_GRANTED);
    }
}
