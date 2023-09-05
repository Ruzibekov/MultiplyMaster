package uz.ruzibekov.multiplymaster.ui.game

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.ruzibekov.multiplymaster.R
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    private var tvCounter: TextView? = null
    private var tvCorrect: TextView? = null
    private var tvWrong: TextView? = null
    private var btnAnswer1: Button? = null
    private var btnAnswer2: Button? = null
    private var btnAnswer3: Button? = null
    private var btnAnswer4: Button? = null
    private var tvQuestion: TextView? = null

    private var correctAnswers: Int = 0
    private var wrongAnswers: Int = 0
    private var counter: Int = 1

    private val listQuestions = ArrayList<String>()
    private val listAnswer = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViews()

        initData()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        tvCounter = findViewById(R.id.tv_counter)
        tvCorrect = findViewById(R.id.tv_correct)
        tvWrong = findViewById(R.id.tv_wrong)
        btnAnswer1 = findViewById(R.id.btn_answer1)
        btnAnswer2 = findViewById(R.id.btn_answer2)
        btnAnswer3 = findViewById(R.id.btn_answer3)
        btnAnswer4 = findViewById(R.id.btn_answer4)
        tvQuestion = findViewById(R.id.tv_question)
    }

    @SuppressLint("SetTextI18n")
    private fun initData() {
        val intentData = intent.getIntExtra("intent_data", 1)

        for (i in 1..10) {
            listQuestions.add("$intentData x $i = ?")
            listAnswer.add(intentData * i)
        }

        tvQuestion?.text = listQuestions[counter - 1]
        tvCounter?.text = "$counter / 10"
        tvCorrect?.text = correctAnswers.toString()
        tvWrong?.text = wrongAnswers.toString()

        changeButtonsText(listAnswer[counter - 1])

        btnAnswer1?.setOnClickListener {
            changeData(btnAnswer1?.text.toString())
            changeButtonsText(listAnswer[counter - 1])
        }

        btnAnswer2?.setOnClickListener {
            changeData(btnAnswer2?.text.toString())
            changeButtonsText(listAnswer[counter - 1])
        }

        btnAnswer3?.setOnClickListener {
            changeData(btnAnswer3?.text.toString())
            changeButtonsText(listAnswer[counter - 1])
        }

        btnAnswer4?.setOnClickListener {
            changeData(btnAnswer4?.text.toString())
            changeButtonsText(listAnswer[counter - 1])
        }
    }

    @SuppressLint("SetTextI18n")
    private fun changeData(text: String) {

        if (text == listAnswer[counter - 1].toString()) {
            correctAnswers += 1
        } else {
            wrongAnswers += 1
        }

        if (counter < 10) {
            counter = counter.plus(1)
            tvCounter?.text = "$counter / 10"
            tvQuestion?.text = listQuestions[counter - 1]
            tvCorrect?.text = correctAnswers.toString()
            tvWrong?.text = wrongAnswers.toString()
        } else {
            openDialog()
        }
    }

    private fun openDialog() {
        Toast.makeText(this, "ssss", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun changeButtonsText(answer: Int) {
        when (Random.nextInt(1, 5)) {
            1 -> {
                btnAnswer1?.text = answer.toString()
                btnAnswer2?.text = (answer + 1).toString()
                btnAnswer3?.text = (answer + 2).toString()
                btnAnswer4?.text = (answer + 3).toString()
            }

            2 -> {
                btnAnswer2?.text = answer.toString()
                btnAnswer1?.text = (answer - 1).toString()
                btnAnswer3?.text = (answer + 1).toString()
                btnAnswer4?.text = (answer + 2).toString()
            }

            3 -> {
                btnAnswer3?.text = answer.toString()
                btnAnswer1?.text = (answer - 1).toString()
                btnAnswer2?.text = (answer + 2).toString()
                btnAnswer4?.text = (answer + 3).toString()
            }

            4 -> {
                btnAnswer4?.text = answer.toString()
                btnAnswer2?.text = (answer + 1).toString()
                btnAnswer3?.text = (answer + 2).toString()
                btnAnswer1?.text = (answer - 3).toString()
            }
        }
    }
}