package edu.csumb.juganiza.c_to_f_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CtoF extends AppCompatActivity {

    Button button;
    EditText value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cto_f);

        button = findViewById(R.id.ctfBtn);
        value = findViewById(R.id.ctf_input);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double inputValue = 0.0;
                try {
                    inputValue = Double.parseDouble(value.getText().toString());
                }catch (NumberFormatException e) {
                    Log.d("C_TO_F", "Bad format");
                }

                button.setText(String.format("%.2f", toFahrenheit(inputValue))+ "");
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(CtoF.this, MainActivity.class);
                startActivity(intent);
                return false;
            }
        });
    }
    public double toFahrenheit(double inputValueC) {
        double fahrenheit = 9 * (inputValueC / 5) + 32;
        return fahrenheit;
    }
}
