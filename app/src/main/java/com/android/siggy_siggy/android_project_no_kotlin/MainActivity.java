package com.android.siggy_siggy.android_project_no_kotlin;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.content.SharedPreferences;
import android.widget.Spinner;

import java.util.prefs.Preferences;
//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.android_project_no_kotlin.MESSAGE";
    public static final String SPINNER_VAL = "spinner_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    // code for spinner
    Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // create arrayadapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinnerItems, android.R.layout.simple_spinner_item);
        //specify the layout
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // apply adapter to the spinner
        spinner.setAdapter(adapter);


    }
        /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        message = "hello\n"+message;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
/*
    private void storePreferences() {
        String selectedString = yourArray[yourSpinner.getSelectedItemPosition()];
        editor.putString("spinnerSelection", selectedString);
        editor.commit();
    }

    private void loadPreferences() {
        //ArrayList<String> list = new ArrayList<String>();
        ArrayList.indexOf(prefs.getString("spinnerSelection", ""));
    }
    */

private void storePreferences() {
    final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
    final SharedPreferences.Editor editor = prefs.edit();
    //String selectedString = R.array.spinnerItems[yourSpinner.getSelectedItemPosition()];
    //editor.putString("spinnerSelection", selectedString);
    editor.putString(SPINNER_VAL, (String) ((Spinner)findViewById(R.id.spinner)).getSelectedItem());
    editor.commit();
}

public void onPause() {
    super.onPause();
    storePreferences();
}

public void onResume() {
    super.onResume();
    SharedPreferences prefs = getSharedPreferences(SPINNER_VAL, 0);
    String text = prefs.getString(SPINNER_VAL, "");

}

public void onRestart() {
    super.onRestart();
    SharedPreferences prefs = getSharedPreferences(SPINNER_VAL, 0);
    String text = prefs.getString(SPINNER_VAL, "");
}

}
