package org.scesi.cappuchino.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CareerDao {

    @Query("SELECT * FROM Career")
    fun getAll(): Flow<List<Career>>

    @Query("SELECT * FROM Career WHERE code = :id")
    fun getById(id: Int): Flow<Career>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCareers(careers: List<Career>)

}