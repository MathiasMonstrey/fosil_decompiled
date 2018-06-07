package com.fossil;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.sina.weibo.sdk.exception.WeiboException;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class dsx {
    private static final String TAG = dsx.class.getName();
    private static dsx dqP;
    private String dqQ;
    private volatile ReentrantLock dqR = new ReentrantLock(true);
    private dsu dqS;
    private dss dqT;
    private Context mContext;

    static class C3182a {
        public static SharedPreferences cK(Context context) {
            return context.getSharedPreferences("com_sina_weibo_sdk", 0);
        }

        public static long m9652a(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("frequency_get_cmd", 3600000);
            }
            return 3600000;
        }

        public static void m9653a(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null && j > 0) {
                Editor edit = sharedPreferences.edit();
                edit.putLong("frequency_get_cmd", j);
                edit.commit();
            }
        }

        public static long m9654b(Context context, SharedPreferences sharedPreferences) {
            if (sharedPreferences != null) {
                return sharedPreferences.getLong("last_time_get_cmd", 0);
            }
            return 0;
        }

        public static void m9655b(Context context, SharedPreferences sharedPreferences, long j) {
            if (sharedPreferences != null) {
                Editor edit = sharedPreferences.edit();
                edit.putLong("last_time_get_cmd", j);
                edit.commit();
            }
        }
    }

    private dsx(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.dqS = new dsu(this.mContext);
        this.dqT = new dss(this.mContext);
        this.dqQ = str;
    }

    public static synchronized dsx m9656L(Context context, String str) {
        dsx com_fossil_dsx;
        synchronized (dsx.class) {
            if (dqP == null) {
                dqP = new dsx(context, str);
            }
            com_fossil_dsx = dqP;
        }
        return com_fossil_dsx;
    }

    public void awO() {
        final SharedPreferences cK = C3182a.cK(this.mContext);
        if (System.currentTimeMillis() - C3182a.m9654b(this.mContext, cK) < C3182a.m9652a(this.mContext, cK)) {
            duj.m9772v(TAG, String.format("it's only %d ms from last time get cmd", new Object[]{Long.valueOf(r4)}));
            return;
        }
        new Thread(new Runnable(this) {
            final /* synthetic */ dsx dqU;

            public void run() {
                WeiboException weiboException;
                Throwable th;
                duj.m9772v(dsx.TAG, "mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                if (this.dqU.dqR.tryLock()) {
                    dsw com_fossil_dsw = null;
                    try {
                        dsw com_fossil_dsw2;
                        String N = dsx.m9657M(this.dqU.mContext, this.dqU.dqQ);
                        if (N != null) {
                            com_fossil_dsw2 = new dsw(dug.ke(N));
                            try {
                                this.dqU.ar(com_fossil_dsw2.awM());
                                this.dqU.as(com_fossil_dsw2.awN());
                            } catch (WeiboException e) {
                                WeiboException weiboException2 = e;
                                com_fossil_dsw = com_fossil_dsw2;
                                weiboException = weiboException2;
                                try {
                                    duj.m9770e(dsx.TAG, weiboException.getMessage());
                                    this.dqU.dqR.unlock();
                                    if (com_fossil_dsw != null) {
                                        C3182a.m9653a(this.dqU.mContext, cK, (long) com_fossil_dsw.getFrequency());
                                        C3182a.m9655b(this.dqU.mContext, cK, System.currentTimeMillis());
                                    }
                                    duj.m9772v(dsx.TAG, "after unlock \n mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                                } catch (Throwable th2) {
                                    th = th2;
                                    this.dqU.dqR.unlock();
                                    if (com_fossil_dsw != null) {
                                        C3182a.m9653a(this.dqU.mContext, cK, (long) com_fossil_dsw.getFrequency());
                                        C3182a.m9655b(this.dqU.mContext, cK, System.currentTimeMillis());
                                    }
                                    duj.m9772v(dsx.TAG, "after unlock \n mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                Throwable th4 = th3;
                                com_fossil_dsw = com_fossil_dsw2;
                                th = th4;
                                this.dqU.dqR.unlock();
                                if (com_fossil_dsw != null) {
                                    C3182a.m9653a(this.dqU.mContext, cK, (long) com_fossil_dsw.getFrequency());
                                    C3182a.m9655b(this.dqU.mContext, cK, System.currentTimeMillis());
                                }
                                duj.m9772v(dsx.TAG, "after unlock \n mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                                throw th;
                            }
                        }
                        com_fossil_dsw2 = null;
                        this.dqU.dqR.unlock();
                        if (com_fossil_dsw2 != null) {
                            C3182a.m9653a(this.dqU.mContext, cK, (long) com_fossil_dsw2.getFrequency());
                            C3182a.m9655b(this.dqU.mContext, cK, System.currentTimeMillis());
                        }
                        duj.m9772v(dsx.TAG, "after unlock \n mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                    } catch (WeiboException e2) {
                        weiboException = e2;
                        duj.m9770e(dsx.TAG, weiboException.getMessage());
                        this.dqU.dqR.unlock();
                        if (com_fossil_dsw != null) {
                            C3182a.m9653a(this.dqU.mContext, cK, (long) com_fossil_dsw.getFrequency());
                            C3182a.m9655b(this.dqU.mContext, cK, System.currentTimeMillis());
                        }
                        duj.m9772v(dsx.TAG, "after unlock \n mLock.isLocked()--->" + this.dqU.dqR.isLocked());
                    }
                }
            }
        }).start();
    }

    private static String m9657M(Context context, String str) {
        String str2 = "http://api.weibo.cn/2/client/common_config";
        str2 = context.getPackageName();
        String T = duq.m9791T(context, str2);
        dtq com_fossil_dtq = new dtq(str);
        com_fossil_dtq.put("appkey", str);
        com_fossil_dtq.put("packagename", str2);
        com_fossil_dtq.put("key_hash", T);
        com_fossil_dtq.put("version", "0031405000");
        return dtn.m9733e(context, "http://api.weibo.cn/2/client/common_config", "GET", com_fossil_dtq);
    }

    private void ar(List<dsr> list) {
        if (list != null) {
            this.dqT.start();
            for (dsr b : list) {
                this.dqT.m9645b(b);
            }
            this.dqT.stop();
        }
    }

    private void as(List<dst> list) {
        if (list != null) {
            for (dst a : list) {
                this.dqS.m9651a(a);
            }
        }
    }
}
