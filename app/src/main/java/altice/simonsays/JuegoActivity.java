package altice.simonsays;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class JuegoActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timeCountDown, randomWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        int nivel = intent.getIntExtra("nivel", 0);
        int randomWordsAmount = intent.getIntExtra("randomWord", 0);

        String[] randomWordsArray = {"Reir", "Hablar", "Jugar", "Ver", "Escuchar", "Rojo", "Morado", "Verde", "Naranja"};
        String[] wordWinners = new String[10];

        Button reir = findViewById(R.id.reirButton);
        Button hablar = findViewById(R.id.hablarButton);
        Button jugar = findViewById(R.id.jugarButton);
        Button ver = findViewById(R.id.verButton);
        Button escuchar = findViewById(R.id.escucharButton);
        Button rojo = findViewById(R.id.rojoButton);
        Button morado = findViewById(R.id.moradoButton);
        Button verde = findViewById(R.id.verdeButton);
        Button naranja = findViewById(R.id.naranjaButton);

        reir.setOnClickListener(this);
        hablar.setOnClickListener(this);
        jugar.setOnClickListener(this);
        ver.setOnClickListener(this);
        escuchar.setOnClickListener(this);
        rojo.setOnClickListener(this);
        morado.setOnClickListener(this);
        verde.setOnClickListener(this);
        naranja.setOnClickListener(this);
        timeCountDown = findViewById(R.id.timerTextView);
        randomWords = findViewById(R.id.randomWordTextView);
        randomWords.setText("");


        switch (nivel){
            case 1:
                wordWinners = setRandomWords(randomWordsAmount, randomWordsArray);
                for(int i = 0; wordWinners[i] != null; i++){
                    randomWords.setText(randomWords.getText()+wordWinners[i]+" ");
                }
                break;
            case 2:
                wordWinners = setRandomWords(randomWordsAmount, randomWordsArray);
                for(int i = 0; wordWinners[i] != null; i++){
                    randomWords.setText(randomWords.getText()+wordWinners[i]+" ");
                }
                break;
            case 3:
                wordWinners = setRandomWords(randomWordsAmount, randomWordsArray);
                for(int i = 0; wordWinners[i] != null; i++){
                    randomWords.setText(randomWords.getText()+wordWinners[i]+" ");
                }
                break;
        }

        timeTextview(timeCountDown);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.reirButton:
                break;
            case R.id.hablarButton:
                break;
            case R.id.jugarButton:
                break;
            case R.id.verButton:
                break;
            case R.id.escucharButton:
                break;
            case R.id.rojoButton:
                break;
            case R.id.moradoButton:
                break;
            case R.id.verdeButton:
                break;
            case R.id.naranjaButton:
                break;
        }

    }

    public void timeTextview(final TextView time){

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                time.setText("Tiempo Restante: " + millisUntilFinished / 1000 + " seg");
            }

            public void onFinish() {
                time.setText("Se acabo el tiempo");
                Intent intent = new Intent(JuegoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }.start();
    }

    public  String[]  setRandomWords(int randomWordsAmount, String[] randomWordArray){
        Random rnd = new Random();
        rnd.setSeed(1);
        int number = rnd.nextInt(9);
        String[] randomWord = new String[10];
        for(int i=0;i<randomWordsAmount;i++){
            randomWord[i] = randomWordArray[number];
            number = rnd.nextInt(9);
        }
        return randomWord;
    }
}
