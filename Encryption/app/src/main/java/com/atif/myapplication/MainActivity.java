package com.atif.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    //TODO Change key and iv before use
    static String key = "aTif@nAvEeDdN_oMaTiFaBduLlAhaTff"; // 32 character of your choice
    static String iv = "t@heZbI_aYsHi01o"; // 16 character of your choice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            String plainText = "My Name is Atif";
            String encryptedText = "";

            byte[] keyBytes = key.getBytes("UTF-8");
            byte[] ivBytes = iv.getBytes("UTF-8");
            byte[] cipherData;

            cipherData = AESCipher.encrypt(ivBytes, keyBytes, plainText.getBytes("UTF-8"));
            plainText = Base64.encodeToString(cipherData, Base64.DEFAULT);
            Log.d("After Encryption", plainText);
            encryptedText = plainText;

            cipherData = AESCipher.decrypt(ivBytes, keyBytes, Base64.decode(encryptedText.getBytes("UTF-8"), Base64.DEFAULT));
            plainText = new String(cipherData, "UTF-8");
            Log.d("After Decryption", plainText);

        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }
}
