package com.renatoarg.androidjetpack_viewmodelexample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // creates reference to MainViewModel
    private val mainViewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sets click listeners to buttons that executes methods on MainViewModel
        btnScoreTeamA.setOnClickListener( {mainViewModel.updateScoreTeamA()} )
        btnScoreTeamB.setOnClickListener( {mainViewModel.updateScoreTeamB()} )
        btnReset.setOnClickListener( {mainViewModel.reset()} )

        // observes the variables in MainViewModel and update the textViews
        mainViewModel.scoreTeamA.observe(this, Observer{ value -> tvScoreTeamA.text = value.toString()})
        mainViewModel.scoreTeamB.observe(this, Observer{ value -> tvScoreTeamB.text = value.toString()})
    }
}
