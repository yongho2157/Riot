package com.yh.riot.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.domain.repository.RiotRepository
import com.yh.riot.domain.usecase.GetChampInfoUseCase
import com.yh.riot.domain.usecase.GetLOLChampUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.yh.riot.Result
import com.yh.riot.data.model.ChampInfo

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getLOLChampUseCase: GetLOLChampUseCase,
    private val getChampInfoUseCase: GetChampInfoUseCase,
    private val repository: RiotRepository
    ) :
    ViewModel() {

    val localChampionList: LiveData<List<LOLChamp>> = repository.getAllChampion()
    val currentChampionList: MutableLiveData<List<LOLChamp>> by lazy {
        MutableLiveData<List<LOLChamp>>()
    }

    val champInfoList: MutableLiveData<List<ChampInfo>> by lazy {
        MutableLiveData<List<ChampInfo>>()
    }

    fun getChamp() {
        getLOLChampUseCase().onEach { result ->
            when (result) {
                is Result.Error -> {}
                is Result.Loading -> {}
                is Result.Success -> {
                    currentChampionList.value = result.data
                }
            }

        }.launchIn(viewModelScope)
    }

    fun getChampInfo(champId: String) {
        Log.d("결과", "getChampInfo")
        getChampInfoUseCase(champId).onEach { result ->
            when (result) {
                is Result.Error -> {
                    Log.d("결과", "getChampInfo : " + result.exception)
                }
                is Result.Loading -> {

                }
                is Result.Success -> {
                    Log.d("결과", "getChampInfo : " + result.data)
                    champInfoList.value = result.data
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