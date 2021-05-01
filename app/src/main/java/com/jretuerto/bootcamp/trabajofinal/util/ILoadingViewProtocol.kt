package pe.com.bootcamp.jretuerto.util

import androidx.constraintlayout.widget.ConstraintLayout


interface ILoadingViewProtocol {
    fun setupLoadingView(layout: ConstraintLayout)
    fun showLoadingView(message: String = "")
    fun hideLoadingView()
}