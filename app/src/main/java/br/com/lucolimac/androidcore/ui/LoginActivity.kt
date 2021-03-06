package br.com.lucolimac.androidcore.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lucolimac.androidcore.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        btRegister.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }
}