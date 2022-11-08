package com.project.dronedemo.view.base

import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun showBottomToast(msg: String) {
        val toast = Toast.makeText(
            this,
            msg, Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0)
        toast.show()
    }
}