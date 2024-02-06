package com.example.gpt_experiments

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class QuestActivity : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var radioGroup: RadioGroup
    private lateinit var submitButton: Button


    private var currentQuestionIndex = 0
    private var score = 0

    private val questions = arrayOf(
        "Какой магический предмет обладает способностью предсказывать будущее и может принимать разные формы?",
        "Какой магический предмет может вызывать и контролировать элементы природы, такие как огонь, вода, земля и воздух?",
        "Какой магический предмет используется для превращения одного объекта в другой и имеет форму маленького котелка?",
        "Какой магический предмет позволяет своему обладателю летать и управлять погодой?",
        "С помощью какого магического предмета можно читать мысли других людей?",
        "Какой магический предмет имеет способность исцелять раны и восстанавливать жизненную энергию?",
        "Какой магический предмет может проникать в мечты людей и манипулировать их содержанием?",
        "Какой магический предмет может превращать людей и животных в каменные статуи?",
        "Какой магический предмет предоставляет своему обладателю невидимость и неприкосновенность перед другими магическими существами?",
        "Какой магический предмет обладает силой управлять живыми существами и заставлять их служить своему обладателю? "
    )

    private val answers = arrayOf(
        arrayOf("Колдовское зеркало", "Гримуар ", "Мантия-невидимка"),
        arrayOf("Огненный жезл", "Амулет стихий", "Кристалл мощи"),
        arrayOf("Магический пендель", "Алхимическая реторта", "Метла-велосипед"),
        arrayOf("Летучий ковер", "Метла-машина", "Перстень власти"),
        arrayOf("Книга теней", "Кристаллический шар", "Руна ментальной прозрачности"),
        arrayOf("Светящаяся амулетка", "Зелье бессмертия", "Посох исцеления"),
        arrayOf("Сновидящий стеллаж", "Кольцо сновидений", "Фляжка с сновидениями"),
        arrayOf("Медузин глаз", "Каменный артефакт", "Маска непоколебимости"),
        arrayOf("Плащ-невидимка", "Теневой амулет", "Посох дымовых облаков"),
        arrayOf("Посох контроля", "Контролирующее око", "Записная книжка управления")
    )

    private val correctAnswers = arrayOf(0, 1, 1, 0, 1, 2, 1, 0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quest)

        questionTextView = findViewById(R.id.questionTextView)
        radioGroup = findViewById(R.id.radioGroup)
        submitButton = findViewById(R.id.submitButton)

        showQuestion()
        val rezBtn1 = findViewById<Button>(R.id.homeButton)
        val rezBtn2 = findViewById<Button>(R.id.cycleButton)
        rezBtn1.visibility = View.GONE

        rezBtn2.visibility = View.GONE
        submitButton.setOnClickListener {
            checkAnswer()
        }
    }
    val colors = listOf(
        Color.RED,
        Color.GREEN,
        Color.BLUE,
        Color.WHITE
    )

    private fun showQuestion() {
        val question = questions[currentQuestionIndex]
        val options = answers[currentQuestionIndex]

        questionTextView.text = question
        radioGroup.removeAllViews()

        for (i in options.indices) {
            val radioButton = RadioButton(this)
            radioButton.text = options[i]
            radioButton.setTextColor(colors[3])
            radioButton.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
            radioButton.id = i
            radioGroup.addView(radioButton)
        }
    }

    private fun checkAnswer() {
        val selectedAnswerId = radioGroup.checkedRadioButtonId

        if (selectedAnswerId != -1) {
            val selectedAnswerIndex = radioGroup.indexOfChild(findViewById(selectedAnswerId))
            if (selectedAnswerIndex == correctAnswers[currentQuestionIndex]) {
                score++
            }

            currentQuestionIndex++

            if (currentQuestionIndex < questions.size) {
                showQuestion()

            } else {
                showResult()
            }
        }
    }

    private fun showResult() {
        questionTextView.visibility = View.GONE
        radioGroup.visibility = View.GONE
        submitButton.visibility = View.GONE

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val rezBtn1 = findViewById<Button>(R.id.homeButton)
        val rezBtn2 = findViewById<Button>(R.id.cycleButton)
        resultTextView.text = "Ваш результат: $score/10"
        resultTextView.visibility = View.VISIBLE
        rezBtn1.visibility = View.VISIBLE
        rezBtn2.visibility = View.VISIBLE
    }

    fun goMainPage(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun goToPageWithQuest(view: View) {
        val intent = Intent(this, QuestActivity::class.java)
        startActivity(intent)
    }


}