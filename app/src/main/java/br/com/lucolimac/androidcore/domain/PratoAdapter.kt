package br.com.lucolimac.androidcore.domain

import Prato
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.lucolimac.androidcore.R


class PratoAdapter(
    private val listaEntrada: List<Prato>,
    private val mOnPratoClickListener: OnPratoClickListener
) : RecyclerView.Adapter<PratoAdapter.PratoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PratoAdapter.PratoViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_prato, parent, false)
        return PratoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PratoAdapter.PratoViewHolder, position: Int) {
        val currentItem = listaEntrada[position]
        holder.ivPrato.setOnClickListener {
            mOnPratoClickListener.onPratoClick(position)
        }
        holder.ivPrato.setImageResource(currentItem.imagem)
        holder.tvNomePrato.setText(currentItem.nome)
//        holder.tvEnderecoPrato.setText(currentItem.de)
//        holder.tvHorarioPrato.setText(currentItem.horario)
    }

    override fun getItemCount(): Int {
        return listaEntrada.size
    }

    inner class PratoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        View.OnClickListener {
        val ivPrato: ImageView = itemView.findViewById(R.id.ivPrato)
        val tvNomePrato: TextView = itemView.findViewById(R.id.tvNomePrato)
//        val tvEnderecoPrato: TextView = itemView.findViewById(R.id.tvEnderecoPrato)
//        val tvHorarioPrato: TextView = itemView.findViewById(R.id.tvHorarioPrato)
//        override fun onClick(v: View?) {
//        }
    }

    interface OnPratoClickListener {
        fun onPratoClick(position: Int)
    }
}