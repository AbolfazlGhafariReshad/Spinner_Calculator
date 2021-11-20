package com.example.spinnercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtv = findViewById<TextView>(R.id.ac_main_txtv)
        val txt1 = findViewById<EditText>(R.id.ac_main_txt_1)
        val txt2 = findViewById<EditText>(R.id.ac_main_txt_2)
        val btn = findViewById<Button>(R.id.ac_btn_sub)
        var a = ""

        Toast.makeText(this@MainActivity, "بعد از وارد کردن اعداد، عملیات مورد نظر را انتخاب کنید و روی محاسبه بزنید", Toast.LENGTH_LONG).show()
        var list_spinner = arrayOf("عملیات مورد نظر را انتخاب کنید", "جمع","تفریق","تقسیم","ضرب")
        var spinner = findViewById<Spinner>(R.id.ac_main_spinner)
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list_spinner)
        spinner.adapter=adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                a = position.toString()

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Code to perform some action when nothing is selected
            }
        }

        btn.setOnClickListener {

            if (txt1.getText().toString().equals("") && txt2.getText().toString().equals("") || txt1.getText().toString().equals("") || txt2.getText().toString().equals("")){
                Toast.makeText(this@MainActivity, "مقادیر را وارد نمایید", Toast.LENGTH_LONG).show()
            }else if (a == "0"){
                Toast.makeText(this@MainActivity, "از فهرست کشویی عملیات مورد نظر را انتخاب کنید", Toast.LENGTH_LONG).show()
            }else if (a == "1"){
                txtv.text = (Integer.parseInt(txt1.text.toString()) + Integer.parseInt(txt2.text.toString())).toString()
            }else if (a == "2"){
                txtv.text = (Integer.parseInt(txt1.text.toString()) - Integer.parseInt(txt2.text.toString())).toString()
            }else if (a == "3"){
                txtv.text = (Integer.parseInt(txt1.text.toString()) / Integer.parseInt(txt2.text.toString())).toString()
            }else if (a == "4"){
                txtv.text = (Integer.parseInt(txt1.text.toString()) * Integer.parseInt(txt2.text.toString())).toString()
            }

        }

    }

}