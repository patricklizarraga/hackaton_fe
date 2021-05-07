package com.jretuerto.bootcamp.trabajofinal.util.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.databinding.TextViewComponentBinding
import com.jretuerto.bootcamp.trabajofinal.databinding.TopNavigationComponentBinding

class NavigationViewComponent(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {


    private var biding = TopNavigationComponentBinding.inflate(LayoutInflater
        .from(context), this, true)

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.NavigationTextView)
        biding.titleNavigation.text = attributes.getString(R.styleable.NavigationTextView_titleNavigation)
    }

    fun setIconRightButton(icon: Int){
        biding.rightButton.setBackgroundResource(icon)
    }

}