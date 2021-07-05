package com.example.loginapplication

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.fragment)
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да")
            { _, _ ->
                super.onBackPressed()
                finish()
            }

            setNegativeButton("Нет") { _, _ ->
                // if user press no, then return the activity
                Toast.makeText(
                    this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG
                ).show()
            }
            setCancelable(true)
        }.create().show()
    }

}