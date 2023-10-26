package com.ugdgomezdiez.superheroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ugdgomezdiez.superheroes.app.ErrorApp
import com.ugdgomezdiez.superheroes.data.remote.BiographyRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.SuperHeroeRemoteDataSource
import com.ugdgomezdiez.superheroes.data.remote.WorkRemoteDataSource
import com.ugdgomezdiez.superheroes.domain.Biography
import com.ugdgomezdiez.superheroes.domain.SuperHeroe
import com.ugdgomezdiez.superheroes.domain.Work
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SuperHeroeViewModel(
    private val biographyRemoteDataSource: BiographyRemoteDataSource,
    private val workRemoteDataSource: WorkRemoteDataSource,
    private val superHeroeRemoteDataSource: SuperHeroeRemoteDataSource
    ): ViewModel(){
    private val _uiModel = MutableLiveData<UiModel>()
    val uiModel: LiveData<UiModel> = _uiModel

    fun loadSuperHeroe(){
        _uiModel.value = UiModel(isLoading = true)

        viewModelScope.launch(Dispatchers.IO) {


            println(biographyRemoteDataSource.findBiography(1))
            println(workRemoteDataSource.findWork(1))
        }
    }


    data class UiModel(
        val isLoading: Boolean= false,
        val errorApp: ErrorApp?=null,
        val superHeroe: SuperHeroe?=null,
        val biography: Biography?=null,
        val work: Work?=null
    )
}