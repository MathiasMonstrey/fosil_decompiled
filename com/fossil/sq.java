package com.fossil;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v8.renderscript.Allocation;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.fossil.pk.C3982a;
import com.fossil.pk.C3987f;
import com.misfit.frameworks.common.constants.Constants;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

public class sq extends oe implements OnClickListener {
    private final SearchView asX;
    private final SearchManager atR = ((SearchManager) this.mContext.getSystemService("search"));
    private final Context atS;
    private final int atT;
    private int atU = 1;
    private ColorStateList atV;
    private int atW = -1;
    private int atX = -1;
    private int atY = -1;
    private int atZ = -1;
    private int aua = -1;
    private int aub = -1;
    private boolean mClosed = false;
    private final WeakHashMap<String, ConstantState> mOutsideDrawablesCache;
    private final SearchableInfo mSearchable;

    static final class C4083a {
        public final TextView auc;
        public final TextView aud;
        public final ImageView aue;
        public final ImageView auf;
        public final ImageView aug;

        public C4083a(View view) {
            this.auc = (TextView) view.findViewById(16908308);
            this.aud = (TextView) view.findViewById(16908309);
            this.aue = (ImageView) view.findViewById(16908295);
            this.auf = (ImageView) view.findViewById(16908296);
            this.aug = (ImageView) view.findViewById(C3987f.edit_query);
        }
    }

    public sq(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.asX = searchView;
        this.mSearchable = searchableInfo;
        this.atT = searchView.getSuggestionCommitIconResId();
        this.atS = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public void ek(int i) {
        this.atU = i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.asX.getVisibility() != 0 || this.asX.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m13573a(this.mSearchable, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m13563a(getCursor());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m13563a(getCursor());
    }

    private void m13563a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    public void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.atW = cursor.getColumnIndex("suggest_text_1");
                this.atX = cursor.getColumnIndex("suggest_text_2");
                this.atY = cursor.getColumnIndex("suggest_text_2_url");
                this.atZ = cursor.getColumnIndex("suggest_icon_1");
                this.aua = cursor.getColumnIndex("suggest_icon_2");
                this.aub = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View newView = super.newView(context, cursor, viewGroup);
        newView.setTag(new C4083a(newView));
        ((ImageView) newView.findViewById(C3987f.edit_query)).setImageResource(this.atT);
        return newView;
    }

    public void bindView(View view, Context context, Cursor cursor) {
        C4083a c4083a = (C4083a) view.getTag();
        int i;
        if (this.aub != -1) {
            i = cursor.getInt(this.aub);
        } else {
            i = 0;
        }
        if (c4083a.auc != null) {
            m13565a(c4083a.auc, m13561a(cursor, this.atW));
        }
        if (c4083a.aud != null) {
            CharSequence a = m13561a(cursor, this.atY);
            if (a != null) {
                a = m13572q(a);
            } else {
                a = m13561a(cursor, this.atX);
            }
            if (TextUtils.isEmpty(a)) {
                if (c4083a.auc != null) {
                    c4083a.auc.setSingleLine(false);
                    c4083a.auc.setMaxLines(2);
                }
            } else if (c4083a.auc != null) {
                c4083a.auc.setSingleLine(true);
                c4083a.auc.setMaxLines(1);
            }
            m13565a(c4083a.aud, a);
        }
        if (c4083a.aue != null) {
            m13564a(c4083a.aue, m13568b(cursor), 4);
        }
        if (c4083a.auf != null) {
            m13564a(c4083a.auf, m13569c(cursor), 8);
        }
        if (this.atU == 2 || (this.atU == 1 && (r1 & 1) != 0)) {
            c4083a.aug.setVisibility(0);
            c4083a.aug.setTag(c4083a.auc.getText());
            c4083a.aug.setOnClickListener(this);
            return;
        }
        c4083a.aug.setVisibility(8);
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.asX.onQueryRefine((CharSequence) tag);
        }
    }

    private CharSequence m13572q(CharSequence charSequence) {
        if (this.atV == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(C3982a.textColorSearchUrl, typedValue, true);
            this.atV = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.atV, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m13565a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable m13568b(Cursor cursor) {
        if (this.atZ == -1) {
            return null;
        }
        Drawable af = af(cursor.getString(this.atZ));
        return af == null ? m13570d(cursor) : af;
    }

    private Drawable m13569c(Cursor cursor) {
        if (this.aua == -1) {
            return null;
        }
        return af(cursor.getString(this.aua));
    }

    private void m13564a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public CharSequence convertToString(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m13562a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.mSearchable.shouldRewriteQueryFromData()) {
            a = m13562a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.mSearchable.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m13562a(cursor, "suggest_text_1");
        if (a != null) {
            return a;
        }
        return null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(this.mContext, this.MC, viewGroup);
            if (newView != null) {
                ((C4083a) newView.getTag()).auc.setText(e.toString());
            }
            return newView;
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newDropDownView = newDropDownView(this.mContext, this.MC, viewGroup);
            if (newDropDownView != null) {
                ((C4083a) newDropDownView.getTag()).auc.setText(e.toString());
            }
            return newDropDownView;
        }
    }

    private Drawable af(String str) {
        if (str == null || str.length() == 0 || AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str)) {
            return null;
        }
        Drawable ag;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.atS.getPackageName() + "/" + parseInt;
            ag = ag(str2);
            if (ag != null) {
                return ag;
            }
            ag = gn.c(this.atS, parseInt);
            m13566a(str2, ag);
            return ag;
        } catch (NumberFormatException e) {
            ag = ag(str);
            if (ag != null) {
                return ag;
            }
            ag = m13571e(Uri.parse(str));
            m13566a(str, ag);
            return ag;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private Drawable m13571e(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m13574f(uri);
            }
            openInputStream = this.atS.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable ag(String str) {
        ConstantState constantState = (ConstantState) this.mOutsideDrawablesCache.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void m13566a(String str, Drawable drawable) {
        if (drawable != null) {
            this.mOutsideDrawablesCache.put(str, drawable.getConstantState());
        }
    }

    private Drawable m13570d(Cursor cursor) {
        Drawable b = m13567b(this.mSearchable.getSearchActivity());
        return b != null ? b : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable m13567b(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.mOutsideDrawablesCache.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.mOutsideDrawablesCache.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.atS.getResources());
        } else {
            Drawable activityIcon = getActivityIcon(componentName);
            if (activityIcon != null) {
                obj = activityIcon.getConstantState();
            }
            this.mOutsideDrawablesCache.put(flattenToShortString, obj);
            return activityIcon;
        }
    }

    private Drawable getActivityIcon(ComponentName componentName) {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, Allocation.USAGE_SHARED);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String m13562a(Cursor cursor, String str) {
        return m13561a(cursor, cursor.getColumnIndex(str));
    }

    private static String m13561a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    Drawable m13574f(Uri uri) throws FileNotFoundException {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    Cursor m13573a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter(Constants.JSON_KEY_LIMIT, String.valueOf(i));
        }
        return this.mContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }
}
