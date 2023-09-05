package uz.ruzibekov.multiplymaster.ui.learn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import uz.ruzibekov.multiplymaster.R
import uz.ruzibekov.multiplymaster.ui.game.GameActivity
import uz.ruzibekov.multiplymaster.ui.learn.adapter.LearnAdapter

class LearnActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    private var rvLearn: RecyclerView? = null
    private var btnStart: Button? = null
    private var adapter = LearnAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn)

        initViews()

        initData()

        initListeners()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        rvLearn = findViewById(R.id.rv_learn)
        btnStart = findViewById(R.id.btn_start)
    }

    private fun initData(){

        adapter.selectedNumber = intent.getIntExtra("data",1)

        val list =ArrayList<Int>()
        for (i in 1..10){
            list.add(i)
        }

        adapter.items = list
        rvLearn?.adapter = adapter
    }

    private fun initListeners(){

        btnBack?.setOnClickListener {
            finish()
        }

        btnStart?.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
    }
}