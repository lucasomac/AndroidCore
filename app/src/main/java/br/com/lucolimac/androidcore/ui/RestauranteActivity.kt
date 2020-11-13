package br.com.lucolimac.androidcore.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lucolimac.androidcore.R
import br.com.lucolimac.androidcore.adapter.PratoAdapter
import br.com.lucolimac.androidcore.domain.Prato
import br.com.lucolimac.androidcore.domain.Restaurante
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity(), PratoAdapter.OnPratoClickListener {
    private lateinit var restaurante: Restaurante
    private var listaPratos = getListaPrato()
    private val pratoAdapter = PratoAdapter(listaPratos, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)
        val extras = intent.extras
        restaurante = extras?.getSerializable("restaurante") as Restaurante
        tvNomeRestaurante.setText(restaurante.local)

        rcPratos.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = pratoAdapter
        }
        icBack.setOnClickListener {
            onNavigateUp()
        }
    }

    override fun onPratoClick(position: Int) {
        Intent(this, PratoActivity::class.java).apply {
            putExtra("prato", listaPratos.get(position))
            putExtra("restaurante", restaurante)
            startActivity(this)
        }
    }

    private fun getListaPrato(): ArrayList<Prato> {
        val prato = Prato(
            R.drawable.image4,
            "Salada com molho Gengibre",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )
        return arrayListOf(prato, prato, prato, prato, prato, prato, prato, prato)
    }
}