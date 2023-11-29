package com.example.cll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private var currentInput:String=""
    private var currentOperator:String=""
    private var operand1:Double=0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText=findViewById(R.id.editText)

        val buttonIds= listOf(R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9)


        for (buttonId in buttonIds){
            findViewById<Button>(buttonId).setOnClickListener {
                onDigitClick(it)
            }
        }
        findViewById<Button>(R.id.btnadd).setOnClickListener {
            onOperatorClick(it)
        }

        findViewById<Button>(R.id.btnsub).setOnClickListener {
            onOperatorClick(it)
        }

        findViewById<Button>(R.id.btnmul).setOnClickListener {
            onOperatorClick(it)
        }

        findViewById<Button>(R.id.btnDivide).setOnClickListener {
            onOperatorClick(it)
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            onEqualsClick(it)
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            onClearClick(it)
        }
    }
    private fun onDigitClick(view: View){
        val digit=(view as Button).text.toString()
        currentInput+=digit
        editText.setText(currentInput)

    }
    private fun onOperatorClick(view: View) {
        currentOperator = (view as Button).text.toString()
        operand1 = currentInput.toDouble()
        currentInput = ""
    }
    private fun onEqualsClick(view: View) {
        val operand2 = currentInput.toDouble()
        var result = 0.0

        when (currentOperator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> result = operand1 / operand2
        }

        currentInput = result.toString()
        editText.setText(currentInput)
        currentOperator = ""
    }
    private fun onClearClick(view: View) {
        currentInput = ""
        currentOperator = ""
        operand1 = 0.0
        editText.setText("0")
    }
}