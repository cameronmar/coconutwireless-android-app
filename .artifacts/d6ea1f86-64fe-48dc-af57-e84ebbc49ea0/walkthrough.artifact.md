# Walkthrough - Full-screen WebView App with Push Notifications

I have successfully converted your app into a full-screen WebView wrapper for `www.thecoconutwirelessnetwork.com` and integrated Firebase Cloud Messaging for push notifications.

## Changes Made

### UI & UX
- **Full-screen WebView:** Removed the navigation drawer, toolbar, and bottom navigation. The app now opens your website directly in full screen.
- **Back Button Support:** Implemented logic to allow users to navigate back through their web history using the hardware back button before closing the app.

### Features
- **Push Notifications:** Integrated Firebase Cloud Messaging (FCM).
    - Added a `MyFirebaseMessagingService` to handle incoming messages.
    - Implemented a notification channel and permission request for Android 13+.
- **Internet Permission:** Added the necessary permissions to `AndroidManifest.xml`.
- **JavaScript Bridge:** Added `AndroidBridge` to allow the website to communicate with native Android features (like showing toasts or fetching the FCM token).
- **File Upload Support:** Enabled the photo picker so users can upload images from the website.

### Infrastructure
- **Firebase Setup:** Added the Google Services plugin and Firebase dependencies.
- **Package Rename:** Renamed the app to **Coconut Wireless Network** and the package ID to `com.thecoconutwirelessnetwork.app`.
- **Git Integration:** Initialized a Git repository and pushed to [GitHub](https://github.com/cameronmar/coconutwireless-android-app).

## Verification
- **Build Status:** ✅ **SUCCESSFUL**. The `google-services.json` has been added, and the app compiles perfectly.
- **Firebase:** The app is now fully connected to your Firebase project.

## Next Steps
- **Play Store:** Start the process of creating a Google Play Developer account.
