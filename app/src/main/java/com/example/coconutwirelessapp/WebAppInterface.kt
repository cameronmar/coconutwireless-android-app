package com.example.coconutwirelessapp

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

/**
 * Instantiate the interface and set the context.
 * This class provides methods that can be called from JavaScript on your website.
 */
class WebAppInterface(private val mContext: Context) {

    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }

    /** 
     * Get the FCM token to send to your server.
     * Your website coder can call this to register the device for notifications.
     */
    @JavascriptInterface
    fun getFcmToken(): String? {
        // This can be expanded to return the token directly to the JS
        return null 
    }
}