package edu.erau.hackriddle.cryptapic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText userField;
    private EditText passField;
    private Button accountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userField = (EditText) findViewById(R.id.editUsername);
        passField = (EditText) findViewById(R.id.editPassword);
        accountButton = (Button) findViewById(R.id.accountButton);

        if (keysExist()) {
            userField.setVisibility(View.GONE);
            accountButton.setVisibility(View.GONE);
        }
    }

    private boolean keysExist() {
        return true; //true; TODO real condition-- do keys exist
    }

    public void attemptLogin(View view) {
        //Going to auth later...
        Intent gallery = new Intent(this, GalleryView.class);
        startActivity(gallery);
    }

    public void recoverAccount(View view) {
        Intent accountExists = new Intent(this, AccountExists.class);
        startActivity(accountExists);
    }
}
