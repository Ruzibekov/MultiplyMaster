package uz.ruzibekov.multiplymaster.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import uz.ruzibekov.multiplymaster.R

class GameActivity : AppCompatActivity() {

    private var btnBack: ImageButton? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
    }
}