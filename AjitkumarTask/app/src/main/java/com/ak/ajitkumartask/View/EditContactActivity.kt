package com.ak.ajitkumartask.View

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Model.US
import com.ak.ajitkumartask.Model.User
import com.ak.ajitkumartask.Viewmodel.ContactViewModel
import com.ak.ajitkumartask.databinding.ActivityEditContactBinding
import retrofit2.HttpException

class EditContactActivity : AppCompatActivity() {
    private lateinit var binding:ActivityEditContactBinding
    val viewmodel:ContactViewModel by viewModels()
    private lateinit var contact: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactExtra = intent.getSerializableExtra("contact")
        if (contactExtra != null && contactExtra is User) {
            contact = contactExtra
            binding.nameEditText.setText(contact.name)
            binding.mobileEditText.setText(contact.number)
            binding.genderEditText.setText(contact.gender)
            binding.emailEditText.setText(contact.email)
            Log.i("TAG", "onCreate: ----> Contact ID: ${contact._id}")
            Log.i("TAG", "onCreate: ----> Contact: $contact") // Log the entire contact object
        } else {
            finish()
        }

        Log.i("TAG", "ID before OnClickListener: ${contact._id}")

        binding.submitButton.setOnClickListener {
            val updatedName = binding.nameEditText.text.toString()
            val updatedMobile = binding.mobileEditText.text.toString()
            val updatedGender = binding.genderEditText.text.toString()
            val updatedEmail = binding.emailEditText.text.toString()

            val updatedContact = US(

                updatedName,
                updatedEmail,
                updatedMobile,
                updatedGender
            )
            Log.i("TAG", "Updated Contact: $updatedContact")

            val id = contact._id
            Log.i("TAG", "ID in OnClickListener: $id") // Log the ID here

            if (id != null ) {
                try {
                    viewmodel.updateContact(id.toString(), updatedContact)
//                    viewmodel.updatecon(updatedContact)
                } catch (e: HttpException) {
                    Log.e("API Error", "HTTP error: ${e.message()}")
                }
            } else {
                Log.e("ID Error", "Contact ID is empty or null")
            }
        }
    }
    }