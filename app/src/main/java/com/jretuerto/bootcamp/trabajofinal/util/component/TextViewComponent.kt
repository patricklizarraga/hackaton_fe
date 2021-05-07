package com.jretuerto.bootcamp.trabajofinal.util.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.databinding.TextViewComponentBinding

class TextViewComponent(context: Context, attrs: AttributeSet? = null) :
    LinearLayout(context, attrs) {

    private var biding = TextViewComponentBinding.inflate(LayoutInflater
        .from(context), this, true)

    init {
        val attributesTitle = context.obtainStyledAttributes(attrs, R.styleable.TextView)
        biding.titleTextView.text = attributesTitle.getString(R.styleable.TextView_titleTextView)

        val attributesHint = context.obtainStyledAttributes(attrs, R.styleable.EditText)
        biding.hintEditText.hint = attributesHint.getString(R.styleable.EditText_hintTextView)
    }


}