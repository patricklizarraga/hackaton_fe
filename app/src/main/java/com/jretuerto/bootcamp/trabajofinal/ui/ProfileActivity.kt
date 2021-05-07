package com.jretuerto.bootcamp.trabajofinal.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityMainBinding
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root, R.id.profileActivity)
    }
}