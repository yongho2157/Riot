package com.yh.riot.domain.usecase

import com.yh.riot.data.model.ChampInfo
import com.yh.riot.domain.repository.RiotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.yh.riot.Result
import javax.inject.Inject

class GetChampInfoUseCase @Inject constructor(private val riotRepository: RiotRepository) {
    operator fun invoke(champId: String): Flow<Result<List<ChampInfo>>> = flow {
        try {
            emit(Result.Success(riotRepository.getChampInfo(champId).data.values.toList()))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}