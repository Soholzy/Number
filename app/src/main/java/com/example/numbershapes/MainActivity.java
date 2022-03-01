package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText input_number;
    Button testButton;
    TextView result;
    class Number {
        int number;
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number);
            if (squareRoot == Math.floor(squareRoot)) {
                return true;
            } else {
                return false;
            }
        }
        public boolean isTriangular() {
            int x = 1;
            int triangularNumber = 1;
            while (triangularNumber < number) {
                x++;
                triangularNumber = triangularNumber + x;
            }
            if (triangularNumber == number) {
                return true;
            } else {
                return false;
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_number = (EditText) findViewById(R.id.numberET);
        testButton = (Button) findViewById(R.id.reportBtn);
        result = (TextView) findViewById(R.id.resultTV);
        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mynum = input_number.getText().toString();
                if (mynum.equals("")) {
                    result.setText(R.string.test_empty);
                } else {
                    Number num = new Number();
                    num.number = Integer.parseInt(mynum);

                    if (num.isSquare()) {
                        if (num.isTriangular()) {
                            result.setText(num.number + " is both square and triangular.");
                        } else {
                            result.setText(num.number + " is square, but not triangular.");
                        }
                    } else if (num.isTriangular()) {
                        result.setText(num.number + " is triangular, but not square");
                    } else
                        result.setText(num.number + " is neither a triangular nor a square number");
                }
            }
        });
    }
}