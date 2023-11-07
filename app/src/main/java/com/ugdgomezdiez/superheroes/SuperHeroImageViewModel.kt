package com.ugdgomezdiez.superheroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.domain.Biography
import com.ugdgomezdiez.superheroes.domain.GetSuperHeroeUseCase
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.Work
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroImageViewModel(private val getSuperHeroeUseCase: GetSuperHeroeUseCase): ViewModel() {

    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel

    fun loadSuperHeroe(id:Int){
        _uiModel.value=UiModel(isLoading = true)
        viewModelScope.launch(Dispatchers.IO) {
            getSuperHeroeUseCase(id).fold(
                {responseError(it)},
                {responseGetSuperHeroSuccess(it)}
            )
        }
    }
    private fun responseError(errorApp: ErrorApp){
        _uiModel.postValue(UiModel(errorApp = errorApp))
    }

    private fun responseGetSuperHeroSuccess(listaSuperHeroe: SuperHeroe) {
        _uiModel.postValue(UiModel(superHeroe = listaSuperHeroe))
    }
    data class UiModel(
    val isLoading: Boolean= false,
    val errorApp: ErrorApp?=null,
    val superHeroe: SuperHeroe?=null,
    val biography: Biography?=null,
    val work: Work?=null
    )
}