package com.hfad.guessinggame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    val words = listOf("Android", "Activity", "Fragment")
    val secretWord = words.random().uppercase()
    val _secretWordDisplay = MutableLiveData<String>()
    val secretWordDisplay:LiveData<String> get() =_secretWordDisplay
    var correctGuesses = ""
    val _incorrectGuesses = MutableLiveData<String>("")
    val incorrectGuesses:LiveData<String> get() = _incorrectGuesses
    val _livesLeft = MutableLiveData<Int>(8)
    val livesLeft:LiveData<Int> get()=_livesLeft
    val _gameOver= MutableLiveData<Boolean>(false)
    val gameOver:LiveData<Boolean> get() = _gameOver
    init {
        _secretWordDisplay.value = deriveSecretWordDisplay()
    }

    fun deriveSecretWordDisplay() : String {
        var display = ""
        secretWord.forEach {
            display += checkLetter(it.toString())
        }
        return display
    }

    fun checkLetter(str: String) = when (correctGuesses.contains(str)) {
        true -> str
        false -> "_"
    }

    fun makeGuess(guess: String) {
        if (guess.length == 1) {
            if (secretWord.contains(guess)) {
                correctGuesses += guess
                _secretWordDisplay.value = deriveSecretWordDisplay()
            } else {
                _incorrectGuesses.value+= "$guess "
                _livesLeft.value=livesLeft.value?.dec()
            }
        }
        if( isWon() || isLost()) _gameOver.value=true
    }

    fun isWon() = secretWord.equals(secretWordDisplay.value, true)

    fun isLost() = (livesLeft.value ?: 0) <= 0

    fun wonLostMessage() : String {
        var message = ""
        if (isWon()) message = "You won!"
        else if (isLost()) message = "You lost!"
        message += "\nThe word was $secretWord."
        return message
    }
}