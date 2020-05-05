package com.minor.mvvm_clean_architecture.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.minor.mvvm_clean_architecture.data.local.entities.UserDBO

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userDBO: UserDBO)

    @Insert
    suspend fun insertUses(userDBOS: List<UserDBO>)

    @Query("SELECT * FROM UserDBO ORDER BY login ASC LIMIT 30")
    suspend fun getTopUsers(): List<UserDBO>
}