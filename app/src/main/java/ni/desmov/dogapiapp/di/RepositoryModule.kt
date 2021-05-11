package ni.desmov.dogapiapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import ni.desmov.dogapiapp.repository.DogRepository
import ni.desmov.dogapiapp.retrofit.DogRetrofit
import ni.desmov.dogapiapp.retrofit.NetworkMapper
import ni.desmov.dogapiapp.room.CacheMapper
import ni.desmov.dogapiapp.room.DogDao
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDogRepository(
        dogDao: DogDao,
        dogRetrofit: DogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): DogRepository {
        return DogRepository(dogDao, dogRetrofit, cacheMapper, networkMapper)
    }
}