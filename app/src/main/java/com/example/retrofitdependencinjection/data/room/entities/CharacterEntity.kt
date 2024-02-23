package com.example.retrofitdependencinjection.data.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterEntity(
    val actor: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val image: String,
    val name: String,

    )