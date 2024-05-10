package com.ak.ajitkumartask.View

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Viewmodel.ContactViewModel
import com.ak.ajitkumartask.databinding.ActivityAddContactBinding

class Add_contact : AppCompatActivity() {
    private lateinit var binding: ActivityAddContactBinding
    private val viewmaodle:ContactViewModel by viewModels()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
createdb(it)
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val mobile = binding.mobileEditText.text.toString()
            val gender = binding.genderEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && mobile.isNotEmpty() && gender.isNotEmpty()) {
                viewmaodle.addContact(name,  mobile,email, gender)

                Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun createdb(it: View?) {
        val name=binding.nameEditText.text.toString()
        val phone=binding.mobileEditText.text.toString()
        val email=binding.emailEditText.text.toString()
        val ganer=binding.genderEditText.text.toString()
        val dates=Contacts(null, name, phone, email, ganer)
        viewmaodle.addContacts(dates)
        Log.i("TAG", "createdb: ---->"+dates)
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        startActivity(Intent(this, MainActivity::class.java))

    }
}