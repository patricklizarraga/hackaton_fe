package com.jretuerto.bootcamp.trabajofinal.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jretuerto.bootcamp.trabajofinal.R
import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import com.jretuerto.bootcamp.trabajofinal.data.entities.ClaimResponse
import com.jretuerto.bootcamp.trabajofinal.data.entities.Option
import com.jretuerto.bootcamp.trabajofinal.databinding.ActivityClaimListBinding
import com.jretuerto.bootcamp.trabajofinal.ui.adapter.ClaimAdapter
import com.jretuerto.bootcamp.trabajofinal.ui.interfaces.IOnEventClick
import com.jretuerto.bootcamp.trabajofinal.ui.model.ClaimListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClaimListActivity : BaseActivity() {

    lateinit var biding: ActivityClaimListBinding
    private lateinit var adapter: ClaimAdapter
    private val viewModel: ClaimListViewModel by viewModels()
    private var listClaim: List<Claim> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        biding = ActivityClaimListBinding.inflate(layoutInflater)
        setContentView(biding.root, R.id.claimListActivity)

        setUI()
        setupViewModel()
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

    private fun setupViewModel() {
        viewModel.listClaim.observe(this, claimObserver)

        viewModel.getClaims()
    }

    private val claimObserver = Observer<ClaimResponse> { data ->

        listClaim = data.claims
        adapter.updateItems(listClaim)
    }
}