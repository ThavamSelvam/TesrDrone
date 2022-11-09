package com.project.dronedemo.view.enternumber

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.dronedemo.R
import com.project.dronedemo.utils.Constant.Companion.MOBILE_NUMBER
import com.project.dronedemo.utils.PermissionHelper
import com.project.dronedemo.view.otpverification.OtpVerificationActivity

class PhoneNumberViewModel : ViewModel() {

    var showErrorMessage: MutableLiveData<String?> = MutableLiveData()

    var phoneNumber = ObservableField("")
    private lateinit var phoneNumberActivity: PhoneNumberActivity
    fun onNextClick() {
        if (!PermissionHelper.getInstance()!!.isAvailableAllPermission()){
            phoneNumberActivity.askPermission()
            return
        }

        if (phoneNumber.get().isNullOrEmpty()) {
            showErrorMessage.value = (phoneNumberActivity.getString(R.string.please_enter_number))
            return
        }
        if (phoneNumber.get()?.length!! < 10) {
            showErrorMessage.value =
                (phoneNumberActivity.getString(R.string.please_enter_number_ten_digit))
            return
        }
        if (phoneNumber.get()?.length!! < 10) {
            showErrorMessage.value =
                (phoneNumberActivity.getString(R.string.please_enter_number_ten_digit))
            return
        }

        phoneNumberActivity.startActivity(
            Intent(
                phoneNumberActivity,
                OtpVerificationActivity::class.java
            ).putExtra(MOBILE_NUMBER, phoneNumber.get())
        )
    }

    fun setActivity(phoneNumberActivity: PhoneNumberActivity) {
        this.phoneNumberActivity = phoneNumberActivity;
    }
}


