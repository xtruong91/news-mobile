package com.xtruong.petapp.ui.contact;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.xtruong.petapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by truongtx on 7/26/2019
 */
public class ContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_contact);
        ButterKnife.bind(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // white background notification bar
        whiteNotificationBar(toolbar);
    }

    @OnClick(R.id.btn_local_search)
    public void openLocalSearch() {
        // launching local search activity
        startActivity(new Intent(ContactsActivity.this, LocalSearchActivity.class));
    }

    @OnClick(R.id.btn_remote_search)
    public void openRemoteSearch() {
        // launch remote search activity
        startActivity(new Intent(ContactsActivity.this, RemoteSearchActivity.class));
    }

    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }
}
