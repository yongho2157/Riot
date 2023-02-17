package com.yh.riot.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.domain.repository.RiotRepository
import com.yh.riot.domain.usecase.GetLOLChampUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLOLChampUseCase: GetLOLChampUseCase,
    private val repository: RiotRepository
    ) :
    ViewModel() {

    val localChampionList: LiveData<List<LOLChamp>> = repository.getAllChampion()
    val currentChampionList: MutableLiveData<List<LOLChamp>> by lazy {
        MutableLiveData<List<LOLChamp>>()
    }

    fun getChamp() {
        getLOLChampUseCase().onEach { result ->
            when (result) {
                is com.yh.riot.Result.Error -> {}
                is com.yh.riot.Result.Loading -> {}
                is com.yh.riot.Result.Success -> {
                    currentChampionList.value = result.data
                }
            }

        }.launchIn(viewModelScope)
    }

    fun saveChampion(lolChamp: LOLChamp) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertChampion(lolChamp)
        }
    }

}