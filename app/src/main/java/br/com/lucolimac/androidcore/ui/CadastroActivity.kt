package br.com.lucolimac.androidcore.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.lucolimac.androidcore.R
import kotlinx.android.synthetic.main.activity_cadastro.*


class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        setSupportActionBar(tbCadastro)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        btRegisterRegister.setOnClickListener {
            when {
                etNameRegister.text!!.isEmpty() || etEmailRegister.text!!.isEmpty() || etPasswordRegister.text!!.isEmpty() || etPasswordConfirmRegister.text!!.isEmpty() -> {
                    Toast.makeText(this, "Alguns dos campos está vazio", Toast.LENGTH_LONG).show()
                }
                etPasswordConfirmRegister.text.toString() != etPasswordRegister.text.toString() -> {
                    Toast.makeText(this, "A senha não confere", Toast.LENGTH_LONG).show()
                }
                else -> {
                    Toast.makeText(this, "Usuário criado com sucesso", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            }
        }
    }
}