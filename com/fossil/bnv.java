package com.fossil;

final class bnv {
    final long byk;
    final long byl;
    final long bym;
    final String mAppId;
    final String mName;

    bnv(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        awa.df(str);
        awa.df(str2);
        awa.aY(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        awa.aY(z);
        this.mAppId = str;
        this.mName = str2;
        this.byk = j;
        this.byl = j2;
        this.bym = j3;
    }

    final bnv QX() {
        return new bnv(this.mAppId, this.mName, this.byk + 1, this.byl + 1, this.bym);
    }

    final bnv al(long j) {
        return new bnv(this.mAppId, this.mName, this.byk, this.byl, j);
    }
}
