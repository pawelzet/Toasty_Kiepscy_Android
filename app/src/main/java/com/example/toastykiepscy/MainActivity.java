package com.example.toastykiepscy;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    ImageButton soundbutton, stopbutton;

    int[] sounds={R.raw.audi, R.raw.berlin, R.raw.bratanki, R.raw.budzik, R.raw.cztery, R.raw.drzyz, R.raw.dziewczyny, R.raw.emeryt, R.raw.enter, R.raw.faza,
            R.raw.heweliusz, R.raw.jagiello, R.raw.jasiu, R.raw.kaczki, R.raw.kompilacja, R.raw.malpa, R.raw.monalisa, R.raw.pierdolamento, R.raw.pilka, R.raw.rymcymcym,
            R.raw.stach, R.raw.tadek, R.raw.tyrtumpyrtum, R.raw.ufo, R.raw.wagoniki, R.raw.waldek, R.raw.wino, R.raw.wozy};
    Random r = new Random();
    int rndm = r.nextInt(9);

    int clickcount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //media player

        soundbutton = (ImageButton)this.findViewById(R.id.playButton);
        stopbutton = (ImageButton)this.findViewById(R.id.stopButton);
        mp = MediaPlayer.create(getApplicationContext(),sounds[rndm]);
        soundbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                    }
                        rndm = r.nextInt(9);
                        mp = MediaPlayer.create(getApplicationContext(),sounds[rndm]);

                    mp.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                stopbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.stop();
                        Toast.makeText(getApplicationContext(),"Karwasz Twarz! Wykryto Pantofla! Wracaj do żony, gra skończona! KOLEGA...", Toast.LENGTH_LONG).show();
                        clickcount=0;


                    }

                });
                clickcount=clickcount+1;
                if(clickcount==1)
                {
                    //first time clicked to do this
                    Toast.makeText(getApplicationContext(),"No to zaczynamy!", Toast.LENGTH_LONG).show();
                }
               else if(clickcount==10)
                {
                    Toast.makeText(getApplicationContext(),"Wóda wchodzi...wypiłeś już:"+clickcount+" kolejek", Toast.LENGTH_LONG).show();
                }
                else if(clickcount==14)
                {
                    Toast.makeText(getApplicationContext(),"Mati ma już urwany film, wypiłeś już:"+clickcount+" kolejek", Toast.LENGTH_LONG).show();
                }
                else if(clickcount==20)
                {
                    Toast.makeText(getApplicationContext(),"Bogiemu gra w dupie, wypiłeś już:"+clickcount+" kolejek", Toast.LENGTH_LONG).show();
                }
                else if(clickcount==23)
                {
                    Toast.makeText(getApplicationContext(),"Arek ma urwany film..., wypiłeś już:"+clickcount+" kolejek", Toast.LENGTH_LONG).show();
                }
                else if(clickcount==26)
                {
                    Toast.makeText(getApplicationContext(),"Tryb Pijany Włączony, wypiłeś już:"+clickcount+" kolejek", Toast.LENGTH_LONG).show();
                }

                else
                {
                    //check how many times clicked and so on
                    Toast.makeText(getApplicationContext(),"Pijesz kolejke nr:"+clickcount, Toast.LENGTH_LONG).show();
                }
            }

                });

        }


    };

