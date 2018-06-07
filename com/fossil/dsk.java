package com.fossil;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class dsk {
    private static final String TAG = dsk.class.getName();
    private static final Uri dpY = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
    private static dsk dpZ;
    private Context mContext;

    public static class C3178a {
        private String bhE;
        private int dqa;

        private void setPackageName(String str) {
            this.bhE = str;
        }

        public String getPackageName() {
            return this.bhE;
        }

        private void ms(int i) {
            this.dqa = i;
        }

        public int awv() {
            return this.dqa;
        }

        public boolean aww() {
            if (TextUtils.isEmpty(this.bhE) || this.dqa <= 0) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.bhE + ", supportApi = " + this.dqa;
        }
    }

    private dsk(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static synchronized dsk cF(Context context) {
        dsk com_fossil_dsk;
        synchronized (dsk.class) {
            if (dpZ == null) {
                dpZ = new dsk(context);
            }
            com_fossil_dsk = dpZ;
        }
        return com_fossil_dsk;
    }

    public synchronized C3178a awu() {
        return cG(this.mContext);
    }

    private C3178a cG(Context context) {
        Object obj = 1;
        C3178a cH = cH(context);
        C3178a cI = cI(context);
        Object obj2 = cH != null ? 1 : null;
        if (cI == null) {
            obj = null;
        }
        if (obj2 == null || obj == null) {
            if (obj2 != null) {
                return cH;
            }
            if (obj != null) {
                return cI;
            }
            return null;
        } else if (cH.awv() >= cI.awv()) {
            return cH;
        } else {
            return cI;
        }
    }

    private C3178a cH(Context context) {
        Cursor query;
        Exception e;
        Throwable th;
        try {
            query = context.getContentResolver().query(dpY, null, null, null, null);
            if (query == null) {
                if (query != null) {
                    query.close();
                }
                return null;
            }
            try {
                int columnIndex = query.getColumnIndex("support_api");
                int columnIndex2 = query.getColumnIndex("package");
                if (query.moveToFirst()) {
                    int i = -1;
                    try {
                        columnIndex = Integer.parseInt(query.getString(columnIndex));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                        columnIndex = i;
                    }
                    String string = query.getString(columnIndex2);
                    if (!TextUtils.isEmpty(string) && dsi.m9619H(context, string)) {
                        C3178a c3178a = new C3178a();
                        c3178a.setPackageName(string);
                        c3178a.ms(columnIndex);
                        if (query == null) {
                            return c3178a;
                        }
                        query.close();
                        return c3178a;
                    }
                }
                if (query != null) {
                    query.close();
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    duj.m9770e(TAG, e.getMessage());
                    if (query != null) {
                        query.close();
                    }
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
            return null;
        } catch (Exception e4) {
            e = e4;
            query = null;
            duj.m9770e(TAG, e.getMessage());
            if (query != null) {
                query.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    private C3178a cI(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            return null;
        }
        C3178a c3178a = null;
        for (ResolveInfo resolveInfo : queryIntentServices) {
            if (!(resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))) {
                C3178a jz = jz(resolveInfo.serviceInfo.applicationInfo.packageName);
                if (jz != null) {
                    if (c3178a == null) {
                        c3178a = jz;
                    } else if (c3178a.awv() < jz.awv()) {
                        c3178a = jz;
                    }
                }
            }
        }
        return c3178a;
    }

    public C3178a jz(String str) {
        InputStream open;
        IOException e;
        NameNotFoundException e2;
        JSONException e3;
        Exception e4;
        Throwable th;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] bArr = new byte[4096];
            open = this.mContext.createPackageContext(str, 2).getAssets().open("weibo_for_sdk.json");
            try {
                StringBuilder stringBuilder = new StringBuilder();
                while (true) {
                    int read = open.read(bArr, 0, 4096);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read));
                }
                if (!TextUtils.isEmpty(stringBuilder.toString()) && dsi.m9619H(this.mContext, str)) {
                    int optInt = new JSONObject(stringBuilder.toString()).optInt("support_api", -1);
                    C3178a c3178a = new C3178a();
                    c3178a.setPackageName(str);
                    c3178a.ms(optInt);
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e5) {
                            duj.m9770e(TAG, e5.getMessage());
                        }
                    }
                    return c3178a;
                } else if (open == null) {
                    return null;
                } else {
                    try {
                        open.close();
                        return null;
                    } catch (IOException e6) {
                        duj.m9770e(TAG, e6.getMessage());
                        return null;
                    }
                }
            } catch (NameNotFoundException e7) {
                e2 = e7;
            } catch (IOException e8) {
                e6 = e8;
            } catch (JSONException e9) {
                e3 = e9;
            } catch (Exception e10) {
                e4 = e10;
            }
        } catch (NameNotFoundException e11) {
            e2 = e11;
            open = null;
            try {
                duj.m9770e(TAG, e2.getMessage());
                if (open == null) {
                    return null;
                }
                try {
                    open.close();
                    return null;
                } catch (IOException e62) {
                    duj.m9770e(TAG, e62.getMessage());
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (open != null) {
                    try {
                        open.close();
                    } catch (IOException e622) {
                        duj.m9770e(TAG, e622.getMessage());
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e622 = e12;
            open = null;
            duj.m9770e(TAG, e622.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e6222) {
                duj.m9770e(TAG, e6222.getMessage());
                return null;
            }
        } catch (JSONException e13) {
            e3 = e13;
            open = null;
            duj.m9770e(TAG, e3.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e62222) {
                duj.m9770e(TAG, e62222.getMessage());
                return null;
            }
        } catch (Exception e14) {
            e4 = e14;
            open = null;
            duj.m9770e(TAG, e4.getMessage());
            if (open == null) {
                return null;
            }
            try {
                open.close();
                return null;
            } catch (IOException e622222) {
                duj.m9770e(TAG, e622222.getMessage());
                return null;
            }
        } catch (Throwable th3) {
            open = null;
            th = th3;
            if (open != null) {
                open.close();
            }
            throw th;
        }
    }
}
