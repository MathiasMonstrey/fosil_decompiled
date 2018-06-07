package com.portfolio.platform.ui.shortcuts.details.secondtimezone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import com.fossil.diw;
import com.fossil.diw.a;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.data.model.microapp.SecondTimezone;
import com.portfolio.platform.view.FlexibleEditText;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class SearchSecondTimezoneActivity extends Activity implements OnClickListener {
    public static final String TAG = SearchSecondTimezoneActivity.class.getSimpleName();
    private FlexibleEditText cWI;
    private diw cWJ;
    private List<SecondTimezone> cWK;
    SecondTimezone cWL;

    class C49531 implements TextWatcher {
        final /* synthetic */ SearchSecondTimezoneActivity cWM;

        C49531(SearchSecondTimezoneActivity searchSecondTimezoneActivity) {
            this.cWM = searchSecondTimezoneActivity;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MFLogger.d(SearchSecondTimezoneActivity.TAG, "beforeTextChanged s=" + charSequence + " start=" + i + " count=" + i2 + " after=" + i3);
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MFLogger.d(SearchSecondTimezoneActivity.TAG, "onTextChanged s=" + charSequence + " start=" + i + " before=" + i2 + " count=" + i3);
        }

        public void afterTextChanged(Editable editable) {
            MFLogger.d(SearchSecondTimezoneActivity.TAG, "afterTextChanged s=" + editable);
            if (this.cWM.cWJ.aqc() != null) {
                this.cWM.cWJ.iO(editable.toString().trim());
            }
        }
    }

    class C49542 implements a {
        final /* synthetic */ SearchSecondTimezoneActivity cWM;

        C49542(SearchSecondTimezoneActivity searchSecondTimezoneActivity) {
            this.cWM = searchSecondTimezoneActivity;
        }

        public void kh(int i) {
            MFLogger.d(SearchSecondTimezoneActivity.TAG, "onItemClick position=" + i);
            this.cWM.cWL = (SecondTimezone) this.cWM.cWJ.aqb().get(i);
            TimeZone timeZone = TimeZone.getTimeZone(this.cWM.cWL.getTimezoneId());
            this.cWM.cWL.setTimezoneOffset((long) timeZone.getRawOffset());
            String displayName = timeZone.getDisplayName(true, 1);
            SecondTimezone secondTimezone = this.cWM.cWL;
            if (displayName.startsWith("GMT")) {
                displayName = "Greenwich Mean Time";
            }
            secondTimezone.setTimezoneType(displayName);
            this.cWM.cWL.generateUri();
            this.cWM.finish();
        }
    }

    class C49553 implements OnClickListener {
        final /* synthetic */ SearchSecondTimezoneActivity cWM;

        C49553(SearchSecondTimezoneActivity searchSecondTimezoneActivity) {
            this.cWM = searchSecondTimezoneActivity;
        }

        public void onClick(View view) {
            this.cWM.finish();
        }
    }

    public static void m15749a(Fragment fragment, ArrayList<SecondTimezone> arrayList, int i) {
        Intent intent = new Intent(fragment.getContext(), SearchSecondTimezoneActivity.class);
        intent.putParcelableArrayListExtra("SECOND_TIMEZONE_LIST", arrayList);
        fragment.startActivityForResult(intent, i);
    }

    public void onCreate(Bundle bundle) {
        MFLogger.d(TAG, "onCreate");
        super.onCreate(bundle);
        setContentView(R.layout.second_timezone_add_fragment);
        this.cWI = (FlexibleEditText) findViewById(R.id.search_time_zone);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.timezone_recycler_view);
        this.cWI.addTextChangedListener(new C49531(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.requestFocus();
        this.cWJ = new diw(this);
        this.cWJ.a(new C49542(this));
        findViewById(R.id.back_iv).setOnClickListener(new C49553(this));
        findViewById(R.id.clear_iv).setOnClickListener(this);
        recyclerView.setAdapter(this.cWJ);
        if (getIntent() != null) {
            this.cWK = getIntent().getParcelableArrayListExtra("SECOND_TIMEZONE_LIST");
            if (this.cWK != null) {
                aqa();
            }
        }
    }

    private void aqa() {
        MFLogger.d(TAG, "showSecondTimezones");
        if (this.cWK == null) {
            this.cWK = new ArrayList();
        }
        this.cWJ.am(this.cWK);
        this.cWJ.notifyDataSetChanged();
    }

    public void onResume() {
        MFLogger.d(TAG, "onResume");
        super.onResume();
    }

    public void onPause() {
        MFLogger.d(TAG, "onPause");
        super.onPause();
    }

    public void onStop() {
        MFLogger.d(TAG, "onStop");
        super.onStop();
    }

    public void onClick(View view) {
        MFLogger.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.back_iv:
                this.cWL = new SecondTimezone();
                finish();
                return;
            case R.id.clear_iv:
                this.cWI.setText("");
                return;
            default:
                return;
        }
    }

    public void finish() {
        if (this.cWL != null) {
            Intent intent = new Intent();
            intent.putExtra("SECOND_TIMEZONE", this.cWL);
            setResult(-1, intent);
        } else {
            setResult(0);
        }
        super.finish();
    }
}
