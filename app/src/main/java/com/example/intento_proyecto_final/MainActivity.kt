package com.example.intento_proyecto_final
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registrarButton = findViewById<Button>(R.id.registrar_button)
        val correoEditText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val nomreEditText = findViewById<EditText>(R.id.name_texto)
        registrarButton.setOnClickListener {
            val correo = correoEditText.text.toString()
            val nombre = nomreEditText.text.toString()
            if (correo.isNotEmpty()) {
                db.collection("usuario").document(correo).set(
                    hashMapOf(
                        "correo" to correo,
                        "nombre" to nombre
                    )
                ).addOnSuccessListener {

                }.addOnFailureListener { e ->
                }
            } else {
            }
        }
    }
}
