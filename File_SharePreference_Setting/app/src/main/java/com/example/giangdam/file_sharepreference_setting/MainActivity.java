package com.example.giangdam.file_sharepreference_setting;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnSetting;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSetting = (Button)findViewById(R.id.btnSetting);

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MySetting.class);
                startActivityForResult(intent,1);
            }
        });

        Context context = getApplicationContext();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

        //get len mac dinh
        if(sharedPreferences.getBoolean("backgroundpref",false))
        {
            btnSetting.setBackgroundColor(Color.RED);
        }
        else {
            btnSetting.setBackgroundColor(Color.GRAY);
        }

    }

    @Override
    protected  void onPause()
    {
        super.onPause();
    }


    @Override
    protected  void onResume()
    {
        super.onResume();

        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals("backgroundpref")) {
                    if (sharedPreferences.getBoolean(key, false)) {
                        btnSetting.setBackgroundColor(Color.RED);
                    }
                    else
                    {
                        btnSetting.setBackgroundColor(Color.GRAY);
                    }
                }
            }
        });

    }




}
