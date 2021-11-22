package com.mapsalud.evoliteperu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.mapsalud.evoliteperu.databinding.ActivityEpLoginBinding
import com.mapsalud.evoliteperu.databinding.ActivityEpSplashBinding

class EPLoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityEpLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityEpLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottonAnimation = AnimationUtils.loadAnimation(this, R.anim.botton_animation)

        mBinding.ivLogo.startAnimation(topAnimation)
        mBinding.etEmail.startAnimation(bottonAnimation)
        mBinding.etPassword.startAnimation(bottonAnimation)
    }
}