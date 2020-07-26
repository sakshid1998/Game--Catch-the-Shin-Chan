package sakshidhodra.example.catchshinchan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatViewInflater
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    var score: Int = 0
    var imageArray = ArrayList<ImageView>()
    var handler : Handler= Handler()
    var runnable : Runnable= Runnable {  }

    // var ImageArray=ArrayList<ImageView>()
    //var handler : Handler= Handler()
    // var runnable : Runnable= Runnable {  }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        score=0

        imageArray = arrayListOf(imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9)
        hideImages()
        object : CountDownTimer(10000,1000){
            override fun onFinish() {
                timeText.text="Time is Off"
                handler.removeCallbacks(runnable)
                for ( image in imageArray){
                    image.visibility=View.INVISIBLE
                }
            }

            override fun onTick(p0: Long) {
                timeText.text="Time: "+p0/1000

            }

        }.start()
    }

    fun hideImages()
    {
        runnable = object : Runnable{
            override fun run() {
                for ( image in imageArray){
                    image.visibility=View.INVISIBLE
                }
                var random = Random
                var index = random.nextInt(0,8)

                imageArray[index].visibility=View.VISIBLE
                handler.postDelayed(runnable,500)
            }
        }
        handler.post(runnable)
    }
    fun increaseScore(view: View)
    {
        score++
        scoreText.text="Score: "+score
    }
}