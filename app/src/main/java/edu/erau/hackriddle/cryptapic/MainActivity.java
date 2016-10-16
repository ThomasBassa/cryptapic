package edu.erau.hackriddle.cryptapic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void attemptLogin(View view) {

    }

    public void recoverAccount(View view) {
        Intent accountExists = new Intent(this, AccountExsists.class);
        startActivity(accountExists);
    }
}
