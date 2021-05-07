package com.jretuerto.bootcamp.trabajofinal.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityMainBinding
import com.jretuerto.bootcamp.trabajofinal.ui.fragment.SearchByIdFragment
import com.jretuerto.bootcamp.trabajofinal.ui.fragment.SearchByNameFragment
import dagger.hilt.android.AndroidEntryPoint
import pe.com.bootcamp.jretuerto.viewmodel.BCPViewModel

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root, R.id.claMain)

        binding.iniciarButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }


    }
}