package com.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MainCoroutineRule: TestWatcher() {

    //Custom Rule - Testing a function which executes coroutine on Main Thread

    val testDispatecher = StandardTestDispatcher()
    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatecher)
    }
    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}