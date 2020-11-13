package br.com.lucolimac.androidcore.ui

import br.com.lucolimac.androidcore.domain.Prato
import br.com.lucolimac.androidcore.domain.Restaurante
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.lucolimac.androidcore.R
import kotlinx.android.synthetic.main.activity_prato.*

class PratoActivity : AppCompatActivity() {
    private lateinit var restaurante: Restaurante
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)
        val extras = intent.extras
        val prato = extras?.getSerializable("prato") as Prato
        restaurante = extras.getSerializable("restaurante") as Restaurante
        logoPrato.setImageResource(prato.imagem)
        tvNomePrato.setText(prato.nome)
        tvDescricaoPrato.setText(prato.descricao)
        icBack.setOnClickListener {
            Intent(this, RestauranteActivity::class.java).apply {
                putExtra("restaurante", restaurante)
                startActivity(this)
            }
        }
    }
}