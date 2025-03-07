package com.example.tp1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RecapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        String message = getIntent().getStringExtra("message");

        TextView recapMessageTextView = findViewById(R.id.recapMessage);

        recapMessageTextView.setText(message);
    }
}
