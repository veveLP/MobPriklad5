package com.example.priklad5;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Vytvořte projekt, který bude obsahovat dva edity pro zadávání čísel a
        4 tlačítka pro součet, rozdíl, součin a podíl a jedno textView pro výsledek.
         Použijte linearLayout. Ošetřete pokud nezadáte žádné číslo. Chybové hlášky vypište do Toast.
         Všechny texty budou v string.xml
         */


        Button button1 = findViewById(R.id.button5);
        button1.setText(MathOperation.ADD.name());
        button1.setOnClickListener(v -> {
            try {
                EditText editText1 = findViewById(R.id.editTextNumber);
                Double n1 = Double.parseDouble(String.valueOf(editText1.getText()));
                EditText editText2 = findViewById(R.id.editTextNumber2);
                Double n2 = Double.parseDouble(String.valueOf(editText2.getText()));
                Double result = calc(n1, n2, MathOperation.ADD);
                TextView textView = findViewById(R.id.textView);
                textView.setText(result.toString());
            } catch (Exception exception) {
                Toast.makeText(v.getContext(), exception.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.button6);
        button2.setText(MathOperation.SUBTRACT.name());
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    EditText editText1 = findViewById(R.id.editTextNumber);
                    Double n1 = Double.parseDouble(String.valueOf(editText1.getText()));
                    EditText editText2 = findViewById(R.id.editTextNumber2);
                    Double n2 = Double.parseDouble(String.valueOf(editText2.getText()));
                    Double result = calc(n1, n2, MathOperation.SUBTRACT);
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(result.toString());
                } catch (Exception exception) {
                    Toast.makeText(v.getContext(), exception.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            }

        });

        Button button3 = findViewById(R.id.button7);
        button3.setText(MathOperation.MULTIPLY.name());
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    EditText editText1 = findViewById(R.id.editTextNumber);
                    Double n1 = Double.parseDouble(String.valueOf(editText1.getText()));
                    EditText editText2 = findViewById(R.id.editTextNumber2);
                    Double n2 = Double.parseDouble(String.valueOf(editText2.getText()));
                    Double result = calc(n1, n2, MathOperation.MULTIPLY);
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(result.toString());
                } catch (Exception exception) {
                    Toast.makeText(v.getContext(), exception.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });


        Button button4 = findViewById(R.id.button8);
        button4.setText(MathOperation.DIVIDE.name());
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    EditText editText1 = findViewById(R.id.editTextNumber);
                    Double n1 = Double.parseDouble(String.valueOf(editText1.getText()));
                    EditText editText2 = findViewById(R.id.editTextNumber2);
                    Double n2 = Double.parseDouble(String.valueOf(editText2.getText()));
                    if(n2 == 0) {throw new Exception(String.valueOf(R.string.devideBy0)); }
                    Double result = calc(n1, n2, MathOperation.DIVIDE);
                    TextView textView = findViewById(R.id.textView);
                    textView.setText(result.toString());
                } catch (Exception exception) {
                Toast.makeText(v.getContext(), exception.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    public Double calc(double n1, double n2, MathOperation mathOperation) {
        switch (mathOperation) {
            case ADD: {
                return n1 + n2;
            }
            case SUBTRACT: {
                return n1 - n2;
            }
            case MULTIPLY: {
                return n1 * n2;
            }
            case DIVIDE: {
                return n1 / n2;
            }
            default:
                return null;
        }
    }
}