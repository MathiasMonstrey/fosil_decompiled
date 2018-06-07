package com.fossil;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.HttpManager;

public class dtl {
    private Context mContext;

    static class C3189a<T> {
        private WeiboException dsl;
        private T result;

        public T getResult() {
            return this.result;
        }

        public WeiboException axq() {
            return this.dsl;
        }

        public C3189a(T t) {
            this.result = t;
        }

        public C3189a(WeiboException weiboException) {
            this.dsl = weiboException;
        }
    }

    static class C3190b extends AsyncTask<Void, Void, C3189a<String>> {
        private final String cxk;
        private final dtq dsm;
        private final String dsn;
        private final dto dso;
        private final Context mContext;

        protected /* synthetic */ Object doInBackground(Object... objArr) {
            return m9728d((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m9727a((C3189a) obj);
        }

        public C3190b(Context context, String str, dtq com_fossil_dtq, String str2, dto com_fossil_dto) {
            this.mContext = context;
            this.cxk = str;
            this.dsm = com_fossil_dtq;
            this.dsn = str2;
            this.dso = com_fossil_dto;
        }

        protected C3189a<String> m9728d(Void... voidArr) {
            try {
                return new C3189a(HttpManager.a(this.mContext, this.cxk, this.dsn, this.dsm));
            } catch (WeiboException e) {
                return new C3189a(e);
            }
        }

        protected void onPreExecute() {
        }

        protected void m9727a(C3189a<String> c3189a) {
            WeiboException axq = c3189a.axq();
            if (axq != null) {
                this.dso.mo2686a(axq);
            } else {
                this.dso.jP((String) c3189a.getResult());
            }
        }
    }

    public dtl(Context context) {
        this.mContext = context;
    }

    public void m9729a(String str, dtq com_fossil_dtq, String str2, dto com_fossil_dto) {
        dsx.m9656L(this.mContext, com_fossil_dtq.awy()).awO();
        new C3190b(this.mContext, str, com_fossil_dtq, str2, com_fossil_dto).execute(new Void[1]);
    }
}
