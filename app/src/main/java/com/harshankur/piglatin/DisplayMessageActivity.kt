package com.harshankur.piglatin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        var response = message

        if (response!!.length != 0) {
            var messageWords = response.split(" ")
            response = ""
            for (word in messageWords) {
                response += word.slice(1 until word.length)
                    .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } + word[0].lowercaseChar() + "ay "
            }
        }
        else {
            response = "Ntereay Omethingsay Udeday!"
        }

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = response
        }
    }
}