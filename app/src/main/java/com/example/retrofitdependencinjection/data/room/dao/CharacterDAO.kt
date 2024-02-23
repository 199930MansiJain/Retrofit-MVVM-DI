package com.example.retrofitdependencinjection.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.retrofitdependencinjection.data.room.entities.CharacterEntity
import org.w3c.dom.CharacterData
import java.util.concurrent.Flow

@Dao
interface CharacterDAO {

 /*   @Insert
    suspend fun insertCharacters(characterData: List<CharacterEntity>)

    @Query("SELECT * FROM insertCharacters WHERE id =:id ORDER BY sortOrder")
    fun  getCharactersById(id: String) : Flow<List<CharacterEntity>?>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCharacters(dynamicDataEntity: List<CharacterData>?)

    @Query("SELECT * FROM CharacterData WHERE id = 1")
    fun  getCharactersById(id: String) : Flow<List<CharacterEntity>?>


}