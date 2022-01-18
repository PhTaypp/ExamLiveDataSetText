package com.example.examlivedatasettext.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examlivedatasettext.model.Text

class SetTextViewModel : ViewModel() {
    private lateinit var textEntity1: Text
    private val textMutableLiveData1: MutableLiveData<Text> = MutableLiveData<Text>()
    private lateinit var textEntity2: Text
    private val textMutableLiveData2: MutableLiveData<Text> = MutableLiveData<Text>()

    fun setText1(text1: String){
        textEntity1 = Text(text1)
        textMutableLiveData1.value = textEntity1
    }
    fun setText2(text2: String) {
        textEntity2 = Text(text2)
        textMutableLiveData2.value = textEntity2
    }
    fun getText1MutableLiveData(): MutableLiveData<Text> {
        return textMutableLiveData1
    }

    fun getText2MutableLiveData(): MutableLiveData<Text> {
        return textMutableLiveData2
    }

}