package com.project.dronedemo.view.otpverification

import android.content.Intent
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.dronedemo.R
import com.project.dronedemo.utils.Constant.Companion.MOBILE_NUMBER
import com.project.dronedemo.view.enternumber.PhoneNumberActivity
import com.project.dronedemo.view.otpverification.OtpVerificationActivity

class OtpVerificationViewModel : ViewModel() {

    var showErrorMessage: MutableLiveData<String?> = MutableLiveData()

    lateinit var otpVerificationActivity: OtpVerificationActivity

    fun setActivity(otpVerificationActivity: OtpVerificationActivity) {
        this.otpVerificationActivity = otpVerificationActivity;
    }

}