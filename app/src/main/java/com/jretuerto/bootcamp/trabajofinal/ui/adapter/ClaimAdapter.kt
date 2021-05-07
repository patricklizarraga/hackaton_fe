package com.jretuerto.bootcamp.trabajofinal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.databinding.OptionViewBinding
import com.jretuerto.bootcamp.trabajofinal.ui.interfaces.IOnEventClick

class ClaimAdapter(
    private var listClaim: List<Claim> = emptyList(),
    private val onEventListener: IOnEventClick
): RecyclerView.Adapter<ClaimAdapter.ClaimHolder>() {


    inner class ClaimHolder(private val itemBinding: OptionViewBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var binding: OptionViewBinding

        fun bind(claim: Claim) {
            binding = itemBinding
            binding.titleTextView.text = claim.sumary

            itemView.setOnClickListener {
                onEventListener.onClick(listClaim[adapterPosition])
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClaimAdapter.ClaimHolder {
        val view = OptionViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ClaimHolder(view)
    }

    override fun onBindViewHolder(holder: ClaimAdapter.ClaimHolder, position: Int) {
        val claim = listClaim[position]

        holder.bind(claim = claim)
    }

    override fun getItemCount(): Int {
        return listClaim.size
    }

}
