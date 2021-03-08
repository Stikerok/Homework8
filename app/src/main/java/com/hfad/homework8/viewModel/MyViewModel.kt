package com.hfad.homework8.viewModel

import android.content.Context
import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.homework8.model.Model

const val BEGIN_TIME = 10000L

class MyViewModel(context: Context) : ViewModel() {
    val message = MutableLiveData<String>()
    private val model = Model(context)
    fun getPin(pin: String) {
        if (model.pinIsTrue(pin) && model.getTime() == BEGIN_TIME) {
            message.postValue("True")
        } else {
            startCounter()
        }
    }

    fun getTime() {
        if (model.getTime() != BEGIN_TIME) {
            startCounter()
        }
    }

    private fun startCounter() {
        object : CountDownTimer(model.getTime(), 1000) {
            override fun onFinish() {
                message.postValue("print PIN")
                model.saveTime(BEGIN_TIME)
            }

            override fun onTick(millisUntilFinished: Long) {
                message.postValue("Left: ${millisUntilFinished / 1000}")
                model.saveTime(millisUntilFinished)
            }
        }.start()
    }
}