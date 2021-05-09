package com.wmp.calculaor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.history_layout.*

class HistoryActivity() :AppCompatActivity() {
    var historyList= arrayListOf<HistoryData>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.history_layout)
        historyList=   MainActivity.history
        if (!historyList.isEmpty()) {
            historyList.forEach {
                history_text.append(it.value + "\n")
                history_text.append("=" + it.result + "\n\n\n")
            }
        }else{
            history_text.text="No History Available"
        }
    }

    }