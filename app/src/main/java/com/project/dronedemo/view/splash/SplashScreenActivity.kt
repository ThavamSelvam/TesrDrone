package com.project.dronedemo.view.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.project.dronedemo.R
import com.project.dronedemo.view.dashboard.DashboardActivity
import com.project.dronedemo.view.enternumber.PhoneNumberActivity
import com.project.dronedemo.view.otpverification.OtpVerificationActivity


class SplashScreenActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        sharedPreferences = getSharedPreferences("appname", Context.MODE_PRIVATE)!!
        Handler(Looper.getMainLooper()).postDelayed({
            if (sharedPreferences.getBoolean("USERLOGIN", false)) {
                startActivity(Intent(this, DashboardActivity::class.java))
            } else {
                startActivity(Intent(this, PhoneNumberActivity::class.java))
            }
            finish()
        }, 3000)

    }
}