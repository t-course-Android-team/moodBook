package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase



    @Database(
        entities = [WatchedMoviesEntity::class],
        version = 1,
        exportSchema = false
    )
    abstract class WatchedMoviesDataBase : RoomDatabase() {
        abstract  fun watchedMoviesDao(): WatchedMoviesDao
        companion object{
            fun getWatchedDataBase(context: Context): WatchedMoviesDataBase{
                return Room.databaseBuilder(
                    context.applicationContext, WatchedMoviesDataBase::class.java, "watched_movies.db"
                ).fallbackToDestructiveMigration().build()
            }
        }
    }