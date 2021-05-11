package ni.desmov.dogapiapp.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ni.desmov.dogapiapp.retrofit.DogRetrofit
import ni.desmov.dogapiapp.retrofit.NetworkMapper
import ni.desmov.dogapiapp.room.CacheMapper
import ni.desmov.dogapiapp.room.DogDao
import ni.desmov.dogapiapp.utils.DataState

class DogRepository constructor(
    private val dogDao: DogDao,
    private val dogRetrofit: DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getCats(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(1000)
        try {
            val catData = dogRetrofit.get()
            val catMap = networkMapper.mapFromEntityList(catData)
            for (tempCat in catMap){
                dogDao.insert(cacheMapper.mapToEntity(tempCat))
            }
            val cacheCat = dogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}