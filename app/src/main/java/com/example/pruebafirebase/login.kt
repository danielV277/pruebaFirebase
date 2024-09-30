package com.example.pruebafirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val btIngresar = findViewById<Button>(R.id.btIngresar)
        val btRegistrar = findViewById<Button>(R.id.btRegistrarse)

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etContraseña = findViewById<EditText>(R.id.etContraseña)
        auth = FirebaseAuth.getInstance()

        btIngresar.setOnClickListener{
            val correo = etCorreo.text.toString()
            val contraseña = etContraseña.text.toString()

            if(correo.isNotEmpty() && contraseña.isNotEmpty()){
                auth.signInWithEmailAndPassword(correo,contraseña).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intenteMAin = Intent(this,MainActivity::class.java)
                        intenteMAin.putExtra("correo",correo)
                        startActivity(intenteMAin)
                        finish()
                        Toast.makeText(this,"Inicio con exito",Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this,"No se puedo iniciar",Toast.LENGTH_LONG).show()}
                }
            }else{
                println("Vacio")
                Toast.makeText(this,"Datos invalidos",Toast.LENGTH_LONG).show()
            }

        }

        btRegistrar.setOnClickListener{
            val correo = etCorreo.text.toString()
            val contraseña = etContraseña.text.toString()

            if(correo.isNotEmpty() && contraseña.isNotEmpty()){
                auth.createUserWithEmailAndPassword(correo,contraseña).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intenteMAin = Intent(this,MainActivity::class.java)
                        intenteMAin.putExtra("correo",correo)
                        startActivity(intenteMAin)
                        finish()
                        Toast.makeText(this, "Usuario Registrado con exito",Toast.LENGTH_LONG).show()

                    }else{
                        Toast.makeText(this, "No se puedo registrar el usuario",Toast.LENGTH_LONG).show() }
                }
            }else{
                Toast.makeText(this, "Datos invalidos",Toast.LENGTH_LONG).show()
            }
        }

    }
}