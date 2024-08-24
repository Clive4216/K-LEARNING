package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses.Constant;

import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.utils.Utils;

public class SplashActivity extends AppCompatActivity  {




    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        context = this;
        callApi();

    }

    public void callApi() {
        if (Utils.isNetworkConnected(this)) {
            successCall();
        }

        handler.postDelayed(myRunnable, 1000);
    }

    private void successCall() {
        if (Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1) == 1) {
            Log.e("TAG", "successCall::::IFFFFF " + Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1));
            Utils.setPref(this, Constant.SPLASH_SCREEN_COUNT, 2);

            startNextActivity(1000);
        } else {
            Log.e("TAG", "successCall::::ELSEEE " + Utils.getPref(this, Constant.SPLASH_SCREEN_COUNT, 1));

        }
    }




    public void startNextActivity(Integer time) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, time);
    }


    /*For ads*/
   // @Override
   // public void adLoadingFailed() {
  //      startNextActivity(0);
   // }

   // @Override
   // public void adClose() {
   //     startNextActivity(0);
   // }

   // @Override
    //public void startNextScreen() {
    //    startNextActivity(0);
    //}

    //private Boolean isLoaded = false;

   // @Override
   // public void onLoaded() {
      //  isLoaded = true;
   // }

    private Handler handler = new Handler();
    private Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            if (Utils.isNetworkConnected(SplashActivity.this)) {
               // if (!isLoaded) {
                    startNextActivity(0);
               // }
            }
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(myRunnable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(myRunnable);
    }
}

