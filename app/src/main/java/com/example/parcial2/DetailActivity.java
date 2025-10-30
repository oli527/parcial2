package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    CircleImageView imgDetalle;
    TextView tvNombre, tvCurso, tvDescripcion;
    Button btnLogout;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imgDetalle = findViewById(R.id.img_detalle);
        tvNombre = findViewById(R.id.tv_nombre_detalle);
        tvCurso = findViewById(R.id.tv_curso_detalle);
        tvDescripcion = findViewById(R.id.tv_descripcion_detalle);
        btnLogout = findViewById(R.id.btn_logout);

        prefs = getSharedPreferences("mi_app_prefs", Context.MODE_PRIVATE);

        // vamos a recibir el dato de intenet
        String nombre = getIntent().getStringExtra("nombre");
        String curso = getIntent().getStringExtra("curso");
        String foto = getIntent().getStringExtra("foto");
        String descripcion = getIntent().getStringExtra("descripcion");

        tvNombre.setText(nombre);
        tvCurso.setText(curso);
        tvDescripcion.setText(descripcion);
        Picasso.get().load(foto).placeholder(R.mipmap.ic_launcher).into(imgDetalle);

        btnLogout.setOnClickListener(v -> {
            prefs.edit().remove("usuario").apply();
            Intent i = new Intent(DetailActivity.this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });
    }
}
