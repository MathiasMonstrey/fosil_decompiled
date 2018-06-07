package com.fossil.wearables.fsl.codeword;

import com.fossil.wearables.fsl.BaseProvider;
import java.util.List;

public interface CodeWordProvider extends BaseProvider {
    List<WordGroup> getAllWordGroups();

    Word getWord(int i);

    WordGroup getWordGroup(int i);

    List<Word> getWords(int i);

    List<Word> getWordsThatContainString(String str);

    void removeAllWordGroups();

    void removeWord(Word word);

    void removeWordGroup(WordGroup wordGroup);

    void saveWord(Word word);

    void saveWordGroup(WordGroup wordGroup);
}
