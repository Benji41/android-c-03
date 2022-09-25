 package com.reynoso.activitylifecycle;

import static android.content.ContentValues.TAG;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.reynoso.activitylifecycle.databinding.ActivityMainBinding;
import com.reynoso.activitylifecycle.databinding.ActivityShowGuessBinding;

 public class MainActivity extends AppCompatActivity {
    private ActivityShowGuessBinding showGuessBinding;
    private final int REQUEST_CODE =2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showGuessBinding = DataBindingUtil.setContentView(this,R.layout.activity_show_guess);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
        showGuessBinding.buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ShowGuess.class);
                intent.putExtra("name",showGuessBinding.inputFieldGuess.getText().toString().trim());
                intent.putExtra("age",23);
                //TO START A NEW ACTIVITY AND EXPECT A RESULT FROM THE COMING ACTIVITY USE:
                startActivityForResult(intent, REQUEST_CODE);
                //startActivity(intent);
            }
        });
    }

     @Override
     protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String message = data.getStringExtra("message_back");
                Snackbar.make(MainActivity.this,showGuessBinding.getRoot(),message,Snackbar.LENGTH_SHORT).show();
            }
        }


     }

     @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

}