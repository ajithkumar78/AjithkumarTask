package com.ak.ajitkumartask.Repo

import com.ak.ajitkumartask.Service.ApiService
import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Model.US
import com.ak.ajitkumartask.Model.User
import com.ak.ajitkumartask.Room.DBDAO

class ContactRepository(val dao:DBDAO,private val apiService: ApiService) {
    fun insaert(contacts: Contacts){
        dao.insertContact(contacts)
    }
    fun update(contacts: Contacts){
        dao.update(contacts)

    }
    suspend fun updateContact(id: String, contact: US) {
        apiService.updateContact(id, contact)
    }
    suspend fun addcontacts(contacts: Contacts){
        apiService.addcont(contacts)
    }
    suspend fun fetchData(): List<User> {
        return apiService.getlist()
    }
}