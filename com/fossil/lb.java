package com.fossil;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

@TargetApi(14)
public class lb {

    static class C3811a extends SingleLineTransformationMethod {
        private Locale Sq;

        public C3811a(Context context) {
            this.Sq = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            return transformation != null ? transformation.toString().toUpperCase(this.Sq) : null;
        }
    }

    public static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new C3811a(textView.getContext()));
    }
}
