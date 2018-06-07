package android.support.v8.renderscript;

import android.os.Build.VERSION;
import android.support.v8.renderscript.Script.FieldID;
import android.support.v8.renderscript.Script.KernelID;
import android.support.v8.renderscript.Script.LaunchOptions;

public class ScriptIntrinsicConvolve5x5 extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;
    private final float[] mValues = new float[25];

    ScriptIntrinsicConvolve5x5(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicConvolve5x5 create(RenderScript renderScript, Element element) {
        if (element.isCompatible(Element.U8(renderScript)) || element.isCompatible(Element.U8_2(renderScript)) || element.isCompatible(Element.U8_3(renderScript)) || element.isCompatible(Element.U8_4(renderScript)) || element.isCompatible(Element.F32(renderScript)) || element.isCompatible(Element.F32_2(renderScript)) || element.isCompatible(Element.F32_3(renderScript)) || element.isCompatible(Element.F32_4(renderScript))) {
            boolean z = renderScript.isUseNative() && VERSION.SDK_INT < 19;
            ScriptIntrinsicConvolve5x5 scriptIntrinsicConvolve5x5 = new ScriptIntrinsicConvolve5x5(renderScript.nScriptIntrinsicCreate(4, element.getID(renderScript), z), renderScript);
            scriptIntrinsicConvolve5x5.setIncSupp(z);
            return scriptIntrinsicConvolve5x5;
        }
        throw new RSIllegalArgumentException("Unsupported element type.");
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(1, (BaseObj) allocation);
    }

    public void setCoefficients(float[] fArr) {
        FieldPacker fieldPacker = new FieldPacker(100);
        for (int i = 0; i < this.mValues.length; i++) {
            this.mValues[i] = fArr[i];
            fieldPacker.addF32(this.mValues[i]);
        }
        setVar(0, fieldPacker);
    }

    public void forEach(Allocation allocation) {
        forEach(0, (Allocation) null, allocation, null);
    }

    public void forEach(Allocation allocation, LaunchOptions launchOptions) {
        forEach(0, (Allocation) null, allocation, null, launchOptions);
    }

    public KernelID getKernelID() {
        return createKernelID(0, 2, null, null);
    }

    public FieldID getFieldID_Input() {
        return createFieldID(1, null);
    }
}
