package com.example.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Util(val dispatcher : CoroutineDispatcher) {
    //CASE 1

    suspend fun getUser():String{
        delay(10000)
        return "Kashish Kataria"
    }
    //CASE 2

    suspend fun getUserMain(): String{ //a function which runs on Main Thread
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "Kashish Kataria"
    }

    //CASE 3
    suspend fun getUserIO(): String{ //a function which runs on Main Thread
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "Kashish Kataria"
    }

    //A scenario where value of a variable is changed within a coroutine

    var globalArg= false
    suspend fun setGlobalArg(){
        CoroutineScope(dispatcher).launch {
            globalArg= true
        }
    }

}