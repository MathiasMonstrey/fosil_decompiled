package com.fossil;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.fossil.ats.C1879a;
import com.fossil.ats.C1887c;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class bfs implements Callback {
    private static final Object bhH = new Object();
    public static final Status btL = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status btM = new Status(4, "The user must be signed in to make this API call.");
    private static bfs btO;
    private final atp bgp;
    private final Map<bdn<?>, bfu<?>> bsl = new ConcurrentHashMap(5, 0.75f, 1);
    private long btN = 10000;
    private int btP = -1;
    private final AtomicInteger btQ = new AtomicInteger(1);
    private final AtomicInteger btR = new AtomicInteger(0);
    private bep btS = null;
    private final Set<bdn<?>> btT = new axi();
    private final Set<bdn<?>> btU = new axi();
    private long bth = 120000;
    private long bti = 5000;
    private final Context mContext;
    private final Handler mHandler;

    private bfs(Context context, Looper looper, atp com_fossil_atp) {
        this.mContext = context;
        this.mHandler = new Handler(looper, this);
        this.bgp = com_fossil_atp;
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6));
    }

    public static bfs NQ() {
        bfs com_fossil_bfs;
        synchronized (bhH) {
            awa.m4640p(btO, "Must guarantee manager is non-null before using getInstance");
            com_fossil_bfs = btO;
        }
        return com_fossil_bfs;
    }

    public static void NR() {
        synchronized (bhH) {
            if (btO != null) {
                bfs com_fossil_bfs = btO;
                com_fossil_bfs.btR.incrementAndGet();
                com_fossil_bfs.mHandler.sendMessageAtFrontOfQueue(com_fossil_bfs.mHandler.obtainMessage(10));
            }
        }
    }

    private final void NT() {
        for (bdn remove : this.btU) {
            ((bfu) this.bsl.remove(remove)).NY();
        }
        this.btU.clear();
    }

    public static bfs aM(Context context) {
        bfs com_fossil_bfs;
        synchronized (bhH) {
            if (btO == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                btO = new bfs(context.getApplicationContext(), handlerThread.getLooper(), atp.Ku());
            }
            com_fossil_bfs = btO;
        }
        return com_fossil_bfs;
    }

    private final void m5078b(atu<?> com_fossil_atu_) {
        bdn KB = com_fossil_atu_.KB();
        bfu com_fossil_bfu = (bfu) this.bsl.get(KB);
        if (com_fossil_bfu == null) {
            com_fossil_bfu = new bfu(this, com_fossil_atu_);
            this.bsl.put(KB, com_fossil_bfu);
        }
        if (com_fossil_bfu.Ky()) {
            this.btU.add(KB);
        }
        com_fossil_bfu.connect();
    }

    final void KD() {
        this.btR.incrementAndGet();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(10));
    }

    public final void MZ() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public final int NS() {
        return this.btQ.getAndIncrement();
    }

    final PendingIntent m5087a(bdn<?> com_fossil_bdn_, int i) {
        bfu com_fossil_bfu = (bfu) this.bsl.get(com_fossil_bdn_);
        if (com_fossil_bfu == null) {
            return null;
        }
        btu Of = com_fossil_bfu.Of();
        return Of == null ? null : PendingIntent.getActivity(this.mContext, i, Of.Kk(), 134217728);
    }

    public final cag<Void> m5088a(Iterable<? extends atu<?>> iterable) {
        bdp com_fossil_bdp = new bdp(iterable);
        for (atu KB : iterable) {
            bfu com_fossil_bfu = (bfu) this.bsl.get(KB.KB());
            if (com_fossil_bfu != null) {
                if (!com_fossil_bfu.isConnected()) {
                }
            }
            this.mHandler.sendMessage(this.mHandler.obtainMessage(2, com_fossil_bdp));
            return com_fossil_bdp.Nb();
        }
        com_fossil_bdp.Nc();
        return com_fossil_bdp.Nb();
    }

    public final void m5089a(atn com_fossil_atn, int i) {
        if (!m5094c(com_fossil_atn, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0, com_fossil_atn));
        }
    }

    public final void m5090a(atu<?> com_fossil_atu_) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, com_fossil_atu_));
    }

    public final <O extends C1879a> void m5091a(atu<O> com_fossil_atu_O, int i, bds<? extends atz, C1887c> com_fossil_bds__extends_com_fossil_atz__com_fossil_ats_c) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new bgq(new bdk(i, com_fossil_bds__extends_com_fossil_atz__com_fossil_ats_c), this.btR.get(), com_fossil_atu_O)));
    }

    public final void m5092a(bep com_fossil_bep) {
        synchronized (bhH) {
            if (this.btS != com_fossil_bep) {
                this.btS = com_fossil_bep;
                this.btT.clear();
                this.btT.addAll(com_fossil_bep.Ny());
            }
        }
    }

    final void m5093b(bep com_fossil_bep) {
        synchronized (bhH) {
            if (this.btS == com_fossil_bep) {
                this.btS = null;
                this.btT.clear();
            }
        }
    }

    final boolean m5094c(atn com_fossil_atn, int i) {
        return this.bgp.m4449a(this.mContext, com_fossil_atn, i);
    }

    public final boolean handleMessage(Message message) {
        bfu com_fossil_bfu;
        switch (message.what) {
            case 1:
                this.btN = ((Boolean) message.obj).booleanValue() ? 10000 : 300000;
                this.mHandler.removeMessages(12);
                for (bdn obtainMessage : this.bsl.keySet()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(12, obtainMessage), this.btN);
                }
                break;
            case 2:
                bdp com_fossil_bdp = (bdp) message.obj;
                for (bdn com_fossil_bdn : com_fossil_bdp.Na()) {
                    bfu com_fossil_bfu2 = (bfu) this.bsl.get(com_fossil_bdn);
                    if (com_fossil_bfu2 == null) {
                        com_fossil_bdp.m4908a(com_fossil_bdn, new atn(13));
                        break;
                    } else if (com_fossil_bfu2.isConnected()) {
                        com_fossil_bdp.m4908a(com_fossil_bdn, atn.bfH);
                    } else if (com_fossil_bfu2.Ob() != null) {
                        com_fossil_bdp.m4908a(com_fossil_bdn, com_fossil_bfu2.Ob());
                    } else {
                        com_fossil_bfu2.m5102a(com_fossil_bdp);
                    }
                }
                break;
            case 3:
                for (bfu com_fossil_bfu3 : this.bsl.values()) {
                    com_fossil_bfu3.Oa();
                    com_fossil_bfu3.connect();
                }
                break;
            case 4:
            case 8:
            case 13:
                bgq com_fossil_bgq = (bgq) message.obj;
                com_fossil_bfu = (bfu) this.bsl.get(com_fossil_bgq.buF.KB());
                if (com_fossil_bfu == null) {
                    m5078b(com_fossil_bgq.buF);
                    com_fossil_bfu = (bfu) this.bsl.get(com_fossil_bgq.buF.KB());
                }
                if (com_fossil_bfu.Ky() && this.btR.get() != com_fossil_bgq.buE) {
                    com_fossil_bgq.buD.mo1271h(btL);
                    com_fossil_bfu.NY();
                    break;
                }
                com_fossil_bfu.m5101a(com_fossil_bgq.buD);
                break;
                break;
            case 5:
                String valueOf;
                String valueOf2;
                int i = message.arg1;
                atn com_fossil_atn = (atn) message.obj;
                for (bfu com_fossil_bfu4 : this.bsl.values()) {
                    if (com_fossil_bfu4.getInstanceId() == i) {
                        if (com_fossil_bfu4 != null) {
                            Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                            break;
                        }
                        valueOf = String.valueOf(this.bgp.ho(com_fossil_atn.getErrorCode()));
                        valueOf2 = String.valueOf(com_fossil_atn.getErrorMessage());
                        com_fossil_bfu4.m5104k(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
                        break;
                    }
                }
                com_fossil_bfu4 = null;
                if (com_fossil_bfu4 != null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i + " while trying to fail enqueued calls.", new Exception());
                } else {
                    valueOf = String.valueOf(this.bgp.ho(com_fossil_atn.getErrorCode()));
                    valueOf2 = String.valueOf(com_fossil_atn.getErrorMessage());
                    com_fossil_bfu4.m5104k(new Status(17, new StringBuilder((String.valueOf(valueOf).length() + 69) + String.valueOf(valueOf2).length()).append("Error resolution was canceled by the user, original error message: ").append(valueOf).append(": ").append(valueOf2).toString()));
                }
            case 6:
                if (this.mContext.getApplicationContext() instanceof Application) {
                    bdq.m4909a((Application) this.mContext.getApplicationContext());
                    bdq.Nd().m4910a(new bft(this));
                    if (!bdq.Nd().aZ(true)) {
                        this.btN = 300000;
                        break;
                    }
                }
                break;
            case 7:
                m5078b((atu) message.obj);
                break;
            case 9:
                if (this.bsl.containsKey(message.obj)) {
                    ((bfu) this.bsl.get(message.obj)).resume();
                    break;
                }
                break;
            case 10:
                NT();
                break;
            case 11:
                if (this.bsl.containsKey(message.obj)) {
                    ((bfu) this.bsl.get(message.obj)).NJ();
                    break;
                }
                break;
            case 12:
                if (this.bsl.containsKey(message.obj)) {
                    ((bfu) this.bsl.get(message.obj)).Oe();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }
}
