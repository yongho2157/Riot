package com.yh.riot.domain.usecase

import android.util.Log
import kotlinx.coroutines.flow.Flow
import com.yh.riot.Result
import com.yh.riot.data.model.LOLChamp
import com.yh.riot.domain.repository.RiotRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLOLChampUseCase @Inject constructor(private val riotRepository: RiotRepository) {

    operator fun invoke(): Flow<Result<List<LOLChamp>>> = flow {
        try {
            emit(Result.Success(riotRepository.getLOLChamp().data.values.toList()))
        } catch (e: Exception) {
            Log.d("결과", "e : ${e.message}")
        }
    }

}