package com.ak.ajitkumartask.Viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Model.US
import com.ak.ajitkumartask.Model.User
import com.ak.ajitkumartask.Repo.ContactRepository
import com.ak.ajitkumartask.Repo.RetrofitClient
import com.ak.ajitkumartask.Room.ContactDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val repository : ContactRepository
    private val contact_=MutableLiveData<List<User>>()
    val contact:LiveData<List<User>>get() = contact_
    init {
        val dao = ContactDatabase.getdatabase(application).contdao()
        repository = ContactRepository(dao,RetrofitClient.apiService)
    }
    fun getContacts(){
        viewModelScope.launch(Dispatchers.IO){
            val respones=repository.fetchData()
            contact_.postValue(respones)
        }
    }
    fun updateContact(id: String?, contact: US) {
        viewModelScope.launch(Dispatchers.IO) {
            if (id != null) {
                repository.updateContact(id, contact)
            }
        }
    }

    fun addContacts(contact : Contacts){
        repository.insaert(contact)
    }
    fun addContact(name: String, email: String, mobile: String, gender: String) {
        val contact = Contacts(null, name, email, mobile, gender)
        CoroutineScope(Dispatchers.IO).launch {
            repository.addcontacts(contact)
        }
    }

    fun updatecon(contact: Contacts){
        repository.update(contact)
    }

}
