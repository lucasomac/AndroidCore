package br.com.lucolimac.androidcore

import Restaurante
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)
        val extras = intent.extras
        var restaurante = extras?.getSerializable("restaurante") as Restaurante
        tvNomeRestaurante.setText(restaurante.local)
    }

}