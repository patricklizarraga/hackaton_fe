package pe.com.bootcamp.jretuerto.util.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.databinding.ViewLoadingBinding
import pe.com.bootcamp.jretuerto.util.Constants


class LoadingView(context: Context, attrs: AttributeSet? = null) : LinearLayout(context, attrs) {

    private var binding: ViewLoadingBinding =
        ViewLoadingBinding.inflate(LayoutInflater.from(context), this, true)

    init {


        inflate(context, R.layout.view_loading, this)

        attrs?.let {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.LoadingView)
            binding.tviTitleLoader.text = attributes.getString(R.styleable.LoadingView_title)


            attributes.recycle()
        }


    }

    fun updateText(message: String) {
        binding.tviTitleLoader.text = message

    }

    fun initializeUI(
        title: String,
        backgroundLoader: Constants.EnumViewLoading = Constants.EnumViewLoading.VIEW_BACKGROUND_TRANSPARENT
    ) {

        var textColor = R.color.design_default_color_primary


        when (backgroundLoader) {
            Constants.EnumViewLoading.VIEW_BACKGROUND_TRANSPARENT -> {

                binding.llaLoading.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.design_default_color_secondary,
                        null
                    )
                )

                textColor = R.color.white


            }
            Constants.EnumViewLoading.VIEW_BACKGROUND_WHITE -> {
                binding.llaLoading.setBackgroundColor(
                    ResourcesCompat.getColor(
                        resources,
                        R.color.white,
                        null
                    )
                )

                textColor = R.color.design_default_color_primary

            }

        }

        binding.tviTitleLoader.text = title

        binding.tviTitleLoader.setTextColor(
            ResourcesCompat.getColor(
                resources,
                textColor,
                null
            )
        )


    }


}