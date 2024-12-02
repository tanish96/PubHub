package com.example.pubhub.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val dob: String,
    val description: String,
    val profileImageUri: String
)

