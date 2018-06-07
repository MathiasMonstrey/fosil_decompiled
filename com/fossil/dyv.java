package com.fossil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import com.fossil.dyf.C3293a;
import com.fossil.dyf.C3294b;
import com.j256.ormlite.field.FieldType;
import com.misfit.frameworks.buttonservice.db.DataFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class dyv implements SharedPreferences {
    private final ContentResolver dBf;
    private final String[] dBg = new String[]{FieldType.FOREIGN_ID_FIELD_SUFFIX, DataFile.COLUMN_KEY, "type", "value"};
    private final HashMap<String, Object> dBh = new HashMap();
    private C3308a dBi = null;

    static class C3308a implements Editor {
        private ContentResolver dBf;
        private Set<String> dBj = new HashSet();
        private boolean dBk = false;
        private Map<String, Object> values = new HashMap();

        public C3308a(ContentResolver contentResolver) {
            this.dBf = contentResolver;
        }

        public void apply() {
        }

        public Editor clear() {
            this.dBk = true;
            return this;
        }

        public boolean commit() {
            ContentValues contentValues = new ContentValues();
            if (this.dBk) {
                this.dBf.delete(C3294b.CONTENT_URI, null, null);
                this.dBk = false;
            }
            for (String str : this.dBj) {
                this.dBf.delete(C3294b.CONTENT_URI, "key = ?", new String[]{str});
            }
            for (Entry value : this.values.entrySet()) {
                int i;
                boolean z;
                Object value2 = value.getValue();
                if (value2 == null) {
                    dyc.m10282x("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, null value");
                    i = 0;
                } else if (value2 instanceof Integer) {
                    i = 1;
                } else if (value2 instanceof Long) {
                    i = 2;
                } else if (value2 instanceof String) {
                    i = 3;
                } else if (value2 instanceof Boolean) {
                    i = 4;
                } else if (value2 instanceof Float) {
                    i = 5;
                } else if (value2 instanceof Double) {
                    i = 6;
                } else {
                    dyc.m10282x("MicroMsg.SDK.PluginProvider.Resolver", "unresolve failed, unknown type=" + value2.getClass().toString());
                    i = 0;
                }
                if (i == 0) {
                    z = false;
                } else {
                    contentValues.put("type", Integer.valueOf(i));
                    contentValues.put("value", value2.toString());
                    z = true;
                }
                if (z) {
                    this.dBf.update(C3294b.CONTENT_URI, contentValues, "key = ?", new String[]{(String) value.getKey()});
                }
            }
            return true;
        }

        public Editor putBoolean(String str, boolean z) {
            this.values.put(str, Boolean.valueOf(z));
            this.dBj.remove(str);
            return this;
        }

        public Editor putFloat(String str, float f) {
            this.values.put(str, Float.valueOf(f));
            this.dBj.remove(str);
            return this;
        }

        public Editor putInt(String str, int i) {
            this.values.put(str, Integer.valueOf(i));
            this.dBj.remove(str);
            return this;
        }

        public Editor putLong(String str, long j) {
            this.values.put(str, Long.valueOf(j));
            this.dBj.remove(str);
            return this;
        }

        public Editor putString(String str, String str2) {
            this.values.put(str, str2);
            this.dBj.remove(str);
            return this;
        }

        public Editor putStringSet(String str, Set<String> set) {
            return null;
        }

        public Editor remove(String str) {
            this.dBj.add(str);
            return this;
        }
    }

    public dyv(Context context) {
        this.dBf = context.getContentResolver();
    }

    private Object getValue(String str) {
        try {
            Cursor query = this.dBf.query(C3294b.CONTENT_URI, this.dBg, "key = ?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            Object x = query.moveToFirst() ? C3293a.m10286x(query.getInt(query.getColumnIndex("type")), query.getString(query.getColumnIndex("value"))) : null;
            query.close();
            return x;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean contains(String str) {
        return getValue(str) != null;
    }

    public Editor edit() {
        if (this.dBi == null) {
            this.dBi = new C3308a(this.dBf);
        }
        return this.dBi;
    }

    public Map<String, ?> getAll() {
        try {
            Cursor query = this.dBf.query(C3294b.CONTENT_URI, this.dBg, null, null, null);
            if (query == null) {
                return null;
            }
            int columnIndex = query.getColumnIndex(DataFile.COLUMN_KEY);
            int columnIndex2 = query.getColumnIndex("type");
            int columnIndex3 = query.getColumnIndex("value");
            while (query.moveToNext()) {
                this.dBh.put(query.getString(columnIndex), C3293a.m10286x(query.getInt(columnIndex2), query.getString(columnIndex3)));
            }
            query.close();
            return this.dBh;
        } catch (Exception e) {
            e.printStackTrace();
            return this.dBh;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Boolean)) ? z : ((Boolean) value).booleanValue();
    }

    public float getFloat(String str, float f) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Float)) ? f : ((Float) value).floatValue();
    }

    public int getInt(String str, int i) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Integer)) ? i : ((Integer) value).intValue();
    }

    public long getLong(String str, long j) {
        Object value = getValue(str);
        return (value == null || !(value instanceof Long)) ? j : ((Long) value).longValue();
    }

    public String getString(String str, String str2) {
        Object value = getValue(str);
        return (value == null || !(value instanceof String)) ? str2 : (String) value;
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        return null;
    }

    public void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }
}
