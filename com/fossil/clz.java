package com.fossil;

import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.microapp.ButtonMapping;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class clz {
    private static final String TAG = clz.class.getSimpleName();
    private String cxi;

    public clz(String str) {
        this.cxi = str.substring(0, 3);
    }

    public List<ButtonMapping> abx() {
        List<ButtonMapping> n;
        FileNotFoundException e;
        IOException e2;
        XmlPullParserException e3;
        ArrayList arrayList = new ArrayList();
        try {
            InputStream openRawResource = PortfolioApp.ZQ().getResources().openRawResource(R.raw.mapping_set_default);
            n = m7047n(openRawResource);
            try {
                openRawResource.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                return n;
            } catch (IOException e5) {
                e2 = e5;
                e2.printStackTrace();
                return n;
            } catch (XmlPullParserException e6) {
                e3 = e6;
                e3.printStackTrace();
                return n;
            }
        } catch (FileNotFoundException e7) {
            FileNotFoundException fileNotFoundException = e7;
            n = arrayList;
            e = fileNotFoundException;
            e.printStackTrace();
            return n;
        } catch (IOException e8) {
            IOException iOException = e8;
            n = arrayList;
            e2 = iOException;
            e2.printStackTrace();
            return n;
        } catch (XmlPullParserException e9) {
            XmlPullParserException xmlPullParserException = e9;
            n = arrayList;
            e3 = xmlPullParserException;
            e3.printStackTrace();
            return n;
        }
        return n;
    }

    public List m7047n(InputStream inputStream) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            newPullParser.setInput(inputStream, null);
            List a = m7045a(newPullParser);
            return a;
        } finally {
            inputStream.close();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List m7045a(org.xmlpull.v1.XmlPullParser r4) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r3 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r4.getEventType();
    L_0x0009:
        r2 = 1;
        if (r1 == r2) goto L_0x0038;
    L_0x000c:
        r2 = r4.getName();
        switch(r1) {
            case 2: goto L_0x0018;
            default: goto L_0x0013;
        };
    L_0x0013:
        r1 = r4.next();
        goto L_0x0009;
    L_0x0018:
        r1 = "sku";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x0013;
    L_0x0020:
        r1 = 0;
        r2 = "name";
        r1 = r4.getAttributeValue(r1, r2);
        if (r1 == 0) goto L_0x0013;
    L_0x0029:
        r2 = r3.cxi;
        r1 = r2.contains(r1);
        if (r1 == 0) goto L_0x0013;
    L_0x0031:
        r1 = r3.m7046b(r4);
        r0.addAll(r1);
    L_0x0038:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.clz.a(org.xmlpull.v1.XmlPullParser):java.util.List");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List m7046b(org.xmlpull.v1.XmlPullParser r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
        r5 = this;
        r4 = 0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r6.getEventType();
    L_0x000a:
        r2 = 1;
        if (r1 == r2) goto L_0x003e;
    L_0x000d:
        r2 = r6.getName();
        switch(r1) {
            case 2: goto L_0x0019;
            case 3: goto L_0x0036;
            default: goto L_0x0014;
        };
    L_0x0014:
        r1 = r6.next();
        goto L_0x000a;
    L_0x0019:
        r1 = "microappmapping";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x0014;
    L_0x0021:
        r1 = "button";
        r1 = r6.getAttributeValue(r4, r1);
        r2 = "appid";
        r2 = r6.getAttributeValue(r4, r2);
        r3 = new com.portfolio.platform.data.model.microapp.ButtonMapping;
        r3.<init>(r1, r2);
        r0.add(r3);
        goto L_0x0014;
    L_0x0036:
        r1 = "sku";
        r1 = r2.equals(r1);
        if (r1 == 0) goto L_0x0014;
    L_0x003e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.clz.b(org.xmlpull.v1.XmlPullParser):java.util.List");
    }
}
