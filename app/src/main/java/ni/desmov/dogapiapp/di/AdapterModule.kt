package ni.desmov.dogapiapp.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import ni.desmov.dogapiapp.utils.AdapterDogs
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterDogs {
        return AdapterDogs()
    }
}