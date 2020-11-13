package br.com.lucolimac.androidcore

import Prato
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_prato.*

class PratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)
        val extras = intent.extras
        var prato = extras?.getSerializable("prato") as Prato

        logoPrato.setImageResource(prato.imagem)
        tvNomePrato.setText(prato.nome)
        tvDescricaoPrato.setText(prato.descricao)
    }
}