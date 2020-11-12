package br.com.lucolimac.androidcore.domain

import Prato
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.androidcore.R


class PratoAdapter(private val listaEntrada: List<Prato>) :
    RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratoAdapter.PratoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_comida, parent, false)
        return PratoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratoAdapter.PratoViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivPrato.setImageResource(currentItem.imagem)
        holder.tvNomeLocal.setText(currentItem.local)
        holder.tvEndereco.setText(currentItem.endereco)
        holder.tvHorario.setText(currentItem.horario)
    }

    override fun getItemCount(): Int {
        return listaEntrada.size
    }

    inner class PratoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
//        itemView.findViewById(R.id.card)setOnClickListener
//        { this }
        val ivPrato: ImageView = itemView.findViewById(R.id.ivPrato)
        val tvNomeLocal: TextView = itemView.findViewById(R.id.tvNomeLocal)
        val tvEndereco: TextView = itemView.findViewById(R.id.tvEndereco)
        val tvHorario: TextView = itemView.findViewById(R.id.tvHorario)
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    interface OnPratoListener {
        fun onPratoClick(position: Int)
    }
}