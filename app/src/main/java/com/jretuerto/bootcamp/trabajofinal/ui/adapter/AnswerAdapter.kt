package com.jretuerto.bootcamp.trabajofinal.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon.answer.Answers


class AnswerAdapter(val answersList: List<Answers>) : RecyclerView.Adapter<AnswerAdapter.ViewHolder>() {

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_information, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: AnswerAdapter.ViewHolder, position: Int) {
        holder.bindItems(answersList[position])
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return answersList.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(answers: Answers) {
            val orden = itemView.findViewById(R.id.orden_text_view) as TextView
            val answer = itemView.findViewById(R.id.answer_text_view) as TextView
            val accept = itemView.findViewById(R.id.accept_image_view) as ImageView
            val date = itemView.findViewById(R.id.date_answer_text_view) as TextView
            val user_answer = itemView.findViewById(R.id.user_answer_text_view) as TextView

            user_answer.text = answers.user
            answer.text = answers.answer
            date.text = answers.date
            orden.text = answers.orden

            if (answers.accept == false){
                accept.visibility = View.INVISIBLE
            } else {
                accept.visibility = View.VISIBLE
            }
        }
    }
}