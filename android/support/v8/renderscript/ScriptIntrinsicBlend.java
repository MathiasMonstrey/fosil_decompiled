package android.support.v8.renderscript;

import android.os.Build.VERSION;
import android.support.v8.renderscript.Script.KernelID;

public class ScriptIntrinsicBlend extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;

    ScriptIntrinsicBlend(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicBlend create(RenderScript renderScript, Element element) {
        boolean z = renderScript.isUseNative() && VERSION.SDK_INT < 19;
        ScriptIntrinsicBlend scriptIntrinsicBlend = new ScriptIntrinsicBlend(renderScript.nScriptIntrinsicCreate(7, element.getID(renderScript), z), renderScript);
        scriptIntrinsicBlend.setIncSupp(z);
        return scriptIntrinsicBlend;
    }

    private void blend(int i, Allocation allocation, Allocation allocation2) {
        if (!allocation.getElement().isCompatible(Element.U8_4(this.mRS))) {
            throw new RSIllegalArgumentException("Input is not of expected format.");
        } else if (allocation2.getElement().isCompatible(Element.U8_4(this.mRS))) {
            forEach(i, allocation, allocation2, null);
        } else {
            throw new RSIllegalArgumentException("Output is not of expected format.");
        }
    }

    public void forEachClear(Allocation allocation, Allocation allocation2) {
        blend(0, allocation, allocation2);
    }

    public KernelID getKernelIDClear() {
        return createKernelID(0, 3, null, null);
    }

    public void forEachSrc(Allocation allocation, Allocation allocation2) {
        blend(1, allocation, allocation2);
    }

    public KernelID getKernelIDSrc() {
        return createKernelID(1, 3, null, null);
    }

    public void forEachDst(Allocation allocation, Allocation allocation2) {
    }

    public KernelID getKernelIDDst() {
        return createKernelID(2, 3, null, null);
    }

    public void forEachSrcOver(Allocation allocation, Allocation allocation2) {
        blend(3, allocation, allocation2);
    }

    public KernelID getKernelIDSrcOver() {
        return createKernelID(3, 3, null, null);
    }

    public void forEachDstOver(Allocation allocation, Allocation allocation2) {
        blend(4, allocation, allocation2);
    }

    public KernelID getKernelIDDstOver() {
        return createKernelID(4, 3, null, null);
    }

    public void forEachSrcIn(Allocation allocation, Allocation allocation2) {
        blend(5, allocation, allocation2);
    }

    public KernelID getKernelIDSrcIn() {
        return createKernelID(5, 3, null, null);
    }

    public void forEachDstIn(Allocation allocation, Allocation allocation2) {
        blend(6, allocation, allocation2);
    }

    public KernelID getKernelIDDstIn() {
        return createKernelID(6, 3, null, null);
    }

    public void forEachSrcOut(Allocation allocation, Allocation allocation2) {
        blend(7, allocation, allocation2);
    }

    public KernelID getKernelIDSrcOut() {
        return createKernelID(7, 3, null, null);
    }

    public void forEachDstOut(Allocation allocation, Allocation allocation2) {
        blend(8, allocation, allocation2);
    }

    public KernelID getKernelIDDstOut() {
        return createKernelID(8, 3, null, null);
    }

    public void forEachSrcAtop(Allocation allocation, Allocation allocation2) {
        blend(9, allocation, allocation2);
    }

    public KernelID getKernelIDSrcAtop() {
        return createKernelID(9, 3, null, null);
    }

    public void forEachDstAtop(Allocation allocation, Allocation allocation2) {
        blend(10, allocation, allocation2);
    }

    public KernelID getKernelIDDstAtop() {
        return createKernelID(10, 3, null, null);
    }

    public void forEachXor(Allocation allocation, Allocation allocation2) {
        blend(11, allocation, allocation2);
    }

    public KernelID getKernelIDXor() {
        return createKernelID(11, 3, null, null);
    }

    public void forEachMultiply(Allocation allocation, Allocation allocation2) {
        blend(14, allocation, allocation2);
    }

    public KernelID getKernelIDMultiply() {
        return createKernelID(14, 3, null, null);
    }

    public void forEachAdd(Allocation allocation, Allocation allocation2) {
        blend(34, allocation, allocation2);
    }

    public KernelID getKernelIDAdd() {
        return createKernelID(34, 3, null, null);
    }

    public void forEachSubtract(Allocation allocation, Allocation allocation2) {
        blend(35, allocation, allocation2);
    }

    public KernelID getKernelIDSubtract() {
        return createKernelID(35, 3, null, null);
    }
}
