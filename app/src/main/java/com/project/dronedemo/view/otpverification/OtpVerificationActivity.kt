package com.project.dronedemo.view.otpverification

import `in`.aabhasjindal.otptextview.OTPListener
import android.annotation.SuppressLint
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.project.dronedemo.R
import com.project.dronedemo.databinding.ActivityOtpVerificationBinding
import com.project.dronedemo.otplistener.AppSMSBroadcastReceiver
import com.project.dronedemo.otplistener.OTPListenerSMS
import com.project.dronedemo.otplistener.OtpReader
import com.project.dronedemo.otplistener.SmsBroadcastReceiver
import com.project.dronedemo.utils.Constant.Companion.MOBILE_NUMBER
import com.project.dronedemo.view.base.BaseActivity
import com.project.dronedemo.view.dashboard.DashboardActivity
import com.project.dronedemo.view.enternumber.PhoneNumberActivity
import java.util.*
import java.util.regex.Pattern


class OtpVerificationActivity : BaseActivity(), OTPListener, OTPListenerSMS,
    AppSMSBroadcastReceiver.OnSmsReceiveListener {
    lateinit var binding: ActivityOtpVerificationBinding
    private val REQ_USER_CONSENT = 200
    var smsBroadcastReceiver: SmsBroadcastReceiver? = null
    var userMobileNumber: String = ""
    lateinit var otpVerificationViewModel: OtpVerificationViewModel
    private var intentFilter: IntentFilter? = null
    private var appSMSBroadcastReceiver: AppSMSBroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this@OtpVerificationActivity,
            R.layout.activity_otp_verification
        )
        userMobileNumber = intent.getStringExtra(MOBILE_NUMBER).toString()
        otpVerificationViewModel =
            ViewModelProvider(this@OtpVerificationActivity).get(OtpVerificationViewModel::class.java)
        binding.viewModel = otpVerificationViewModel
        otpVerificationViewModel.setActivity(this@OtpVerificationActivity)
        binding.txtOnNumber.setText(getString(R.string.on_number) + " " + userMobileNumber)
        OtpReader.bind(this, "+91" + userMobileNumber);
        binding.txtOtpView.setOtpListener(this);

        startSmartUserConsent()
        sendSMS("0091" + userMobileNumber, "")
    }

    private fun startSmartUserConsent() {
        val client = SmsRetriever.getClient(this)
        client.startSmsUserConsent(null)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQ_USER_CONSENT) {
            if (resultCode == RESULT_OK && data != null) {
                val message = data.getStringExtra(SmsRetriever.EXTRA_SMS_MESSAGE)
                getOtpFromMessage(message)
            }
        }
    }

    private fun getOtpFromMessage(message: String?) {
        val otpPattern = Pattern.compile("(|^)\\d{6}")
        val matcher = otpPattern.matcher(message)
        if (matcher.find()) {
            binding.txtOtpView.setOTP(matcher.group(0))
            checkOtp(binding.txtOtpView.otp)
        }
    }

    private fun checkOtp(otp: String?) {
        if (id.equals(otp)) {
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this@OtpVerificationActivity, DashboardActivity::class.java))
                finish()
            }, 2000)

        } else {
            otpCame = false
            showBottomToast(getString(R.string.please_enter_valid_otp))
        }

    }


    private fun registerBroadcastReceiver() {
        smsBroadcastReceiver = SmsBroadcastReceiver()
        smsBroadcastReceiver!!.smsBroadcastReceiverListener =
            object : SmsBroadcastReceiver.SmsBroadcastReceiverListener {
                override fun onSuccess(intent: Intent?) {
                    startActivityForResult(
                        intent,
                        REQ_USER_CONSENT
                    )
                }

                override fun onFailure() {}
            }
        val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        registerReceiver(smsBroadcastReceiver, intentFilter)
    }

    override fun onStart() {
        super.onStart()
        registerBroadcastReceiver()
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(smsBroadcastReceiver)
    }

    private fun smsListener() {
        val client = SmsRetriever.getClient(this)
        client.startSmsRetriever()
    }

    private fun initBroadCast() {
        intentFilter = IntentFilter("com.google.android.gms.auth.api.phone.SMS_RETRIEVED")
        appSMSBroadcastReceiver = AppSMSBroadcastReceiver()
        AppSMSBroadcastReceiver.setOnSmsReceiveListener(this)

    }

    var id: String = ""

    @SuppressLint("DefaultLocale")
    fun sendSMS(phoneNo: String?, s: String?) {
        try {
            id = java.lang.String.format("%06d", Random().nextInt(10000))
            val msg = "Your verification code is: " + id
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(phoneNo, null, msg, null, null)
            Toast.makeText(
                applicationContext, "Message Sent",
                Toast.LENGTH_LONG
            ).show()
        } catch (ex: Exception) {
            Toast.makeText(
                applicationContext, ex.message.toString(),
                Toast.LENGTH_LONG
            ).show()
            ex.printStackTrace()
        }
    }

    override fun onInteractionListener() {


    }

    var otpCame: Boolean = true
    override fun onOTPComplete(otp: String?) {
     //   startActivity(Intent(this@OtpVerificationActivity, DashboardActivity::class.java))
     //   finish()
    }

    override fun otpReceived(messageText: String?) {
        Toast.makeText(this, "Got " + messageText, Toast.LENGTH_LONG).show();
        Log.d("Otp", "Otp received");
        startActivity(Intent(this@OtpVerificationActivity, DashboardActivity::class.java))
    }

    override fun onReceive(code: String?) {
        //    Toast.makeText(this, "Got " + messageText, Toast.LENGTH_LONG).show();
        startActivity(Intent(this@OtpVerificationActivity, DashboardActivity::class.java))

    }
}



