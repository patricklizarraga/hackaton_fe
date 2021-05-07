package com.jretuerto.bootcamp.trabajofinal.ui

import android.content.Intent
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


        binding.informationButton.setOnClickListener {

            val intent = Intent(this, InformationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}