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
import com.fossil.bxo;
import com.fossil.bxw;
import com.fossil.bxz;
import com.fossil.byj;
import com.fossil.byk;
import com.fossil.bzj;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final C4256b bIU;

    public static class C4255a implements bxz {
        private final ViewGroup bIE;
        private final bxw bIV;
        private View bIW;

        public C4255a(ViewGroup viewGroup, bxw com_fossil_bxw) {
            this.bIV = (bxw) awa.bO(com_fossil_bxw);
            this.bIE = (ViewGroup) awa.bO(viewGroup);
        }

        public final void m14266a(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void m14267a(bxo com_fossil_bxo) {
            try {
                this.bIV.a(new bzj(this, com_fossil_bxo));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                this.bIV.onCreate(bundle2);
                byj.b(bundle2, bundle);
                this.bIW = (View) azc.a(this.bIV.Tq());
                this.bIE.removeAllViews();
                this.bIE.addView(this.bIW);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onDestroy() {
            try {
                this.bIV.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onLowMemory() {
            try {
                this.bIV.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.bIV.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.bIV.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                this.bIV.onSaveInstanceState(bundle2);
                byj.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
        }

        public final void onStop() {
        }
    }

    static class C4256b extends ays<C4255a> {
        private final ViewGroup bIH;
        private final Context bII;
        private azd<C4255a> bIJ;
        private final StreetViewPanoramaOptions bIX;
        private final List<bxo> bIY = new ArrayList();

        C4256b(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.bIH = viewGroup;
            this.bII = context;
            this.bIX = streetViewPanoramaOptions;
        }

        protected final void m14268a(azd<C4255a> com_fossil_azd_com_google_android_gms_maps_StreetViewPanoramaView_a) {
            this.bIJ = com_fossil_azd_com_google_android_gms_maps_StreetViewPanoramaView_a;
            if (this.bIJ != null && LQ() == null) {
                try {
                    this.bIJ.a(new C4255a(this.bIH, byk.aT(this.bII).a(azc.bQ(this.bII), this.bIX)));
                    for (bxo a : this.bIY) {
                        ((C4255a) LQ()).m14267a(a);
                    }
                    this.bIY.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.bIU = new C4256b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bIU = new C4256b(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bIU = new C4256b(this, context, null);
    }
}
