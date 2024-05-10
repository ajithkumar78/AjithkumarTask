package com.ak.ajitkumartask.Service

import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Model.US
import com.ak.ajitkumartask.Model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    @POST("ajithkumar")
    suspend fun addcont(@Body contacts: Contacts): Contacts

    @GET("ajithkumar")
    suspend fun getlist():List<User>
    @PUT("ajithkumar/{id}")
    suspend fun updateContact(@Path("id") id: String, @Body contact: US): User

}