package android.lucamps.androidimccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    //Life cycle methods
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LIFE_CYCLE","MAIN --- onStart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LIFE_CYCLE","MAIN --- onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LIFE_CYCLE","MAIN --- onStop");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LIFE_CYCLE","MAIN --- onRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LIFE_CYCLE","MAIN --- onResume");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LIFE_CYCLE","MAIN --- onDestroy");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("LIFE_CYCLE","MAIN --- onCreate");

        setContentView(R.layout.activity_main);

        final EditText nameText = findViewById(R.id.editTextPersonName);
        final EditText ageText = findViewById(R.id.editTextAge);
        final EditText weightText = findViewById(R.id.editTextWeight);
        final EditText heightText = findViewById(R.id.editTextHeight);
        final Button resultBT = findViewById(R.id.button1);

        //Button to calculate BMI
        resultBT.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view) {
                name = nameText.getText().toString();
                age = textToDouble(ageText);
                weight = textToDouble(weightText);
                height = textToDouble(heightText);

                setResultNumber();
                setResultText();

                Intent it = new Intent(getBaseContext(),SecondActivity.class);
                it.putExtra("name",name);
                it.putExtra("age",age);
                it.putExtra("weight",weight);
                it.putExtra("height",height);
                it.putExtra("resultNumber",resultNumber);
                it.putExtra("resultText",resultText);

                startActivity(it);
            }
        });
    }
}