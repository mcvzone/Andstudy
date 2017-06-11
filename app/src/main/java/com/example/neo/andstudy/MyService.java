package com.example.neo.andstudy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public void onCreate() {
        Log.d(MyService.class.getSimpleName(), "onCreate() success.");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(MyService.class.getSimpleName(), "onStartCommand() success.");

        if( intent != null ){
            String command = intent.getStringExtra("command");
            if( command != null ){
                if( command.equals("start")){
                    PrintThread thread = new PrintThread();
                    thread.start();
                }
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }

    class PrintThread extends Thread{
        public void run(){
            for(int i=0; i<10; i++){
                Log.d(MyService.class.getSimpleName(), "#" + i + "서비스 반복됨.");

                try{
                    Thread.sleep(1000);
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onDestroy() {
        Log.d(MyService.class.getSimpleName(), "onDestroy() success.");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
