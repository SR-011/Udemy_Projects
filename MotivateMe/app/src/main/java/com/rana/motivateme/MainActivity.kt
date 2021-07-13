package com.rana.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var name:EditText
    private lateinit var message: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val updateButton: Button = findViewById(R.id.main_activity_bt_update)
        updateButton.setOnClickListener {updateMessage()}
        //val name: EditText = findViewById(R.id.main_activity_et_name)
        name = findViewById(R.id.main_activity_et_name)
        message = findViewById(R.id.main_activity_tv_message)

    }
    //get a name from edittext and display personalised message
    private fun updateMessage(){
        // get the userName from edittext
        val userName = name.text
        // pick a random motivattional message from the list
        val motivationalMessages = listOf("Keep your head up!", "Die hard!", "Never give up!", "Keep working hard!",
            "Difficulties are growth!", "Be yourself!", "Be passionate!")
        val index = (0..6).random()
        val currentMessage = motivationalMessages[index]
        if (userName.toString()==""){
            message.text = "Please enter your name."
        }else
            message.text = "Hello $userName! $currentMessage"
        name.setText("")
        hideKeyboard()
    }
    //we can use Context class with a call to get system services
    // hide the keyboard using InputMethodManager
    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }
}