package com.example.equation;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView pic;
    EditText A, B, C;
    int a, c, b;
    double root1, root2;
    int max = 50;
    int min = -50;
    Random rn;
    int n = max - min + 1;
    TextView x1, x2;
    boolean check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pic = findViewById(R.id.imageView);
        rn = new Random();
        pic.setImageResource(R.drawable.eyal);
        A = findViewById(R.id.A);
        B = findViewById(R.id.b);
        C = findViewById(R.id.C);
        x1 = findViewById(R.id.x1);
        x2 = findViewById(R.id.x2);


    }

    @Override
    protected void onActivityResult(int source, int good, @Nullable Intent data_back) {
        super.onActivityResult(source, good, data_back);
        if (data_back != null) {
            root2 = data_back.getDoubleExtra("x2", 1);
            root1 = data_back.getDoubleExtra("x1", 1);
            check1 = data_back.getBooleanExtra("x3",false);
            if (check1 == true){
                x1.setText("root1 = "+root1+" + "+root2+"i");
                x2.setText("root2 = "+root1+" - "+root2+"i");
            }
            else {
                x1.setText("Root1: " + root1);
                x2.setText("Root2: " + root2);
            }


        }
    }

    public void rand(View view) {
        a = rn.nextInt() % n;
        b = rn.nextInt() % n;
        c = rn.nextInt() % n;
        A.setText("" + a);
        B.setText("" + b);
        C.setText("" + c);
    }

    public void result(View view) {
        if ((A.getText().toString().isEmpty()) || (B.getText().toString().isEmpty()) || (C.getText().toString().isEmpty())) {
            Toast.makeText(getApplicationContext(), "Enter all variables please", Toast.LENGTH_SHORT).show();
        } else {
            a = Integer.parseInt(A.getText().toString());
            b = Integer.parseInt(B.getText().toString());
            c = Integer.parseInt(C.getText().toString());
            Intent si = new Intent(this, results.class);
            si.putExtra("n", a);
            si.putExtra("nn", b);
            si.putExtra("nnn", c);
            startActivityForResult(si, 1);
        }


    }


}