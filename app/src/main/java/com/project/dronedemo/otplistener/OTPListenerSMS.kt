package com.project.dronedemo.otplistener

interface OTPListenerSMS {
    fun otpReceived(messageText: String?)
}