package com.fossil;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import com.fossil.gh.C3623a;
import com.fossil.ig.C3698a;
import com.fossil.ih.C3700a;
import com.fossil.ik.C3702a;
import com.fossil.il.C3723a;
import com.fossil.il.C3727c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ij {
    private final C3707c Os;
    private final C3727c Ot;

    public static abstract class C3705a implements DeathRecipient {
        private final Object Ou;
        C3701a Ov;
        boolean Ow;
        boolean Ox = false;

        class C3701a extends Handler {
            final /* synthetic */ C3705a Oy;

            public void handleMessage(Message message) {
                if (this.Oy.Ox) {
                    switch (message.what) {
                        case 1:
                            this.Oy.onSessionEvent((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.Oy.m11801a((io) message.obj);
                            return;
                        case 3:
                            this.Oy.m11799a((id) message.obj);
                            return;
                        case 4:
                            this.Oy.m11800a((C3719h) message.obj);
                            return;
                        case 5:
                            this.Oy.onQueueChanged((List) message.obj);
                            return;
                        case 6:
                            this.Oy.onQueueTitleChanged((CharSequence) message.obj);
                            return;
                        case 7:
                            this.Oy.onExtrasChanged((Bundle) message.obj);
                            return;
                        case 8:
                            this.Oy.onSessionDestroyed();
                            return;
                        case 9:
                            this.Oy.aW(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.Oy.m11797B(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            this.Oy.m11798C(((Boolean) message.obj).booleanValue());
                            return;
                        default:
                            return;
                    }
                }
            }

            public void m11784a(int i, Object obj, Bundle bundle) {
                Message obtainMessage = obtainMessage(i, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        class C3703b implements C3702a {
            final /* synthetic */ C3705a Oy;

            C3703b(C3705a c3705a) {
                this.Oy = c3705a;
            }

            public void onSessionDestroyed() {
                this.Oy.onSessionDestroyed();
            }

            public void onSessionEvent(String str, Bundle bundle) {
                if (!this.Oy.Ow || VERSION.SDK_INT >= 23) {
                    this.Oy.onSessionEvent(str, bundle);
                }
            }

            public void mo3225C(Object obj) {
                if (!this.Oy.Ow) {
                    this.Oy.m11801a(io.m11836M(obj));
                }
            }

            public void mo3226D(Object obj) {
                this.Oy.m11799a(id.m11743B(obj));
            }

            public void onQueueChanged(List<?> list) {
                this.Oy.onQueueChanged(C3723a.m11824p(list));
            }

            public void onQueueTitleChanged(CharSequence charSequence) {
                this.Oy.onQueueTitleChanged(charSequence);
            }

            public void onExtrasChanged(Bundle bundle) {
                this.Oy.onExtrasChanged(bundle);
            }

            public void mo3227b(int i, int i2, int i3, int i4, int i5) {
                this.Oy.m11800a(new C3719h(i, i2, i3, i4, i5));
            }
        }

        class C3704c extends C3698a {
            final /* synthetic */ C3705a Oy;

            C3704c(C3705a c3705a) {
                this.Oy = c3705a;
            }

            public void mo3174e(String str, Bundle bundle) throws RemoteException {
                this.Oy.Ov.m11784a(1, str, bundle);
            }

            public void onSessionDestroyed() throws RemoteException {
                this.Oy.Ov.m11784a(8, null, null);
            }

            public void mo3172a(io ioVar) throws RemoteException {
                this.Oy.Ov.m11784a(2, ioVar, null);
            }

            public void mo3170a(id idVar) throws RemoteException {
                this.Oy.Ov.m11784a(3, idVar, null);
            }

            public void onQueueChanged(List<C3723a> list) throws RemoteException {
                this.Oy.Ov.m11784a(5, list, null);
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                this.Oy.Ov.m11784a(6, charSequence, null);
            }

            public void mo3169C(boolean z) throws RemoteException {
                this.Oy.Ov.m11784a(11, Boolean.valueOf(z), null);
            }

            public void aW(int i) throws RemoteException {
                this.Oy.Ov.m11784a(9, Integer.valueOf(i), null);
            }

            public void mo3168B(boolean z) throws RemoteException {
                this.Oy.Ov.m11784a(10, Boolean.valueOf(z), null);
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                this.Oy.Ov.m11784a(7, bundle, null);
            }

            public void mo3171a(in inVar) throws RemoteException {
                Object c3719h;
                if (inVar != null) {
                    c3719h = new C3719h(inVar.Pa, inVar.Pb, inVar.Pc, inVar.Pd, inVar.Pe);
                } else {
                    c3719h = null;
                }
                this.Oy.Ov.m11784a(4, c3719h, null);
            }
        }

        public C3705a() {
            if (VERSION.SDK_INT >= 21) {
                this.Ou = ik.m11818a(new C3703b(this));
            } else {
                this.Ou = new C3704c(this);
            }
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String str, Bundle bundle) {
        }

        public void m11801a(io ioVar) {
        }

        public void m11799a(id idVar) {
        }

        public void onQueueChanged(List<C3723a> list) {
        }

        public void onQueueTitleChanged(CharSequence charSequence) {
        }

        public void onExtrasChanged(Bundle bundle) {
        }

        public void m11800a(C3719h c3719h) {
        }

        public void m11798C(boolean z) {
        }

        public void aW(int i) {
        }

        public void m11797B(boolean z) {
        }
    }

    static class C3706b extends C3623a {
        private final ij Oz;

        C3706b(ij ijVar) {
            this.Oz = ijVar;
        }

        ij jd() {
            return this.Oz;
        }
    }

    interface C3707c {
    }

    static class C3715d implements C3707c {
        protected final Object OA;
        private ih OB;
        private HashMap<C3705a, C3714b> OC = new HashMap();
        private List<C3705a> OD = new ArrayList();

        static class C3708a extends ResultReceiver {
            private WeakReference<C3715d> OE;

            public C3708a(C3715d c3715d, Handler handler) {
                super(handler);
                this.OE = new WeakReference(c3715d);
            }

            protected void onReceiveResult(int i, Bundle bundle) {
                C3715d c3715d = (C3715d) this.OE.get();
                if (c3715d != null && bundle != null) {
                    c3715d.OB = C3700a.m11783c(es.m11119a(bundle, "android.support.v4.media.session.EXTRA_BINDER"));
                    c3715d.jf();
                }
            }
        }

        class C3714b extends C3698a {
            private C3705a OF;
            final /* synthetic */ C3715d OG;

            C3714b(C3715d c3715d, C3705a c3705a) {
                this.OG = c3715d;
                this.OF = c3705a;
            }

            public void mo3174e(final String str, final Bundle bundle) throws RemoteException {
                this.OF.Ov.post(new Runnable(this) {
                    final /* synthetic */ C3714b OI;

                    public void run() {
                        this.OI.OF.onSessionEvent(str, bundle);
                    }
                });
            }

            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            public void mo3172a(final io ioVar) throws RemoteException {
                this.OF.Ov.post(new Runnable(this) {
                    final /* synthetic */ C3714b OI;

                    public void run() {
                        this.OI.OF.m11801a(ioVar);
                    }
                });
            }

            public void mo3170a(id idVar) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueChanged(List<C3723a> list) throws RemoteException {
                throw new AssertionError();
            }

            public void onQueueTitleChanged(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            public void mo3169C(final boolean z) throws RemoteException {
                this.OF.Ov.post(new Runnable(this) {
                    final /* synthetic */ C3714b OI;

                    public void run() {
                        this.OI.OF.m11798C(z);
                    }
                });
            }

            public void aW(final int i) throws RemoteException {
                this.OF.Ov.post(new Runnable(this) {
                    final /* synthetic */ C3714b OI;

                    public void run() {
                        this.OI.OF.aW(i);
                    }
                });
            }

            public void mo3168B(final boolean z) throws RemoteException {
                this.OF.Ov.post(new Runnable(this) {
                    final /* synthetic */ C3714b OI;

                    public void run() {
                        this.OI.OF.m11797B(z);
                    }
                });
            }

            public void onExtrasChanged(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            public void mo3171a(in inVar) throws RemoteException {
                throw new AssertionError();
            }
        }

        public C3715d(Context context, C3727c c3727c) throws RemoteException {
            this.OA = ik.m11817a(context, c3727c.jg());
            if (this.OA == null) {
                throw new RemoteException();
            }
            this.OB = c3727c.jh();
            if (this.OB == null) {
                je();
            }
        }

        public void sendCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
            ik.m11820a(this.OA, str, bundle, resultReceiver);
        }

        private void je() {
            sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new C3708a(this, new Handler()));
        }

        private void jf() {
            if (this.OB != null) {
                synchronized (this.OD) {
                    for (C3705a c3705a : this.OD) {
                        ig c3714b = new C3714b(this, c3705a);
                        this.OC.put(c3705a, c3714b);
                        c3705a.Ow = true;
                        try {
                            this.OB.mo3185a(c3714b);
                        } catch (Throwable e) {
                            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
                        }
                    }
                    this.OD.clear();
                }
            }
        }
    }

    static class C3716e extends C3715d {
        public C3716e(Context context, C3727c c3727c) throws RemoteException {
            super(context, c3727c);
        }
    }

    static class C3717f extends C3716e {
        public C3717f(Context context, C3727c c3727c) throws RemoteException {
            super(context, c3727c);
        }
    }

    static class C3718g implements C3707c {
        private ih ON;

        public C3718g(C3727c c3727c) {
            this.ON = C3700a.m11783c((IBinder) c3727c.jg());
        }
    }

    public static final class C3719h {
        private final int OO;
        private final int OP;
        private final int OQ;
        private final int OT;
        private final int OU;

        C3719h(int i, int i2, int i3, int i4, int i5) {
            this.OO = i;
            this.OP = i2;
            this.OQ = i3;
            this.OT = i4;
            this.OU = i5;
        }
    }

    public static void m11811a(Activity activity, ij ijVar) {
        if (activity instanceof gh) {
            ((gh) activity).putExtraData(new C3706b(ijVar));
        }
        if (VERSION.SDK_INT >= 21) {
            Object obj = null;
            if (ijVar != null) {
                obj = ik.m11817a((Context) activity, ijVar.jc().jg());
            }
            ik.m11819a(activity, obj);
        }
    }

    public static ij m11812l(Activity activity) {
        if (activity instanceof gh) {
            ij jd;
            C3706b c3706b = (C3706b) ((gh) activity).getExtraData(C3706b.class);
            if (c3706b != null) {
                jd = c3706b.jd();
            } else {
                jd = null;
            }
            return jd;
        } else if (VERSION.SDK_INT < 21) {
            return null;
        } else {
            Object m = ik.m11821m(activity);
            if (m == null) {
                return null;
            }
            try {
                return new ij(activity, C3727c.m11827I(ik.m11816E(m)));
            } catch (Throwable e) {
                Log.e("MediaControllerCompat", "Dead object in getMediaController.", e);
                return null;
            }
        }
    }

    public ij(Context context, C3727c c3727c) throws RemoteException {
        if (c3727c == null) {
            throw new IllegalArgumentException("sessionToken must not be null");
        }
        this.Ot = c3727c;
        if (VERSION.SDK_INT >= 24) {
            this.Os = new C3717f(context, c3727c);
        } else if (VERSION.SDK_INT >= 23) {
            this.Os = new C3716e(context, c3727c);
        } else if (VERSION.SDK_INT >= 21) {
            this.Os = new C3715d(context, c3727c);
        } else {
            this.Os = new C3718g(this.Ot);
        }
    }

    public C3727c jc() {
        return this.Ot;
    }
}
