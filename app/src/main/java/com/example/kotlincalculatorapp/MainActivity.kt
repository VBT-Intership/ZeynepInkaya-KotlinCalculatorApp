package com.example.kotlincalculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        Buttons
         */
        var buttonList: ArrayList<Button> = arrayListOf()
        buttonList = arrayListOf(
            findViewById(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )
        for (button:Button in buttonList){
            val decimal : String = button.id.toString().substring(button.id.toString().length-1)
            button.setOnClickListener{
                proceedExpression(decimal,true)
            }

        }
        /*
        Operators
         */
        buttonAdd.setOnClickListener{
            proceedExpression("+",true)
        }
        buttonDiv.setOnClickListener{
            proceedExpression("/",true)
        }
        buttonSubtr.setOnClickListener{
            proceedExpression("-",true)
        }
        buttonMult.setOnClickListener{
            proceedExpression("*",true)
        }
        buttonModulo.setOnClickListener{
            proceedExpression("%",true)
        }
        buttonDecimal.setOnClickListener{
            proceedExpression(".",true)
        }
        buttonDelete.setOnClickListener{
            expressionbt.text = ""
            result.text = ""
        }
        buttonClear.setOnClickListener{
            expressionbt.text = expressionbt.text.substring(0,expressionbt.text.length-1)
        }
        buttonEquals.setOnClickListener{
            calculateResult()
        }
    }


    fun proceedExpression(input : String, clear : Boolean){
        if(clear){
            result.text = ""
            expressionbt.append(input)
        }
        else{
            expressionbt.append(result.text)
            expressionbt.append(input)
            result.text = ""
        }
    }

    fun calculateResult() {
        val text = expressionbt.text.toString()
        val exp = ExpressionBuilder(text).build()
        val result_ev = exp.evaluate()
        if(result_ev == result_ev.toLong().toDouble()){
            result.text = result_ev.toLong().toString()
        }
        else{
            result.text = result_ev.toString()
        }
    }
}
