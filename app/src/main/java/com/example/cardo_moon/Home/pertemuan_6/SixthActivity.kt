package com.example.cardo_moon.Home.pertemuan_6

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.cardo_moon.R

class SixthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sixth)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(
                WindowInsetsCompat.Type.systemBars()
            )
            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )
            insets
        }

        // Menampilkan Fragment pertama saat Activity dibuka
        if (savedInstanceState == null) {
            replaceFragment(SatuFragment())
        }

        // Mengambil tombol dari layout
        val btnFragment1 = findViewById<Button>(R.id.btnFragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnFragment2)
        val btnFragment3 = findViewById<Button>(R.id.btnFragment3)

        // Tombol untuk berpindah Fragment
        btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }

        btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }

        btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    // Fungsi untuk mengganti Fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}