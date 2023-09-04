package uz.ruzibekov.multiplymaster.ui.entrance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import uz.ruzibekov.multiplymaster.R
import uz.ruzibekov.multiplymaster.ui.home.HomeActivity

class EntranceActivity : AppCompatActivity() {

    private var btnStart: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entrance)

        initViews()

        initListeners()
    }

    private fun initViews() {
        btnStart = findViewById(R.id.btn_start)
    }

    private fun initListeners(){

        btnStart?.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}