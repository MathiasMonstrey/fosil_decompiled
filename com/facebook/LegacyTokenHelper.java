package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class LegacyTokenHelper {
    public static final String APPLICATION_ID_KEY = "com.facebook.TokenCachingStrategy.ApplicationId";
    public static final String DECLINED_PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.DeclinedPermissions";
    public static final String DEFAULT_CACHE_KEY = "com.facebook.SharedPreferencesTokenCachingStrategy.DEFAULT_KEY";
    public static final String EXPIRATION_DATE_KEY = "com.facebook.TokenCachingStrategy.ExpirationDate";
    private static final long INVALID_BUNDLE_MILLISECONDS = Long.MIN_VALUE;
    private static final String IS_SSO_KEY = "com.facebook.TokenCachingStrategy.IsSSO";
    private static final String JSON_VALUE = "value";
    private static final String JSON_VALUE_ENUM_TYPE = "enumType";
    private static final String JSON_VALUE_TYPE = "valueType";
    public static final String LAST_REFRESH_DATE_KEY = "com.facebook.TokenCachingStrategy.LastRefreshDate";
    public static final String PERMISSIONS_KEY = "com.facebook.TokenCachingStrategy.Permissions";
    private static final String TAG = LegacyTokenHelper.class.getSimpleName();
    public static final String TOKEN_KEY = "com.facebook.TokenCachingStrategy.Token";
    public static final String TOKEN_SOURCE_KEY = "com.facebook.TokenCachingStrategy.AccessTokenSource";
    private static final String TYPE_BOOLEAN = "bool";
    private static final String TYPE_BOOLEAN_ARRAY = "bool[]";
    private static final String TYPE_BYTE = "byte";
    private static final String TYPE_BYTE_ARRAY = "byte[]";
    private static final String TYPE_CHAR = "char";
    private static final String TYPE_CHAR_ARRAY = "char[]";
    private static final String TYPE_DOUBLE = "double";
    private static final String TYPE_DOUBLE_ARRAY = "double[]";
    private static final String TYPE_ENUM = "enum";
    private static final String TYPE_FLOAT = "float";
    private static final String TYPE_FLOAT_ARRAY = "float[]";
    private static final String TYPE_INTEGER = "int";
    private static final String TYPE_INTEGER_ARRAY = "int[]";
    private static final String TYPE_LONG = "long";
    private static final String TYPE_LONG_ARRAY = "long[]";
    private static final String TYPE_SHORT = "short";
    private static final String TYPE_SHORT_ARRAY = "short[]";
    private static final String TYPE_STRING = "string";
    private static final String TYPE_STRING_LIST = "stringList";
    private SharedPreferences cache;
    private String cacheKey;

    public LegacyTokenHelper(Context context) {
        this(context, null);
    }

    public LegacyTokenHelper(Context context, String str) {
        Validate.notNull(context, "context");
        if (Utility.isNullOrEmpty(str)) {
            str = DEFAULT_CACHE_KEY;
        }
        this.cacheKey = str;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        this.cache = context.getSharedPreferences(this.cacheKey, 0);
    }

    public Bundle load() {
        Bundle bundle = new Bundle();
        for (String str : this.cache.getAll().keySet()) {
            try {
                deserializeKey(str, bundle);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error reading cached value for key: '" + str + "' -- " + e);
                return null;
            }
        }
        return bundle;
    }

    public void save(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        Editor edit = this.cache.edit();
        for (String str : bundle.keySet()) {
            try {
                serializeKey(str, bundle, edit);
            } catch (JSONException e) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error processing value for key: '" + str + "' -- " + e);
                return;
            }
        }
        edit.apply();
    }

    public void clear() {
        this.cache.edit().clear().apply();
    }

    public static boolean hasTokenInformation(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(TOKEN_KEY);
        if (string == null || string.length() == 0 || bundle.getLong(EXPIRATION_DATE_KEY, 0) == 0) {
            return false;
        }
        return true;
    }

    public static String getToken(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(TOKEN_KEY);
    }

    public static void putToken(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(str, JSON_VALUE);
        bundle.putString(TOKEN_KEY, str);
    }

    public static Date getExpirationDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, EXPIRATION_DATE_KEY);
    }

    public static void putExpirationDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, JSON_VALUE);
        putDate(bundle, EXPIRATION_DATE_KEY, date);
    }

    public static long getExpirationMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(EXPIRATION_DATE_KEY);
    }

    public static void putExpirationMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(EXPIRATION_DATE_KEY, j);
    }

    public static Set<String> getPermissions(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        Collection stringArrayList = bundle.getStringArrayList(PERMISSIONS_KEY);
        if (stringArrayList == null) {
            return null;
        }
        return new HashSet(stringArrayList);
    }

    public static void putPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, JSON_VALUE);
        bundle.putStringArrayList(PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static void putDeclinedPermissions(Bundle bundle, Collection<String> collection) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(collection, JSON_VALUE);
        bundle.putStringArrayList(DECLINED_PERMISSIONS_KEY, new ArrayList(collection));
    }

    public static AccessTokenSource getSource(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        if (bundle.containsKey(TOKEN_SOURCE_KEY)) {
            return (AccessTokenSource) bundle.getSerializable(TOKEN_SOURCE_KEY);
        }
        return bundle.getBoolean(IS_SSO_KEY) ? AccessTokenSource.FACEBOOK_APPLICATION_WEB : AccessTokenSource.WEB_VIEW;
    }

    public static void putSource(Bundle bundle, AccessTokenSource accessTokenSource) {
        Validate.notNull(bundle, "bundle");
        bundle.putSerializable(TOKEN_SOURCE_KEY, accessTokenSource);
    }

    public static Date getLastRefreshDate(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return getDate(bundle, LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshDate(Bundle bundle, Date date) {
        Validate.notNull(bundle, "bundle");
        Validate.notNull(date, JSON_VALUE);
        putDate(bundle, LAST_REFRESH_DATE_KEY, date);
    }

    public static long getLastRefreshMilliseconds(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getLong(LAST_REFRESH_DATE_KEY);
    }

    public static void putLastRefreshMilliseconds(Bundle bundle, long j) {
        Validate.notNull(bundle, "bundle");
        bundle.putLong(LAST_REFRESH_DATE_KEY, j);
    }

    public static String getApplicationId(Bundle bundle) {
        Validate.notNull(bundle, "bundle");
        return bundle.getString(APPLICATION_ID_KEY);
    }

    public static void putApplicationId(Bundle bundle, String str) {
        Validate.notNull(bundle, "bundle");
        bundle.putString(APPLICATION_ID_KEY, str);
    }

    static Date getDate(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        long j = bundle.getLong(str, INVALID_BUNDLE_MILLISECONDS);
        if (j != INVALID_BUNDLE_MILLISECONDS) {
            return new Date(j);
        }
        return null;
    }

    static void putDate(Bundle bundle, String str, Date date) {
        bundle.putLong(str, date.getTime());
    }

    private void serializeKey(String str, Bundle bundle, Editor editor) throws JSONException {
        Object obj = null;
        int i = 0;
        Object obj2 = bundle.get(str);
        if (obj2 != null) {
            JSONObject jSONObject = new JSONObject();
            String str2;
            if (obj2 instanceof Byte) {
                str2 = TYPE_BYTE;
                jSONObject.put(JSON_VALUE, ((Byte) obj2).intValue());
                obj2 = null;
                obj = str2;
            } else if (obj2 instanceof Short) {
                str2 = TYPE_SHORT;
                jSONObject.put(JSON_VALUE, ((Short) obj2).intValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Integer) {
                str2 = TYPE_INTEGER;
                jSONObject.put(JSON_VALUE, ((Integer) obj2).intValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Long) {
                str2 = TYPE_LONG;
                jSONObject.put(JSON_VALUE, ((Long) obj2).longValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Float) {
                str2 = TYPE_FLOAT;
                jSONObject.put(JSON_VALUE, ((Float) obj2).doubleValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Double) {
                str2 = TYPE_DOUBLE;
                jSONObject.put(JSON_VALUE, ((Double) obj2).doubleValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Boolean) {
                str2 = TYPE_BOOLEAN;
                jSONObject.put(JSON_VALUE, ((Boolean) obj2).booleanValue());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Character) {
                str2 = TYPE_CHAR;
                jSONObject.put(JSON_VALUE, obj2.toString());
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof String) {
                str2 = TYPE_STRING;
                jSONObject.put(JSON_VALUE, (String) obj2);
                obj2 = null;
                r1 = str2;
            } else if (obj2 instanceof Enum) {
                str2 = TYPE_ENUM;
                jSONObject.put(JSON_VALUE, obj2.toString());
                jSONObject.put(JSON_VALUE_ENUM_TYPE, obj2.getClass().getName());
                obj2 = null;
                r1 = str2;
            } else {
                JSONArray jSONArray = new JSONArray();
                int length;
                JSONArray jSONArray2;
                if (obj2 instanceof byte[]) {
                    obj = TYPE_BYTE_ARRAY;
                    byte[] bArr = (byte[]) obj2;
                    length = bArr.length;
                    while (i < length) {
                        jSONArray.put(bArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof short[]) {
                    obj = TYPE_SHORT_ARRAY;
                    short[] sArr = (short[]) obj2;
                    length = sArr.length;
                    while (i < length) {
                        jSONArray.put(sArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof int[]) {
                    obj = TYPE_INTEGER_ARRAY;
                    int[] iArr = (int[]) obj2;
                    length = iArr.length;
                    while (i < length) {
                        jSONArray.put(iArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof long[]) {
                    obj = TYPE_LONG_ARRAY;
                    long[] jArr = (long[]) obj2;
                    length = jArr.length;
                    while (i < length) {
                        jSONArray.put(jArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof float[]) {
                    obj = TYPE_FLOAT_ARRAY;
                    float[] fArr = (float[]) obj2;
                    length = fArr.length;
                    while (i < length) {
                        jSONArray.put((double) fArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof double[]) {
                    obj = TYPE_DOUBLE_ARRAY;
                    double[] dArr = (double[]) obj2;
                    length = dArr.length;
                    while (i < length) {
                        jSONArray.put(dArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof boolean[]) {
                    obj = TYPE_BOOLEAN_ARRAY;
                    boolean[] zArr = (boolean[]) obj2;
                    length = zArr.length;
                    while (i < length) {
                        jSONArray.put(zArr[i]);
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof char[]) {
                    obj = TYPE_CHAR_ARRAY;
                    char[] cArr = (char[]) obj2;
                    length = cArr.length;
                    while (i < length) {
                        jSONArray.put(String.valueOf(cArr[i]));
                        i++;
                    }
                    jSONArray2 = jSONArray;
                } else if (obj2 instanceof List) {
                    obj = TYPE_STRING_LIST;
                    for (Object obj22 : (List) obj22) {
                        if (obj22 == null) {
                            obj22 = JSONObject.NULL;
                        }
                        jSONArray.put(obj22);
                    }
                    jSONArray2 = jSONArray;
                } else {
                    obj22 = null;
                }
            }
            if (obj != null) {
                jSONObject.put(JSON_VALUE_TYPE, obj);
                if (obj22 != null) {
                    jSONObject.putOpt(JSON_VALUE, obj22);
                }
                editor.putString(str, jSONObject.toString());
            }
        }
    }

    private void deserializeKey(String str, Bundle bundle) throws JSONException {
        int i = 0;
        JSONObject jSONObject = new JSONObject(this.cache.getString(str, "{}"));
        String string = jSONObject.getString(JSON_VALUE_TYPE);
        if (string.equals(TYPE_BOOLEAN)) {
            bundle.putBoolean(str, jSONObject.getBoolean(JSON_VALUE));
        } else if (string.equals(TYPE_BOOLEAN_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            boolean[] zArr = new boolean[r1.length()];
            while (i < zArr.length) {
                zArr[i] = r1.getBoolean(i);
                i++;
            }
            bundle.putBooleanArray(str, zArr);
        } else if (string.equals(TYPE_BYTE)) {
            bundle.putByte(str, (byte) jSONObject.getInt(JSON_VALUE));
        } else if (string.equals(TYPE_BYTE_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            byte[] bArr = new byte[r1.length()];
            while (i < bArr.length) {
                bArr[i] = (byte) r1.getInt(i);
                i++;
            }
            bundle.putByteArray(str, bArr);
        } else if (string.equals(TYPE_SHORT)) {
            bundle.putShort(str, (short) jSONObject.getInt(JSON_VALUE));
        } else if (string.equals(TYPE_SHORT_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            short[] sArr = new short[r1.length()];
            while (i < sArr.length) {
                sArr[i] = (short) r1.getInt(i);
                i++;
            }
            bundle.putShortArray(str, sArr);
        } else if (string.equals(TYPE_INTEGER)) {
            bundle.putInt(str, jSONObject.getInt(JSON_VALUE));
        } else if (string.equals(TYPE_INTEGER_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            int[] iArr = new int[r1.length()];
            while (i < iArr.length) {
                iArr[i] = r1.getInt(i);
                i++;
            }
            bundle.putIntArray(str, iArr);
        } else if (string.equals(TYPE_LONG)) {
            bundle.putLong(str, jSONObject.getLong(JSON_VALUE));
        } else if (string.equals(TYPE_LONG_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            long[] jArr = new long[r1.length()];
            while (i < jArr.length) {
                jArr[i] = r1.getLong(i);
                i++;
            }
            bundle.putLongArray(str, jArr);
        } else if (string.equals(TYPE_FLOAT)) {
            bundle.putFloat(str, (float) jSONObject.getDouble(JSON_VALUE));
        } else if (string.equals(TYPE_FLOAT_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            float[] fArr = new float[r1.length()];
            while (i < fArr.length) {
                fArr[i] = (float) r1.getDouble(i);
                i++;
            }
            bundle.putFloatArray(str, fArr);
        } else if (string.equals(TYPE_DOUBLE)) {
            bundle.putDouble(str, jSONObject.getDouble(JSON_VALUE));
        } else if (string.equals(TYPE_DOUBLE_ARRAY)) {
            r1 = jSONObject.getJSONArray(JSON_VALUE);
            double[] dArr = new double[r1.length()];
            while (i < dArr.length) {
                dArr[i] = r1.getDouble(i);
                i++;
            }
            bundle.putDoubleArray(str, dArr);
        } else if (string.equals(TYPE_CHAR)) {
            string = jSONObject.getString(JSON_VALUE);
            if (string != null && string.length() == 1) {
                bundle.putChar(str, string.charAt(0));
            }
        } else if (string.equals(TYPE_CHAR_ARRAY)) {
            r2 = jSONObject.getJSONArray(JSON_VALUE);
            char[] cArr = new char[r2.length()];
            for (r1 = 0; r1 < cArr.length; r1++) {
                String string2 = r2.getString(r1);
                if (string2 != null && string2.length() == 1) {
                    cArr[r1] = string2.charAt(0);
                }
            }
            bundle.putCharArray(str, cArr);
        } else if (string.equals(TYPE_STRING)) {
            bundle.putString(str, jSONObject.getString(JSON_VALUE));
        } else if (string.equals(TYPE_STRING_LIST)) {
            r2 = jSONObject.getJSONArray(JSON_VALUE);
            int length = r2.length();
            ArrayList arrayList = new ArrayList(length);
            for (r1 = 0; r1 < length; r1++) {
                Object obj = r2.get(r1);
                if (obj == JSONObject.NULL) {
                    obj = null;
                } else {
                    String str2 = (String) obj;
                }
                arrayList.add(r1, obj);
            }
            bundle.putStringArrayList(str, arrayList);
        } else if (string.equals(TYPE_ENUM)) {
            try {
                bundle.putSerializable(str, Enum.valueOf(Class.forName(jSONObject.getString(JSON_VALUE_ENUM_TYPE)), jSONObject.getString(JSON_VALUE)));
            } catch (ClassNotFoundException e) {
            } catch (IllegalArgumentException e2) {
            }
        }
    }
}
