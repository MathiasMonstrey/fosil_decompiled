package com.fossil;

import java.util.Queue;

abstract class vk<T extends vq> {
    private final Queue<T> aCo = abl.eR(20);

    protected abstract T vc();

    vk() {
    }

    protected T vd() {
        vq vqVar = (vq) this.aCo.poll();
        if (vqVar == null) {
            return vc();
        }
        return vqVar;
    }

    public void m13906a(T t) {
        if (this.aCo.size() < 20) {
            this.aCo.offer(t);
        }
    }
}
