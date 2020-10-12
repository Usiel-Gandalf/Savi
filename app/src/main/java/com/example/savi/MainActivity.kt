package com.example.savi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var btnLogin: Button? = null
    private var editUser: EditText? = null
    private var editPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnInicial) as Button
        editUser = findViewById(R.id.editUser) as EditText
        editPassword = findViewById(R.id.editPassword) as EditText
        login()

    }

    fun login() {
        btnLogin!!.setOnClickListener() {
            //val toast = Toast.makeText(this, "Uso de funciones con onclick", Toast.LENGTH_SHORT).show()
            val log: Intent = Intent(applicationContext, SelectLanguaje::class.java)
            startActivity(log)
        }
    }

}