package com.xtruong.petapp.utils;

/**
 * Created by truongtx on 7/25/2019
 */
public final class AppConstant {
    private AppConstant() {
        // This class in not publicly instantiable.
    }

    public static final String LINE_SEPARATOR = "\n";

    // To fetch the tickets
    // https://api.androidhive.info/json/airline-tickets.php

    // To fetch individual ticket price
    // https://api.androidhive.info/json/airline-tickets-price.php
    public static final String BASE_URL = "https://api.androidhive.info/json/";

    public static final String BASE_URL_NOTE = "https://demo.androidhive.info/";

    // contact
    public static final String BASE_URL_CONTACT = "https://api.androidhive.info/json/";

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";
}
