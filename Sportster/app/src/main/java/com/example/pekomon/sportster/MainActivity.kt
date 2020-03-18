package com.example.pekomon.sportster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


/**
 * First simple excercise. Hooray \,,/
 */
class MainActivity : AppCompatActivity() {

    val allSportsList = arrayListOf("Biking", "Hiking", "Gym")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportNameTextView.text = allSportsList[0]

        randomizeButton.setOnClickListener {
            val rand = Random()
            val index = rand.nextInt(allSportsList.count())
            sportNameTextView.text = allSportsList[index].toString()

        }

        addNewButton.setOnClickListener {
            val newSport = newSportEditText.text.toString();
            if (TextUtils.isEmpty(newSport)) {
                return@setOnClickListener
            }
            allSportsList.add(newSport);
            newSportEditText.text.clear()

        }
    }
}
