# Android App & Website Integration Guide

This document explains how the **Coconut Wireless App** (Android) and **The Coconut Wireless Network** (Website) are connected. It serves as a technical hand-off for the website developer to ensure smooth interoperability.

## 1. The Core: WebView Wrapper
The app is a "WebView Wrapper." It loads the live website into a full-screen container, removing Android-native navigation to prioritize the website's design.

- **App Target URL:** `https://www.thecoconutwirelessnetwork.com`
- **User Agent:** The app uses the standard Android WebView User Agent.

## 2. The JavaScript Bridge (Deep Interoperability)
The app exposes a native interface to the website's JavaScript. This allows the website to trigger native Android functions.

### Interface Details
- **Bridge Name:** `AndroidBridge`
- **Location in Android Code:** `com.thecoconutwirelessnetwork.app.WebAppInterface`

### Available Methods
The website can call these methods directly from its JavaScript:

| Method | Description | JavaScript Example |
| :--- | :--- | :--- |
| `showToast(string)` | Shows a native Android "Toast" message. | `AndroidBridge.showToast("Saved!");` |
| `getFcmToken()` | (Placeholder) Intended to return the unique Firebase Messaging Token. | `let token = AndroidBridge.getFcmToken();` |

> [!TIP]
> **To add more functions:** Add a method with the `@JavascriptInterface` annotation in `WebAppInterface.kt`, and it will immediately become available to the website.

## 3. Push Notifications (FCM)
The app is configured for **Firebase Cloud Messaging**.

### Implementation Details:
- **Service Class:** `MyFirebaseMessagingService.kt`
- **Channel ID:** `fcm_default_channel`
- **Permissions:** The app automatically requests `POST_NOTIFICATIONS` on Android 13+.

### Website Integration Requirement:
To send a notification to a specific user, the website needs to:
1. Receive the **FCM Token** from the app (via the `AndroidBridge`).
2. Store that token in your website's database associated with the User ID.
3. Use the Firebase Admin SDK on your server to send messages to that token.

## 4. Hardware Interoperability
- **Back Button:** The Android back button is wired to the WebView history. It will go back one page on the website. If at the homepage, it will exit the app.
- **Permissions:**
    - `INTERNET`: For loading the site.
    - `POST_NOTIFICATIONS`: For push alerts.

## 5. Required Files for Website Coder
If sharing this project with a web developer, ensure they see:
1. `app/src/main/java/com/thecoconutwirelessnetwork/app/MainActivity.kt`
2. `app/src/main/java/com/thecoconutwirelessnetwork/app/WebAppInterface.kt`
3. `app/src/main/java/com/thecoconutwirelessnetwork/app/MyFirebaseMessagingService.kt`
4. `app/src/main/AndroidManifest.xml`

---
*Created on: 2026-08-16*
