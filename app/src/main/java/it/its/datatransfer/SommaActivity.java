package it.its.datatransfer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SommaActivity extends AppCompatActivity {
    int primoAddendo;
    int secondoAddendo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_somma);
        Intent intent = getIntent();
         this.primoAddendo = intent.getIntExtra(KeyConstants.PRIMO_ADDENDO_KEY,0);
         this.secondoAddendo = intent.getIntExtra(KeyConstants.SECONDO_ADDENDO_KEY,0);

    }

    public void onClickButton(View view) {
        int somma = primoAddendo + secondoAddendo;
        Intent data = new Intent();
        data.putExtra("SOMMA",somma);
        setResult(1,data);
        finish();
    }
}