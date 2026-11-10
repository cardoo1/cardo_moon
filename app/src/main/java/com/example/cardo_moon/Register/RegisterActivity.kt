package com.example.cardo_moon.Register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cardo_moon.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etNama.text?.toString()?.trim().orEmpty()
            val phone = binding.etPhone.text?.toString()?.trim().orEmpty()
            val username = binding.etUsername.text?.toString()?.trim().orEmpty()
            val password = binding.etPassword.text?.toString().orEmpty()

            if (name.isBlank() || phone.isBlank() || username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (phone.any { !it.isDigit() } || phone.length < 8) {
                binding.etPhone.error = "Masukkan nomor handphone yang valid"
                return@setOnClickListener
            }
            if (password.length < 6) {
                binding.etPassword.error = "Password minimal 6 karakter"
                return@setOnClickListener
            }

            startActivity(Intent(this, OtpActivity::class.java).apply {
                putExtra("EXTRA_NAMA", name)
                putExtra("EXTRA_PHONE", phone)
                putExtra("EXTRA_USERNAME", username)
                putExtra("EXTRA_PASSWORD", password)
            })
        }
    }
}
