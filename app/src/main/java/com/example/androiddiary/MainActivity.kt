package com.example.androiddiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Para isso eu utilizei algo chamado Lambda, eu não sei o que é, mas me permitiu não inicializar a variável.
        button.setOnClickListener {
            if (editTextTextEmailAddress.text.isNullOrBlank()&& editTextTextPassword.text.isNullOrBlank()) {
                Toast.makeText(this, "Please fill the required fields", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "${editTextTextEmailAddress.text} is logged on!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}