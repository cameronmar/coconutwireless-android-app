# Implementation Plan - Convert to Full-screen WebView App

Convert the existing multi-fragment navigation app into a full-screen WebView wrapper for `www.thecoconutwirelessnetwork.com`.

## Proposed Changes

### Configuration
#### [MODIFY] [AndroidManifest.xml](file:///C:/Users/camer/AndroidStudioProjects/CoconutWirelessApp/app/src/main/AndroidManifest.xml)
- Add `android.permission.INTERNET` permission.
- Ensure the app can load the website securely.

### Layouts
#### [MODIFY] [activity_main.xml](file:///C:/Users/camer/AndroidStudioProjects/CoconutWirelessApp/app/src/main/res/layout/activity_main.xml)
- Simplify to a single container or directly host the WebView if preferred.
- I'll simplify it to just include `content_main` without the drawer logic.

#### [MODIFY] [app_bar_main.xml](file:///C:/Users/camer/AndroidStudioProjects/CoconutWirelessApp/app/src/main/res/layout/app_bar_main.xml)
- Remove `Toolbar` and `AppBarLayout` to achieve a true full-screen experience.
- Remove `FloatingActionButton`.

#### [MODIFY] [content_main.xml](file:///C:/Users/camer/AndroidStudioProjects/CoconutWirelessApp/app/src/main/res/layout/content_main.xml)
- Replace `NavHostFragment` and `BottomNavigationView` with a `WebView`.

### Code
#### [MODIFY] [MainActivity.kt](file:///C:/Users/camer/AndroidStudioProjects/CoconutWirelessApp/app/src/main/java/com/example/coconutwirelessapp/MainActivity.kt)
- Remove all navigation-related code (Drawer, BottomNav, NavController).
- Initialize and configure the `WebView`:
    - Enable JavaScript.
    - Set `WebViewClient` to open links inside the app.
    - Load `https://www.thecoconutwirelessnetwork.com`.
- Handle the hardware "Back" button to navigate back in web history instead of closing the app.

## Verification Plan

### Manual Verification
- Deploy to an Android device/emulator.
- Verify the website loads successfully.
- Verify that clicking links stays within the app.
- Verify the back button works for web history.
- Verify there are no Android UI elements (drawer, toolbar) visible.
