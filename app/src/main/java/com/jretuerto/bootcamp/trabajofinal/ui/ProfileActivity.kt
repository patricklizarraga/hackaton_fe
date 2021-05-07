package com.jretuerto.bootcamp.trabajofinal.ui

import android.content.Intent
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

        setUI()
    }

    fun setUI() {
        adapter = OptionAdapter(listOptions.toList(), onEventListener = object: IOnEventClick {
            override fun onClick(option: Option) {
                if (option.title == "Reclamos") {
                    val intent = Intent(applicationContext, ClaimListActivity::class.java)
                    startActivity(intent)
                }
            }

            override fun onClick(claim: Claim) {
                TODO("Not yet implemented")
            }

        })

        binding.optionRecycleView.layoutManager = LinearLayoutManager(this)
        binding.optionRecycleView.adapter = adapter
    }

    companion object {
        val listOptions: Array<Option> = arrayOf(
            Option(R.drawable.ic_setting, "Configuración"),
            Option(R.drawable.ic_document, "Reclamos"),
            Option(R.drawable.ic_logout, "Salir")
        )


        binding.informationButton.setOnClickListener {

            val intent = Intent(this, InformationActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}