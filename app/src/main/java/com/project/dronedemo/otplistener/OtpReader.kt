package com.project.dronedemo.otplistener

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.telephony.SmsMessage;
import android.util.Log;

class OtpReader : BroadcastReceiver() {


    private val TAG = "OtpReader"




    companion object{
        private var otpListener: OTPListenerSMS? = null

        private var receiverString: String? = null
        fun bind(listener: OTPListenerSMS, sender: String?) {
            otpListener = listener
            receiverString = sender
        }
    }

    override fun onReceive(context: Context?, intent: Intent) {
        val bundle = intent.extras
        if (bundle != null) {
            val pdusArr = bundle["pdus"] as Array<Any>?
            for (i in pdusArr!!.indices) {
                val currentMessage: SmsMessage = SmsMessage.createFromPdu(pdusArr[i] as ByteArray)
                val senderNum: String = currentMessage.getDisplayOriginatingAddress()
                val message: String = currentMessage.getDisplayMessageBody()
                Log.i(TAG, "senderNum: $senderNum message: $message")
                if (!TextUtils.isEmpty(receiverString) && senderNum.contains(receiverString!!)) { //If message received is from required number.
                    //If bound a listener interface, callback the overriden method.
                    if (otpListener != null) {
                        otpListener!!.otpReceived(message)
                    }
                }
            }
        }
    }

    fun unbind() {
        otpListener = null
        receiverString = null
    }
}