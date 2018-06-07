package android.support.v8.renderscript;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ScriptC extends Script {
    private static final String TAG = "ScriptC";

    protected ScriptC(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    protected ScriptC(RenderScript renderScript, Resources resources, int i) {
        super(0, renderScript);
        long internalCreate = internalCreate(renderScript, resources, i);
        if (internalCreate == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(internalCreate);
    }

    protected ScriptC(RenderScript renderScript, String str, byte[] bArr, byte[] bArr2) {
        long internalStringCreate;
        super(0, renderScript);
        if (RenderScript.sPointerSize == 4) {
            internalStringCreate = internalStringCreate(renderScript, str, bArr);
        } else {
            internalStringCreate = internalStringCreate(renderScript, str, bArr2);
        }
        if (internalStringCreate == 0) {
            throw new RSRuntimeException("Loading of ScriptC script failed.");
        }
        setID(internalStringCreate);
    }

    private static synchronized long internalCreate(RenderScript renderScript, Resources resources, int i) {
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            InputStream openRawResource = resources.openRawResource(i);
            try {
                Object obj = new byte[1024];
                int i2 = 0;
                while (true) {
                    Object obj2;
                    int length = obj.length - i2;
                    if (length == 0) {
                        obj2 = new byte[(obj.length * 2)];
                        System.arraycopy(obj, 0, obj2, 0, obj.length);
                        length = obj2.length - i2;
                    } else {
                        obj2 = obj;
                    }
                    length = openRawResource.read(obj2, i2, length);
                    if (length <= 0) {
                        openRawResource.close();
                        nScriptCCreate = renderScript.nScriptCCreate(resources.getResourceEntryName(i), renderScript.getApplicationContext().getCacheDir().toString(), obj2, i2);
                    } else {
                        i2 = length + i2;
                        obj = obj2;
                    }
                }
            } catch (IOException e) {
                throw new NotFoundException();
            } catch (Throwable th) {
                openRawResource.close();
            }
        }
        return nScriptCCreate;
    }

    private static synchronized long internalStringCreate(RenderScript renderScript, String str, byte[] bArr) {
        long nScriptCCreate;
        synchronized (ScriptC.class) {
            nScriptCCreate = renderScript.nScriptCCreate(str, renderScript.getApplicationContext().getCacheDir().toString(), bArr, bArr.length);
        }
        return nScriptCCreate;
    }
}
