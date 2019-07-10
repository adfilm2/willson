package com.example.appjam_willson.fcm;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    public void onMessageReceived (RemoteMessage remoteMessage){
        Map<String, String> bundle = remoteMessage.getData();
    }

}
