package br.com.lucolimac.androidcore

import Restaurante
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucolimac.androidcore.domain.RestauranteAdapter
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), RestauranteAdapter.OnRestauranteClickListener {
    private val listaRestaurantes = getListaRestaurante()
    private val restauranteAdapter = RestauranteAdapter(listaRestaurantes, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(tbHome)
        rcRestaurantes.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = restauranteAdapter
        }

    }

    fun getListaRestaurante(): ArrayList<Restaurante> {
        val restaurante01 = Restaurante(
            R.drawable.image1,
            "Tony Roma's",
            "Av. Lavandisca, 717 - Indianópolis, São Paulo",
            "Fecha às 22:00"
        )
        val restaurante02 =
            Restaurante(
                R.drawable.image2,
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00"
            )
        val restaurante03 = Restaurante(
            R.drawable.image3,
            "Outback - Moema",
            "Av. Moaci, 187, 187 - Moema, São Paulo",
            "Fecha às 00:00"
        )
        val restaurante04 = Restaurante(
            R.drawable.image4,
            "Sí Señor!",
            "Alameda Jauaperi, 626 - Moema",
            "Fecha às 01:00"
        )
//        val restaurante05 = Restaurante(R.drawable.image5, "LITUANIA", "23/08/1994", "Das 05 as 12")
        val lista =
            arrayListOf(restaurante01, restaurante02, restaurante03, restaurante04)
        return lista
    }

    override fun onRestauranteClick(position: Int) {
        val intent = Intent(this, RestauranteActivity::class.java)
        startActivity(intent)
    }
}