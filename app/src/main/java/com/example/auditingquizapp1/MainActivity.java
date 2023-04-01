package com.example.auditingquizapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    String name;
    private Button button;
    private EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setText(" ");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editTextName.getText().toString();

                if (" ".equals(name)) {
                    Toast.makeText(MainActivity.this, "You did not type your name!!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent newIntent = new Intent(MainActivity.this, QuizAuditing.class);
                    newIntent.putExtra("VALUE_KEY", name);
                    startActivity(newIntent);
                }
            }
        });
    }

}