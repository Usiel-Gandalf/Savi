package com.example.savi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {
    private var btnLogin: Button? = null
    private var btnRegistrar: Button? = null
    private var txtEmail: EditText? = null
    private var txtPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        btnLogin = findViewById(R.id.btnInicial) as Button
        btnRegistrar = findViewById(R.id.btnRegistrar) as Button
        txtEmail = findViewById(R.id.txtCorreo) as EditText
        txtPassword = findViewById(R.id.txtPassword) as EditText
        //login()

        // Setup
        setup()

    }

    private fun setup(){
        btnRegistrar!!.setOnClickListener(){
            if (txtEmail!!.text.isNotEmpty() && txtPassword!!.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtEmail!!.text.toString(), txtPassword!!.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        showLanguajes(it.result?.user?.email?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }

        btnLogin!!.setOnClickListener(){
            if (txtEmail!!.text.isNotEmpty() && txtPassword!!.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(txtEmail!!.text.toString(), txtPassword!!.text.toString()).addOnCompleteListener{
                    if (it.isSuccessful){
                        showLanguajes(it.result?.user?.email?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }
            }
        }
    }

    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error algo salio mal")
        builder.setMessage("Se ha producido un error autenticando al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showLanguajes(email: String, provider: ProviderType) {
            val languajeActivity: Intent = Intent(this, SelectLanguaje::class.java).apply {
                putExtra("email", email)
                putExtra("provider", provider.name)
            }
        startActivity(languajeActivity)
    }

}