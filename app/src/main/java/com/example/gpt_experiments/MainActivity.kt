package com.example.gpt_experiments
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var submitButton: Button

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }

    fun goToPageWithRules(view: View) {
        val intent = Intent(this, RulesActivity::class.java)
        startActivity(intent)
    }
}

