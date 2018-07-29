package com.renatoarg.androidjetpack_viewmodelexample

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    // create the variables that will be observed
    var scoreTeamA = MutableLiveData<Int>().apply { value = 0 }
    var scoreTeamB = MutableLiveData<Int>().apply { value = 0 }

    fun updateScoreTeamA() {
        updateScore(scoreTeamA)
    }

    fun updateScoreTeamB() {
        updateScore(scoreTeamB)
    }

    private fun updateScore(score: MutableLiveData<Int>) {
        var value = score.value ?: 0
        score.value = value + 1
    }

    fun reset() {
        scoreTeamA.value = 0;
        scoreTeamB.value = 0;
    }
}