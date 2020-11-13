package br.com.lucolimac.androidcore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.androidcore.R
import br.com.lucolimac.androidcore.domain.Restaurante


class RestauranteAdapter(
    private val listaEntrada: List<Restaurante>,
    private val mOnRestauranteClickListener: OnRestauranteClickListener
) : RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestauranteViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_restaurante, parent, false)
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivRestaurante.setOnClickListener {
            mOnRestauranteClickListener.onRestauranteClick(position)
        }
        holder.ivRestaurante.setImageResource(currentItem.imagem)
        holder.tvNomeRestaurante.setText(currentItem.local)
        holder.tvEnderecoRestaurante.setText(currentItem.endereco)
        holder.tvHorarioRestaurante.setText(currentItem.horario)
    }

    override fun getItemCount(): Int {
        return listaEntrada.size
    }

    inner class RestauranteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivRestaurante: ImageView = itemView.findViewById(R.id.ivRestaurante)
        val tvNomeRestaurante: TextView = itemView.findViewById(R.id.tvNomeRestaurante)
        val tvEnderecoRestaurante: TextView = itemView.findViewById(R.id.tvEnderecoRestaurante)
        val tvHorarioRestaurante: TextView = itemView.findViewById(R.id.tvHorarioRestaurante)
    }

    interface OnRestauranteClickListener {
        fun onRestauranteClick(position: Int)
    }
}