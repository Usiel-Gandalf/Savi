package com.example.savi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_select_languaje.*
import kotlin.String as String

enum class ProviderType{
    BASIC
}

class SelectLanguaje : AppCompatActivity() {
    private var btnLogout: Button? = null
    private var btnMixteco: Button? = null
    private var btnTriqui: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_languaje)
        btnLogout = findViewById(R.id.btnLogout) as Button
        btnMixteco = findViewById(R.id.btnMixteco) as Button
        btnTriqui = findViewById(R.id.btnTriqui) as Button

        val bundle = intent.extras
        val email: String? = bundle?.getString("email")
      //  val provider: String? = bundle?.getString("provider")
        //setup
        setup(email ?: "")

        btnMixteco!!.setOnClickListener(){
            Mixteco()
        }
    }

    private fun setup(email: String) {
        txtCorreo.text = email
       // txtProvider.text = provider
        btnLogout!!.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            onBackPressed()

        }
    }

    private fun Mixteco(){
        Toast.makeText(this, "Usted a seleccionado el lenguaje mixteco", Toast.LENGTH_LONG).show()
    }
}