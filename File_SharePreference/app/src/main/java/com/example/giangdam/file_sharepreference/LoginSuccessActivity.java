package com.example.giangdam.file_sharepreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LoginSuccessActivity extends AppCompatActivity {

    TextView lblView;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        lblView = (TextView) findViewById(R.id.lblView);
        btnExit = (Button)findViewById(R.id.btnExit);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BundleLogin");
        lblView.setText("Hello "+ bundle.getString("UserName"));


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}
