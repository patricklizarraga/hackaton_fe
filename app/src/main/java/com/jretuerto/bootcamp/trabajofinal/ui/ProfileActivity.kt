package com.jretuerto.bootcamp.trabajofinal.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.data.entities.Option
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityProfileBinding
import com.jretuerto.bootcamp.trabajofinal.ui.adapter.OptionAdapter
import com.jretuerto.bootcamp.trabajofinal.ui.interfaces.IOnEventClick

class ProfileActivity : BaseActivity() {

    private lateinit var binding: ActivityProfileBinding

    private lateinit var adapter: OptionAdapter

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
    }
}