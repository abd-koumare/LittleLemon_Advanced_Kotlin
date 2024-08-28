package com.koogin.littlelemon

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        findViewById<Button>(R.id.hamburger_btn).setOnClickListener {
            IngredientsActivity.start(this, "Hamburger")
        }

        findViewById<Button>(R.id.pasta_btn).setOnClickListener {
            IngredientsActivity.start(this, "Pasta")
        }


        findViewById<Button>(R.id.remove_salt_btn).setOnClickListener {
            IngredientsActivity.removeSalt()

            showToast("Salt removed") // extension func for AppCompactActivity
        }
    }
}