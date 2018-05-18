package com.ianmunene.higherorlower

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNum = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignRandomNumber()
        createListenerForButton()
    }

    private fun generateRandomNumber(): Int{
        var random = Random()
        var min = 1
        var max = 10
        randomNum = random.nextInt(max + 1 - min) + min

        return randomNum
    }

    private fun assignRandomNumber() {
        randomNum = generateRandomNumber()
    }

    private fun guessNumber() {
        var numberToGuess = randomNum
        var userGuess: Int = Integer.parseInt(numGuess.getText().toString())

        checkUserGuess(userGuess, numberToGuess)
        tvCompGuess.setText(getString(R.string.empty_text))
        var tvString = getString(R.string.computer_guessed, numberToGuess.toString())
        tvCompGuess.setText(tvString)
    }

    private fun checkUserGuess(userGuess: Int, numberToGuess: Int) {
        if (userGuess > numberToGuess) {
            tvFeedback.setText("Lower")
        } else if (userGuess < numberToGuess) {
            tvFeedback.setText("Higher")
        } else {
            tvFeedback.setText("Correct!")
        }
    }

    private fun createListenerForButton() {
        btnGuess.setOnClickListener{
            if(numGuess.getText().toString().equals("")) {
                toast("Please enter a number")
            } else {
                assignRandomNumber()
                guessNumber()
            }
        }
    }
}
