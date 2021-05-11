package ni.desmov.dogapiapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ni.desmov.dogapiapp.room.DogDao
import ni.desmov.dogapiapp.room.DogDatabase
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideCatDb(@ApplicationContext context: Context): DogDatabase {
        return Room
            .databaseBuilder(context, DogDatabase::class.java, DogDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideCatDao(dogDatabase: DogDatabase): DogDao {
        return dogDatabase.catDao()
    }
}