package com.example.pass3a

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SavedDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved_data)

        val prefs = getSharedPreferences("saved_data", MODE_PRIVATE)

        val country = prefs.getString("country", "No country clicked yet")
        val code = prefs.getString("code", "")
        val gold = prefs.getInt("gold", 0)
        val silver = prefs.getInt("silver", 0)
        val bronze = prefs.getInt("bronze", 0)
        val total = prefs.getInt("total", 0)

        val savedText = findViewById<TextView>(R.id.savedText)

        savedText.text =
            "Last clicked country:\n\n$country\n\nIOC Code: $code\nGold: $gold\nSilver: $silver\nBronze: $bronze\nTotal medals: $total"
    }
}