package com.fossil;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import java.util.List;

public final class bwg {
    public static CharSequence m5733a(String str, List<bwb> list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        CharSequence spannableString = new SpannableString(str);
        for (bwb com_fossil_bwb : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), com_fossil_bwb.Qz, com_fossil_bwb.mLength + com_fossil_bwb.Qz, 0);
        }
        return spannableString;
    }
}
