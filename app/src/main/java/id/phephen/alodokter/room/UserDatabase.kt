package id.phephen.alodokter.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import id.phephen.alodokter.model.User

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */

@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao() : DAOAccess

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDataseClient(context: Context) : UserDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, UserDatabase::class.java, "USER_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }

    }
}