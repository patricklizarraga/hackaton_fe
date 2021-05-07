package com.jretuerto.bootcamp.trabajofinal.ui

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon.answer.Answer
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon.answer.Answers
import com.jretuerto.bootcamp.trabajofinal.data.repository.WatsonRepository
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityInformationBinding
import com.jretuerto.bootcamp.trabajofinal.ui.adapter.AnswerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationActivity() : BaseActivity() {

    private lateinit var binding: ActivityInformationBinding
    private val answersAdapter = AnswerAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        var callApiWatson: String = ""

        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root, R.id.claInformation)

        binding.questionResponseTextView.visibility = View.INVISIBLE
        binding.questionRecyclerView.visibility = View.INVISIBLE

        binding.questionButton.setOnClickListener {
            if (!isEditTextEmpty(binding.questionEditText)) {
                Thread({
                    callApiWatson =
                        WatsonRepository.CallApiWatson(binding.questionEditText!!.text!!.toString())

                    Log.d("Respuesta: ", callApiWatson)

                }).start()

                Thread.sleep(5000)

                Log.d("Respuesta: ", callApiWatson)

                binding.questionRecyclerView.visibility = View.VISIBLE

                //adding a layoutmanager
                binding.questionRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)


                val answers: List<Answers> = getAnswers(callApiWatson)[0].lista

                val adapter = AnswerAdapter(answers)

                binding.questionRecyclerView.adapter = adapter

                binding.questionResponseTextView.visibility = View.VISIBLE
                binding.questionResponseTextView.text = getAnswers(callApiWatson)[0].question

            }


        }
    }


    private fun isEditTextEmpty(editText: EditText) : Boolean {

        var texto = editText.text.toString().trim()

        if (TextUtils.isEmpty(texto)){
            editText.setError("Campo requerido")
            editText.requestFocus()
            return true
        } else {
            return false
        }
    }

    fun getAnswers(code: String): MutableList<Answer>{
        var answers:MutableList<Answer> = ArrayList()
        var Listas1:MutableList<Answers> = ArrayList()
        var Listas2:MutableList<Answers> = ArrayList()

        if (code.equals("002")) {
            Listas1.add(
                Answers(
                    "1",
                    "Fallo en el sistema del banco",
                    "Joel Retuerto",
                    "04/05/2021",
                    true
                )
            )
            Listas1.add(
                Answers(
                    "2",
                    "Es un cobro automático por falta de pagos el mes pasado",
                    "Patrick L. ",
                    "05/05/2021",
                    false
                )
            )
            Listas1.add(
                Answers(
                    "3",
                    "Es un procedimiento de rutina del banco para saber que está todo bien",
                    "Danny Alva",
                    "04/05/2021",
                    false
                )
            )
            answers.add(Answer("¿Por qué hay cobros dobles?", Listas1))
        }

        if (code.equals("001")) {
            Listas2.add(Answers("1","Puede ser alguna modalidad de robo", "Joel Retuerto", "04/05/2021", false))
            Listas2.add(Answers("2","Es por el concepto de membresía", "Patrick L. ", "05/05/2021", true))
            Listas2.add(Answers("3","El cobro se debe a los intereses que se cobran los 10 de cada mes", "Danny Alva", "04/05/2021", false))
            answers.add(Answer("Tengo un cobro no reconocido en mi tarjeta de crédito", Listas2))
        } else {
            Listas2.add(Answers("","", "", "", false))
            answers.add(Answer("", Listas2))
        }


        return answers
    }
}