package com.ak.ajitkumartask.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.ak.ajitkumartask.Model.Contacts

@Dao
interface DBDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE )
    fun insertContact(contact : Contacts)

    @Update
    fun update(contact: Contacts)
}