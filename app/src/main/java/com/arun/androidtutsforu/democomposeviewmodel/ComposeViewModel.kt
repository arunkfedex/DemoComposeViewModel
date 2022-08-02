package com.arun.androidtutsforu.democomposeviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ComposeViewModel : ViewModel() {

    private val _firstNum = mutableStateOf("")
    val firstNum :String
    get() = _firstNum.value
    private val _secondNum = mutableStateOf("")
    val secondNum :String
        get() = _secondNum.value

    private var _sum = mutableStateOf(0)
    val sum:Int
      get() =_sum.value

    fun changeFirstNum(number: String){
        _firstNum.value = number
    }
    fun changeSecondNum(number: String){
        _secondNum.value = number
    }
   fun valuculate() {
       val num1 = firstNum.toIntOrNull()?:0
       val num2 = secondNum.toIntOrNull()?:0
       _sum.value = num1 + num2
   }
}