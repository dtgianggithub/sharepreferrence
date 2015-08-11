package com.example.giangdam.file_sharepreference_setting;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class MySetting extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my_setting);

        addPreferencesFromResource(R.xml.mypreferencelayout);
    }


}
