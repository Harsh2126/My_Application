package com.example.myapplication;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnClick;
    EditText textEnter;
    TextToSpeech textToSpeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



            btnClick=(Button)findViewById(R.id.button);
            textEnter=(EditText)findViewById(R.id.editText);
            textToSpeech=new TextToSpeech(getApplicationContext(),
                    new TextToSpeech.OnInitListener() {
                        @Override
                        public void onInit(int status) {
                            if(status==TextToSpeech.SUCCESS){
                                int language=textToSpeech.setLanguage(Locale.ENGLISH);
                            }
                        }
                    });
            btnClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String s=textEnter.getText().toString();
                    int speech=textToSpeech.speak(s, textToSpeech.QUEUE_FLUSH,null);
                }
            });

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}