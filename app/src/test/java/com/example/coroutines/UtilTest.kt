package com.example.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class UtilTest {

@get:Rule
 val mainCoroutineRule = MainCoroutineRule()
//val testDispatecher = StandardTestDispatcher()

//    @Before
//    fun setup(){
//        Dispatchers.setMain(testDispatecher)
//    }

    //CASE 1

//    @Test
//    fun testGetUser() {//testing delay()
//        val sut= Util()
//        runTest {
//            sut.getUser()
//        }
//    }

    //CASE 2

//    @Test
//    fun testGetUserMain() { //Testing function which runs on Main Thread
//        val sut= Util()
//        runTest {
//            sut.getUserMain()
//        }
//    }

    //CASE 3

//@Test
//    fun testGetUserMain() {
//        val sut= Util(testDispatecher)
//        runTest {
//            sut.getUserIO()
//        }
//    }

//    @After
//    fun tearDown(){
//        Dispatchers.resetMain()
//    }

    //Custom Rule - Testing a function which executes coroutine on Main Thread

//    @Test
//    fun testGetUserM() { //Testing function which runs on Main Thread
//        val sut= Util(mainCoroutineRule.testDispatecher)
//        runTest {
//            sut.getUserMain()
//        }
//    }

    //a scenario where we need to wait for all the coroutine to get completed before putting Assert statement.
    @Test
    fun testSetGlobalArg(){
        val sut = Util(mainCoroutineRule.testDispatecher)
        runTest {
            sut.setGlobalArg()
            mainCoroutineRule.testDispatecher.scheduler.advanceUntilIdle() //it'll  make sure that all the coroutine running on testDispatcher thread are completed
            Assert.assertEquals(true, sut.globalArg)
        }
    }

}