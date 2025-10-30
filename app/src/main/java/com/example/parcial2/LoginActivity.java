package com.example.parcial2;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsuario, etPassword;
    Button btnLogin;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("mi_app_prefs", Context.MODE_PRIVATE);

        // Si ya hay usuario guardado, vamos directo a Main-_-
        if (prefs.contains("usuario")) {
            startMain();
            return;
        }

        etUsuario = findViewById(R.id.et_usuario);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            String u = etUsuario.getText().toString().trim();
            String p = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(u) || TextUtils.isEmpty(p)) {
                Toast.makeText(this, "Completa usuario y contraseña", Toast.LENGTH_SHORT).show();
                return;
            }

            // Guardar usuario en SharedPreferences(uno de los requisitos que usted pidio profe)
            prefs.edit().putString("usuario", u).apply();
            startMain();
        });
    }

    private void startMain() {
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
