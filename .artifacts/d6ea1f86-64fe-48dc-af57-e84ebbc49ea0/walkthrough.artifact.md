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

### Infrastructure
- **Firebase Setup:** Added the Google Services plugin and Firebase dependencies to the project.

## ⚠️ Action Required
To complete the setup and enable push notifications, you must:
1. Create a project in the [Firebase Console](https://console.firebase.google.com/).
2. Add an Android app with the package name `com.example.coconutwirelessapp`.
3. Download the `google-services.json` file.
4. **Copy the file into the `app/` folder** of your project in Android Studio.

## Verification
- The project structure is ready.
- The build will succeed once the `google-services.json` file is added.
