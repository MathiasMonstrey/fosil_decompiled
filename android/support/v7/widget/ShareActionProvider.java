package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import com.fossil.kc;
import com.fossil.pk.a;
import com.fossil.pk.h;
import com.fossil.pn;
import com.fossil.rc;
import com.fossil.rc.e;

public class ShareActionProvider extends kc {
    private static final int DEFAULT_INITIAL_ACTIVITY_COUNT = 4;
    public static final String DEFAULT_SHARE_HISTORY_FILE_NAME = "share_history.xml";
    final Context mContext;
    private int mMaxShownActivityCount = 4;
    private e mOnChooseActivityListener;
    private final C1274c mOnMenuItemClickListener = new C1274c(this);
    C1272a mOnShareTargetSelectedListener;
    String mShareHistoryFileName = DEFAULT_SHARE_HISTORY_FILE_NAME;

    public interface C1272a {
        boolean m2511a(ShareActionProvider shareActionProvider, Intent intent);
    }

    class C1273b implements e {
        final /* synthetic */ ShareActionProvider ate;

        C1273b(ShareActionProvider shareActionProvider) {
            this.ate = shareActionProvider;
        }

        public boolean m2512a(rc rcVar, Intent intent) {
            if (this.ate.mOnShareTargetSelectedListener != null) {
                this.ate.mOnShareTargetSelectedListener.m2511a(this.ate, intent);
            }
            return false;
        }
    }

    class C1274c implements OnMenuItemClickListener {
        final /* synthetic */ ShareActionProvider ate;

        C1274c(ShareActionProvider shareActionProvider) {
            this.ate = shareActionProvider;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent cH = rc.d(this.ate.mContext, this.ate.mShareHistoryFileName).cH(menuItem.getItemId());
            if (cH != null) {
                String action = cH.getAction();
                if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                    this.ate.updateIntent(cH);
                }
                this.ate.mContext.startActivity(cH);
            }
            return true;
        }
    }

    public ShareActionProvider(Context context) {
        super(context);
        this.mContext = context;
    }

    public void setOnShareTargetSelectedListener(C1272a c1272a) {
        this.mOnShareTargetSelectedListener = c1272a;
        setActivityChooserPolicyIfNeeded();
    }

    public View onCreateActionView() {
        View activityChooserView = new ActivityChooserView(this.mContext);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(rc.d(this.mContext, this.mShareHistoryFileName));
        }
        TypedValue typedValue = new TypedValue();
        this.mContext.getTheme().resolveAttribute(a.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(pn.c(this.mContext, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(h.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(h.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    public boolean hasSubMenu() {
        return true;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
        int i;
        subMenu.clear();
        rc d = rc.d(this.mContext, this.mShareHistoryFileName);
        PackageManager packageManager = this.mContext.getPackageManager();
        int nS = d.nS();
        int min = Math.min(nS, this.mMaxShownActivityCount);
        for (i = 0; i < min; i++) {
            ResolveInfo cG = d.cG(i);
            subMenu.add(0, i, i, cG.loadLabel(packageManager)).setIcon(cG.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
        }
        if (min < nS) {
            SubMenu addSubMenu = subMenu.addSubMenu(0, min, min, this.mContext.getString(h.abc_activity_chooser_view_see_all));
            for (i = 0; i < nS; i++) {
                cG = d.cG(i);
                addSubMenu.add(0, i, i, cG.loadLabel(packageManager)).setIcon(cG.loadIcon(packageManager)).setOnMenuItemClickListener(this.mOnMenuItemClickListener);
            }
        }
    }

    public void setShareHistoryFileName(String str) {
        this.mShareHistoryFileName = str;
        setActivityChooserPolicyIfNeeded();
    }

    public void setShareIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                updateIntent(intent);
            }
        }
        rc.d(this.mContext, this.mShareHistoryFileName).setIntent(intent);
    }

    private void setActivityChooserPolicyIfNeeded() {
        if (this.mOnShareTargetSelectedListener != null) {
            if (this.mOnChooseActivityListener == null) {
                this.mOnChooseActivityListener = new C1273b(this);
            }
            rc.d(this.mContext, this.mShareHistoryFileName).a(this.mOnChooseActivityListener);
        }
    }

    void updateIntent(Intent intent) {
        if (VERSION.SDK_INT >= 21) {
            intent.addFlags(134742016);
        } else {
            intent.addFlags(524288);
        }
    }
}
