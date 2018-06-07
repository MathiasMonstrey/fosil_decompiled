package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fossil.awa;
import com.fossil.ays;
import com.fossil.azc;
import com.fossil.azd;
import com.fossil.bxm;
import com.fossil.bxn;
import com.fossil.bxu;
import com.fossil.bxy;
import com.fossil.byj;
import com.fossil.byk;
import com.fossil.bzh;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class MapView extends FrameLayout {
    private final C4254b bID;

    public static class C4253a implements bxy {
        private final ViewGroup bIE;
        private final bxu bIF;
        private View bIG;

        public C4253a(ViewGroup viewGroup, bxu com_fossil_bxu) {
            this.bIF = (bxu) awa.bO(com_fossil_bxu);
            this.bIE = (ViewGroup) awa.bO(viewGroup);
        }

        public final void m14263a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
        }

        public final void m14264a(bxn com_fossil_bxn) {
            try {
                this.bIF.a(new bzh(this, com_fossil_bxn));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                this.bIF.onCreate(bundle2);
                byj.b(bundle2, bundle);
                this.bIG = (View) azc.a(this.bIF.Tq());
                this.bIE.removeAllViews();
                this.bIE.addView(this.bIG);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
        }

        public final void onDestroy() {
            try {
                this.bIF.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
        }

        public final void onLowMemory() {
            try {
                this.bIF.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.bIF.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.bIF.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                this.bIF.onSaveInstanceState(bundle2);
                byj.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
            try {
                this.bIF.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStop() {
            try {
                this.bIF.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    static class C4254b extends ays<C4253a> {
        private final ViewGroup bIH;
        private final Context bII;
        private azd<C4253a> bIJ;
        private final GoogleMapOptions bIK;
        private final List<bxn> bIL = new ArrayList();

        C4254b(ViewGroup viewGroup, Context context, GoogleMapOptions googleMapOptions) {
            this.bIH = viewGroup;
            this.bII = context;
            this.bIK = googleMapOptions;
        }

        protected final void m14265a(azd<C4253a> com_fossil_azd_com_google_android_gms_maps_MapView_a) {
            this.bIJ = com_fossil_azd_com_google_android_gms_maps_MapView_a;
            if (this.bIJ != null && LQ() == null) {
                try {
                    bxm.aS(this.bII);
                    bxu a = byk.aT(this.bII).a(azc.bQ(this.bII), this.bIK);
                    if (a != null) {
                        this.bIJ.a(new C4253a(this.bIH, a));
                        for (bxn a2 : this.bIL) {
                            ((C4253a) LQ()).m14264a(a2);
                        }
                        this.bIL.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.bID = new C4254b(this, context, null);
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bID = new C4254b(this, context, GoogleMapOptions.m14259e(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bID = new C4254b(this, context, GoogleMapOptions.m14259e(context, attributeSet));
        setClickable(true);
    }
}
