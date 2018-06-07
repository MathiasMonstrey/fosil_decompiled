package com.fossil.wearables.fsl.codeword;

import android.content.Context;
import android.util.Log;
import com.fossil.wearables.fsl.shared.BaseDbProvider;
import com.fossil.wearables.fsl.shared.UpgradeCommand;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodeWordProviderImpl extends BaseDbProvider implements CodeWordProvider {
    public static final String DB_NAME = "codeword.db";
    private List<WordGroup> cache;

    class C41761 extends HashMap<Integer, UpgradeCommand> {
        C41761() {
        }
    }

    public CodeWordProviderImpl(Context context, String str) {
        super(context, str);
    }

    protected int getDbVersion() {
        return 1;
    }

    protected Class<?>[] getDbEntities() {
        return new Class[]{WordGroup.class, Word.class};
    }

    protected Map<Integer, UpgradeCommand> getDbUpgrades() {
        return new C41761();
    }

    private Dao<WordGroup, Integer> getWordGroupDao() throws SQLException {
        return this.databaseHelper.getDao(WordGroup.class);
    }

    private Dao<Word, Integer> getWordDao() throws SQLException {
        return this.databaseHelper.getDao(Word.class);
    }

    public String getDbPath() {
        return this.databaseHelper.getDbPath();
    }

    public List<WordGroup> getAllWordGroups() {
        SQLException e;
        List<WordGroup> queryForAll;
        try {
            if (this.isCacheDirty) {
                Log.d(this.TAG, "Cache miss in code words :(");
                queryForAll = getWordGroupDao().queryForAll();
                try {
                    Log.d(this.TAG, "New word group is " + queryForAll);
                    if (queryForAll == null) {
                        return new ArrayList();
                    }
                    this.cache = queryForAll;
                    this.isCacheDirty = false;
                    return queryForAll;
                } catch (SQLException e2) {
                    e = e2;
                    e.printStackTrace();
                    return queryForAll;
                }
            }
            Log.d(this.TAG, "We have a cache hit in code words! Yay!");
            return this.cache;
        } catch (SQLException e3) {
            SQLException sQLException = e3;
            queryForAll = null;
            e = sQLException;
            e.printStackTrace();
            return queryForAll;
        }
    }

    public List<Word> getWordsThatContainString(String str) {
        Log.d(this.TAG, "Looking for code words in: " + str);
        List<Word> arrayList = new ArrayList();
        List allWordGroups = getAllWordGroups();
        if (allWordGroups != null) {
            for (int i = 0; i < allWordGroups.size(); i++) {
                WordGroup wordGroup = (WordGroup) allWordGroups.get(i);
                if (wordGroup == null || !wordGroup.isEnabled()) {
                    Log.e(this.TAG, "Word group is null!");
                } else {
                    arrayList.addAll(wordGroup.containsString(str));
                }
            }
        }
        Log.d(this.TAG, "Found " + arrayList.size() + " code words");
        return arrayList;
    }

    public WordGroup getWordGroup(int i) {
        try {
            return (WordGroup) getWordGroupDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void removeWordGroup(WordGroup wordGroup) {
        setCacheToDirty();
        if (wordGroup != null) {
            try {
                for (Word removeWord : wordGroup.getWords()) {
                    removeWord(removeWord);
                }
                getWordGroupDao().delete((Object) wordGroup);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWordGroup(WordGroup wordGroup) {
        setCacheToDirty();
        if (wordGroup != null) {
            try {
                WordGroup wordGroup2 = (WordGroup) getWordGroupDao().queryForSameId(wordGroup);
                if (wordGroup2 != null) {
                    wordGroup.setDbRowId(wordGroup2.getDbRowId());
                }
                getWordGroupDao().createOrUpdate(wordGroup);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveWord(Word word) {
        setCacheToDirty();
        if (word != null) {
            try {
                QueryBuilder queryBuilder = getWordDao().queryBuilder();
                queryBuilder.where().eq("value", word.getValue());
                List query = getWordDao().query(queryBuilder.prepare());
                if (query != null && query.size() > 0) {
                    Word word2 = (Word) query.get(0);
                    if (word2 != null) {
                        word.setDbRowId(word2.getDbRowId());
                    }
                }
                getWordDao().createOrUpdate(word);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeAllWordGroups() {
        setCacheToDirty();
        for (WordGroup removeWordGroup : getAllWordGroups()) {
            removeWordGroup(removeWordGroup);
        }
    }

    public void removeWord(Word word) {
        setCacheToDirty();
        if (word != null) {
            try {
                getWordDao().delete((Object) word);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Word getWord(int i) {
        try {
            return (Word) getWordDao().queryForId(Integer.valueOf(i));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Word> getWords(int i) {
        List<Word> arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = getWordDao().queryBuilder();
            queryBuilder.where().eq("word_group_id", Integer.valueOf(i));
            arrayList = getWordDao().query(queryBuilder.prepare());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
