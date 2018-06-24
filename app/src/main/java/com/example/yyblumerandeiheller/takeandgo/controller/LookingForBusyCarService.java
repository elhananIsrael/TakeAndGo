package com.example.yyblumerandeiheller.takeandgo.controller;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import com.example.yyblumerandeiheller.takeandgo.model.backend.FactoryMethod;
import com.example.yyblumerandeiheller.takeandgo.model.entities.Car;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class LookingForBusyCarService extends Service {
    ArrayList<Car> carAvailable=new ArrayList();
    ArrayList<Car> tempCarAvailable=new ArrayList();
    ArrayList<Car> lastCarAvailable=new ArrayList();

    boolean isFirstTime=true;
    int id = 0, startId = -1;
    boolean isRun = false;
    final String TAG = "testService";
    private Timer timer = new Timer();
    static final int UPDATE_INTERVAL = 1000 * 10;
    public static final String PARAM_OUT_MSG = "OUT_MESSAGE";
    public static final String ACTION_RESP =
            "takego_clientside.yaakovblumer.example.com.intent.action.MESSAGE_PROCESSED";


    String serviceInfo()
    {
        return "service [" + id + "] startId = " + startId;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                /////////////////////////////////////////
                if(isFirstTime)
                {
                    isFirstTime=false;
                    carAvailable= FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarAvailable();

                    Intent broadcastIntent = new Intent();
                    broadcastIntent.setAction(ACTION_RESP);
                    broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
                    broadcastIntent.putExtra(PARAM_OUT_MSG, "Cars available: " + carAvailable.toString());
                    sendBroadcast(broadcastIntent);

                    Log.d("Take&Go-Service", "Start Sending message..");

                }

                else {

                    tempCarAvailable=FactoryMethod.getDataSource(FactoryMethod.Type.MySQL).allCarAvailable();
                    lastCarAvailable.addAll(tempCarAvailable);

                    for (Car tempCarItem : tempCarAvailable) {
                        for (Car carItem : carAvailable) {
                            if (tempCarItem.getLicenseNumber().equals(carItem.getLicenseNumber()))
                                lastCarAvailable.remove(tempCarItem);
                        }}

                    carAvailable.clear();
                    carAvailable.addAll(tempCarAvailable);
                    if(!lastCarAvailable.isEmpty())
                    {
                        Intent broadcastIntent = new Intent();
                        broadcastIntent.setAction(ACTION_RESP);
                        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
                        broadcastIntent.putExtra(PARAM_OUT_MSG, "Last cars available: " + lastCarAvailable.toString());
                        sendBroadcast(broadcastIntent);
                        Log.d("Take&Go-Service", "Last cars available: " + lastCarAvailable.toString());
                    }

                }

            }
        }, 1, UPDATE_INTERVAL);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
        //
        Object obj = getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationManager notificationManager = (NotificationManager)obj;
        notificationManager.cancel(1234);
        //
        Log.d(TAG, serviceInfo() + " onDestroy ...");
        isRun = false;
        Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
