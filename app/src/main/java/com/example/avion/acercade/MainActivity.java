package com.example.avion.acercade;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button share;
    String nombre = "Ricardo López";
    String correo = "00024614@uca.edu.sv";
    String numero = "+(503)7461-9432";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = (ImageView) findViewById(R.id.p_image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.foto_perfil);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
        share = (Button)findViewById(R.id.btn_share);
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String titulo = nombre;
                String subtitulo1 = numero;
                String subtitulo2 = correo;
                intent.putExtra(Intent.EXTRA_TEXT, nombre + '\n' + "Teléfono "+subtitulo1+ '\n' + "Email: "+subtitulo2);
                startActivity(Intent.createChooser(intent, "Compartir en:"));

            }


        });


    }
}
