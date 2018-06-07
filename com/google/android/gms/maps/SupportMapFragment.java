package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fossil.awa;
import com.fossil.ayq;
import com.fossil.ays;
import com.fossil.azc;
import com.fossil.azd;
import com.fossil.bxm;
import com.fossil.bxn;
import com.fossil.bxt;
import com.fossil.bxy;
import com.fossil.byj;
import com.fossil.byk;
import com.fossil.bzk;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportMapFragment extends Fragment {
    private final C4258b bIZ = new C4258b(this);

    public static class C4257a implements bxy {
        private final Fragment bJa;
        private final bxt bJb;

        public C4257a(Fragment fragment, bxt com_fossil_bxt) {
            this.bJb = (bxt) awa.bO(com_fossil_bxt);
            this.bJa = (Fragment) awa.bO(fragment);
        }

        public final void m14269a(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                byj.b(bundle2, bundle3);
                this.bJb.a(azc.bQ(activity), googleMapOptions, bundle3);
                byj.b(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void m14270a(bxn com_fossil_bxn) {
            try {
                this.bJb.a(new bzk(this, com_fossil_bxn));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                Bundle arguments = this.bJa.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    byj.a(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.bJb.onCreate(bundle2);
                byj.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                ayq a = this.bJb.a(azc.bQ(layoutInflater), azc.bQ(viewGroup), bundle2);
                byj.b(bundle2, bundle);
                return (View) azc.a(a);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroy() {
            try {
                this.bJb.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            try {
                this.bJb.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onLowMemory() {
            try {
                this.bJb.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.bJb.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.bJb.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                byj.b(bundle, bundle2);
                this.bJb.onSaveInstanceState(bundle2);
                byj.b(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
            try {
                this.bJb.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStop() {
            try {
                this.bJb.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    static class C4258b extends ays<C4257a> {
        private Activity IX;
        private azd<C4257a> bIJ;
        private final List<bxn> bIL = new ArrayList();
        private final Fragment bJa;

        C4258b(Fragment fragment) {
            this.bJa = fragment;
        }

        private final void To() {
            if (this.IX != null && this.bIJ != null && LQ() == null) {
                try {
                    bxm.aS(this.IX);
                    bxt d = byk.aT(this.IX).d(azc.bQ(this.IX));
                    if (d != null) {
                        this.bIJ.a(new C4257a(this.bJa, d));
                        for (bxn a : this.bIL) {
                            ((C4257a) LQ()).m14270a(a);
                        }
                        this.bIL.clear();
                    }
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }

        private final void setActivity(Activity activity) {
            this.IX = activity;
            To();
        }

        protected final void m14272a(azd<C4257a> com_fossil_azd_com_google_android_gms_maps_SupportMapFragment_a) {
            this.bIJ = com_fossil_azd_com_google_android_gms_maps_SupportMapFragment_a;
            To();
        }

        public final void m14273a(bxn com_fossil_bxn) {
            if (LQ() != null) {
                ((C4257a) LQ()).m14270a(com_fossil_bxn);
            } else {
                this.bIL.add(com_fossil_bxn);
            }
        }
    }

    public void m14274a(bxn com_fossil_bxn) {
        awa.dg("getMapAsync must be called on the main thread.");
        this.bIZ.m14273a(com_fossil_bxn);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.bIZ.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bIZ.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.bIZ.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.bIZ.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.bIZ.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        super.onInflate(activity, attributeSet, bundle);
        this.bIZ.setActivity(activity);
        Parcelable e = GoogleMapOptions.m14259e(activity, attributeSet);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("MapOptions", e);
        this.bIZ.a(activity, bundle2, bundle);
    }

    public void onLowMemory() {
        this.bIZ.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.bIZ.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.bIZ.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(SupportMapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.bIZ.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.bIZ.onStart();
    }

    public void onStop() {
        this.bIZ.onStop();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}
