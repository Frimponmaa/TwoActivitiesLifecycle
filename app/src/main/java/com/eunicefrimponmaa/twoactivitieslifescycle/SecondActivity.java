package com.eunicefrimponmaa.twoactivitieslifescycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

// this activity is responsible for th esecond activity in the app. it is launched form an intent with a message and sends an intent back with the a second message
public class SecondActivity extends AppCompatActivity {
    // unique tag for the intent reply
    public static final String EXTRA_REPLY="com.eunicefrimponmaa.twoactivities.extra.REPLY";
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();

    // edit text for the reply
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // gets the intent that launched this activity, and the message in the intent extra
        Intent intent = getIntent();
        String message =intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // put that message into the text_message TextView
        TextView textView = (TextView) findViewById(R.id.text_message);
        textView.setText(message);

        //initialize view variables
        mReply = (EditText) findViewById(R.id.editText_second);

    }

    /**
     * Handle the onClick for the "Reply" button. Gets the message from the second EditText,
     * creates an intent, and returns that message back to the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void returnReply(View view) {
        // get the reply message from the edit text
        String reply = mReply.getText().toString();

        //Create a new intent for the reply, add the reply message to it as an extra
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        // set the intent result, and close the activity
        setResult(RESULT_OK, replyIntent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}


