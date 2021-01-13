package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val dice = Dice(6)
        when (dice.roll()) {
            1 -> {
                binding.diceImage.setImageResource(R.drawable.dice_1)
            }
            2 -> {
                binding.diceImage.setImageResource(R.drawable.dice_2)
            }
            3 -> {
                binding.diceImage.setImageResource(R.drawable.dice_3)
            }
            4 -> {
                binding.diceImage.setImageResource(R.drawable.dice_4)
            }
            5 -> {
                binding.diceImage.setImageResource(R.drawable.dice_5)
            }
            6 -> {
                binding.diceImage.setImageResource(R.drawable.dice_6)
            }
        }
    }
}

class Dice(private val numSides: Int){
    fun roll(): Int{
        return (1..numSides).random()
    }
}