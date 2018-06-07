package android.support.v8.renderscript;

import android.os.Build.VERSION;
import android.support.v8.renderscript.Script.FieldID;
import android.support.v8.renderscript.Script.KernelID;

public class ScriptIntrinsicBlur extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues = new float[9];

    protected ScriptIntrinsicBlur(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicBlur create(RenderScript renderScript, Element element) {
        if (element.isCompatible(Element.U8_4(renderScript)) || element.isCompatible(Element.U8(renderScript))) {
            boolean z = renderScript.isUseNative() && VERSION.SDK_INT < 19;
            ScriptIntrinsicBlur scriptIntrinsicBlur = new ScriptIntrinsicBlur(renderScript.nScriptIntrinsicCreate(5, element.getID(renderScript), z), renderScript);
            scriptIntrinsicBlur.setIncSupp(z);
            scriptIntrinsicBlur.setRadius(5.0f);
            return scriptIntrinsicBlur;
        }
        throw new RSIllegalArgumentException("Unsupported element type.");
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, (BaseObj) allocation);
    }

    public void setRadius(float f) {
        if (f <= 0.0f || f > 25.0f) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        }
        setVar(0, f);
    }

    public void forEach(Allocation allocation) {
        forEach(0, (Allocation) null, allocation, null);
    }

    public KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }
}
