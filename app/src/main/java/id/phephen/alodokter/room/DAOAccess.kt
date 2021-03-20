package id.phephen.alodokter.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import id.phephen.alodokter.model.User

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
@Dao
interface DAOAccess {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(userModel: User)

    @Query("SELECT * FROM User WHERE email =:email")
    fun getLoginDetails(email: String?) : LiveData<User>
}