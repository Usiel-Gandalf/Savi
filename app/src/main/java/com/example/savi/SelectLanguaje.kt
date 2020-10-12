package com.example.savi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class SelectLanguaje : AppCompatActivity() {
    private var btnMixteco: Button? = null
    private var btnTriqui: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_languaje)
        btnMixteco = findViewById(R.id.btnMixteco) as Button
        btnTriqui = findViewById(R.id.btnTriqui) as Button
        btnMixteco!!.setOnClickListener() {
            languaje()
        }
        btnTriqui!!.setOnClickListener(){
            languaje()
        }
    }

    fun languaje() {
        //Toast.makeText(this, "Bienvenido al mundo  Oaxaqueño", Toast.LENGTH_SHORT).show()
        val lan: Intent = Intent(applicationContext, Languaje::class.java)
        startActivity(lan)

    }
}