package com.example.logicgame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private CheckBox msecondCheck, mforthCheck, meightsCheck;
    private Button mCheckResults;
    private int mResult = 0;
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);

            msecondCheck = findViewById(R.id.Task1_2);
            mforthCheck = findViewById(R.id.Task2_1);
            meightsCheck = findViewById(R.id.Task3_2);

            mCheckResults = findViewById(R.id.Button);

            msecondCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (msecondCheck.isChecked())
                        mResult += 1;
                }
            });

            mforthCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mforthCheck.isChecked())
                        mResult += 1;
                }
            });


            meightsCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (meightsCheck.isChecked())
                            mResult += 1;
                }
            });

            mCheckResults.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity2.this);
                    switch (mResult) {
                        case 3 :

                    a_builder.setMessage("You win!");
                    a_builder.setCancelable(false);
                    a_builder.setPositiveButton("Return to menu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent i;
                            i = new Intent(MainActivity2.this, MainActivity.class);
                            startActivity(i);
                        }
                    });

                    a_builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                           Intent i;
                            i = new Intent(MainActivity2.this, MainActivity2.class);
                            startActivity(i);
                        }
                    });
                        break;

                        default:

                        a_builder.setMessage("You failed the exam with the percent of right answers: " + (mResult * 33));
                        a_builder.setCancelable(false);
                        a_builder.setPositiveButton("Return to menu", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i;
                                i = new Intent(MainActivity2.this, MainActivity.class);
                                startActivity(i);
                            }
                        });
                        a_builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(MainActivity2.this, MainActivity2.class));
                            }
                        });

                    }
                    AlertDialog alert = a_builder.create();
                    alert.setTitle("Look!");
                    alert.show();
                }
            });


        }

    }