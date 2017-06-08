package io.github.romulus10.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int NOP = 0;
    private static final int ADD = 1;
    private static final int SUB = 2;
    private static final int MUL = 3;
    private static final int DIV = 4;

    protected boolean negative;
    protected double current;
    protected String screen;
    protected boolean next;
    protected int op;
    protected boolean done;
    protected boolean done_2;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.negative = false;
        this.next = false;
        this.screen = "";
        this.op = NOP;
        this.current = 0;
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(screen);
        Log.d(TAG, "Application started successfully.");
    }

    public void refresh(){
        if (this.next) {
            this.next = false;
            this.current = Double.parseDouble(screen);
            if (this.negative) {
                this.current *= -1;
            }
            this.negative = false;
            this.screen = "";
        }
        if (this.negative) {
            this.textView.setText("-" + screen);
        } else {
            this.textView.setText(screen);
        }
    }

    public void add(View view) {
        Log.d(TAG, "ADD operation.");
        this.op = ADD;
        this.next = true;
        this.refresh();
    }

    public void subtract(View view) {
        Log.d(TAG, "SUB operation.");
        this.op = SUB;
        this.next = true;
        this.refresh();
    }

    public void multiply(View view) {
        Log.d(TAG, "MUL operation.");
        this.op = MUL;
        this.next = true;
        this.refresh();
    }

    public void divide(View view) {
        Log.d(TAG, "DIV operation.");
        this.op = DIV;
        this.next = true;
        this.refresh();
    }

    public void equals(View view) {
        double operand;
        if (this.negative) {
            operand = Double.parseDouble(this.screen) * -1;
        } else {
            operand = Double.parseDouble(this.screen);
        }
        switch (this.op) {
            case ADD:
                this.current += operand;
                break;
            case SUB:
                this.current -= operand;
                break;
            case MUL:
                this.current *= operand;
                break;
            case DIV:
                this.current /= operand;
                break;
        }
        this.screen = Double.toString(this.current);
        this.refresh();
    }

    public void clear(View view) {
        this.screen = "";
        this.negative = false;
        this.current = 0;
        this.op = NOP;
        this.refresh();
    }

    public void setDisplay_1(View view) {
        this.screen = screen + "1";
        this.refresh();
    }

    public void setDisplay_2(View view) {
        this.screen = screen + "2";
        this.refresh();
    }

    public void setDisplay_3(View view) {
        this.screen = screen + "3";
        this.refresh();
    }

    public void setDisplay_4(View view) {
        this.screen = screen + "4";
        this.refresh();
    }

    public void setDisplay_5(View view) {
        this.screen = screen + "5";
        this.refresh();
    }

    public void setDisplay_6(View view) {
        this.screen = screen + "6";
        this.refresh();
    }

    public void setDisplay_7(View view) {
        this.screen = screen + "7";
        this.refresh();
    }

    public void setDisplay_8(View view) {
        this.screen = screen + "8";
        this.refresh();
    }

    public void setDisplay_9(View view) {
        this.screen = screen + "9";
        this.refresh();
    }

    public void setDisplay_0(View view) {
        this.screen = screen + "0";
        this.refresh();
    }

    public void setDisplay_dot(View view) {
        this.screen = screen + ".";
        this.refresh();
    }

    public void setDisplay_negate(View view) {
        this.negative = !this.negative;
        this.refresh();
    }
}
