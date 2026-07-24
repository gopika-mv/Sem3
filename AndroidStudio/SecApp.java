package com.example.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecApp extends AppCompatActivity implements View.OnClickListener {

    Button previous;
    TextView t, c;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sec_app);

        previous = findViewById(R.id.Button);   // or R.id.button
        previous.setOnClickListener(this);

        t = findViewById(R.id.textView);
        c = findViewById(R.id.textView2);

        sp = getSharedPreferences("Mine", MODE_PRIVATE);

        if (sp.contains("Name"))
            t.setText("Welcome " + sp.getString("Name", ""));

        if (sp.contains("Email"))
            c.setText(sp.getString("Email", ""));
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
