package android.lucamps.androidimccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    double age = 0;
    double weight = 0;
    double height = 0;
    double resultNumber = 0;
    String name = "";
    String resultText = "";

    void setResultNumber(){
        if(height == 0)
            resultNumber = -1;
        else
            resultNumber = weight/(height*height);
    }

    void setResultText(){
        if(resultNumber < 18.5)
            resultText = getText(R.string.underW).toString();
        else if(resultNumber < 25)
            resultText = getText(R.string.healthy).toString();
        else if(resultNumber < 30)
            resultText = getText(R.string.overW).toString();
        else if(resultNumber < 35)
            resultText = getText(R.string.obesityI).toString();
        else if(resultNumber < 40)
            resultText = getText(R.string.obesityII).toString();
        else
            resultText = getText(R.string.obesityIII).toString();
    }

    static double textToDouble(final EditText text){
        String temp = text.getText().toString().replace(",",".");
        return Double.parseDouble(temp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = findViewById(R.id.editTextPersonName);
        final EditText ageText = findViewById(R.id.editTextAge);
        final EditText weightText = findViewById(R.id.editTextWeight);
        final EditText heightText = findViewById(R.id.editTextHeight);

        final Button resultBT = findViewById(R.id.button1);

        resultBT.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = nameText.getText().toString();
                age = textToDouble(ageText);
                weight = textToDouble(weightText);
                height = textToDouble(heightText);

                setResultNumber();
                setResultText();
                Log.i("Result Number", String.valueOf(resultNumber));
                Log.i("Result Text", resultText);
            }
        });
    }
}