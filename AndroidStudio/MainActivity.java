package com.example.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText name, email;
    Button submit;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        submit = findViewById(R.id.Button);

        submit.setOnClickListener(this);

        sp = getSharedPreferences("Mine", MODE_PRIVATE);

        name.setText(sp.getString("Name", ""));
        email.setText(sp.getString("Email", ""));
    }

    @Override
    public void onClick(View v) {

        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Name", name.getText().toString());
        editor.putString("Email", email.getText().toString());
        editor.apply();

        Intent i = new Intent(MainActivity.this, SecApp.class);
        startActivity(i);
    }
}
