package id.phephen.alodokter.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
@Entity(tableName = "User")
data class User(
    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "password")
    var password: String,

    @ColumnInfo(name = "phone")
    var phone: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}
