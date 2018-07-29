package com.renatoarg.androidjetpack_viewmodelexample

import android.arch.lifecycle.ViewModelProviders
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class MainViewModelUnitTest {

    @Test
    fun testUpdateScoreTeamA() {
        var vm = getMainViewModel()
        vm.updateScoreTeamA()
        assertEquals(1, vm.scoreTeamA.value)
    }

    @Test
    fun testUpdateScoreTeamB() {
        var vm = getMainViewModel()
        vm.updateScoreTeamB()
        assertEquals(1, vm.scoreTeamB.value)
    }

    @Test
    fun testReset() {
        var vm = getMainViewModel()
        vm.updateScoreTeamA()
        vm.updateScoreTeamB()
        vm.reset()
        assertEquals(0, vm.scoreTeamA.value)
        assertEquals(0, vm.scoreTeamB.value)
    }

    fun getMainViewModel() : MainViewModel {
        return ViewModelProviders.of(Robolectric.setupActivity(MainActivity::class.java)).get(MainViewModel::class.java)
    }
}
