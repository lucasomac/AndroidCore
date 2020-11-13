package br.com.lucolimac.androidcore

import Prato
import Restaurante
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lucolimac.androidcore.domain.PratoAdapter
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity(), PratoAdapter.OnPratoClickListener {

    private val listaPratos = getListaPrato()
    private val pratoAdapter = PratoAdapter(listaPratos, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)
        val extras = intent.extras
        var restaurante = extras?.getSerializable("restaurante") as Restaurante
        tvNomeRestaurante.setText(restaurante.local)

        rcPratos.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            adapter = pratoAdapter
        }
    }

    override fun onPratoClick(position: Int) {
        TODO("Not yet implemented")
    }

    private fun getListaPrato(): ArrayList<Prato> {
        val prato = Prato(
            R.drawable.image3,
            "Salada com molho Gengibre",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."
        )
        return arrayListOf(prato, prato, prato, prato, prato, prato, prato, prato)
    }
}