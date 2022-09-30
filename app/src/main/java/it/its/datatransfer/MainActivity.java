package it.its.datatransfer;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText primoAddendoEditText;
    EditText secondoAddendoEditText;

    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        primoAddendoEditText = findViewById(R.id.primoAddendoEditText);
        secondoAddendoEditText = findViewById(R.id.secondoAddendoEditText);
        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new MyCallBack());

    }

    public void onClickButton (View view) {
        Log.d("MAINACTIVITY","inside onclickbutton");
        if (primoAddendoEditText.getText() != null && !primoAddendoEditText.getText().toString().equals("")
        && secondoAddendoEditText.getText() != null && !secondoAddendoEditText.getText().toString().equals("")
        ) {
            int primoAddendo = Integer.parseInt(primoAddendoEditText.getText().toString());
            int secondoAddendo = Integer.parseInt(secondoAddendoEditText.getText().toString());
            Intent myIntent = new Intent(this,SommaActivity.class);
            myIntent.putExtra(KeyConstants.PRIMO_ADDENDO_KEY,primoAddendo);
            myIntent.putExtra(KeyConstants.SECONDO_ADDENDO_KEY,secondoAddendo);
            //startActivity(intent);
            launcher.launch(myIntent);
        }
    }
    public class MyCallBack implements ActivityResultCallback<ActivityResult> {

        @Override
        public void onActivityResult(ActivityResult result) {
            Log.d("Main","VAI CALLBACK");
            if (result.getResultCode() == 1) {
               Intent data = result.getData();
               int somma = data.getIntExtra("SOMMA",0);
            }
        }
    }
}