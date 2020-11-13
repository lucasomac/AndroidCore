package br.com.lucolimac.androidcore

import Prato
import Restaurante
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lucolimac.androidcore.domain.PratoAdapter
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity(), PratoAdapter.OnPratoClickListener {

    private var listaPratos = ArrayList<Prato>()
    private val pratoAdapter = PratoAdapter(listaPratos, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)
        val extras = intent.extras
        val restaurante = extras?.getSerializable("restaurante") as Restaurante
        this.listaPratos = getListaPrato(restaurante)
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
        val intent = Intent(this, PratoActivity::class.java)
        intent.putExtra("prato", listaPratos.get(position))
        startActivity(intent)
    }

    private fun getListaPrato(restaurante: Restaurante): ArrayList<Prato> {
        val prato = Prato(
            R.drawable.image3,
            "Salada com molho Gengibre",
            "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis.",
            restaurante
        )
        return arrayListOf(prato, prato, prato, prato, prato, prato, prato, prato)
    }
}