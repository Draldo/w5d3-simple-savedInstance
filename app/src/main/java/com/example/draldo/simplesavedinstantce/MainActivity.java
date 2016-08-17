package com.example.draldo.simplesavedinstantce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String SUM_KEY_BUNDLE = "SUM_KEY";
    private EditText mEditText;
    private TextView mTextView;

    private int mSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.a_main_et);
        mTextView = (TextView) findViewById(R.id.a_main_txt);
    }

    public void doMagic(View view) {
        int sum = Integer.parseInt(mTextView.getText().toString());
        int val = Integer.parseInt(mEditText.getText().toString());

        mSum = sum + val;

        mTextView.setText(String.valueOf(mSum));
        mEditText.setText("");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(SUM_KEY_BUNDLE, mSum);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mSum = savedInstanceState.getInt(SUM_KEY_BUNDLE, 0);
        mTextView.setText(String.valueOf(mSum));
    }
}
