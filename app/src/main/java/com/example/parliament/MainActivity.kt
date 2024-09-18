package com.example.parliament

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    private lateinit var mpImageView: ImageView
    private lateinit var mpNameTextView: TextView
    private lateinit var mpPartyTextView: TextView
    private lateinit var mpSeatNumberTextView: TextView
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mpImageView = findViewById(R.id.mpImageView)
        mpNameTextView = findViewById(R.id.mpNameTextView)
        mpPartyTextView = findViewById(R.id.mpPartyTextView)
        mpSeatNumberTextView = findViewById(R.id.mpSeatNumberTextView)
        nextButton = findViewById(R.id.nextButton)

        showRandomMP()

        nextButton.setOnClickListener {
            showRandomMP()
        }
    }

    private fun showRandomMP() {
        val randomMP = ParliamentMembersData.members[Random.nextInt(ParliamentMembersData.members.size)]

        mpNameTextView.text = "${randomMP.firstname} ${randomMP.lastname}"
        mpPartyTextView.text = randomMP.party.uppercase()
        mpSeatNumberTextView.text = "${randomMP.seatNumber}"

        mpImageView.setImageResource(R.drawable.placeholder_mp)
    }
}
