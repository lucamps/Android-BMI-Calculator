package android.lucamps.androidimccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent it = getIntent();

        final TextView name = findViewById(R.id.textName);
        final TextView age = findViewById(R.id.textAge);
        final TextView weight = findViewById(R.id.textWeight);
        final TextView height = findViewById(R.id.textHeight);
        final TextView BMI = findViewById(R.id.textBMI);
        final TextView rating = findViewById(R.id.textRating);

        name.setText(it.getStringExtra("name"));
        age.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("age",0)));
        weight.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("weight",0)));
        height.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("height",0)));
        BMI.setText(new DecimalFormat("##0.##").format(it.getDoubleExtra("resultNumber",0)));
        rating.setText(it.getStringExtra("resultText"));


    }
}