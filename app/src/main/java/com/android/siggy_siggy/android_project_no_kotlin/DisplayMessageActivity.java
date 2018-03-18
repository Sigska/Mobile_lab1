package com.android.siggy_siggy.android_project_no_kotlin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import android.view.View;


public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        String messageFromA3 = intent.getStringExtra(Main3Activity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        TextView textView2 = findViewById(R.id.textView);
      //  string helloName = "hello"+ message;
      //  textView.setText(helloName);
        textView.setText(message);

        messageFromA3 = "From A3:  "+messageFromA3;
        textView2.setText(messageFromA3);


    }
    public void switchActivity(View view){
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();  // optional depending on your needs
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
