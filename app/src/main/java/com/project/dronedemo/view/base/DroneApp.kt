package com.project.dronedemo.view.base

import android.app.Application
import android.content.Context

class DroneApp : Application() {
    public lateinit var appData: AppData
    override fun onCreate() {
        super.onCreate()
         appData = AppData()
    }

    public fun getApplicationData(): AppData {
        return appData
    }



}