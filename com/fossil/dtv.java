package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.sina.weibo.sdk.component.view.TitleBar;
import com.sina.weibo.sdk.register.mobile.Country;
import com.sina.weibo.sdk.register.mobile.CountryList;
import com.sina.weibo.sdk.register.mobile.LetterIndexBar;
import com.sina.weibo.sdk.register.mobile.LetterIndexBar.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class dtv extends Activity implements a {
    private ListView ZS;
    private FrameLayout dpH;
    private LetterIndexBar dtg;
    private List<Country>[] dth;
    private List<Country> dti;
    String dtj = "";
    private CountryList dtk;
    private List<C3203b> dtl = new ArrayList();
    private C3202a dtm;
    private RelativeLayout dtn;

    class C32001 implements TitleBar.a {
        final /* synthetic */ dtv dto;

        C32001(dtv com_fossil_dtv) {
            this.dto = com_fossil_dtv;
        }

        public void axp() {
            this.dto.setResult(0);
            this.dto.finish();
        }
    }

    class C32012 implements OnItemClickListener {
        final /* synthetic */ dtv dto;

        C32012(dtv com_fossil_dtv) {
            this.dto = com_fossil_dtv;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Country country = (Country) this.dto.dtm.getItem(i);
            if (country != null) {
                Intent intent = new Intent();
                intent.putExtra("code", country.getCode());
                intent.putExtra("name", country.getName());
                this.dto.setResult(-1, intent);
                this.dto.finish();
            }
        }
    }

    class C3202a extends BaseAdapter {
        final /* synthetic */ dtv dto;

        private C3202a(dtv com_fossil_dtv) {
            this.dto = com_fossil_dtv;
        }

        public int getCount() {
            if (this.dto.dtl != null) {
                return this.dto.dtl.size();
            }
            return 0;
        }

        public Object getItem(int i) {
            if (this.dto.dtl == null || this.dto.dtl.isEmpty()) {
                return null;
            }
            if (i == this.dto.dtl.size()) {
                return null;
            }
            C3203b c3203b = (C3203b) this.dto.dtl.get(i);
            if (c3203b.dtr == -1) {
                return null;
            }
            return this.dto.dth[c3203b.dtq].get(c3203b.dtr);
        }

        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C3203b c3203b = (C3203b) this.dto.dtl.get(i);
            Country country;
            if (view == null) {
                if (c3203b.dtr == -1) {
                    return mw(c3203b.dtq);
                }
                country = (Country) this.dto.dth[c3203b.dtq].get(c3203b.dtr);
                return new dtw(this.dto, country.getName(), country.getCode());
            } else if (c3203b.dtr != -1) {
                country = (Country) this.dto.dth[c3203b.dtq].get(c3203b.dtr);
                if (view instanceof dtx) {
                    return new dtw(this.dto, country.getName(), country.getCode());
                }
                ((dtw) view).aP(country.getName(), country.getCode());
                return view;
            } else if (!(view instanceof dtx)) {
                return mw(c3203b.dtq);
            } else {
                if (c3203b.dtq != 0) {
                    return mw(c3203b.dtq);
                }
                ((dtx) view).kc(dum.m9779c(this.dto, "Common", "常用", "常用"));
                return view;
            }
        }

        private dtx mw(int i) {
            dtx com_fossil_dtx = new dtx(this.dto.getApplicationContext());
            if (i == 0) {
                com_fossil_dtx.setTitle(dum.m9779c(this.dto, "Common", "常用", "常用"));
            } else {
                com_fossil_dtx.setTitle(String.valueOf((char) ((i + 65) - 1)));
            }
            return com_fossil_dtx;
        }
    }

    class C3203b {
        final /* synthetic */ dtv dto;
        int dtq;
        int dtr;

        C3203b(dtv com_fossil_dtv, int i, int i2) {
            this.dto = com_fossil_dtv;
            this.dtq = i;
            this.dtr = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C3203b) || this.dtr != -1) {
                return false;
            }
            C3203b c3203b = (C3203b) obj;
            if (this.dtq == c3203b.dtq && this.dtr == c3203b.dtr) {
                return true;
            }
            return false;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        avf();
    }

    private void avf() {
        this.dtn = new RelativeLayout(this);
        this.dtn.setLayoutParams(new LayoutParams(-1, -1));
        View titleBar = new TitleBar(this);
        titleBar.setId(1);
        titleBar.setLeftBtnBg(dum.m9782g((Context) this, "weibosdk_navigationbar_back.png", "weibosdk_navigationbar_back_highlighted.png"));
        titleBar.setTitleBarText(dum.m9779c(this, "Region", "选择国家", "選擇國家"));
        titleBar.setTitleBarClickListener(new C32001(this));
        this.dtn.addView(titleBar);
        this.dpH = new FrameLayout(this);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        layoutParams.addRule(3, titleBar.getId());
        this.dpH.setLayoutParams(layoutParams);
        this.dtn.addView(this.dpH);
        this.ZS = new ListView(this);
        this.ZS.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        this.ZS.setFadingEdgeLength(0);
        this.ZS.setSelector(new ColorDrawable(0));
        this.ZS.setDividerHeight(dum.m9773I(this, 1));
        this.ZS.setCacheColorHint(0);
        this.ZS.setDrawSelectorOnTop(false);
        this.ZS.setScrollingCacheEnabled(false);
        this.ZS.setScrollbarFadingEnabled(false);
        this.ZS.setVerticalScrollBarEnabled(false);
        this.ZS.setOnItemClickListener(new C32012(this));
        this.dpH.addView(this.ZS);
        this.dtm = new C3202a();
        this.ZS.setAdapter(this.dtm);
        this.dtg = new LetterIndexBar(this);
        this.dtg.setIndexChangeListener(this);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -1);
        layoutParams2.gravity = 5;
        this.dtg.setLayoutParams(layoutParams2);
        this.dpH.addView(this.dtg);
        dtu.cN(this);
        Locale language = dum.getLanguage();
        if (Locale.SIMPLIFIED_CHINESE.equals(language)) {
            this.dtj = dum.m9778S(this, "countryCode.txt");
        } else if (Locale.TRADITIONAL_CHINESE.equals(language)) {
            this.dtj = dum.m9778S(this, "countryCodeTw.txt");
        } else {
            this.dtj = dum.m9778S(this, "countryCodeEn.txt");
        }
        this.dtk = new CountryList(this.dtj);
        this.dti = this.dtk.countries;
        this.dth = at(this.dti);
        this.dtl = m9751a(this.dth);
        this.dtm.notifyDataSetChanged();
        setContentView(this.dtn);
    }

    protected void onPause() {
        super.onPause();
    }

    public void mv(int i) {
        if (this.dth != null && i < this.dth.length && this.dth[i] != null) {
            this.ZS.setSelection(this.dtl.indexOf(new C3203b(this, i, -1)));
        }
    }

    private List<Country>[] at(List<Country> list) {
        List[] listArr = new ArrayList[27];
        Country country = new Country();
        country.setCode(Country.CHINA_CODE);
        country.setName(dum.m9779c(this, "China", "中国", "中國"));
        listArr[0] = new ArrayList();
        listArr[0].add(country);
        for (int i = 0; i < list.size(); i++) {
            country = (Country) list.get(i);
            if (country.getCode().equals("00852") || country.getCode().equals("00853") || country.getCode().equals("00886")) {
                listArr[0].add(country);
            } else {
                int charAt = (country.getPinyin().charAt(0) - 97) + 1;
                if (listArr[charAt] == null) {
                    listArr[charAt] = new ArrayList();
                }
                listArr[charAt].add(country);
            }
        }
        return listArr;
    }

    private List<C3203b> m9751a(List<Country>[] listArr) {
        List<C3203b> arrayList = new ArrayList();
        if (listArr != null) {
            for (int i = 0; i < listArr.length; i++) {
                List list = listArr[i];
                if (list != null && list.size() > 0) {
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        if (i2 == 0) {
                            arrayList.add(new C3203b(this, i, -1));
                        }
                        arrayList.add(new C3203b(this, i, i2));
                    }
                }
            }
        }
        return arrayList;
    }

    protected void onDestroy() {
        super.onDestroy();
    }
}
