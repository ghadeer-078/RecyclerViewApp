package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var clRoot: ConstraintLayout
    private lateinit var messageField: EditText
    private lateinit var submitButton: Button

    var messages = arrayListOf<String>()

    private lateinit var rvMain: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clRoot = findViewById(R.id.clRoot)
        messageField = findViewById(R.id.etMessage)
        submitButton = findViewById(R.id.btSubmit)
        submitButton.setOnClickListener { addMessage() }

        rvMain = findViewById(R.id.rvMain)
        rvMain.adapter = RecyclerViewAdapter(messages)
        rvMain.layoutManager = LinearLayoutManager(this)
    }

    private fun addMessage(){
        val msg = messageField.text.toString()
        if(msg.isNotEmpty()){
            messages.add(msg)
            messageField.text.clear()
            messageField.clearFocus()
            rvMain.adapter!!.notifyDataSetChanged()
        }else{
            Snackbar.make(clRoot, "Please enter some text", Snackbar.LENGTH_LONG).show()
        }
    }
}