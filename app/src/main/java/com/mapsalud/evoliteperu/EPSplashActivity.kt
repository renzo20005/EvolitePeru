package com.mapsalud.evoliteperu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.animation.AnimationUtils
import com.mapsalud.evoliteperu.databinding.ActivityEpSplashBinding

class EPSplashActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityEpSplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityEpSplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottonAnimation = AnimationUtils.loadAnimation(this, R.anim.botton_animation)

        mBinding.ivLogo.startAnimation(topAnimation)
        mBinding.ivBranding.startAnimation(bottonAnimation)

        startTimer()
        /*val aplashScreenTimeOut = 4000
        val homeIntent = Intent(this,EPLoginActivity::class.java)

        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        },aplashScreenTimeOut.toLong())*/
    }

    fun startTimer(){
        object: CountDownTimer(4000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(applicationContext,EPLoginActivity::class.java).apply {  }
                startActivity(intent)
                finish()
            }

        }.start()
    }

}