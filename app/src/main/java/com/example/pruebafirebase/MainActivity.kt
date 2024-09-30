package com.example.pruebafirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var correo = intent.getStringExtra("correo")

        val tvCorreo = findViewById<TextView>(R.id.tvCorreo)
        tvCorreo.text = correo

        val btSalir = findViewById<Button>(R.id.btSalir)

        btSalir.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            var intentLogin = Intent(this,login::class.java)
            startActivity(intentLogin)
            finish()
        }

    }
}