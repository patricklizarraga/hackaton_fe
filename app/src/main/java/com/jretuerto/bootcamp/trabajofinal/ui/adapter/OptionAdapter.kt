package com.jretuerto.bootcamp.trabajofinal.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jretuerto.bootcamp.trabajofinal.data.entities.Option
import com.jretuerto.bootcamp.trabajofinal.databinding.OptionViewBinding
import com.jretuerto.bootcamp.trabajofinal.ui.interfaces.IOnEventClick

class OptionAdapter(
    private var listOption: List<Option> = emptyList(),
    private val onEventListener: IOnEventClick
): RecyclerView.Adapter<OptionAdapter.OptionHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionHolder {
        val view = OptionViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return OptionHolder(view)
    }

    override fun onBindViewHolder(holder: OptionHolder, position: Int) {
        val option = listOption[position]

        holder.bind(option = option)
    }

    override fun getItemCount(): Int {
        return listOption.size
    }

    inner class OptionHolder(private val itemBinding: OptionViewBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var binding: OptionViewBinding

        fun bind(option: Option) {
            binding = itemBinding
            binding.iconImageView.setImageResource(option.imgResource)
            binding.titleTextView.text = option.title

            itemView.setOnClickListener {
                onEventListener.onClick(listOption[adapterPosition])
            }
        }

    }

}