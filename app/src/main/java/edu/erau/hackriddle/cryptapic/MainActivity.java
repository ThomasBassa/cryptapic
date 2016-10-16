package edu.erau.hackriddle.cryptapic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText userField;
    private EditText passField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void attemptLogin(View view) {
        //Going to auth later...
        Intent gallery = new Intent(this, GalleryView.class);
        startActivity(gallery);
    }

    public void recoverAccount(View view) {
        Intent accountExists = new Intent(this, AccountExsists.class);
        startActivity(accountExists);
    }
}
