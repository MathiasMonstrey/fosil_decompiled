package com.fossil;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.misfit.frameworks.common.constants.Constants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class rc extends DataSetObservable {
    static final String LOG_TAG = rc.class.getSimpleName();
    private static final Object ajk = new Object();
    private static final Map<String, rc> ajl = new HashMap();
    private final Object ajm = new Object();
    private final List<C4033a> ajn = new ArrayList();
    private final List<C4036d> ajo = new ArrayList();
    final String ajp;
    private C4034b ajq = new C4035c(this);
    private int ajr = 50;
    boolean ajs = true;
    private boolean ajt = false;
    private boolean aju = true;
    private boolean ajv = false;
    private C4037e ajw;
    final Context mContext;
    private Intent mIntent;

    public final class C4033a implements Comparable<C4033a> {
        final /* synthetic */ rc ajx;
        public final ResolveInfo resolveInfo;
        public float weight;

        public /* synthetic */ int compareTo(Object obj) {
            return m13273a((C4033a) obj);
        }

        public C4033a(rc rcVar, ResolveInfo resolveInfo) {
            this.ajx = rcVar;
            this.resolveInfo = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.weight) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(((C4033a) obj).weight)) {
                return false;
            }
            return true;
        }

        public int m13273a(C4033a c4033a) {
            return Float.floatToIntBits(c4033a.weight) - Float.floatToIntBits(this.weight);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.resolveInfo.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C4034b {
        void mo4067a(Intent intent, List<C4033a> list, List<C4036d> list2);
    }

    final class C4035c implements C4034b {
        final /* synthetic */ rc ajx;
        private final Map<ComponentName, C4033a> ajy = new HashMap();

        C4035c(rc rcVar) {
            this.ajx = rcVar;
        }

        public void mo4067a(Intent intent, List<C4033a> list, List<C4036d> list2) {
            Map map = this.ajy;
            map.clear();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C4033a c4033a = (C4033a) list.get(i);
                c4033a.weight = 0.0f;
                map.put(new ComponentName(c4033a.resolveInfo.activityInfo.packageName, c4033a.resolveInfo.activityInfo.name), c4033a);
            }
            float f = 1.0f;
            int size2 = list2.size() - 1;
            while (size2 >= 0) {
                float f2;
                C4036d c4036d = (C4036d) list2.get(size2);
                C4033a c4033a2 = (C4033a) map.get(c4036d.ajz);
                if (c4033a2 != null) {
                    c4033a2.weight = (c4036d.weight * f) + c4033a2.weight;
                    f2 = 0.95f * f;
                } else {
                    f2 = f;
                }
                size2--;
                f = f2;
            }
            Collections.sort(list);
        }
    }

    public static final class C4036d {
        public final ComponentName ajz;
        public final long time;
        public final float weight;

        public C4036d(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public C4036d(ComponentName componentName, long j, float f) {
            this.ajz = componentName;
            this.time = j;
            this.weight = f;
        }

        public int hashCode() {
            return (((((this.ajz == null ? 0 : this.ajz.hashCode()) + 31) * 31) + ((int) (this.time ^ (this.time >>> 32)))) * 31) + Float.floatToIntBits(this.weight);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C4036d c4036d = (C4036d) obj;
            if (this.ajz == null) {
                if (c4036d.ajz != null) {
                    return false;
                }
            } else if (!this.ajz.equals(c4036d.ajz)) {
                return false;
            }
            if (this.time != c4036d.time) {
                return false;
            }
            if (Float.floatToIntBits(this.weight) != Float.floatToIntBits(c4036d.weight)) {
                return false;
            }
            return true;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.ajz);
            stringBuilder.append("; time:").append(this.time);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.weight));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    public interface C4037e {
        boolean m13276a(rc rcVar, Intent intent);
    }

    final class C4038f extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ rc ajx;

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m13277a(objArr);
        }

        C4038f(rc rcVar) {
            this.ajx = rcVar;
        }

        public Void m13277a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.ajx.mContext.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C4036d c4036d = (C4036d) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, Constants.ACTIVITY, c4036d.ajz.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c4036d.time));
                        newSerializer.attribute(null, Constants.PROFILE_KEY_UNITS_WEIGHT, String.valueOf(c4036d.weight));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.ajx.ajs = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(rc.LOG_TAG, "Error writing historical record file: " + this.ajx.ajp, e2);
                    this.ajx.ajs = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(rc.LOG_TAG, "Error writing historical record file: " + this.ajx.ajp, e22);
                    this.ajx.ajs = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(rc.LOG_TAG, "Error writing historical record file: " + this.ajx.ajp, e222);
                    this.ajx.ajs = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.ajx.ajs = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(rc.LOG_TAG, "Error writing historical record file: " + str, e2222);
            }
            return null;
        }
    }

    public static rc m13279d(Context context, String str) {
        rc rcVar;
        synchronized (ajk) {
            rcVar = (rc) ajl.get(str);
            if (rcVar == null) {
                rcVar = new rc(context, str);
                ajl.put(str, rcVar);
            }
        }
        return rcVar;
    }

    private rc(Context context, String str) {
        this.mContext = context.getApplicationContext();
        if (TextUtils.isEmpty(str) || str.endsWith(".xml")) {
            this.ajp = str;
        } else {
            this.ajp = str + ".xml";
        }
    }

    public void setIntent(Intent intent) {
        synchronized (this.ajm) {
            if (this.mIntent == intent) {
                return;
            }
            this.mIntent = intent;
            this.ajv = true;
            nV();
        }
    }

    public int nS() {
        int size;
        synchronized (this.ajm) {
            nV();
            size = this.ajn.size();
        }
        return size;
    }

    public ResolveInfo cG(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.ajm) {
            nV();
            resolveInfo = ((C4033a) this.ajn.get(i)).resolveInfo;
        }
        return resolveInfo;
    }

    public int m13280a(ResolveInfo resolveInfo) {
        synchronized (this.ajm) {
            nV();
            List list = this.ajn;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C4033a) list.get(i)).resolveInfo == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent cH(int i) {
        synchronized (this.ajm) {
            if (this.mIntent == null) {
                return null;
            }
            nV();
            C4033a c4033a = (C4033a) this.ajn.get(i);
            ComponentName componentName = new ComponentName(c4033a.resolveInfo.activityInfo.packageName, c4033a.resolveInfo.activityInfo.name);
            Intent intent = new Intent(this.mIntent);
            intent.setComponent(componentName);
            if (this.ajw != null) {
                if (this.ajw.m13276a(this, new Intent(intent))) {
                    return null;
                }
            }
            m13278a(new C4036d(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public void m13281a(C4037e c4037e) {
        synchronized (this.ajm) {
            this.ajw = c4037e;
        }
    }

    public ResolveInfo nT() {
        synchronized (this.ajm) {
            nV();
            if (this.ajn.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C4033a) this.ajn.get(0)).resolveInfo;
            return resolveInfo;
        }
    }

    public void cI(int i) {
        synchronized (this.ajm) {
            float f;
            nV();
            C4033a c4033a = (C4033a) this.ajn.get(i);
            C4033a c4033a2 = (C4033a) this.ajn.get(0);
            if (c4033a2 != null) {
                f = (c4033a2.weight - c4033a.weight) + 5.0f;
            } else {
                f = 1.0f;
            }
            m13278a(new C4036d(new ComponentName(c4033a.resolveInfo.activityInfo.packageName, c4033a.resolveInfo.activityInfo.name), System.currentTimeMillis(), f));
        }
    }

    private void nU() {
        if (!this.ajt) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.aju) {
            this.aju = false;
            if (!TextUtils.isEmpty(this.ajp)) {
                ir.a(new C4038f(this), new Object[]{new ArrayList(this.ajo), this.ajp});
            }
        }
    }

    public int getHistorySize() {
        int size;
        synchronized (this.ajm) {
            nV();
            size = this.ajo.size();
        }
        return size;
    }

    private void nV() {
        int nX = nX() | nY();
        nZ();
        if (nX != 0) {
            nW();
            notifyChanged();
        }
    }

    private boolean nW() {
        if (this.ajq == null || this.mIntent == null || this.ajn.isEmpty() || this.ajo.isEmpty()) {
            return false;
        }
        this.ajq.mo4067a(this.mIntent, this.ajn, Collections.unmodifiableList(this.ajo));
        return true;
    }

    private boolean nX() {
        if (!this.ajv || this.mIntent == null) {
            return false;
        }
        this.ajv = false;
        this.ajn.clear();
        List queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(this.mIntent, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.ajn.add(new C4033a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean nY() {
        if (!this.ajs || !this.aju || TextUtils.isEmpty(this.ajp)) {
            return false;
        }
        this.ajs = false;
        this.ajt = true;
        oa();
        return true;
    }

    private boolean m13278a(C4036d c4036d) {
        boolean add = this.ajo.add(c4036d);
        if (add) {
            this.aju = true;
            nZ();
            nU();
            nW();
            notifyChanged();
        }
        return add;
    }

    private void nZ() {
        int size = this.ajo.size() - this.ajr;
        if (size > 0) {
            this.aju = true;
            for (int i = 0; i < size; i++) {
                C4036d c4036d = (C4036d) this.ajo.remove(0);
            }
        }
    }

    private void oa() {
        try {
            InputStream openFileInput = this.mContext.openFileInput(this.ajp);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i = 0;
                while (i != 1 && i != 2) {
                    i = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List list = this.ajo;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            break;
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C4036d(newPullParser.getAttributeValue(null, Constants.ACTIVITY), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, Constants.PROFILE_KEY_UNITS_WEIGHT))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                            return;
                        } catch (IOException e) {
                            return;
                        }
                    }
                    return;
                }
                throw new XmlPullParserException("Share records file does not start with historical-records tag.");
            } catch (Throwable e2) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + this.ajp, e2);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + this.ajp, e22);
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e5) {
                    }
                }
            }
        } catch (FileNotFoundException e6) {
        }
    }
}
