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

    /**
     * Prepend this string to private keys before encrypting them with the user
     * password. Use this to detect whether later decryption is successful.
     */
    private static final String PRIVATE_KEY_PREFIX = "CAP-PK";
    public static final String KEY_FILE_NAME = ".userKeys";


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
        return new File(getFilesDir(), KEY_FILE_NAME).exists();
    }

    public void attemptLogin(View view) {
        Log.v("cryptapic", "Login attempt.");
        if (keysExist()) {
            //Log in the existing user
            String decryptResult = decryptPrivateKey(passField.getText().toString());
            if (decryptResult.startsWith(PRIVATE_KEY_PREFIX)) {
                //Successfully decrypted

                Intent gallery = new Intent(this, GalleryView.class);
                //TODO Strip prefix from PK & store this in the intent

                //Open the gallery!
                startActivity(gallery);
            } else {
                //Decrypt fail
                passField.setText("");
                Toast.makeText(this, "The password was wrong", Toast.LENGTH_LONG).show();
            }
        } else {
            Log.v("cryptapic", "Creating a new user!");
            //Create new key file/DB user

            //Generate an RSA? key pair securely

            //Write the public key to KEY_FILE_NAME as the first? line

            //Encrypt PRIVATE_KEY_PREFIX + the private key using the user password

            //Write that as the second line of keyfile

            //Publish public key & username to AWS or similar

        }
    }

    private String decryptPrivateKey(String userPassword) {
        return PRIVATE_KEY_PREFIX + "result of decrypting PK in KEY_FILE_NAME";
    }

    public void recoverAccount(View view) {
        //This is all test code for the keysExist method
        File testFile = new File(getFilesDir(), KEY_FILE_NAME);
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
