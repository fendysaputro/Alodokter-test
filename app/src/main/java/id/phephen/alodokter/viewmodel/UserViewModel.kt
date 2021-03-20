package id.phephen.alodokter.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import id.phephen.alodokter.model.User
import id.phephen.alodokter.repository.UserRepository

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
class UserViewModel : ViewModel() {

    var liveDataUser: LiveData<User>? = null

    fun insertData(context: Context, name: String, email: String, password: String, phone: String) {
        UserRepository.insertData(context, name, email, password, phone)
    }

    fun getUserDetails(context: Context, email: String) : LiveData<User>? {
        liveDataUser = UserRepository.getLoginDetails(context, email)
        return liveDataUser
    }
}