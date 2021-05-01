package com.jretuerto.bootcamp.trabajofinal.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.ui.model.DashboardSearchModel


class DashboardSearchView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val title: TextView
    private val subtitle: TextView
    private val searchText: EditText
    private val searchButton: Button
    private val imagePokemon: ImageView
    private val namePokemon: TextView

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_search_dashboard, this, true)

        title = view.findViewById(R.id.title_text_view)
        subtitle = view.findViewById(R.id.subtitle_text_view)
        searchText = view.findViewById(R.id.search_edit_text)
        searchButton = view.findViewById(R.id.search_button)
        imagePokemon = view.findViewById(R.id.image_pokemon_image_view)
        namePokemon = view.findViewById(R.id.name_pokemon_text_view)
    }

    fun setTypeDashboard(dashboard: DashboardSearchModel){
        title.text = dashboard.title
        subtitle.text = dashboard.subtitle
        searchText.hint = dashboard.hint
    }

    fun getSearchButton(): Button{
        return searchButton
    }

    fun getSearchText(): EditText{
        return searchText
    }

    fun getNamePokemon(): TextView{
        return namePokemon
    }

    fun getImagePokemon(): ImageView{
        return imagePokemon
    }

}