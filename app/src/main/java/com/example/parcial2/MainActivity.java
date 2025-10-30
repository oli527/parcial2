package com.example.parcial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial2.adaptadores.UsuarioAdaptador;
import com.example.parcial2.clases.Usuario;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcv_usuarios;
    List<Usuario> listaUsuarios = new ArrayList<>();
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = getSharedPreferences("mi_app_prefs", Context.MODE_PRIVATE);
        if (!prefs.contains("usuario")) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_main);

        rcv_usuarios = findViewById(R.id.rcv_usuarios);

        // la super descripcion de mis personajes u cuento con la imagens
        listaUsuarios.add(new Usuario(
                "Héroe-Humano",
                "Eli Shane",
                "https://static.wikia.nocookie.net/slugterra/images/f/f1/Eli_crouch_BurpyHand.jpg/revision/latest?cb=20170321201824",
                "Eli Shane es un joven valiente y decidido, heredero de una larga línea de duelistas de babosas. Su objetivo es mantener la paz en Slugterra y convertirse en el mejor maestro de babosas. Con su babosa principal, Burpy, demuestra gran habilidad, inteligencia y un fuerte sentido de la justicia."
        ));

        listaUsuarios.add(new Usuario(
                "Babosa",
                "Burpy",
                "https://static.wikia.nocookie.net/slugterra/images/6/67/Opening_Burpy.png/revision/latest?cb=20130414204153",
                "Burpy es una Babosa de tipo Infierno y la compañera más fiel de Eli Shane. Posee un gran corazón y una fuerza impresionante, capaz de lanzar potentes ataques de fuego cuando se transforma. Es valiente, leal y siempre está dispuesto a proteger a Eli y a sus amigos."
        ));

        listaUsuarios.add(new Usuario(
                "Babosa",
                "Blastipede",
                "https://static.wikia.nocookie.net/slugterra/images/d/da/Tormato_ghoul_.png/revision/latest?cb=20130214210520",
                "Blastipede es una Babosa del tipo Tierra que combina fuerza y resistencia. Su habilidad principal consiste en crear potentes explosiones que pueden derribar enemigos. Aunque es temperamental, demuestra una lealtad inquebrantable y una determinación admirable."
        ));

        listaUsuarios.add(new Usuario(
                "Trol de las cavernas",
                "Kord Zane",
                "https://static.wikia.nocookie.net/slugterra/images/b/bb/Kord.png/revision/latest?cb=20130224211022",
                "Kord Zane es un trol fuerte y de gran corazón, miembro del equipo de Eli Shane. Experto en mecánica, suele reparar armas y vehículos del grupo. Aunque parece rudo, es amistoso, leal y siempre está dispuesto a ayudar a sus amigos."
        ));

        rcv_usuarios.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columnas
        rcv_usuarios.setAdapter(new UsuarioAdaptador(listaUsuarios));
    }
}
