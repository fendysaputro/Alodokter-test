package id.phephen.alodokter.repository

import android.content.Context
import androidx.lifecycle.LiveData
import id.phephen.alodokter.model.User
import id.phephen.alodokter.room.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
class UserRepository {
    companion object {

        var userDatabase: UserDatabase? = null

        var userModel: LiveData<User>? = null

        private fun initializeDB(context: Context) : UserDatabase {
            return UserDatabase.getDataseClient(context)
        }

        fun insertData(context: Context, name: String, email: String, password: String, phone: String) {

            userDatabase = initializeDB(context)

            CoroutineScope(IO).launch {
                val userDetails = User(name, email, password, phone)
                userDatabase!!.userDao().insertData(userDetails)
            }

        }

        fun getLoginDetails(context: Context, email: String) : LiveData<User>? {

            userDatabase = initializeDB(context)

            userModel = userDatabase!!.userDao().getLoginDetails(email)

            return userModel
        }

    }
}