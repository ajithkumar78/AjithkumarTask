package com.ak.ajitkumartask.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ak.ajitkumartask.Model.Contacts

@Database(entities = [Contacts::class], version = 1, exportSchema = false)

abstract class ContactDatabase :RoomDatabase() {
abstract fun contdao():DBDAO
companion object{
    @Volatile
    var instance: ContactDatabase?=null
    fun getdatabase(context: Context):ContactDatabase{
        val tambinst= instance
        if (tambinst!=null){
            return tambinst
        }
synchronized(this){
    val roomdb= Room.databaseBuilder(context, ContactDatabase::class.java,"ajith").allowMainThreadQueries().build()
    instance =roomdb
    return roomdb
}
    }
}
}