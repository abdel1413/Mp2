package com.example.mp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    //constant used to get intent string for the second activity
    public static final String EXTRA_MESSAGE = "com.example.mp2.extra.MESSAGE";

    private EditText mMessageEditText; //to hold the editText for reference in second activity

    public static final int TEXT_REQUEST = 1;  //key for response from second activity

    private TextView mReplyHeadTextView; // to hold reply header  from textVIew
    private TextView mReplyTextView;    //to hold reply text  from textView



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mMessageEditText = findViewById(R.id.editText_main);  //get the reference  to the editText from layout

        //to get reponse from seconde activity and show it on main activity screen
        mReplyHeadTextView = findViewById(R.id.text_header_reply);  //find reference to reply header
        mReplyTextView = findViewById(R.id.text_message_reply);    //find reference to reply message
    }

    public void launchSecondActivity(View view) {

        Log.d(LOG_TAG, "Button clicked!");

        Intent intent = new Intent(this, SecondActivity.class);

        //get the text from editText
        String message = mMessageEditText.getText().toString();

        //add the constant and message  as parameters of putExtra(key, value)
        intent.putExtra(EXTRA_MESSAGE, message);


        //clear  out the input box after sending the msg
        mMessageEditText.setText("");
        //  startActivity(intent);

        //change startActivity(intent) to startActivityForResult() in order to
        //to able to get response from second activity
        startActivityForResult(intent, TEXT_REQUEST);
    }
}