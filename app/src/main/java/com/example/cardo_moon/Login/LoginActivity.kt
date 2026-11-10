package com.example.cardo_moon.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cardo_moon.BaseActivity
import com.example.cardo_moon.Register.RegisterActivity
import com.example.cardo_moon.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val inputUser = binding.etEmail.text?.toString()?.trim().orEmpty()
            val inputPass = binding.etPassword.text?.toString().orEmpty()
            if (inputUser.isBlank() || inputPass.isBlank()) {
                Toast.makeText(this, "Username dan password wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val prefs = getSharedPreferences("UserPref", Context.MODE_PRIVATE)
            val savedUser = prefs.getString("KEY_USERNAME", null)
            val savedPass = prefs.getString("KEY_PASSWORD", null)
            val defaultRule = inputUser == inputPass
            val registeredRule = inputUser == savedUser && inputPass == savedPass

            if (defaultRule || registeredRule) {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, BaseActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}