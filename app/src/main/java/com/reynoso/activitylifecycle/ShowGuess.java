package com.reynoso.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.reynoso.activitylifecycle.databinding.ActivityMainBinding;

public class ShowGuess extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null) mainBinding.receivedTextView.setText(bundle.getString("name")+" "+bundle.getInt("age",41));

        mainBinding.receivedTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back","Tu nombre es: "+bundle.getString("name")+" ,tu numero favorito es 41");
                //code from result and intent
                setResult(RESULT_OK,intent);
                //removes the activity from the stack
                finish();
            }
        });
    }
}