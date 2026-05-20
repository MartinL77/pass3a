package com.example.pass3a

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var medallists: List<Medallist>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.medallistRecyclerView)

        medallists = CsvReader.readMedallists(this)

        Toast.makeText(
            this,
            "Rows loaded: ${medallists.size}",
            Toast.LENGTH_LONG
        ).show()

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = MedallistAdapter(medallists) { selectedMedallist ->
            saveLastClicked(selectedMedallist)

            MedallistBottomSheet.newInstance(selectedMedallist)
                .show(supportFragmentManager, "MedallistBottomSheet")
        }
    }

    private fun saveLastClicked(medallist: Medallist) {
        val prefs = getSharedPreferences("saved_data", MODE_PRIVATE)

        prefs.edit()
            .putString("country", medallist.country)
            .putString("code", medallist.code)
            .putInt("gold", medallist.gold)
            .putInt("silver", medallist.silver)
            .putInt("bronze", medallist.bronze)
            .putInt("total", medallist.totalMedals)
            .apply()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_saved_data -> {
                startActivity(Intent(this, SavedDataActivity::class.java))
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}