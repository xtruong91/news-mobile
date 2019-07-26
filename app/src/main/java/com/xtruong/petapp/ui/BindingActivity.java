package com.xtruong.petapp.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xtruong.petapp.R;
import com.xtruong.petapp.databinding.ActivityBindingmainBinding;
import com.xtruong.petapp.data.db.model.recyclerview.User;

/**
 * Created by truongtx on 7/25/2019
 */
public class BindingActivity extends AppCompatActivity {
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView(R.layout.activity_main);

        ActivityBindingmainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_bindingmain);

        user = new User();
        user.setName("Ravi Tamada");
        user.setEmail("ravi@androidhive.info");

        binding.setUser(user);
    }
}
