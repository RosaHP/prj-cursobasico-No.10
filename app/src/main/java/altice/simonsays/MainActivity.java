package altice.simonsays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Button facil = findViewById(R.id.level1);
        Button intermedio = findViewById(R.id.level2);
        Button dificil = findViewById(R.id.level3);
        Button ayuda = findViewById(R.id.help);

        facil.setOnClickListener(this);
        intermedio.setOnClickListener(this);
        dificil.setOnClickListener(this);
        ayuda.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Bundle pack;

        switch (v.getId()){
            case R.id.level1:
                intent = new Intent(MainActivity.this, JuegoActivity.class);
                pack = new Bundle();
                pack.putInt("nivel", 1);
                pack.putInt("randomWord", 3);
                intent.putExtras(pack);
                startActivity(intent);
                break;
            case R.id.level2:
                intent = new Intent(MainActivity.this, JuegoActivity.class);
                pack = new Bundle();
                pack.putInt("nivel", 2);
                pack.putInt("randomWord", 6);
                intent.putExtras(pack);
                startActivity(intent);
                break;
            case R.id.level3:
                intent = new Intent(MainActivity.this, JuegoActivity.class);
                pack = new Bundle();
                pack.putInt("nivel", 3);
                pack.putInt("randomWord", 9);
                intent.putExtras(pack);
                startActivity(intent);
                break;
            case R.id.help:
                intent = new Intent(MainActivity.this, AyudaActivity.class);
                startActivity(intent);
                break;
        }

    }
}
