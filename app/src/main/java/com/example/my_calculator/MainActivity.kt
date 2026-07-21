package com.example.my_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextNumberDecimal)
        val num2 = findViewById<EditText>(R.id.editTextNumberDecimal2)

        val add = findViewById<Button>(R.id.btnAdd)
        val sub = findViewById<Button>(R.id.btnSubtract)
        val mul = findViewById<Button>(R.id.btnMultiply)
        val div = findViewById<Button>(R.id.btnDivide)
        val calculate = findViewById<Button>(R.id.button)

        val result = findViewById<TextView>(R.id.txtResult)

        add.setOnClickListener {
            operation = "+"
            Toast.makeText(this, "Addition Selected", Toast.LENGTH_SHORT).show()
        }

        sub.setOnClickListener {
            operation = "-"
            Toast.makeText(this, "Subtraction Selected", Toast.LENGTH_SHORT).show()
        }

        mul.setOnClickListener {
            operation = "*"
            Toast.makeText(this, "Multiplication Selected", Toast.LENGTH_SHORT).show()
        }

        div.setOnClickListener {
            operation = "/"
            Toast.makeText(this, "Division Selected", Toast.LENGTH_SHORT).show()
        }

        calculate.setOnClickListener {

            if (num1.text.isEmpty() || num2.text.isEmpty()) {
                Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val n1 = num1.text.toString().toDoubleOrNull()
            val n2 = num2.text.toString().toDoubleOrNull()

            if (n1 == null || n2 == null) {
                Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val ans = when (operation) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> {
                    if (n2 == 0.0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                    n1 / n2
                }
                else -> {
                    Toast.makeText(this, "Select an operation first", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            result.text = ans.toString()
        }
    }
}