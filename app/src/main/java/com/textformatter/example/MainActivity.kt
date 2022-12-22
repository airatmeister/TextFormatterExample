package com.textformatter.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import ru.touchin.roboswag.textprocessing.TextFormatter

class MainActivity : AppCompatActivity() {

    private val textFormatter = TextFormatter(
        regex = "(\\d{2})\\/?(\\d{2})"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText1 = findViewById<EditText>(R.id.editText1)

        val buttonEditTextOne = findViewById<Button>(R.id.buttonEditTextOne)

        val textViewInfoOne = findViewById<TextView>(R.id.textViewInfoOne)
        textViewInfoOne.text = textFormatter.getRegexReplace()

        val textViewInfoTwo = findViewById<TextView>(R.id.textViewInfoTwo)

        buttonEditTextOne.setOnClickListener {
            val inputText = editText1.text.toString()
            if (inputText.isNotEmpty()) {
                textViewInfoTwo.text = textFormatter.getFormattedText(inputText)
            }
        }

        val editText2 = findViewById<EditText>(R.id.editText2)
        editText2.hint = textFormatter.getPlaceholder()

        textFormatter.mask(editText2)
    }
}