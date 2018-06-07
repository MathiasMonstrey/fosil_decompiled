package com.fossil;

import android.os.Binder;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public final class bpp extends boe {
    private Boolean bBV;
    private String bBW;
    private final bpk zzboe;

    public bpp(bpk com_fossil_bpk) {
        this(com_fossil_bpk, null);
    }

    private bpp(bpk com_fossil_bpk, String str) {
        awa.bO(com_fossil_bpk);
        this.zzboe = com_fossil_bpk;
        this.bBW = null;
    }

    private final void m5503b(bnh com_fossil_bnh, boolean z) {
        awa.bO(com_fossil_bnh);
        m5504l(com_fossil_bnh.packageName, false);
        this.zzboe.Pb().eE(com_fossil_bnh.bxq);
    }

    private final void m5504l(String str, boolean z) {
        boolean z2 = false;
        if (TextUtils.isEmpty(str)) {
            this.zzboe.Pf().Rc().log("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.bBV == null) {
                    if ("com.google.android.gms".equals(this.bBW) || axz.m4689B(this.zzboe.getContext(), Binder.getCallingUid()) || ayp.aA(this.zzboe.getContext()).m4701a(this.zzboe.getContext().getPackageManager(), Binder.getCallingUid())) {
                        z2 = true;
                    }
                    this.bBV = Boolean.valueOf(z2);
                }
                if (this.bBV.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.zzboe.Pf().Rc().m5439d("Measurement Service called with invalid calling package. appId", bol.ei(str));
                throw e;
            }
        }
        if (this.bBW == null && ayo.m4454a(this.zzboe.getContext(), Binder.getCallingUid(), str)) {
            this.bBW = str;
        }
        if (!str.equals(this.bBW)) {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
        }
    }

    public final List<bsh> mo1428a(bnh com_fossil_bnh, boolean z) {
        Object e;
        m5503b(com_fossil_bnh, false);
        try {
            List<bsj> list = (List) this.zzboe.Pe().m5467d(new bqe(this, com_fossil_bnh)).get();
            List<bsh> arrayList = new ArrayList(list.size());
            for (bsj com_fossil_bsj : list) {
                if (z || !bsk.eI(com_fossil_bsj.mName)) {
                    arrayList.add(new bsh(com_fossil_bsj));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(com_fossil_bnh.packageName), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(com_fossil_bnh.packageName), e);
            return null;
        }
    }

    public final List<bnk> mo1429a(String str, String str2, bnh com_fossil_bnh) {
        Object e;
        m5503b(com_fossil_bnh, false);
        try {
            return (List) this.zzboe.Pe().m5467d(new bpx(this, com_fossil_bnh, str, str2)).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.zzboe.Pf().Rc().m5439d("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }

    public final List<bsh> mo1430a(String str, String str2, String str3, boolean z) {
        Object e;
        m5504l(str, true);
        try {
            List<bsj> list = (List) this.zzboe.Pe().m5467d(new bpw(this, str, str2, str3)).get();
            List<bsh> arrayList = new ArrayList(list.size());
            for (bsj com_fossil_bsj : list) {
                if (z || !bsk.eI(com_fossil_bsj.mName)) {
                    arrayList.add(new bsh(com_fossil_bsj));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(str), e);
            return Collections.emptyList();
        }
    }

    public final List<bsh> mo1431a(String str, String str2, boolean z, bnh com_fossil_bnh) {
        Object e;
        m5503b(com_fossil_bnh, false);
        try {
            List<bsj> list = (List) this.zzboe.Pe().m5467d(new bpv(this, com_fossil_bnh, str, str2)).get();
            List<bsh> arrayList = new ArrayList(list.size());
            for (bsj com_fossil_bsj : list) {
                if (z || !bsk.eI(com_fossil_bsj.mName)) {
                    arrayList.add(new bsh(com_fossil_bsj));
                }
            }
            return arrayList;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(com_fossil_bnh.packageName), e);
            return Collections.emptyList();
        } catch (ExecutionException e3) {
            e = e3;
            this.zzboe.Pf().Rc().m5437a("Failed to get user attributes. appId", bol.ei(com_fossil_bnh.packageName), e);
            return Collections.emptyList();
        }
    }

    public final void mo1432a(long j, String str, String str2, String str3) {
        this.zzboe.Pe().m5469h(new bqg(this, str2, str3, str, j));
    }

    public final void mo1433a(bnh com_fossil_bnh) {
        m5503b(com_fossil_bnh, false);
        Runnable com_fossil_bqf = new bqf(this, com_fossil_bnh);
        if (this.zzboe.Pe().Rw()) {
            com_fossil_bqf.run();
        } else {
            this.zzboe.Pe().m5469h(com_fossil_bqf);
        }
    }

    public final void mo1434a(bnk com_fossil_bnk, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnk);
        awa.bO(com_fossil_bnk.bxD);
        m5503b(com_fossil_bnh, false);
        bnk com_fossil_bnk2 = new bnk(com_fossil_bnk);
        com_fossil_bnk2.packageName = com_fossil_bnh.packageName;
        if (com_fossil_bnk.bxD.getValue() == null) {
            this.zzboe.Pe().m5469h(new bpr(this, com_fossil_bnk2, com_fossil_bnh));
        } else {
            this.zzboe.Pe().m5469h(new bps(this, com_fossil_bnk2, com_fossil_bnh));
        }
    }

    public final void mo1435a(bnz com_fossil_bnz, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bnz);
        m5503b(com_fossil_bnh, false);
        this.zzboe.Pe().m5469h(new bpz(this, com_fossil_bnz, com_fossil_bnh));
    }

    public final void mo1436a(bnz com_fossil_bnz, String str, String str2) {
        awa.bO(com_fossil_bnz);
        awa.df(str);
        m5504l(str, true);
        this.zzboe.Pe().m5469h(new bqa(this, com_fossil_bnz, str));
    }

    public final void mo1437a(bsh com_fossil_bsh, bnh com_fossil_bnh) {
        awa.bO(com_fossil_bsh);
        m5503b(com_fossil_bnh, false);
        if (com_fossil_bsh.getValue() == null) {
            this.zzboe.Pe().m5469h(new bqc(this, com_fossil_bsh, com_fossil_bnh));
        } else {
            this.zzboe.Pe().m5469h(new bqd(this, com_fossil_bsh, com_fossil_bnh));
        }
    }

    public final byte[] mo1438a(bnz com_fossil_bnz, String str) {
        Object e;
        awa.df(str);
        awa.bO(com_fossil_bnz);
        m5504l(str, true);
        this.zzboe.Pf().Rh().m5439d("Log and bundle. event", this.zzboe.Pa().ef(com_fossil_bnz.name));
        long nanoTime = this.zzboe.OX().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zzboe.Pe().m5468e(new bqb(this, com_fossil_bnz, str)).get();
            if (bArr == null) {
                this.zzboe.Pf().Rc().m5439d("Log and bundle returned null. appId", bol.ei(str));
                bArr = new byte[0];
            }
            this.zzboe.Pf().Rh().m5438a("Log and bundle processed. event, size, time_ms", this.zzboe.Pa().ef(com_fossil_bnz.name), Integer.valueOf(bArr.length), Long.valueOf((this.zzboe.OX().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException e2) {
            e = e2;
            this.zzboe.Pf().Rc().m5438a("Failed to log and bundle. appId, event, error", bol.ei(str), this.zzboe.Pa().ef(com_fossil_bnz.name), e);
            return null;
        } catch (ExecutionException e3) {
            e = e3;
            this.zzboe.Pf().Rc().m5438a("Failed to log and bundle. appId, event, error", bol.ei(str), this.zzboe.Pa().ef(com_fossil_bnz.name), e);
            return null;
        }
    }

    public final void mo1439b(bnh com_fossil_bnh) {
        m5503b(com_fossil_bnh, false);
        this.zzboe.Pe().m5469h(new bpq(this, com_fossil_bnh));
    }

    public final void mo1440b(bnk com_fossil_bnk) {
        awa.bO(com_fossil_bnk);
        awa.bO(com_fossil_bnk.bxD);
        m5504l(com_fossil_bnk.packageName, true);
        bnk com_fossil_bnk2 = new bnk(com_fossil_bnk);
        if (com_fossil_bnk.bxD.getValue() == null) {
            this.zzboe.Pe().m5469h(new bpt(this, com_fossil_bnk2));
        } else {
            this.zzboe.Pe().m5469h(new bpu(this, com_fossil_bnk2));
        }
    }

    public final String mo1441c(bnh com_fossil_bnh) {
        m5503b(com_fossil_bnh, false);
        return this.zzboe.ev(com_fossil_bnh.packageName);
    }

    public final List<bnk> mo1442g(String str, String str2, String str3) {
        Object e;
        m5504l(str, true);
        try {
            return (List) this.zzboe.Pe().m5467d(new bpy(this, str, str2, str3)).get();
        } catch (InterruptedException e2) {
            e = e2;
        } catch (ExecutionException e3) {
            e = e3;
        }
        this.zzboe.Pf().Rc().m5439d("Failed to get conditional user properties", e);
        return Collections.emptyList();
    }
}
