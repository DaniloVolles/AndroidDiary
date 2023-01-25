package com.example.androiddiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androiddiary.databinding.ActivitySignInBinding
import com.example.androiddiary.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.signUpOption.setOnClickListener {
            startSignUpActivity()
        }

        binding.button.setOnClickListener {

            val email = binding.editTextTextEmailAddress.text.toString()
            val pass = binding.editTextTextPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                    firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            startMainActivity()
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }

            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (firebaseAuth.currentUser != null) {
            startMainActivity()
        }
    }

    private fun startSignUpActivity () {
            val intent = Intent (this, SignUpActivity::class.java)
            startActivity(intent)
    }

    private fun startMainActivity () {
        val intent = Intent (this, MainActivity::class.java)
        startActivity(intent)
    }
}