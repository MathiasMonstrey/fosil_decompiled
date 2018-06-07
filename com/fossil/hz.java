package com.fossil;

import android.app.Service;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.fossil.hx.C3658a;
import com.fossil.il.C3727c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class hz extends Service {
    static final boolean DEBUG = Log.isLoggable("MBServiceCompat", 3);
    final jl<IBinder, C3665b> Nw = new jl();
    C3665b Nx;
    final C3678g Ny = new C3678g(this);
    C3727c Nz;

    public static class C3659c<T> {
        private int JM;
        private final Object NM;
        private boolean NN;
        private boolean NO;
        private boolean NP;

        C3659c(Object obj) {
            this.NM = obj;
        }

        public void sendResult(T t) {
            if (this.NO || this.NP) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.NM);
            }
            this.NO = true;
            mo3162q(t);
        }

        public void m11671f(Bundle bundle) {
            if (this.NO || this.NP) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.NM);
            }
            this.NP = true;
            mo3163e(bundle);
        }

        boolean isDone() {
            return this.NN || this.NO || this.NP;
        }

        void setFlags(int i) {
            this.JM = i;
        }

        int getFlags() {
            return this.JM;
        }

        void mo3162q(T t) {
        }

        void mo3163e(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.NM);
        }
    }

    public static final class C3664a {
        private final Bundle KV;
        private final String NG;

        public String getRootId() {
            return this.NG;
        }

        public Bundle getExtras() {
            return this.KV;
        }
    }

    class C3665b {
        final /* synthetic */ hz NE;
        String NH;
        Bundle NI;
        C3676e NJ;
        C3664a NK;
        HashMap<String, List<jt<IBinder, Bundle>>> NL = new HashMap();

        C3665b(hz hzVar) {
            this.NE = hzVar;
        }
    }

    class C3675d {
        final /* synthetic */ hz NE;

        C3675d(hz hzVar) {
            this.NE = hzVar;
        }

        public void m11684a(String str, int i, Bundle bundle, C3676e c3676e) {
            if (this.NE.m11710e(str, i)) {
                final C3676e c3676e2 = c3676e;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final int i2 = i;
                this.NE.Ny.m11696d(new Runnable(this) {
                    final /* synthetic */ C3675d NU;

                    public void run() {
                        IBinder asBinder = c3676e2.asBinder();
                        this.NU.NE.Nw.remove(asBinder);
                        C3665b c3665b = new C3665b(this.NU.NE);
                        c3665b.NH = str2;
                        c3665b.NI = bundle2;
                        c3665b.NJ = c3676e2;
                        c3665b.NK = this.NU.NE.m11697a(str2, i2, bundle2);
                        if (c3665b.NK == null) {
                            Log.i("MBServiceCompat", "No root for client " + str2 + " from service " + getClass().getName());
                            try {
                                c3676e2.iQ();
                                return;
                            } catch (RemoteException e) {
                                Log.w("MBServiceCompat", "Calling onConnectFailed() failed. Ignoring. pkg=" + str2);
                                return;
                            }
                        }
                        try {
                            this.NU.NE.Nw.put(asBinder, c3665b);
                            if (this.NU.NE.Nz != null) {
                                c3676e2.mo3164a(c3665b.NK.getRootId(), this.NU.NE.Nz, c3665b.NK.getExtras());
                            }
                        } catch (RemoteException e2) {
                            Log.w("MBServiceCompat", "Calling onConnect() failed. Dropping client. pkg=" + str2);
                            this.NU.NE.Nw.remove(asBinder);
                        }
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i + " package=" + str);
        }

        public void m11682a(final C3676e c3676e) {
            this.NE.Ny.m11696d(new Runnable(this) {
                final /* synthetic */ C3675d NU;

                public void run() {
                    if (((C3665b) this.NU.NE.Nw.remove(c3676e.asBinder())) == null) {
                    }
                }
            });
        }

        public void m11686a(String str, IBinder iBinder, Bundle bundle, C3676e c3676e) {
            final C3676e c3676e2 = c3676e;
            final String str2 = str;
            final IBinder iBinder2 = iBinder;
            final Bundle bundle2 = bundle;
            this.NE.Ny.m11696d(new Runnable(this) {
                final /* synthetic */ C3675d NU;

                public void run() {
                    C3665b c3665b = (C3665b) this.NU.NE.Nw.get(c3676e2.asBinder());
                    if (c3665b == null) {
                        Log.w("MBServiceCompat", "addSubscription for callback that isn't registered id=" + str2);
                    } else {
                        this.NU.NE.m11702a(str2, c3665b, iBinder2, bundle2);
                    }
                }
            });
        }

        public void m11687a(final String str, final IBinder iBinder, final C3676e c3676e) {
            this.NE.Ny.m11696d(new Runnable(this) {
                final /* synthetic */ C3675d NU;

                public void run() {
                    C3665b c3665b = (C3665b) this.NU.NE.Nw.get(c3676e.asBinder());
                    if (c3665b == null) {
                        Log.w("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + str);
                    } else if (!this.NU.NE.m11706a(str, c3665b, iBinder)) {
                        Log.w("MBServiceCompat", "removeSubscription called for " + str + " which is not subscribed");
                    }
                }
            });
        }

        public void m11688a(final String str, final jb jbVar, final C3676e c3676e) {
            if (!TextUtils.isEmpty(str) && jbVar != null) {
                this.NE.Ny.m11696d(new Runnable(this) {
                    final /* synthetic */ C3675d NU;

                    public void run() {
                        C3665b c3665b = (C3665b) this.NU.NE.Nw.get(c3676e.asBinder());
                        if (c3665b == null) {
                            Log.w("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + str);
                        } else {
                            this.NU.NE.m11703a(str, c3665b, jbVar);
                        }
                    }
                });
            }
        }

        public void m11683a(final C3676e c3676e, final Bundle bundle) {
            this.NE.Ny.m11696d(new Runnable(this) {
                final /* synthetic */ C3675d NU;

                public void run() {
                    IBinder asBinder = c3676e.asBinder();
                    this.NU.NE.Nw.remove(asBinder);
                    C3665b c3665b = new C3665b(this.NU.NE);
                    c3665b.NJ = c3676e;
                    c3665b.NI = bundle;
                    this.NU.NE.Nw.put(asBinder, c3665b);
                }
            });
        }

        public void m11689b(final C3676e c3676e) {
            this.NE.Ny.m11696d(new Runnable(this) {
                final /* synthetic */ C3675d NU;

                public void run() {
                    this.NU.NE.Nw.remove(c3676e.asBinder());
                }
            });
        }

        public void m11685a(String str, Bundle bundle, jb jbVar, C3676e c3676e) {
            if (!TextUtils.isEmpty(str) && jbVar != null) {
                final C3676e c3676e2 = c3676e;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final jb jbVar2 = jbVar;
                this.NE.Ny.m11696d(new Runnable(this) {
                    final /* synthetic */ C3675d NU;

                    public void run() {
                        C3665b c3665b = (C3665b) this.NU.NE.Nw.get(c3676e2.asBinder());
                        if (c3665b == null) {
                            Log.w("MBServiceCompat", "search for callback that isn't registered query=" + str2);
                        } else {
                            this.NU.NE.m11699a(str2, bundle2, c3665b, jbVar2);
                        }
                    }
                });
            }
        }

        public void m11690b(String str, Bundle bundle, jb jbVar, C3676e c3676e) {
            if (!TextUtils.isEmpty(str) && jbVar != null) {
                final C3676e c3676e2 = c3676e;
                final String str2 = str;
                final Bundle bundle2 = bundle;
                final jb jbVar2 = jbVar;
                this.NE.Ny.m11696d(new Runnable(this) {
                    final /* synthetic */ C3675d NU;

                    public void run() {
                        C3665b c3665b = (C3665b) this.NU.NE.Nw.get(c3676e2.asBinder());
                        if (c3665b == null) {
                            Log.w("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + str2 + ", extras=" + bundle2);
                        } else {
                            this.NU.NE.m11707b(str2, bundle2, c3665b, jbVar2);
                        }
                    }
                });
            }
        }
    }

    interface C3676e {
        void mo3164a(String str, C3727c c3727c, Bundle bundle) throws RemoteException;

        void mo3165a(String str, List<C3658a> list, Bundle bundle) throws RemoteException;

        IBinder asBinder();

        void iQ() throws RemoteException;
    }

    class C3677f implements C3676e {
        final /* synthetic */ hz NE;
        final Messenger Oa;

        C3677f(hz hzVar, Messenger messenger) {
            this.NE = hzVar;
            this.Oa = messenger;
        }

        public IBinder asBinder() {
            return this.Oa.getBinder();
        }

        public void mo3164a(String str, C3727c c3727c, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("extra_service_version", 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putParcelable("data_media_session_token", c3727c);
            bundle2.putBundle("data_root_hints", bundle);
            m11693c(1, bundle2);
        }

        public void iQ() throws RemoteException {
            m11693c(2, null);
        }

        public void mo3165a(String str, List<C3658a> list, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString("data_media_item_id", str);
            bundle2.putBundle("data_options", bundle);
            if (list != null) {
                String str2 = "data_media_item_list";
                if (list instanceof ArrayList) {
                    list = (ArrayList) list;
                } else {
                    Object arrayList = new ArrayList(list);
                }
                bundle2.putParcelableArrayList(str2, list);
            }
            m11693c(3, bundle2);
        }

        private void m11693c(int i, Bundle bundle) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            this.Oa.send(obtain);
        }
    }

    final class C3678g extends Handler {
        final /* synthetic */ hz NE;
        private final C3675d Ob = new C3675d(this.NE);

        C3678g(hz hzVar) {
            this.NE = hzVar;
        }

        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    this.Ob.m11684a(data.getString("data_package_name"), data.getInt("data_calling_uid"), data.getBundle("data_root_hints"), new C3677f(this.NE, message.replyTo));
                    return;
                case 2:
                    this.Ob.m11682a(new C3677f(this.NE, message.replyTo));
                    return;
                case 3:
                    this.Ob.m11686a(data.getString("data_media_item_id"), es.m11119a(data, "data_callback_token"), data.getBundle("data_options"), new C3677f(this.NE, message.replyTo));
                    return;
                case 4:
                    this.Ob.m11687a(data.getString("data_media_item_id"), es.m11119a(data, "data_callback_token"), new C3677f(this.NE, message.replyTo));
                    return;
                case 5:
                    this.Ob.m11688a(data.getString("data_media_item_id"), (jb) data.getParcelable("data_result_receiver"), new C3677f(this.NE, message.replyTo));
                    return;
                case 6:
                    this.Ob.m11683a(new C3677f(this.NE, message.replyTo), data.getBundle("data_root_hints"));
                    return;
                case 7:
                    this.Ob.m11689b(new C3677f(this.NE, message.replyTo));
                    return;
                case 8:
                    this.Ob.m11685a(data.getString("data_search_query"), data.getBundle("data_search_extras"), (jb) data.getParcelable("data_result_receiver"), new C3677f(this.NE, message.replyTo));
                    return;
                case 9:
                    this.Ob.m11690b(data.getString("data_custom_action"), data.getBundle("data_custom_action_extras"), (jb) data.getParcelable("data_result_receiver"), new C3677f(this.NE, message.replyTo));
                    return;
                default:
                    Log.w("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: " + 1 + "\n  Client version: " + message.arg1);
                    return;
            }
        }

        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(hx.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            return super.sendMessageAtTime(message, j);
        }

        public void m11696d(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    public abstract C3664a m11697a(String str, int i, Bundle bundle);

    public abstract void m11704a(String str, C3659c<List<C3658a>> c3659c);

    public void m11705a(String str, C3659c<List<C3658a>> c3659c, Bundle bundle) {
        c3659c.setFlags(1);
        m11704a(str, (C3659c) c3659c);
    }

    public void m11709b(String str, C3659c<C3658a> c3659c) {
        c3659c.setFlags(2);
        c3659c.sendResult(null);
    }

    public void m11700a(String str, Bundle bundle, C3659c<List<C3658a>> c3659c) {
        c3659c.setFlags(4);
        c3659c.sendResult(null);
    }

    public void m11708b(String str, Bundle bundle, C3659c<Bundle> c3659c) {
        c3659c.m11671f(null);
    }

    boolean m11710e(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String equals : getPackageManager().getPackagesForUid(i)) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void m11702a(String str, C3665b c3665b, IBinder iBinder, Bundle bundle) {
        List list = (List) c3665b.NL.get(str);
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = list;
        }
        for (jt jtVar : r1) {
            if (iBinder == jtVar.first && hy.m11669a(bundle, (Bundle) jtVar.second)) {
                return;
            }
        }
        r1.add(new jt(iBinder, bundle));
        c3665b.NL.put(str, r1);
        m11701a(str, c3665b, bundle);
    }

    boolean m11706a(String str, C3665b c3665b, IBinder iBinder) {
        if (iBinder != null) {
            boolean z;
            List list = (List) c3665b.NL.get(str);
            if (list != null) {
                Iterator it = list.iterator();
                z = false;
                while (it.hasNext()) {
                    if (iBinder == ((jt) it.next()).first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    c3665b.NL.remove(str);
                }
            } else {
                z = false;
            }
            return z;
        } else if (c3665b.NL.remove(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    void m11701a(String str, C3665b c3665b, Bundle bundle) {
        final C3665b c3665b2 = c3665b;
        final String str2 = str;
        final Bundle bundle2 = bundle;
        C3659c c36601 = new C3659c<List<C3658a>>(this, str) {
            final /* synthetic */ hz NE;

            /* synthetic */ void mo3162q(Object obj) {
                m11673o((List) obj);
            }

            void m11673o(List<C3658a> list) {
                if (this.NE.Nw.get(c3665b2.NJ.asBinder()) == c3665b2) {
                    List a;
                    if ((getFlags() & 1) != 0) {
                        a = this.NE.m11698a((List) list, bundle2);
                    }
                    try {
                        c3665b2.NJ.mo3165a(str2, a, bundle2);
                    } catch (RemoteException e) {
                        Log.w("MBServiceCompat", "Calling onLoadChildren() failed for id=" + str2 + " package=" + c3665b2.NH);
                    }
                } else if (hz.DEBUG) {
                    Log.d("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + c3665b2.NH + " id=" + str2);
                }
            }
        };
        this.Nx = c3665b;
        if (bundle == null) {
            m11704a(str, c36601);
        } else {
            m11705a(str, c36601, bundle);
        }
        this.Nx = null;
        if (!c36601.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + c3665b.NH + " id=" + str);
        }
    }

    List<C3658a> m11698a(List<C3658a> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i2 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int i4 = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.EMPTY_LIST;
        }
        if (i4 > list.size()) {
            i4 = list.size();
        }
        return list.subList(i3, i4);
    }

    void m11703a(String str, C3665b c3665b, final jb jbVar) {
        C3659c c36612 = new C3659c<C3658a>(this, str) {
            final /* synthetic */ hz NE;

            /* synthetic */ void mo3162q(Object obj) {
                m11675a((C3658a) obj);
            }

            void m11675a(C3658a c3658a) {
                if ((getFlags() & 2) != 0) {
                    jbVar.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelable("media_item", c3658a);
                jbVar.send(0, bundle);
            }
        };
        this.Nx = c3665b;
        m11709b(str, c36612);
        this.Nx = null;
        if (!c36612.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    void m11699a(String str, Bundle bundle, C3665b c3665b, final jb jbVar) {
        C3659c c36623 = new C3659c<List<C3658a>>(this, str) {
            final /* synthetic */ hz NE;

            /* synthetic */ void mo3162q(Object obj) {
                m11677o((List) obj);
            }

            void m11677o(List<C3658a> list) {
                if ((getFlags() & 4) != 0 || list == null) {
                    jbVar.send(-1, null);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putParcelableArray("search_results", (Parcelable[]) list.toArray(new C3658a[0]));
                jbVar.send(0, bundle);
            }
        };
        this.Nx = c3665b;
        m11700a(str, bundle, c36623);
        this.Nx = null;
        if (!c36623.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    void m11707b(String str, Bundle bundle, C3665b c3665b, final jb jbVar) {
        C3659c c36634 = new C3659c<Bundle>(this, str) {
            final /* synthetic */ hz NE;

            /* synthetic */ void mo3162q(Object obj) {
                m11679d((Bundle) obj);
            }

            void m11679d(Bundle bundle) {
                jbVar.send(0, bundle);
            }

            void mo3163e(Bundle bundle) {
                jbVar.send(-1, bundle);
            }
        };
        this.Nx = c3665b;
        m11708b(str, bundle, c36634);
        this.Nx = null;
        if (!c36634.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }
}
