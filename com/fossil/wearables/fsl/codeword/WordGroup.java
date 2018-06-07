package com.fossil.wearables.fsl.codeword;

import android.text.TextUtils;
import android.util.Log;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fossil.wearables.fsl.shared.BaseFeatureModel;
import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.ForeignCollectionField;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordGroup extends BaseFeatureModel {
    private static final Pattern LatinCharacterPattern = Pattern.compile("\\p{InBasic_Latin}+");
    private static final Pattern NonLatinCharacterPattern = Pattern.compile("[^\\p{InBasic_Latin}]+");
    private static final char[] charsToIgnore = new char[]{'!', '?', '\'', '\\', '\"', ';', ':', '.', ',', '‎', '‏'};
    private static final Pattern emojiPattern = Pattern.compile("[🀀-🏿]|[🐀-🟿]|[☀-⟿]", 66);
    @ForeignCollectionField(eager = true)
    private ForeignCollection<Word> words;

    public List<Word> getWords() {
        List<Word> arrayList = new ArrayList();
        if (this.words == null || this.words.size() <= 0) {
            return arrayList;
        }
        return new ArrayList(this.words);
    }

    public void setWords(ForeignCollection<Word> foreignCollection) {
        this.words = foreignCollection;
    }

    public List<Word> containsString(String str) {
        List<Word> arrayList = new ArrayList();
        List words = getWords();
        for (int i = 0; i < words.size(); i++) {
            Word word = (Word) words.get(i);
            if (codeWordIsInString(word.getValue(), str)) {
                arrayList.add(word);
            }
        }
        return arrayList;
    }

    public static final boolean isValidWord(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < charsToIgnore.length; i++) {
            if (str.indexOf(charsToIgnore[i]) != -1) {
                str = str.replace(Character.toString(charsToIgnore[i]), "");
            }
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true;
    }

    public static boolean codeWordIsInString(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < charsToIgnore.length; i++) {
            if (str2.indexOf(charsToIgnore[i]) != -1) {
                str2 = str2.replace(Character.toString(charsToIgnore[i]), "");
            }
            if (str.indexOf(charsToIgnore[i]) != -1) {
                str = str.replace(Character.toString(charsToIgnore[i]), "");
            }
        }
        if (str.isEmpty()) {
            return false;
        }
        if (emojiPattern.matcher(str).find()) {
            Log.i("WordGroup", "emoji found");
            return str2.contains(str);
        }
        if (LatinCharacterPattern.matcher(str).find()) {
            Log.i("WordGroup", "Latin found");
            String[] split = str2.split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            for (String equalsIgnoreCase : split) {
                if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                    return true;
                }
            }
        }
        if (!NonLatinCharacterPattern.matcher(str).find()) {
            return false;
        }
        Log.i("WordGroup", "Non Latin found");
        return str2.contains(str);
    }
}
