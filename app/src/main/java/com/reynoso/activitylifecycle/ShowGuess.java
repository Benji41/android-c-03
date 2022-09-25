package com.reynoso.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.reynoso.activitylifecycle.databinding.ActivityMainBinding;

public class ShowGuess extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) mainBinding.receivedTextView.setText(bundle.getString("name")+" "+bundle.getInt("age",41));
    }
}