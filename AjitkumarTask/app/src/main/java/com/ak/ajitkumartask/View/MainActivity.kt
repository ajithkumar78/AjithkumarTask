package com.ak.ajitkumartask.View

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ak.ajitkumartask.Adapter.ContactsAdapter
import com.ak.ajitkumartask.R
import com.ak.ajitkumartask.Viewmodel.ContactViewModel
import com.ak.ajitkumartask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val viewmodel: ContactViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.map.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, Add_contact::class.java)
            startActivity(intent)
        }


        val adapter = ContactsAdapter(emptyList()) { contact ->
            val intent = Intent(this@MainActivity, EditContactActivity::class.java)
            intent.putExtra("contact", contact)
            startActivity(intent)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        viewmodel.getContacts()
        viewmodel.contact.observe(this) { cont ->
            adapter.updateData(cont)
        }

    }
}