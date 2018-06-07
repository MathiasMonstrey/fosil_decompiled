package com.fossil;

import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window.Callback;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class qb implements Callback {
    final Callback aeT;

    public qb(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.aeT = callback;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.aeT.dispatchKeyEvent(keyEvent);
    }

    @TargetApi(11)
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.aeT.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.aeT.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.aeT.dispatchTrackballEvent(motionEvent);
    }

    @TargetApi(12)
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.aeT.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.aeT.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public View onCreatePanelView(int i) {
        return this.aeT.onCreatePanelView(i);
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.aeT.onCreatePanelMenu(i, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.aeT.onPreparePanel(i, view, menu);
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.aeT.onMenuOpened(i, menu);
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.aeT.onMenuItemSelected(i, menuItem);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.aeT.onWindowAttributesChanged(layoutParams);
    }

    public void onContentChanged() {
        this.aeT.onContentChanged();
    }

    public void onWindowFocusChanged(boolean z) {
        this.aeT.onWindowFocusChanged(z);
    }

    public void onAttachedToWindow() {
        this.aeT.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        this.aeT.onDetachedFromWindow();
    }

    public void onPanelClosed(int i, Menu menu) {
        this.aeT.onPanelClosed(i, menu);
    }

    @TargetApi(23)
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.aeT.onSearchRequested(searchEvent);
    }

    public boolean onSearchRequested() {
        return this.aeT.onSearchRequested();
    }

    @TargetApi(11)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.aeT.onWindowStartingActionMode(callback);
    }

    @TargetApi(23)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return this.aeT.onWindowStartingActionMode(callback, i);
    }

    @TargetApi(11)
    public void onActionModeStarted(ActionMode actionMode) {
        this.aeT.onActionModeStarted(actionMode);
    }

    @TargetApi(11)
    public void onActionModeFinished(ActionMode actionMode) {
        this.aeT.onActionModeFinished(actionMode);
    }

    @TargetApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
        this.aeT.onProvideKeyboardShortcuts(list, menu, i);
    }
}
