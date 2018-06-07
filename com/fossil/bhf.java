package com.fossil;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

final class bhf extends Handler {
    private /* synthetic */ bhd buW;

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                atw com_fossil_atw = (atw) message.obj;
                synchronized (this.buW.brE) {
                    if (com_fossil_atw == null) {
                        this.buW.buP.m5170l(new Status(13, "Transform returned null"));
                    } else if (com_fossil_atw instanceof bgu) {
                        this.buW.buP.m5170l(((bgu) com_fossil_atw).Ka());
                    } else {
                        this.buW.buP.m5172a(com_fossil_atw);
                    }
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String str = "TransformedResultImpl";
                String str2 = "Runtime exception on the transformation worker thread: ";
                String valueOf = String.valueOf(runtimeException.getMessage());
                Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                return;
        }
    }
}
