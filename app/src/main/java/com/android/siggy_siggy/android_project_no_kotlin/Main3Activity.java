package com.android.siggy_siggy.android_project_no_kotlin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Main3Activity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android_project_no_kotlin.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    }
    public void switchBackToActivity2(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText editText2 = findViewById(R.id.editText2);
        String message2 = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message2);

        startActivity(intent);
    }
    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        super.onBackPressed();  // optional depending on your needs
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        // just store the message data from editText2
        // +code so the backbutton also saves data input because luls
        EditText editText2 = findViewById(R.id.editText2);
        String message2 = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message2);
        startActivity(intent);
    }




}
