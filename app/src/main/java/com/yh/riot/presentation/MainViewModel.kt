package com.yh.riot.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.domain.usecase.GetLOLChampUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getLOLChampUseCase: GetLOLChampUseCase) :
    ViewModel() {

    val currentChampionList: MutableLiveData<List<LOLChamp>> by lazy {
        MutableLiveData<List<LOLChamp>>()
    }

    fun getChamp() {
        Log.d("결과", "getChamp()")
//        viewModelScope.launch(Dispatchers.IO) {
//            getLOLChampUseCase().onEach {
//
//            }
//        }
        getLOLChampUseCase().onEach { result ->
            when (result) {
                is com.yh.riot.Result.Error -> {}
                is com.yh.riot.Result.Loading -> {}
                is com.yh.riot.Result.Success -> {
                    Log.d("결과", result.data.toString())
                    currentChampionList.value = result.data
                }
            }

        }.launchIn(viewModelScope)
    }
}