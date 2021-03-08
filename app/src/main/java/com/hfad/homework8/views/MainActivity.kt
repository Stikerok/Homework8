package com.hfad.homework8.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.hfad.homework8.R
import com.hfad.homework8.viewModel.MyViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = MyViewModel(this)
        viewModel.message.observeForever {
            findViewById<TextView>(R.id.text_error).text = it
        }
        viewModel.getTime()
        findViewById<Button>(R.id.button_send).setOnClickListener {
            viewModel.getPin(findViewById<EditText>(R.id.editTextNumberPassword).text.toString())
        }
    }
}