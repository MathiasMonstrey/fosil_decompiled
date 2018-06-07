package com.fossil;

import android.text.TextUtils;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import java.text.BreakIterator;

public class drh {
    public static CharSequence m9475x(CharSequence charSequence) {
        return charSequence != null ? charSequence.toString().toLowerCase() : null;
    }

    public static CharSequence m9476y(CharSequence charSequence) {
        return charSequence != null ? charSequence.toString().toUpperCase() : null;
    }

    public static CharSequence m9477z(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        String[] split = charSequence.toString().toLowerCase().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : split) {
            if (!str.isEmpty()) {
                stringBuilder.append(str.substring(0, 1).toUpperCase() + str.substring(1)).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    public static CharSequence m9473A(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        BreakIterator sentenceInstance = BreakIterator.getSentenceInstance();
        StringBuilder stringBuilder = new StringBuilder();
        String charSequence2 = charSequence.toString();
        sentenceInstance.setText(charSequence2);
        int first = sentenceInstance.first();
        for (int next = sentenceInstance.next(); next != -1; next = sentenceInstance.next()) {
            stringBuilder.append(charSequence2.substring(first, first + 1).toUpperCase()).append(charSequence2.substring(first + 1, next).toLowerCase());
            first = next;
        }
        return stringBuilder.toString();
    }

    public static CharSequence m9474B(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        String charSequence2 = charSequence.toString();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < charSequence2.length(); i++) {
            if (Character.isAlphabetic(charSequence2.charAt(i))) {
                stringBuilder.append(Character.toUpperCase(charSequence2.charAt(i)));
                stringBuilder.append(charSequence2.substring(i + 1, charSequence2.length()).toLowerCase());
                break;
            }
            stringBuilder.append(charSequence2.charAt(i));
        }
        return stringBuilder.toString();
    }
}
