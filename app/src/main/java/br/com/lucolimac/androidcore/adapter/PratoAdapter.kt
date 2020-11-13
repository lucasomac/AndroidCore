package br.com.lucolimac.androidcore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.androidcore.R
import br.com.lucolimac.androidcore.domain.Prato


class PratoAdapter(
    private val listaEntrada: List<Prato>,
    private val mOnPratoClickListener: OnPratoClickListener
) : RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_prato, parent, false)
        return PratoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivPrato.setOnClickListener {
            mOnPratoClickListener.onPratoClick(position)
        }
        holder.ivPrato.setImageResource(currentItem.imagem)
        holder.tvNomePrato.setText(currentItem.nome)
    }

    override fun getItemCount(): Int {
        return listaEntrada.size
    }

    inner class PratoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPrato: ImageView = itemView.findViewById(R.id.ivPrato)
        val tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)
    }

    interface OnPratoClickListener {
        fun onPratoClick(position: Int)
    }
}