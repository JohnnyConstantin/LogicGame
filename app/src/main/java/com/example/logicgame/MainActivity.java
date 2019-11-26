package com.example.logicgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int REQ_C = 0;
    Button button, button2, button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                switch (v.getId()) {
                    case R.id.button:
                        i = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i);
                        break;
                    case R.id.button2:
                        i = new Intent(MainActivity.this, ToInfActivity.class);
                        startActivity(i);
                        break;
                    case R.id.button3:
                        i = new Intent(MainActivity.this, ComeBackActivity.class);
                        startActivityForResult(i, REQ_C);
                        break;
                    default:
                        return;
                }
            }
        };
        button.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                break;
        }
    }
}
