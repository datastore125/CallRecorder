package com.aykuttasil.callrecord.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.aykuttasil.callrecord.CallRecord;

/**
 * Created by aykutasil on 19.10.2016.
 */

public class CallRecordService extends Service {

    private static final String TAG = CallRecordService.class.getSimpleName();

    CallRecord mCallRecord;
    String mFileName;
    String mDirName;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(TAG, "onStartCommand()");

        mFileName = intent.getStringExtra(CallRecord.INTENT_FILE_NAME);
        mDirName = intent.getStringExtra(CallRecord.INTENT_DIR_NAME);

        mCallRecord = new CallRecord.Builder(this)
                .setRecordFileName(mFileName)
                .setRecordDirName(mDirName)
                .build();

        Log.i(TAG, "mCallRecord.startCallReceiver()");
        mCallRecord.startCallReceiver();

        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}
