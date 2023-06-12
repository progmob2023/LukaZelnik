package com.example.bmikalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tezina, visina, BMIispis, statusIspis;

    Button gumb;

    ImageView slika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tezina = findViewById(R.id.InputWeight);
        visina = findViewById(R.id.InputHeight);
        BMIispis = findViewById(R.id.BMIOutput);
        statusIspis = findViewById(R.id.BMIStatus);
        gumb = findViewById(R.id.gumb1);
        slika = findViewById(R.id.statusImage);






        gumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!(tezina.getText().toString().isEmpty()) && !(visina.getText().toString().isEmpty())){
                    double height, weight;
                    double BMI;
                    height = Double.parseDouble(visina.getText().toString());
                    weight = Double.parseDouble(tezina.getText().toString());

                    height=height/100;

                    BMI = weight / (height * height);

                    BMIispis.setText(String.format("%.2f", BMI));

                    Drawable happySlika = getResources().getDrawable(R.drawable.happy);
                    Drawable sadSlika = getResources().getDrawable(R.drawable.sad);

                    if(BMI < 20){
                        statusIspis.setText("Imate pre malu težinu. ");
                        slika.setImageDrawable(sadSlika);
                    }
                    else if(BMI >= 20 && BMI <= 25){
                        statusIspis.setText("Imate normalnu težinu.");
                        slika.setImageDrawable(happySlika);
                    }
                    else if(BMI > 25){
                        statusIspis.setText("Imate pre veliku težinu.");
                        slika.setImageDrawable(sadSlika);
                    }
                }


            }
        });

    }
}