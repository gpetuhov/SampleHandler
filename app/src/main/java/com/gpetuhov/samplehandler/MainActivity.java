package com.gpetuhov.samplehandler;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MESSAGE_ID = 100;
    public static final int DELAY = 5000;

    private MyHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new MyHandler();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // This removes any pending messages with provided ID
        handler.removeMessages( MESSAGE_ID );

        // This shows Toast 5 seconds later after onResume has been called
        handler.sendMessageDelayed( handler.obtainMessage( MESSAGE_ID ), DELAY );
    }

    private class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MainActivity.this, "Delay passed", Toast.LENGTH_SHORT).show();
        }
    }
}
