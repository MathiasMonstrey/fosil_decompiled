package com.fossil;

final class bft implements bdr {
    private /* synthetic */ bfs btV;

    bft(bfs com_fossil_bfs) {
        this.btV = com_fossil_bfs;
    }

    public final void ba(boolean z) {
        this.btV.mHandler.sendMessage(this.btV.mHandler.obtainMessage(1, Boolean.valueOf(z)));
    }
}
