package com.jretuerto.bootcamp.trabajofinal.ui.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jretuerto.bootcamp.trabajofinal.data.entities.Claim
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.com.bootcamp.jretuerto.data.remote.Result
import pe.com.bootcamp.jretuerto.data.repository.ClaimRepository
import pe.com.bootcamp.jretuerto.viewmodel.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class ClaimListViewModel@Inject constructor(private val repository: ClaimRepository) : BaseViewModel() {

    private val _formData = MutableLiveData<List<Claim>>()
    val formData: LiveData<List<Claim>> = _formData

    fun getDataForm(customerId: String) {

        viewModelScope.launch {

            val result: Result<Claim> = withContext(Dispatchers.IO) {
                repository.getClaim(customerId)
            }

            when (result) {
                is Result.Success -> {
                    _formData.value = listOf(result.data)
                }

                //is Result.ApiError -> _onMessageError.postValue(result.exception)
            }

        }

    }
}