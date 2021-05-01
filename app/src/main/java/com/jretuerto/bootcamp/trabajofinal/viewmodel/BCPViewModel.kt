package pe.com.bootcamp.jretuerto.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.jretuerto.bootcamp.trabajofinal.data.entities.pokemon.PokemonResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import pe.com.bootcamp.jretuerto.data.repository.BCPRepository
import pe.com.bootcamp.jretuerto.data.remote.Result
import pe.com.bootcamp.jretuerto.util.Constants.NOT_FOUND_POKEMON
import javax.inject.Inject

@HiltViewModel
class BCPViewModel @Inject constructor(private val repository: BCPRepository) :
    BaseViewModel() {


    private val _pokemon = MutableLiveData<PokemonResponse>()
    val pokemon: LiveData<PokemonResponse> = _pokemon

    protected val _onMessageError = MutableLiveData<String>()
    val onMessageError: LiveData<String> = _onMessageError

    fun doSearchPokemonById(pokemonId: String) {
        viewModelScope.launch {


            val result: Result<PokemonResponse> = withContext(Dispatchers.IO) {
                repository.searchPokemonById(pokemonId)
            }

            when (result) {
                is Result.Success -> {
                    _pokemon.value = result.data
                }

                is Result.ApiError -> {
                    _onMessageError.postValue(NOT_FOUND_POKEMON)

                }

            }
        }
    }

    fun doSearchPokemonByName(pokemonName: String) {
        viewModelScope.launch {


            val result: Result<PokemonResponse> = withContext(Dispatchers.IO) {
                repository.searchPokemonByName(pokemonName)
            }

            when (result) {
                is Result.Success -> {
                    _pokemon.value = result.data
                }

                is Result.ApiError -> {
                    _onMessageError.postValue(NOT_FOUND_POKEMON)

                }

            }
        }
    }
}