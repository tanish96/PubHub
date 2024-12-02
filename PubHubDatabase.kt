package com.example.pubhub.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class PubHubDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: PubHubDatabase? = null

        fun getDatabase(context: Context): PubHubDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PubHubDatabase::class.java,
                    "pubhub_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
