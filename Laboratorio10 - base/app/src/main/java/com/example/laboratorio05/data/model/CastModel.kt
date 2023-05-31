package com.example.laboratorio05.data.model

import androidx.room.Entity

@Entity(tableName = "cast_table", primaryKeys = ["movieId", "actorId"])
data class CastModel (
    val movieId: Int,
    val actorId: Long
)