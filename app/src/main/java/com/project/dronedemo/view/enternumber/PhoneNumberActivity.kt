package com.project.dronedemo.view.enternumber

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.project.dronedemo.R
import com.project.dronedemo.databinding.ActivityPhoneNumberBinding
import com.project.dronedemo.utils.Constant
import com.project.dronedemo.view.base.BaseActivity
import com.project.dronedemo.view.otpverification.OtpVerificationActivity

class PhoneNumberActivity : BaseActivity() {
    lateinit var phoneNumberViewModel: PhoneNumberViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)
        val binding: ActivityPhoneNumberBinding =
            DataBindingUtil.setContentView(this@PhoneNumberActivity, R.layout.activity_phone_number)
        phoneNumberViewModel =
            ViewModelProvider(this@PhoneNumberActivity).get(PhoneNumberViewModel::class.java)
        binding.viewModel = phoneNumberViewModel
        phoneNumberViewModel.setActivity(this@PhoneNumberActivity)
        loadLiveDataModel()
        binding.edtNumberPhome.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, count1: Int, count: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.length == 10) {
                    phoneNumberViewModel.onNextClick()
                }
            }
        })
    }

    private fun loadLiveDataModel() {
        phoneNumberViewModel.showErrorMessage.observe(this, {
            showBottomToast(it!!)
        })
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 12) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(
                    Intent(
                        this@PhoneNumberActivity,
                        OtpVerificationActivity::class.java
                    ).putExtra(Constant.MOBILE_NUMBER, phoneNumberViewModel.phoneNumber.get())
                )
            }
        }
    }
}