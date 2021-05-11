package ni.desmov.dogapiapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(CategoryCacheEntity :CategoryCacheEntity): Long

    @Query("select * from Categories where id = :parametro")
    suspend fun select(parametro : Int): CategoryCacheEntity

    @Query("select * from Categories")
    suspend fun selectAll(): List<CategoryCacheEntity>
}