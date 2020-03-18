package com.example.pekomon.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf("Chinese", "Burgers", "Pizza", "Hese", "Traditional")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideButton.setOnClickListener {
            println("heippati hei")
            val random = Random();
            val randomFood = random.nextInt(foodList.count())

            selectedFoodText.text = foodList[randomFood]
        }

        addFoodButton.setOnClickListener {
            val food = editText.text.toString()
            foodList.add(food);
            editText.text.clear()
        }
    }
}
