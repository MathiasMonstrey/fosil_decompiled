package com.fossil;

import android.annotation.TargetApi;
import android.view.KeyEvent;

@TargetApi(11)
class kh {
    public static int normalizeMetaState(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean metaStateHasModifiers(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean metaStateHasNoModifiers(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }

    public static boolean m11965c(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }
}
