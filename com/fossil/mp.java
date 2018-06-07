package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(14)
class mp {
    public static Object ar(Object obj) {
        return AccessibilityNodeInfo.obtain((AccessibilityNodeInfo) obj);
    }

    public static void m12576b(Object obj, int i) {
        ((AccessibilityNodeInfo) obj).addAction(i);
    }

    public static void m12586f(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).addChild(view);
    }

    public static int as(Object obj) {
        return ((AccessibilityNodeInfo) obj).getActions();
    }

    public static void m12577b(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInParent(rect);
    }

    public static void m12579c(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).getBoundsInScreen(rect);
    }

    public static CharSequence at(Object obj) {
        return ((AccessibilityNodeInfo) obj).getClassName();
    }

    public static CharSequence au(Object obj) {
        return ((AccessibilityNodeInfo) obj).getContentDescription();
    }

    public static CharSequence av(Object obj) {
        return ((AccessibilityNodeInfo) obj).getPackageName();
    }

    public static CharSequence aw(Object obj) {
        return ((AccessibilityNodeInfo) obj).getText();
    }

    public static boolean ax(Object obj) {
        return ((AccessibilityNodeInfo) obj).isCheckable();
    }

    public static boolean ay(Object obj) {
        return ((AccessibilityNodeInfo) obj).isChecked();
    }

    public static boolean az(Object obj) {
        return ((AccessibilityNodeInfo) obj).isClickable();
    }

    public static boolean aA(Object obj) {
        return ((AccessibilityNodeInfo) obj).isEnabled();
    }

    public static boolean aB(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocusable();
    }

    public static boolean aC(Object obj) {
        return ((AccessibilityNodeInfo) obj).isFocused();
    }

    public static boolean aD(Object obj) {
        return ((AccessibilityNodeInfo) obj).isLongClickable();
    }

    public static boolean aE(Object obj) {
        return ((AccessibilityNodeInfo) obj).isPassword();
    }

    public static boolean aF(Object obj) {
        return ((AccessibilityNodeInfo) obj).isScrollable();
    }

    public static boolean aG(Object obj) {
        return ((AccessibilityNodeInfo) obj).isSelected();
    }

    public static void m12581d(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInParent(rect);
    }

    public static void m12583e(Object obj, Rect rect) {
        ((AccessibilityNodeInfo) obj).setBoundsInScreen(rect);
    }

    public static void m12575a(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setCheckable(z);
    }

    public static void m12578b(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setChecked(z);
    }

    public static void m12584e(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setClassName(charSequence);
    }

    public static void m12580c(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setClickable(z);
    }

    public static void m12587f(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setContentDescription(charSequence);
    }

    public static void m12582d(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setEnabled(z);
    }

    public static void m12585e(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocusable(z);
    }

    public static void m12588f(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setFocused(z);
    }

    public static void m12591g(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setLongClickable(z);
    }

    public static void m12590g(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setPackageName(charSequence);
    }

    public static void m12589g(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setParent(view);
    }

    public static void m12594h(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setScrollable(z);
    }

    public static void m12595i(Object obj, boolean z) {
        ((AccessibilityNodeInfo) obj).setSelected(z);
    }

    public static void m12592h(Object obj, View view) {
        ((AccessibilityNodeInfo) obj).setSource(view);
    }

    public static void m12593h(Object obj, CharSequence charSequence) {
        ((AccessibilityNodeInfo) obj).setText(charSequence);
    }

    public static void aH(Object obj) {
        ((AccessibilityNodeInfo) obj).recycle();
    }
}
