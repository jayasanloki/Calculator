package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button b;
char c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt= (TextView) findViewById(R.id.textView);
        b = (Button) findViewById(R.id.erase);
    }
    public void home(View view) {
    }

    public void number(View view) {
        if(c == '='){
            txt.setText("");
        }
        switch (view.getId())
        {
            case R.id.one: txt.setText(txt.getText().toString()+"1");
            c = '0';
            break;
            case R.id.two: txt.setText(txt.getText().toString()+"2");
                c = '0';
                break;
            case R.id.three: txt.setText(txt.getText().toString()+"3");
                c = '0';
                break;
            case R.id.four: txt.setText(txt.getText().toString()+"4");
                c = '0';
                break;
            case R.id.five: txt.setText(txt.getText().toString()+"5");
                c = '0';
                break;
            case R.id.six: txt.setText(txt.getText().toString()+"6");
                c = '0';
                break;
            case R.id.seven: txt.setText(txt.getText().toString()+"7");
                c = '0';
                break;
            case R.id.eight: txt.setText(txt.getText().toString()+"8");
                c = '0';
                break;
            case R.id.nine: txt.setText(txt.getText().toString()+"9");
                c = '0';
                break;
            case R.id.zero: txt.setText(txt.getText().toString()+"0");
                c = '0';
                break;
            case R.id.dot: txt.setText(txt.getText().toString()+".");
                c = '0';
                break;

        }

        b.setEnabled(true);
    }

    public void operation(View view) {
        if(txt.getText().length()==0)
        {
            Toast.makeText(this,"Enter number first", Toast.LENGTH_SHORT).show();
            return;
        }
        if((txt.getText().length()!=0)&& (view.getId() == R.id.delete) &&
                ((c== '+') ||
                        (c== '-') ||
                        (c== '*') ||
                        (c== '/')))
        {
            txt.setText(txt.getText().toString().substring(0,txt.getText().length()-3));
            c = '0';
            b.setEnabled(true);
            return;
        }
        if(((txt.getText().length()!=0)&& (view.getId() != R.id.erase) && (view.getId() != R.id.delete)) &&
                ((c== '+') ||
                (c== '-') ||
                (c== '*') ||
                (c== '/'))) {
            Toast.makeText(this,"only one operation", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (view.getId()) {
            case R.id.add:
                txt.setText(txt.getText() +"\n" + "+"+"\n");
                c='+';
                b.setEnabled(true);
                break;
            case R.id.minus:
                txt.setText(txt.getText() +"\n"+ "-"+"\n");
                c='-';
                b.setEnabled(true);
                break;
            case R.id.multiply:
                txt.setText(txt.getText() +"\n"+ "*"+"\n");
                c='*';
                b.setEnabled(true);
                break;
            case R.id.divide:
                txt.setText(txt.getText() +"\n"+ "/"+"\n");
                c='/';
                b.setEnabled(true);
                break;
            case R.id.delete: txt.setText(txt.getText().toString().substring(0,txt.getText().length()-1));
                c = '0';
                b.setEnabled(true);
                break;
            case R.id.erase: txt.setText("");
                c = '0';
                b.setEnabled(false);
                break;
        }
    }

    public void result(View view) {
        if((txt.getText().length()==0) && (c== '='))
        {
            Toast.makeText(this,"Enter number first", Toast.LENGTH_SHORT).show();
            return;
        }
        if((c== '+') ||
                (c== '-') ||
                (c== '*') ||
                (c== '/')) {
            Toast.makeText(this,"Check numbers properly", Toast.LENGTH_SHORT).show();
            return;
        }
         String res="";
        if(txt.getText().toString().contains("+")){
            String[] spl= txt.getText().toString().split("\\+");
            res = String.valueOf(Float.parseFloat(spl[0]) + Float.parseFloat(spl[1]));
        }
        else if(txt.getText().toString().contains("-")){
            String[] spl= txt.getText().toString().split("-");
            res = String.valueOf(Float.parseFloat(spl[0]) - Float.parseFloat(spl[1]));
        }
        else if(txt.getText().toString().contains("*")){
            String[] spl= txt.getText().toString().split("\\*");
            res = String.valueOf(Float.parseFloat(spl[0]) * Float.parseFloat(spl[1]));
        }
        else if(txt.getText().toString().contains("/"))
        {
            String[] spl= txt.getText().toString().split("/");
            res = String.valueOf(Float.parseFloat(spl[0]) / Float.parseFloat(spl[1]));
        }
        else
        {
            Toast.makeText(this,"Enter number first", Toast.LENGTH_SHORT).show();
            return;
        }
        txt.setText(res);
        c= '=';
        b.setEnabled(false);
    }
}