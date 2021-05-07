package com.jretuerto.bootcamp.trabajofinal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.data.entities.Option
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityClaimListBinding
import com.jretuerto.bootcamp.trabajofinal.ui.adapter.ClaimAdapter
import com.jretuerto.bootcamp.trabajofinal.ui.adapter.OptionAdapter
import com.jretuerto.bootcamp.trabajofinal.ui.interfaces.IOnEventClick

class ClaimListActivity : BaseActivity() {

    lateinit var biding: ActivityClaimListBinding
    private lateinit var adapter: ClaimAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityClaimListBinding.inflate(layoutInflater)
        setContentView(biding.root, R.id.claimListActivity)

        setUI()
    }

    fun setUI() {
        adapter = ClaimAdapter(onEventListener = object: IOnEventClick {
            override fun onClick(option: Option) {
                TODO("Not yet implemented")
            }

            override fun onClick(claim: Claim) {

            }

        })

        biding.claimRecycleView.layoutManager = LinearLayoutManager(this)
        biding.claimRecycleView.adapter = adapter
    }
}