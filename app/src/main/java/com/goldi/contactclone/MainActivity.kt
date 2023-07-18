package com.goldi.contactclone

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editName: EditText
    private lateinit var editPhoneNumber: EditText
    private lateinit var btnAddContact: Button
    private lateinit var contactList: ListView
    private lateinit var adapter: ArrayAdapter<String>
    private val contacts = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editName = findViewById(R.id.editName)
        editPhoneNumber = findViewById(R.id.editPhoneNumber)
        btnAddContact = findViewById(R.id.btnAddContact)
        contactList = findViewById(R.id.contactList)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contacts)
        contactList.adapter = adapter

        btnAddContact.setOnClickListener {
            val name = editName.text.toString()
            val phoneNumber = editPhoneNumber.text.toString()
            val contact = "$name - $phoneNumber"
            contacts.add(contact)
            adapter.notifyDataSetChanged()
            clearFields()
        }
    }

    private fun clearFields() {
        editName.text.clear()
        editPhoneNumber.text.clear()
    }
}
