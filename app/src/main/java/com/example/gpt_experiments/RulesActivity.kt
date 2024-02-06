package com.example.gpt_experiments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RulesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)
    }

    fun goToPageWithQuest(view: View) {
        val intent = Intent(this, QuestActivity::class.java)
        startActivity(intent)
    }
}