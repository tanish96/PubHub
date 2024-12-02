package com.example.pubhub

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.pubhub.activities.PubDataActivity
import com.example.pubhub.activities.PubSavedDataView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        /* this activity is for insert data   */
        val pubact = findViewById<ImageView>(R.id.pet_info)
        pubact.setOnClickListener {
            val i = Intent(this, PubDataActivity::class.java)
            startActivity(i)
        }
        /* this is activity is for after data insertion data will save here */
        val pubdatasaved = findViewById<ImageView>(R.id.pet)
        pubdatasaved.setOnClickListener{
            val intent= Intent(this,PubSavedDataView::class.java)
            startActivity(intent)
        }

    }
}
