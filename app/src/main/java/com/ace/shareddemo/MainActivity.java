package com.ace.shareddemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Set;

public class MainActivity extends AppCompatActivity {
EditText nameedt,phoneEdt,passEdt,emailEdt;
    SharedPreferences preferences;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameedt=(EditText)findViewById(R.id.editText);
        phoneEdt=(EditText)findViewById(R.id.editText2);
        passEdt=(EditText)findViewById(R.id.editText3);
        emailEdt=(EditText)findViewById(R.id.editText4);
        //create the file
        preferences=getSharedPreferences("myFile",MODE_APPEND);
    }
    public void save(View v){

        String name=nameedt.getText().toString();
        String phone=phoneEdt.getText().toString();
        String pass=passEdt.getText().toString();
        String email=emailEdt.getText().toString();
        //inset the data from preferences
        SharedPreferences.Editor editor=preferences.edit();
        /*String new_contact = name + " " + phone;
        String existing_contact = preferences.getString("NAME", "");
        String phoneNo = preferences.getString("PHONE", "");
        String latestfavContacts = append(existing_contact, new_contact);*/

        editor.putString("NAME",name);
        editor.putString("PHONE",phone);
        editor.putString("PASS",pass);
        editor.putString("Email",email);
        editor.commit();
        nameedt.setText("");
        phoneEdt.setText("");
        passEdt.setText("");
        emailEdt.setText("");


    }
    public void openData(View view){
        Intent intent=new Intent(this,OpenDataActivity.class);
        startActivity(intent);
    }
    public void delete(View view){
        SharedPreferences.Editor editor=preferences.edit();
        editor.remove("NAME");
        editor.remove("PHONE");
        editor.remove("PASS");
        editor.remove("Email");
        editor.apply();

    }public void editData(View view){
        nameedt.setText(preferences.getString("NAME",""));
        phoneEdt.setText(preferences.getString("PHONE",""));
        passEdt.setText(preferences.getString("PASS",""));
        emailEdt.setText(preferences.getString("Email",""));

        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("NAME",nameedt.getText().toString());//key and value
        editor.putString("PHONE",phoneEdt.getText().toString());
        editor.putString("PASS",passEdt.getText().toString());
        editor.putString("Email",emailEdt.getText().toString());
        editor.commit();

    }
    protected String append(String existing_contact, String new_contact) {
        String latestfavContacts = existing_contact + " | " + new_contact;
        return latestfavContacts;
    }
}
