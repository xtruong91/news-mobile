package com.xtruong.petapp.data.db.model.recyclerview;

import java.util.ArrayList;

/**
 * Created by truongtx on 7/26/2019
 */
public class Contact {

    private String name;
    private boolean online;

    public Contact(String mName, boolean mOnline) {
        this.name = mName;
        this.online = mOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public static int getLastContactId() {
        return lastContactId;
    }

    public static void setLastContactId(int lastContactId) {
        Contact.lastContactId = lastContactId;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }

}
