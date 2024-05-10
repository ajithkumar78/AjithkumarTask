package com.ak.ajitkumartask.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.ak.ajitkumartask.Model.Contacts
import com.ak.ajitkumartask.Model.User
import com.ak.ajitkumartask.databinding.ListItemBinding

class ContactsAdapter(private var contacts: List<User>, private  val editClickListener:(User)->Unit):RecyclerView.Adapter<ContactsAdapter.ContViewHolder>() {
    class ContViewHolder (val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(contacts: User) {
            binding.nameTextView.text=contacts.name
            binding.mobileTextView.text=contacts.number
            binding.genderTextView.text=contacts.gender
            binding.emailTextView.text=contacts.email


        }

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactsAdapter.ContViewHolder {
    val  binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ContViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactsAdapter.ContViewHolder, position: Int) {
        val contacts=contacts[position]
        holder.bind(contacts)
        holder.itemView.setOnClickListener { editClickListener(contacts) }
    }
    fun updateData(newContacts: List<User>) {
        contacts = newContacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
      return contacts.size
    }
}