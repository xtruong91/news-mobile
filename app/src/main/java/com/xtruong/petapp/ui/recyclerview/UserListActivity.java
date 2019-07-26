package com.xtruong.petapp.ui.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xtruong.petapp.R;
import com.xtruong.petapp.data.db.model.recyclerview.Contact;

import java.util.ArrayList;

/**
 * Created by truongtx on 7/26/2019
 *
 * 1. Add RecyclerView support library to the Gradle build file
 * 2. Define a model class to use as the data source
 * 3. Add a RecyclerView to your activity to display the items
 * 4. Create a custom row layout XML file to visualize the item
 * 5. Create a RecyclerView.Adapter and ViewHolder to render the item
 * 6. Bind the adapter to the data source to populate the RecyclerView
 */
public class UserListActivity extends AppCompatActivity {

    ArrayList<Contact> contacts;
    //private UserListActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_recycler_users);
        // Lookup the recyclerview in activity layout
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        // Initialize contacts
        contacts = Contact.createContactsList(20);
        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
