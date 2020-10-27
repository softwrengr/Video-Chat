package com.shivam.androidwebrtc;

import android.app.Application;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;


public class ChatApplication extends Application {

    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("https://ancient-mountain-83221.herokuapp.com/");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return mSocket;
    }

}
