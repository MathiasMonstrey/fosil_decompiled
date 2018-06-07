package com.fossil;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public interface ayr {
    void m4704a(Activity activity, Bundle bundle, Bundle bundle2);

    void onCreate(Bundle bundle);

    View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void onDestroy();

    void onDestroyView();

    void onLowMemory();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();
}
