package com.example.braindump

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var editText:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        viewModel = (application as BrainDumpApp).viewModel
        editText = findViewById(R.id.editText)

        val observable = Observable.Base(object : TextCallback {
            override fun updateText(text: String) {
                editText.setText(text)
            }
        })
        viewModel.init(observable)

        buttonClear.setOnClickListener {
            viewModel.clearData()
            editText.setText("")
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getData()
    }

    override fun onPause() {
        super.onPause()
        viewModel.saveData(editText.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.clear()
    }
}