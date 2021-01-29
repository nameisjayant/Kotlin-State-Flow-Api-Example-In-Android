package com.example.stateflowexample

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel : ViewModel() {

    private val _counterState:MutableStateFlow<Int> = MutableStateFlow(0)
    val counterState = _counterState

    fun incrementCount()
    {
        _counterState.value++
    }

    fun decrementCount()
    {
        _counterState.value--
    }
}