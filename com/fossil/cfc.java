package com.fossil;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.ado;
import com.google.android.gms.measurement.AppMeasurement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class cfc {
    private static Bundle m6143a(bct com_fossil_bct) {
        return aj(com_fossil_bct.bqN, com_fossil_bct.bqO);
    }

    private static Object m6144a(bct com_fossil_bct, String str, cfb com_fossil_cfb) {
        Object newInstance;
        Throwable e;
        Object obj = null;
        try {
            Class cls = Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
            Bundle a = m6143a(com_fossil_bct);
            newInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
            try {
                cls.getField("mOrigin").set(newInstance, str);
                cls.getField("mCreationTimestamp").set(newInstance, Long.valueOf(com_fossil_bct.bqP));
                cls.getField("mName").set(newInstance, com_fossil_bct.bqN);
                cls.getField("mValue").set(newInstance, com_fossil_bct.bqO);
                if (!TextUtils.isEmpty(com_fossil_bct.bqQ)) {
                    obj = com_fossil_bct.bqQ;
                }
                cls.getField("mTriggerEventName").set(newInstance, obj);
                cls.getField("mTimedOutEventName").set(newInstance, !TextUtils.isEmpty(com_fossil_bct.bqW) ? com_fossil_bct.bqW : com_fossil_cfb.Wq());
                cls.getField("mTimedOutEventParams").set(newInstance, a);
                cls.getField("mTriggerTimeout").set(newInstance, Long.valueOf(com_fossil_bct.bqR));
                cls.getField("mTriggeredEventName").set(newInstance, !TextUtils.isEmpty(com_fossil_bct.bqU) ? com_fossil_bct.bqU : com_fossil_cfb.Wp());
                cls.getField("mTriggeredEventParams").set(newInstance, a);
                cls.getField("mTimeToLive").set(newInstance, Long.valueOf(com_fossil_bct.bqS));
                cls.getField("mExpiredEventName").set(newInstance, !TextUtils.isEmpty(com_fossil_bct.bqX) ? com_fossil_bct.bqX : com_fossil_cfb.Wr());
                cls.getField("mExpiredEventParams").set(newInstance, a);
            } catch (ClassNotFoundException e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (NoSuchMethodException e3) {
                e = e3;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (IllegalAccessException e4) {
                e = e4;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (InvocationTargetException e5) {
                e = e5;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (NoSuchFieldException e6) {
                e = e6;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            } catch (InstantiationException e7) {
                e = e7;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
                return newInstance;
            }
        } catch (ClassNotFoundException e8) {
            e = e8;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (NoSuchMethodException e9) {
            e = e9;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (IllegalAccessException e10) {
            e = e10;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (InvocationTargetException e11) {
            e = e11;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (NoSuchFieldException e12) {
            e = e12;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        } catch (InstantiationException e13) {
            e = e13;
            newInstance = null;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return newInstance;
        }
        return newInstance;
    }

    private static String m6145a(bct com_fossil_bct, cfb com_fossil_cfb) {
        return (com_fossil_bct == null || TextUtils.isEmpty(com_fossil_bct.bqV)) ? com_fossil_cfb.Ws() : com_fossil_bct.bqV;
    }

    private static List<Object> m6146a(AppMeasurement appMeasurement, String str) {
        List<Object> list;
        Throwable e;
        Object obj;
        ArrayList arrayList = new ArrayList();
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getConditionalUserProperties", new Class[]{String.class, String.class});
            declaredMethod.setAccessible(true);
            list = (List) declaredMethod.invoke(appMeasurement, new Object[]{str, ""});
        } catch (NoSuchMethodException e2) {
            e = e2;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        } catch (InvocationTargetException e4) {
            e = e4;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            obj = arrayList;
            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
            }
            return list;
        }
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            Log.v("FirebaseAbtUtil", new StringBuilder(String.valueOf(str).length() + 55).append("Number of currently set _Es for origin: ").append(str).append(" is ").append(list.size()).toString());
        }
        return list;
    }

    private static void m6147a(Context context, String str, String str2, String str3, String str4) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str5 = "FirebaseAbtUtil";
            String str6 = "_CE(experimentId) called by ";
            String valueOf = String.valueOf(str);
            Log.v(str5, valueOf.length() != 0 ? str6.concat(valueOf) : new String(str6));
        }
        if (bk(context)) {
            AppMeasurement bj = bj(context);
            try {
                Method declaredMethod = AppMeasurement.class.getDeclaredMethod("clearConditionalUserProperty", new Class[]{String.class, String.class, Bundle.class});
                declaredMethod.setAccessible(true);
                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str2).length() + 17) + String.valueOf(str3).length()).append("Clearing _E: [").append(str2).append(", ").append(str3).append("]").toString());
                }
                declaredMethod.invoke(bj, new Object[]{str2, str4, aj(str2, str3)});
            } catch (NoSuchMethodException e2) {
                e = e2;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (IllegalAccessException e3) {
                e = e3;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            } catch (InvocationTargetException e4) {
                e = e4;
                Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            }
        }
    }

    public static void m6148a(Context context, String str, byte[] bArr, cfb com_fossil_cfb, int i) {
        Throwable e;
        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
            String str2 = "FirebaseAbtUtil";
            String str3 = "_SE called by ";
            String valueOf = String.valueOf(str);
            Log.v(str2, valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3));
        }
        if (bk(context)) {
            AppMeasurement bj = bj(context);
            bct an = an(bArr);
            if (an != null) {
                try {
                    Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                    Object obj = null;
                    for (Object next : m6146a(bj, str)) {
                        Object next2;
                        String cD = cD(next2);
                        String cE = cE(next2);
                        long longValue = ((Long) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mCreationTimestamp").get(next2)).longValue();
                        if (an.bqN.equals(cD) && an.bqO.equals(cE)) {
                            if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 23) + String.valueOf(cE).length()).append("_E is already set. [").append(cD).append(", ").append(cE).append("]").toString());
                            }
                            obj = 1;
                        } else {
                            next2 = null;
                            bcs[] com_fossil_bcsArr = an.bqZ;
                            int length = com_fossil_bcsArr.length;
                            int i2 = 0;
                            while (i2 < length) {
                                if (com_fossil_bcsArr[i2].bqN.equals(cD)) {
                                    if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                        Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 33) + String.valueOf(cE).length()).append("_E is found in the _OE list. [").append(cD).append(", ").append(cE).append("]").toString());
                                    }
                                    next2 = 1;
                                    if (next2 != null) {
                                        continue;
                                    } else if (an.bqP > longValue) {
                                        if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                            Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 115) + String.valueOf(cE).length()).append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [").append(cD).append(", ").append(cE).append("]").toString());
                                        }
                                        m6147a(context, str, cD, cE, m6145a(an, com_fossil_cfb));
                                    } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                        Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 109) + String.valueOf(cE).length()).append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [").append(cD).append(", ").append(cE).append("]").toString());
                                    }
                                } else {
                                    i2++;
                                }
                            }
                            if (next2 != null) {
                                continue;
                            } else if (an.bqP > longValue) {
                                if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                    Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 115) + String.valueOf(cE).length()).append("Clearing _E as it was not in the _OE list, andits start time is older than the start time of the _E to be set. [").append(cD).append(", ").append(cE).append("]").toString());
                                }
                                m6147a(context, str, cD, cE, m6145a(an, com_fossil_cfb));
                            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                                Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(cD).length() + 109) + String.valueOf(cE).length()).append("_E was not found in the _OE list, but not clearing it as it has a new start time than the _E to be set.  [").append(cD).append(", ").append(cE).append("]").toString());
                            }
                        }
                    }
                    if (obj == null) {
                        m6149a(bj, context, str, an, com_fossil_cfb, 1);
                        return;
                    } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                        str2 = String.valueOf(an.bqN);
                        str3 = String.valueOf(an.bqO);
                        Log.v("FirebaseAbtUtil", new StringBuilder((String.valueOf(str2).length() + 44) + String.valueOf(str3).length()).append("_E is already set. Not setting it again [").append(str2).append(", ").append(str3).append("]").toString());
                        return;
                    } else {
                        return;
                    }
                } catch (ClassNotFoundException e2) {
                    e = e2;
                } catch (IllegalAccessException e3) {
                    e = e3;
                } catch (NoSuchFieldException e4) {
                    e = e4;
                }
            } else if (Log.isLoggable("FirebaseAbtUtil", 2)) {
                Log.v("FirebaseAbtUtil", "_SE failed; either _P was not set, or we couldn't deserialize the _P.");
                return;
            } else {
                return;
            }
        }
        return;
        Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m6149a(com.google.android.gms.measurement.AppMeasurement r7, android.content.Context r8, java.lang.String r9, com.fossil.bct r10, com.fossil.cfb r11, int r12) {
        /*
        r1 = 1;
        r2 = 2;
        r0 = "FirebaseAbtUtil";
        r0 = android.util.Log.isLoggable(r0, r2);
        if (r0 == 0) goto L_0x004b;
    L_0x000a:
        r0 = "FirebaseAbtUtil";
        r2 = r10.bqN;
        r2 = java.lang.String.valueOf(r2);
        r3 = r10.bqO;
        r3 = java.lang.String.valueOf(r3);
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r4 = r4 + 7;
        r5 = java.lang.String.valueOf(r3);
        r5 = r5.length();
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r4);
        r4 = "_SEI: ";
        r4 = r5.append(r4);
        r2 = r4.append(r2);
        r4 = " ";
        r2 = r2.append(r4);
        r2 = r2.append(r3);
        r2 = r2.toString();
        android.util.Log.v(r0, r2);
    L_0x004b:
        r0 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = m6146a(r7, r9);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r0 = m6150b(r7, r9);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = m6146a(r7, r9);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3.size();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r3 < r0) goto L_0x00af;
    L_0x0062:
        r0 = r10.bqY;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r0 == 0) goto L_0x012a;
    L_0x0066:
        r0 = r10.bqY;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
    L_0x0068:
        if (r0 != r1) goto L_0x012d;
    L_0x006a:
        r0 = 0;
        r0 = r2.get(r0);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = cD(r0);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r0 = cE(r0);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r3 == 0) goto L_0x00a8;
    L_0x0080:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4 + 38;
        r5 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = "Clearing _E due to overflow policy: [";
        r4 = r5.append(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.append(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = "]";
        r4 = r4.append(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
    L_0x00a8:
        r3 = m6145a(r10, r11);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        m6147a(r8, r9, r1, r0, r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
    L_0x00af:
        r0 = r2.iterator();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
    L_0x00b3:
        r1 = r0.hasNext();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r1 == 0) goto L_0x0180;
    L_0x00b9:
        r1 = r0.next();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = cD(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = cE(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r10.bqN;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r2.equals(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r3 == 0) goto L_0x00b3;
    L_0x00cd:
        r3 = r10.bqO;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r1.equals(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r3 != 0) goto L_0x00b3;
    L_0x00d5:
        r3 = "FirebaseAbtUtil";
        r4 = 2;
        r3 = android.util.Log.isLoggable(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r3 == 0) goto L_0x00b3;
    L_0x00de:
        r3 = "FirebaseAbtUtil";
        r4 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4 + 77;
        r5 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = r5.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4 + r5;
        r5 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5.<init>(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = "Clearing _E, as only one _V of the same _E can be set atany given time: [";
        r4 = r5.append(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = ", ";
        r4 = r4.append(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.append(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = "].";
        r4 = r4.append(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.toString();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        android.util.Log.v(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = m6145a(r10, r11);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        m6147a(r8, r9, r2, r1, r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        goto L_0x00b3;
    L_0x0121:
        r0 = move-exception;
    L_0x0122:
        r1 = "FirebaseAbtUtil";
        r2 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r1, r2, r0);
    L_0x0129:
        return;
    L_0x012a:
        r0 = r1;
        goto L_0x0068;
    L_0x012d:
        r0 = "FirebaseAbtUtil";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r0 == 0) goto L_0x0129;
    L_0x0136:
        r0 = "FirebaseAbtUtil";
        r1 = r10.bqN;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r10.bqO;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3 + 44;
        r4 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4.<init>(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = "_E won't be set due to overflow policy. [";
        r3 = r4.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = ", ";
        r1 = r1.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = "]";
        r1 = r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r1.toString();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        android.util.Log.v(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        goto L_0x0129;
    L_0x017e:
        r0 = move-exception;
        goto L_0x0122;
    L_0x0180:
        r1 = m6144a(r10, r9, r11);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r1 != 0) goto L_0x01db;
    L_0x0186:
        r0 = "FirebaseAbtUtil";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r0 == 0) goto L_0x0129;
    L_0x018f:
        r0 = "FirebaseAbtUtil";
        r1 = r10.bqN;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r10.bqO;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = java.lang.String.valueOf(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3 + 42;
        r4 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r4.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4.<init>(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = "Could not create _CUP for: [";
        r3 = r4.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r3.append(r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = ", ";
        r1 = r1.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = "]. Skipping.";
        r1 = r1.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r1 = r1.toString();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        android.util.Log.v(r0, r1);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        goto L_0x0129;
    L_0x01d8:
        r0 = move-exception;
        goto L_0x0122;
    L_0x01db:
        r0 = "FirebaseAbtUtil";
        r2 = 2;
        r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        if (r0 == 0) goto L_0x0244;
    L_0x01e4:
        r0 = "FirebaseAbtUtil";
        r2 = r10.bqN;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = r10.bqO;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = java.lang.String.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = r10.bqQ;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = java.lang.String.valueOf(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = r5.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = r5 + 27;
        r6 = java.lang.String.valueOf(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r6 = r6.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = r5 + r6;
        r6 = java.lang.String.valueOf(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r6 = r6.length();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = r5 + r6;
        r6 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r6.<init>(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = "Setting _CUP for _E: [";
        r5 = r6.append(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r5.append(r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r5 = ", ";
        r2 = r2.append(r5);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = ", ";
        r2 = r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r2.append(r4);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r3 = "]";
        r2 = r2.append(r3);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        r2 = r2.toString();	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        android.util.Log.v(r0, r2);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
    L_0x0244:
        r0 = "com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty";
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r2 = com.google.android.gms.measurement.AppMeasurement.class;
        r3 = "setConditionalUserProperty";
        r4 = 1;
        r4 = new java.lang.Class[r4];	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r5 = 0;
        r4[r5] = r0;	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r0 = 1;
        r2.setAccessible(r0);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r0 = r10.bqT;	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        if (r0 != 0) goto L_0x0282;
    L_0x0264:
        r0 = r10.bqT;	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
    L_0x0266:
        r3 = m6143a(r10);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r7.logEventInternal(r9, r0, r3);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r3 = 0;
        r0[r3] = r1;	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        r2.invoke(r7, r0);	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        goto L_0x0129;
    L_0x0278:
        r0 = move-exception;
    L_0x0279:
        r1 = "FirebaseAbtUtil";
        r2 = "Could not complete the operation due to an internal error.";
        android.util.Log.e(r1, r2, r0);	 Catch:{ ClassNotFoundException -> 0x0121, IllegalAccessException -> 0x017e, NoSuchFieldException -> 0x01d8 }
        goto L_0x0129;
    L_0x0282:
        r0 = r11.Wo();	 Catch:{ ClassNotFoundException -> 0x0278, NoSuchMethodException -> 0x0289, IllegalAccessException -> 0x0287, InvocationTargetException -> 0x028b, NoSuchFieldException -> 0x01d8 }
        goto L_0x0266;
    L_0x0287:
        r0 = move-exception;
        goto L_0x0279;
    L_0x0289:
        r0 = move-exception;
        goto L_0x0279;
    L_0x028b:
        r0 = move-exception;
        goto L_0x0279;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cfc.a(com.google.android.gms.measurement.AppMeasurement, android.content.Context, java.lang.String, com.fossil.bct, com.fossil.cfb, int):void");
    }

    private static Bundle aj(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(str, str2);
        return bundle;
    }

    private static bct an(byte[] bArr) {
        try {
            return bct.ag(bArr);
        } catch (ado e) {
            return null;
        }
    }

    private static int m6150b(AppMeasurement appMeasurement, String str) {
        Throwable e;
        try {
            Method declaredMethod = AppMeasurement.class.getDeclaredMethod("getMaxUserProperties", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(appMeasurement, new Object[]{str})).intValue();
        } catch (NoSuchMethodException e2) {
            e = e2;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        } catch (IllegalAccessException e3) {
            e = e3;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        } catch (InvocationTargetException e4) {
            e = e4;
            Log.e("FirebaseAbtUtil", "Could not complete the operation due to an internal error.", e);
            return 20;
        }
    }

    private static AppMeasurement bj(Context context) {
        try {
            return AppMeasurement.getInstance(context);
        } catch (NoClassDefFoundError e) {
            return null;
        }
    }

    private static boolean bk(Context context) {
        if (bj(context) != null) {
            try {
                Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty");
                return true;
            } catch (ClassNotFoundException e) {
                if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
                    return false;
                }
                Log.v("FirebaseAbtUtil", "Firebase Analytics library is missing support for abt. Please update to a more recent version.");
                return false;
            }
        } else if (!Log.isLoggable("FirebaseAbtUtil", 2)) {
            return false;
        } else {
            Log.v("FirebaseAbtUtil", "Firebase Analytics not available");
            return false;
        }
    }

    private static String cD(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mName").get(obj);
    }

    private static String cE(Object obj) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        return (String) Class.forName("com.google.android.gms.measurement.AppMeasurement$ConditionalUserProperty").getField("mValue").get(obj);
    }
}
