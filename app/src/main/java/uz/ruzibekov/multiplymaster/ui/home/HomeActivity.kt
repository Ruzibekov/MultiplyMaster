package uz.ruzibekov.multiplymaster.ui.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import uz.ruzibekov.multiplymaster.R
import uz.ruzibekov.multiplymaster.ui.home.adapter.HomeAdapter
import uz.ruzibekov.multiplymaster.ui.learn.LearnActivity

class HomeActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    private var rvHome: RecyclerView? = null
    private var adapter = HomeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()

        initData()

        initListeners()
    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        rvHome = findViewById(R.id.rv_home)
    }

    private fun initData(){

        val list =ArrayList<Int>()
        for (i in 1..20){
            list.add(i)
        }

        adapter.items = list
        rvHome?.adapter = adapter
    }

    private fun initListeners(){

        btnBack?.setOnClickListener {
            finish()
        }

        adapter.onClick = {
            val intent = Intent(this, LearnActivity::class.java)
            intent.putExtra("data",it)
            startActivity(intent)
        }
    }
}