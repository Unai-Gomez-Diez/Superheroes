package com.ugdgomezdiez.superheroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.data.remote.ApiRemoteDataSource
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SuperHeroeViewModel(private val apiRemoteDataSource: ApiRemoteDataSource): ViewModel(){
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel

    fun loadSuperHeroe(){
        _uiModel.value = UiModel(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {


            println(apiRemoteDataSource.findSuperHeroe())
        }
    }


    data class UiModel(
        val isLoading: Boolean= false,
        val errorApp: ErrorApp?=null,
        val superHeroe: SuperHeroe?=null
    )
}