package com.example.savi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    private var button: Button? = null
    private var editUser: EditText? = null
    private var editPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btnInicial) as Button
        editUser = findViewById(R.id.editUser) as EditText
        editPassword = findViewById(R.id.editPassword) as EditText

        button!!.setOnClickListener{
            val user = editUser!!.text.toString()
            val password = editPassword!!
            val duration = Toast.LENGTH_SHORT
            if (user == "Usiel")
            {
                val toast = Toast.makeText(this, "Inicio de sesion correcto", duration).show()
            }else{
                val toast = Toast.makeText(this, "Usuario incorrecto", duration).show()
            }

        }
    }

}