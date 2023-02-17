package com.yh.riot.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yh.riot.data.model.LOLChamp

@Database(
    entities = [LOLChamp::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(OrmConverter::class)
abstract class RiotDataBase : RoomDatabase() {

    abstract fun champDao(): ChampDao

}