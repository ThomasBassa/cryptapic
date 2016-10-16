package edu.erau.hackriddle.cryptapic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
            //accountButton.setVisibility(View.GONE);
        }
    }

    private boolean keysExist() {
        return new File(getFilesDir(), "userKeys").exists();
    }

    public void attemptLogin(View view) {
        //Going to auth later...
        Intent gallery = new Intent(this, GalleryView.class);
        startActivity(gallery);
    }

    public void recoverAccount(View view) {
        //This is all test code for the keysExist method
        File testFile = new File(getFilesDir(), "userKeys");
        if (keysExist()) {
            if (!testFile.delete()) {
                Log.wtf("cryptapic", "Couldn't delete test file though exists?");
            }
            Toast.makeText(this, "Keys exist-- deleted", Toast.LENGTH_SHORT).show();
        } else {
            try (FileOutputStream stream = new FileOutputStream(testFile)) {
                stream.write(0x30);
            } catch (IOException e) {
                Toast.makeText(this, "Key creation failed", Toast.LENGTH_SHORT)
                        .show();
                Log.e("cryptapic", e.toString(), e);
            }
            Toast.makeText(this, "Keys created", Toast.LENGTH_SHORT).show();
        }

        //"Actual" code
        //Intent accountExists = new Intent(this, AccountExists.class);
        //startActivity(accountExists);
    }
}
