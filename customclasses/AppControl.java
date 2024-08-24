package com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.customclasses;

import android.app.Application;
import android.content.Context;
import android.speech.tts.TextToSpeech;

import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.R;
import com.kidslearning.kidsplay.kidsgames.kidseducation.K_LEARNING.utils.Utils;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


public class AppControl extends Application {
    Context context;
    public static TextToSpeech textToSpeech;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        new Utils(context);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("Fon/OhWhale.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(new Locale("en","IN"));
//                    textToSpeech.setLanguage(Locale.forLanguageTag(""));
                }
            }
        },
                "com.google.android.tts");
    }


}
