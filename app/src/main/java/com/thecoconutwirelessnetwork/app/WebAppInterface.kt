package com.thecoconutwirelessnetwork.app

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class WebAppInterface(private val mContext: Context) {

    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }

    // Returns the current FCM device token so the website's JavaScript can
    // POST it to /api/register-device/ to enable push notifications.
    // Returns null if the token hasn't been generated yet (first install,
    // before Firebase has called onNewToken), in which case the site's
    // registration script simply skips — the next page load after the token
    // arrives will register it.
    @JavascriptInterface
    fun getFcmToken(): String? {
        return mContext.getSharedPreferences("fcm_prefs", Context.MODE_PRIVATE)
            .getString("fcm_token", null)
    }
}
