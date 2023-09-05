package uz.ruzibekov.multiplymaster.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import uz.ruzibekov.multiplymaster.R

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        initViews()
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
}