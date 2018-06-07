package com.fossil;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.os.Handler;
import android.os.Looper;
import android.view.DragEvent;
import android.view.View;
import android.view.View.OnDragListener;

public abstract class dgy implements OnDragListener {
    private Handler mHandler;

    public abstract boolean m8540a(View view, String str);

    public abstract boolean aof();

    public abstract void aog();

    public abstract void iw(String str);

    public abstract void ix(String str);

    public boolean onDrag(View view, DragEvent dragEvent) {
        switch (dragEvent.getAction()) {
            case 1:
                if (this.mHandler == null) {
                    this.mHandler = new Handler(Looper.getMainLooper());
                    break;
                }
                break;
            case 3:
                m8538a(view, dragEvent);
                break;
            case 4:
                if (!dragEvent.getResult()) {
                    aog();
                    break;
                }
                break;
            case 5:
                m8539b(dragEvent);
                break;
            case 6:
                m8536a(dragEvent);
                break;
        }
        return true;
    }

    private void m8536a(DragEvent dragEvent) {
        ClipDescription clipDescription = dragEvent.getClipDescription();
        if (clipDescription != null) {
            String charSequence = clipDescription.getLabel().toString();
            Object obj = -1;
            switch (charSequence.hashCode()) {
                case -1787728117:
                    if (charSequence.equals("SWAP_PRESET")) {
                        obj = null;
                        break;
                    }
                    break;
                case -1602256410:
                    if (charSequence.equals("MICRO_APP")) {
                        obj = 1;
                        break;
                    }
                    break;
            }
            switch (obj) {
                case null:
                    this.mHandler.removeCallbacksAndMessages(null);
                    return;
                case 1:
                    ix(charSequence);
                    return;
                default:
                    return;
            }
        }
    }

    private void m8539b(DragEvent dragEvent) {
        ClipDescription clipDescription = dragEvent.getClipDescription();
        if (clipDescription != null) {
            final String charSequence = clipDescription.getLabel().toString();
            if (charSequence.equals("SWAP_PRESET")) {
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ dgy cTS;

                    public void run() {
                        this.cTS.iw(charSequence);
                    }
                }, 150);
            } else {
                iw(charSequence);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m8538a(android.view.View r6, android.view.DragEvent r7) {
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.mHandler;
        if (r1 == 0) goto L_0x000b;
    L_0x0005:
        r1 = r5.mHandler;
        r2 = 0;
        r1.removeCallbacksAndMessages(r2);
    L_0x000b:
        r2 = r7.getClipData();
        if (r2 == 0) goto L_0x0017;
    L_0x0011:
        r1 = r2.getItemCount();
        if (r1 != 0) goto L_0x0018;
    L_0x0017:
        return r0;
    L_0x0018:
        r1 = r2.getDescription();
        if (r1 == 0) goto L_0x0017;
    L_0x001e:
        r1 = r1.getLabel();
        r3 = r1.toString();
        r1 = -1;
        r4 = r3.hashCode();
        switch(r4) {
            case -1787728117: goto L_0x0037;
            default: goto L_0x002e;
        };
    L_0x002e:
        r0 = r1;
    L_0x002f:
        switch(r0) {
            case 0: goto L_0x0040;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r5.m8537a(r6, r2);
        goto L_0x0017;
    L_0x0037:
        r4 = "SWAP_PRESET";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x002e;
    L_0x003f:
        goto L_0x002f;
    L_0x0040:
        r0 = r5.aof();
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.dgy.a(android.view.View, android.view.DragEvent):boolean");
    }

    private boolean m8537a(View view, ClipData clipData) {
        Item itemAt = clipData.getItemAt(0);
        if (itemAt == null || !m8540a(view, itemAt.getText().toString())) {
            return false;
        }
        return true;
    }
}
