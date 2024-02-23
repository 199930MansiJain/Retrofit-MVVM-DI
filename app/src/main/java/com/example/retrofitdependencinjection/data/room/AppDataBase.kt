package com.example.retrofitdependencinjection.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofitdependencinjection.data.room.dao.CharacterDAO
import com.example.retrofitdependencinjection.data.room.entities.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val characterDao: CharacterDAO
}
