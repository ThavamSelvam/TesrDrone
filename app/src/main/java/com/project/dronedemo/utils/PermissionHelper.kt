package com.project.dronedemo.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import java.util.*
import kotlin.collections.ArrayList


class PermissionHelper {

    private val RC_RUNTIME_PERMISSION = 12345
    private val permission = ArrayList<String>()
    private var mContext: Context? = null
    private var mListner: PermissionCallback? = null
    private var runtimePermissionDenied = false

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var INSTANCE: PermissionHelper? = null
        fun getInstance(): PermissionHelper? {
            if (INSTANCE == null) {
                synchronized(PermissionHelper::class.java) { INSTANCE = PermissionHelper() }
            }
            return INSTANCE
        }
    }

    fun askPermission(vararg permission: String) {
        if (permission.size > 0) {
            this.permission.clear()
            this.permission.addAll(permission)
        }
        if (mContext is Activity) ActivityCompat.requestPermissions(
            (mContext as Activity?)!!,
            this.permission.toArray(arrayOfNulls(0)),
            RC_RUNTIME_PERMISSION
        )
    }

    fun onPermissionRequestResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray?
    ) {
        when (requestCode) {
            RC_RUNTIME_PERMISSION -> {
                if (!isAvailableAllPermission()) {
                    if (mContext is Activity) for (name in permissions) {
                        runtimePermissionDenied =
                            ActivityCompat.shouldShowRequestPermissionRationale(
                                (mContext as Activity?)!!,
                                name!!
                            )
                        if (!runtimePermissionDenied) break
                    }
                    if (!runtimePermissionDenied) {
                        if (mListner != null) {
                            mListner!!.onNeverAskAgainPermission(true)
                        }
                    } else {
                        if (mListner != null) {
                            mListner!!.onDenied()
                        }
                    }
                } else if (mListner != null) mListner!!.onPermissionGranted()
            }
        }
    }

    fun with(context: Context?): PermissionHelper {
        mContext = context
        return this
    }

    fun setListener(mListner: PermissionCallback?): PermissionHelper {
        this.mListner = mListner
        return this
    }

      fun isAvailableAllPermission(): Boolean {
        var isAllowed = true
        for (item in permission) {
            isAllowed = ActivityCompat.checkSelfPermission(
                mContext!!,
                item
            ) == PackageManager.PERMISSION_GRANTED
            if (!isAllowed) break
        }
        return isAllowed
    }

    interface PermissionCallback {
        fun onPermissionGranted()
        fun onNeverAskAgainPermission(runtimePermissionDenied: Boolean)
        fun onDenied()
    }
}