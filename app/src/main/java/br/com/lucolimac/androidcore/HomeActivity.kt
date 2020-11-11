package br.com.lucolimac.androidcore

import Prato
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.androidcore.domain.PratoAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), PratoAdapter.OnClickPratoListener {
    private val listaPratos = getListaPrato()
    private val pratoAdapter = PratoAdapter(listaPratos, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(tbHome)
        rcPratos.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = pratoAdapter
        }

    }

    fun getListaPrato(): ArrayList<Prato> {
        val Prato01 = Prato(R.drawable.image1, "PEDRA DA ARADA", "23/08/1994", "Das 09 as 18")
//        val Prato02 = Prato(R.drawable.image2, "CAMPOS DO JORDÃO", "23/08/1994", "Das 09 as 15")
        val Prato03 = Prato(R.drawable.image3, "SACRAMENTO", "23/08/1994", "Das 18 as 22")
        val Prato04 = Prato(R.drawable.image4, "JALAPÃO", "23/08/1994", "Das 17 as 02")
        val Prato05 = Prato(R.drawable.image5, "LITUANIA", "23/08/1994", "Das 05 as 12")
        val lista = arrayListOf(Prato01, Prato03, Prato04, Prato05)
        return lista
    }

    override fun onClickPrato(position: Int) {
        val prato: Prato = listaPratos.get(position)
////        prato.local = "Presente"
//        pratoAdapter.notifyItemChanged(position)
        Toast.makeText(this, prato.local, Toast.LENGTH_LONG).show()
    }
}