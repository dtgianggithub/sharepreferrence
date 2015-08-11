package com.example.giangdam.file_sharepreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {


    Button btnLogin;

    EditText txtUserName,txtPassWord;
    CheckBox chkSave;

    //file name for save info login
    public static final String preferenceSaveInfo = "my_info_login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        txtUserName = (EditText)findViewById(R.id.txtUserName);
        txtPassWord = (EditText)findViewById(R.id.txtPassWord);
        chkSave = (CheckBox)findViewById(R.id.chkSave);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtPassWord.getText().toString() != "" && txtUserName.getText().toString() != "'")
                {
                    executeLogin();
                }


            }
        });
    }


    public void executeLogin()
    {
        Intent intent = new Intent(MainActivity.this,LoginSuccessActivity.class);
        Bundle bundle = new Bundle();

        bundle.putString("UserName",txtUserName.getText().toString());

        intent.putExtra("BundleLogin", bundle);
        startActivity(intent);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
         // luu thong tin tai day
        savingPreferences();

    }

    public void savingPreferences()
    {
        //tao doi tuong getSharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(preferenceSaveInfo,MODE_PRIVATE);


        //tao doi tuong editer
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String user  = txtUserName.getText().toString();
        String pass = txtPassWord.getText().toString();

        boolean bchk = chkSave.isChecked();


        if(!bchk)
        {
            //xoa du lieu luu truoc do
            editor.clear();
        }
        else
        {
            editor.putString("user",user);
            editor.putString("pass",pass);
            editor.putBoolean("checked",bchk);
        }

        editor.commit();


    }

    @Override
    protected  void onResume()
    {
        super.onResume();

        //doc thong tin len o day
        restoringPreferences();
    }


    public void restoringPreferences()
    {
        //tao doi tuong getSharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(preferenceSaveInfo,MODE_PRIVATE);

        //lay gia tri checkbook, k co mac dinh la false
        boolean bchk = sharedPreferences.getBoolean("checked",false);
        if(bchk)
        {
            //lay user, pass, neu k co mac dinh gia tri la rong
            String user = sharedPreferences.getString("user","");
            String pass = sharedPreferences.getString("pass","");
            txtUserName.setText("user");
            txtPassWord.setText("pass");
        }

        chkSave.setChecked(bchk);
    }




}
