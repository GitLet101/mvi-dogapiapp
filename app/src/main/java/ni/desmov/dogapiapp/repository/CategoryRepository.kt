package ni.desmov.dogapiapp.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ni.desmov.dogapiapp.model.Dog
import ni.desmov.dogapiapp.retrofit.CategoryMapper
import ni.desmov.dogapiapp.retrofit.DogRetrofit
import ni.desmov.dogapiapp.retrofit.NetworkMapper
import ni.desmov.dogapiapp.room.CacheMapper
import ni.desmov.dogapiapp.room.DogDao
import ni.desmov.dogapiapp.utils.DataState

class CategoryRepository (
    private val dogDao: DogDao,
    private val dogRetrofit: DogRetrofit,
    private val cacheMapper: CacheMapper,
    private val categoryMapper: CategoryMapper
){
    suspend fun getCategories(): Flow<DataState> = flow {
        emit(DataState.Loading)
        delay(5000)
        try {
            val dogData = dogRetrofit.get_categories()
            val dogMap = categoryMapper.mapFromEntityList(dogData)

            val cacheCat = dogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheCat)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}