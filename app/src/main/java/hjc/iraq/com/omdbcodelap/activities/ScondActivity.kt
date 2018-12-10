package hjc.iraq.com.omdbcodelap.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import hjc.iraq.com.omdbcodelap.R
import kotlinx.android.synthetic.main.activity_scond.*

class ScondActivity : AppCompatActivity() {

    var getButton: Animation?=null
    var omDb: Animation?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scond)

        getStartButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        beginAnim()

    }

    private fun beginAnim() {
        omDb = AnimationUtils.loadAnimation(this, R.anim.omdb)
        omdbImageView.setAnimation(omDb)
        getButton = AnimationUtils.loadAnimation(this, R.anim.getbutton)
        getStartButton.setAnimation(getButton)
    }
}
