package com.example.cardo_moon.Register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cardo_moon.Login.LoginActivity
import com.example.cardo_moon.databinding.ActivityOtpBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class OtpActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("EXTRA_NAMA").orEmpty()
        val phone = intent.getStringExtra("EXTRA_PHONE").orEmpty()
        val username = intent.getStringExtra("EXTRA_USERNAME").orEmpty()
        val password = intent.getStringExtra("EXTRA_PASSWORD").orEmpty()

        binding.btnVerifyOtp.setOnClickListener {
            val otp = binding.etOtpCode.text?.toString()?.trim().orEmpty()
            if (otp.isBlank() || otp != phone) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Verifikasi Gagal")
                    .setMessage("Kode OTP salah atau kosong. Masukkan nomor handphone yang sama seperti saat registrasi.")
                    .setPositiveButton("Coba Lagi", null)
                    .show()
                return@setOnClickListener
            }

            val saved = getSharedPreferences("UserPref", Context.MODE_PRIVATE).edit()
                .putString("KEY_NAMA", name)
                .putString("KEY_PHONE", phone)
                .putString("KEY_USERNAME", username)
                .putString("KEY_PASSWORD", password)
                .commit()

            if (saved) {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Registrasi Berhasil")
                    .setMessage("Data berhasil disimpan. Silakan login menggunakan akun yang baru dibuat.")
                    .setPositiveButton("Ke Login") { _, _ ->
                        val i = Intent(this, LoginActivity::class.java)
                        i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                        startActivity(i)
                        finish()
                    }
                    .setCancelable(false)
                    .show()
            } else {
                MaterialAlertDialogBuilder(this)
                    .setTitle("Gagal Menyimpan")
                    .setMessage("Data akun tidak berhasil disimpan. Silakan coba lagi.")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}
