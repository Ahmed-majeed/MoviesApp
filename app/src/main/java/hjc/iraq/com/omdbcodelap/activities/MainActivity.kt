package hjc.iraq.com.omdbcodelap.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import hjc.iraq.com.omdbcodelap.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val thread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(3000)
                    val intent = Intent(applicationContext, ScondActivity::class.java)
                    startActivities(arrayOf(intent))
                     finish()
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

            }
        }
        thread.start()


    }
}
