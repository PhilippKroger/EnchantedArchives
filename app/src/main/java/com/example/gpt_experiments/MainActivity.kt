package com.example.gpt_experiments
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
    }

    fun goToPageWithRules(view: View) {
        val intent = Intent(this, RulesActivity::class.java)
        startActivity(intent)
    }
}

