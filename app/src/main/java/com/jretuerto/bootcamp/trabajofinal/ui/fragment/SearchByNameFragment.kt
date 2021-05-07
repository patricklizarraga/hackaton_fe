package com.jretuerto.bootcamp.trabajofinal.ui.fragment

import android.content.Context
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.pokemon.PokemonResponse
import com.jretuerto.bootcamp.trabajofinal.databinding.FragmentSearchByNameBinding
import com.jretuerto.bootcamp.trabajofinal.ui.model.DashboardSearchModel
import dagger.hilt.android.AndroidEntryPoint
import pe.com.bootcamp.jretuerto.viewmodel.BCPViewModel


@AndroidEntryPoint
class SearchByNameFragment : Fragment(R.layout.fragment_search_by_name) {

    private var searchBinding: FragmentSearchByNameBinding? = null
    private val viewModel: BCPViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSearchByNameBinding.bind(view)
        searchBinding = binding

        setupUI()

        binding.dashboard.getSearchButton().setOnClickListener {

            if (!isEditTextEmpty(binding.dashboard.getSearchText())) {
                viewModel.doSearchPokemonByName(binding.dashboard.getSearchText().text.toString())
            }

            hideKeyboard(view)
        }

        setupViewModel()

    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        searchBinding = null
        super.onDestroyView()
    }

    private fun setupUI(){
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()

        searchBinding!!.dashboard.setTypeDashboard(
            DashboardSearchModel(
                resources.getString(R.string.search_name_title),
                resources.getString(R.string.search_name_subtitle),
                resources.getString(R.string.search_name_hint)
            )
        )

        searchBinding!!.dashboard.getSearchText().inputType = InputType.TYPE_CLASS_TEXT
        searchBinding!!.dashboard.getImagePokemon().visibility = View.INVISIBLE
        searchBinding!!.dashboard.getNamePokemon().visibility = View.INVISIBLE

    }

    private fun setupViewModel() {
        viewModel.pokemon.observe(viewLifecycleOwner, pokemonObserver)
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
    }

    private val pokemonObserver = Observer<PokemonResponse> { response ->

        if (!response.id.equals("")) {
            searchBinding!!.dashboard.getNamePokemon().text = response.name
            Glide.with(this).load(response.sprites.front_default).into(searchBinding!!.dashboard.getImagePokemon());

            searchBinding!!.dashboard.getImagePokemon().visibility = View.VISIBLE
            searchBinding!!.dashboard.getNamePokemon().visibility = View.VISIBLE

        } else {

        }

    }

    private val onMessageErrorObserver = Observer<String> {
        searchBinding!!.dashboard.getImagePokemon().visibility = View.INVISIBLE
        searchBinding!!.dashboard.getNamePokemon().visibility = View.INVISIBLE

        Toast.makeText(getContext(), it, Toast.LENGTH_SHORT).show();
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

    fun hideKeyboard(view: View) {
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}