package com.project.dronedemo.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.project.dronedemo.R
import com.project.dronedemo.view.enternumber.PhoneNumberActivity
import com.project.dronedemo.view.otpverification.OtpVerificationActivity


class SplashScreenActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,PhoneNumberActivity::class.java))
            finish()
       }, 3000)

    }
}