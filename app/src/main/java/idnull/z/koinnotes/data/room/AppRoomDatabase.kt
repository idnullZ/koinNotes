package idnull.z.koinnotes.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import idnull.z.koinnotes.domain.AppNote

@Database(entities = [AppNote::class],version = 1)
abstract class AppRoomDatabase:RoomDatabase()
{
    abstract val getAppRoomDao: AppRoomDao


    companion object{
        @Volatile
        private var database: AppRoomDatabase?=null
        @Synchronized
        fun getInstance(context: Context): AppRoomDatabase {
            return if (database ==null){
                database = Room.databaseBuilder(context.applicationContext,
                    AppRoomDatabase::class.java,"database").build()
                database as AppRoomDatabase
            } else database as AppRoomDatabase
        }

    }
}