package com.wmp.calculaor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.wmp.calculaor.Utils.MADSCalculation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),View.OnClickListener {

    companion object{
        public var history = arrayListOf<HistoryData>()

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        buttonAdd.setOnClickListener(this)
        buttonSubtraction.setOnClickListener(this)
        buttonMultiply.setOnClickListener(this)
        buttonEqual.setOnClickListener(this)
        buttonDivide.setOnClickListener(this)
        buttonPoint.setOnClickListener(this)
        buttonZero.setOnClickListener(this)
        buttonBack.setOnClickListener(this)
        buttonHistory.setOnClickListener(this)
        buttonclear.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button1->{
                evaluateExpression("1", true)
            }
            R.id.button2->{
                evaluateExpression("2", true)
            }
            R.id.button3->{
                evaluateExpression("3", true)
            }
            R.id.button4->{
                evaluateExpression("4", true)
            }
            R.id.button5->{
                evaluateExpression("5", true)
            }
            R.id.button6->{
                evaluateExpression("6", true)
            }
            R.id.button7->{
                evaluateExpression("7", true)
            }
            R.id.button8->{
                evaluateExpression("8", true)
            }
            R.id.button9->{
                evaluateExpression("9", true)
            }
            R.id.buttonZero->{
                evaluateExpression("0", true)
            }
            R.id.buttonAdd->{
                evaluateExpression("+", true)
            }
            R.id.buttonDivide->{
                evaluateExpression("/", true)
            }
            R.id.buttonEqual->{
                try {
                 val result =  MADSCalculation(textView1.text.toString())
                    textResult.text = result.toString()
                    saveToPref(textView1.text.toString(),result)
                }catch (e:Exception){
                    Log.d("Exception"," message : " + e.message )
                }
            }
            R.id.buttonMultiply->{
                evaluateExpression("*", true)
            }
            R.id.buttonSubtraction->{
                evaluateExpression("-", true)
            }
            R.id.buttonPoint->{
                evaluateExpression(".", true)
            }
            R.id.buttonBack->{
                val text = textView1.text.toString()
                if(text.isNotEmpty()) {
                    textView1.text = text.substring(0,textView1.text.length-1)
                }
                textResult.text = ""
            }
            R.id.buttonclear->{
                textView1.text=""
                textResult.text=""
            }
            R.id.buttonHistory->{
                startActivity(Intent(this,HistoryActivity()::class.java).putExtra("List",history))
            }
        }
    }

    private fun saveToPref(toString: String, result: Double) {
        if (history.size<=10) {
            val historyData = HistoryData()
            historyData.value = toString
            historyData.result = result.toString()
            history.add(historyData)
        }
    }


    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            textResult.text = ""
            textView1.append(string)
        } else {
            textView1.append(textResult.text)
            textView1.append(string)
            textResult.text = ""
        }
    }
}