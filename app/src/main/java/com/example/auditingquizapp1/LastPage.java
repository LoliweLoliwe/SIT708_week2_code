package com.example.auditingquizapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LastPage extends AppCompatActivity {
    TextView congrats, scoreT;
    Button finishBtn, restartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_page);

        congrats = findViewById(R.id.textView5);
        scoreT = findViewById(R.id.textView6);

        Intent valueIntent = getIntent();
        Bundle bundle = valueIntent.getExtras();
        String receivedValue = bundle.getString("VALUE_KEY");
        Integer score = bundle.getInt("SCORE_KEY");
        congrats.setText("Thank  you for attempting this quiz " + receivedValue + "!!");
        scoreT.setText("Your got { " + score + "/5 }");

        restartBtn = findViewById(R.id.restartBtn);
        finishBtn = findViewById(R.id.finishBtn);

        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Integer yourScore = 0;
                    Integer currentProgress = 0;

                    Bundle bundle = new Bundle();
                    bundle.putInt("NIL_KEY", yourScore);
                    bundle.putInt("TER_KEY", currentProgress);
                    Intent newIntent = new Intent(LastPage.this, QuizAuditing.class);
                    newIntent.putExtras(bundle);
                    startActivity(newIntent);
                }
                catch (Exception e){
                    Toast.makeText(LastPage.this, "Something was not done right", Toast.LENGTH_SHORT).show();
                }
            }
        });

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent newIntent = new Intent(LastPage.this, MainActivity.class);
                startActivity(newIntent);
            }
        });
    }
}