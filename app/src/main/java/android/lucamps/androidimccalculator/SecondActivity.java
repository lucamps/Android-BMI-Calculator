package android.lucamps.androidimccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFE_CYCLE","SECOND --- onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFE_CYCLE","SECOND --- onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFE_CYCLE","SECOND --- onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFE_CYCLE","SECOND --- onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFE_CYCLE","SECOND --- onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFE_CYCLE","SECOND --- onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LIFE_CYCLE","SECOND --- onCreate");
        setContentView(R.layout.activity_second);

        Intent it = getIntent();

        final TextView name = findViewById(R.id.textName);
        final TextView age = findViewById(R.id.textAge);
        final TextView weight = findViewById(R.id.textWeight);
        final TextView height = findViewById(R.id.textHeight);
        final TextView BMI = findViewById(R.id.textBMI);
        final TextView rating = findViewById(R.id.textRating);

        name.setText(it.getStringExtra("name"));
        age.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("age",0)) + " " + getText(R.string.years));
        weight.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("weight",0)) + " Kg");
        height.setText(new DecimalFormat("##0.00").format(it.getDoubleExtra("height",0)) + " m");
        BMI.setText(new DecimalFormat("##0.00").format(it.getDoubleExtra("resultNumber",0)) + " Kg/m²");
        rating.setText(it.getStringExtra("resultText"));


    }
}