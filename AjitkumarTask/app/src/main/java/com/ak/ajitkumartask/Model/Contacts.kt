package com.ak.ajitkumartask.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "userAjith")
class Contacts(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String,
    var number: String,
    var email: String,
    var gender: String
):Serializable