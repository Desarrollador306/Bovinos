package com.example.pablosanjuan.core;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;


public class Splash extends ActionBarActivity {


    private static final long SPLASH_SCREEN_DELAY = 3000;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        prefs = getSharedPreferences("datos", Context.MODE_PRIVATE);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                if (prefs.getBoolean("validar_sesion", false)) {
                    Intent ir_log = new Intent().setClass(Splash.this, Main.class);
                    startActivity(ir_log);
                    finish();
                }else{
                    Intent ir_princ = new Intent().setClass(Splash.this, Logueo.class);
                    startActivity(ir_princ);
                    finish();
                }
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }
}
