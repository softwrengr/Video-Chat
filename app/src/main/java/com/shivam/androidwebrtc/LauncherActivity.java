package com.shivam.androidwebrtc;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.myhexaville.androidwebrtc.R;
import com.shivam.androidwebrtc.tutorial.CompleteActivity;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ChatApplication app = new ChatApplication();
        Socket mSocket = app.getSocket();

        mSocket.connect();

    }
    public void openSampleSocketActivity(View view) {
        startActivity(new Intent(this, CompleteActivity.class));

    }

    //connecting socket
    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LauncherActivity.this, "connect", Toast.LENGTH_SHORT).show();

                }
            });
        }

    };

    //showing error in connecting socket
    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(LauncherActivity.this, "connect", Toast.LENGTH_SHORT).show();

                }
            });
        }

    };
}
