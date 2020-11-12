package br.com.lucolimac.androidcore

import Restaurante
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucolimac.androidcore.domain.RestauranteAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RestauranteAdapter.OnRestauranteClickListener {
    private val listaPratos = getListaPrato()
    private val pratoAdapter = RestauranteAdapter(listaPratos, this)
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

    fun getListaPrato(): ArrayList<Restaurante> {
        val Prato01 = Restaurante(R.drawable.image1, "PEDRA DA ARADA", "23/08/1994", "Das 09 as 18")
        val Prato02 =
            Restaurante(R.drawable.image2, "CAMPOS DO JORDÃO", "23/08/1994", "Das 09 as 15")
        val Prato03 = Restaurante(R.drawable.image3, "SACRAMENTO", "23/08/1994", "Das 18 as 22")
        val Prato04 = Restaurante(R.drawable.image4, "JALAPÃO", "23/08/1994", "Das 17 as 02")
        val Prato05 = Restaurante(R.drawable.image5, "LITUANIA", "23/08/1994", "Das 05 as 12")
        val lista = arrayListOf(Prato01, Prato02, Prato03, Prato04, Prato05)
        return lista
    }

    override fun onRestauranteClick(position: Int) {
        val intent = Intent(this, RestauranteActivity::class.java)
        startActivity(intent)
    }
}