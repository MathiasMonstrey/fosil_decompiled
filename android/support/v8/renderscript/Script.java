package android.support.v8.renderscript;

import android.util.SparseArray;

public class Script extends BaseObj {
    private final SparseArray<FieldID> mFIDs = new SparseArray();
    private final SparseArray<InvokeID> mIIDs = new SparseArray();
    private final SparseArray<KernelID> mKIDs = new SparseArray();
    private boolean mUseIncSupp = false;

    public static class Builder {
        RenderScript mRS;

        Builder(RenderScript renderScript) {
            this.mRS = renderScript;
        }
    }

    public static class FieldBase {
        protected Allocation mAllocation;
        protected Element mElement;

        protected void init(RenderScript renderScript, int i) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, 1);
        }

        protected void init(RenderScript renderScript, int i, int i2) {
            this.mAllocation = Allocation.createSized(renderScript, this.mElement, i, i2 | 1);
        }

        protected FieldBase() {
        }

        public Element getElement() {
            return this.mElement;
        }

        public Type getType() {
            return this.mAllocation.getType();
        }

        public Allocation getAllocation() {
            return this.mAllocation;
        }

        public void updateAllocation() {
        }
    }

    public static final class FieldID extends BaseObj {
        android.renderscript.Script.FieldID mN;
        Script mScript;
        int mSlot;

        FieldID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    public static final class InvokeID extends BaseObj {
        Script mScript;
        int mSlot;

        InvokeID(long j, RenderScript renderScript, Script script, int i) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
        }
    }

    public static final class KernelID extends BaseObj {
        android.renderscript.Script.KernelID mN;
        Script mScript;
        int mSig;
        int mSlot;

        KernelID(long j, RenderScript renderScript, Script script, int i, int i2) {
            super(j, renderScript);
            this.mScript = script;
            this.mSlot = i;
            this.mSig = i2;
        }
    }

    public static final class LaunchOptions {
        private int strategy;
        private int xend = 0;
        private int xstart = 0;
        private int yend = 0;
        private int ystart = 0;
        private int zend = 0;
        private int zstart = 0;

        public LaunchOptions setX(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.xstart = i;
            this.xend = i2;
            return this;
        }

        public LaunchOptions setY(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.ystart = i;
            this.yend = i2;
            return this;
        }

        public LaunchOptions setZ(int i, int i2) {
            if (i < 0 || i2 <= i) {
                throw new RSIllegalArgumentException("Invalid dimensions");
            }
            this.zstart = i;
            this.zend = i2;
            return this;
        }

        public int getXStart() {
            return this.xstart;
        }

        public int getXEnd() {
            return this.xend;
        }

        public int getYStart() {
            return this.ystart;
        }

        public int getYEnd() {
            return this.yend;
        }

        public int getZStart() {
            return this.zstart;
        }

        public int getZEnd() {
            return this.zend;
        }
    }

    protected void setIncSupp(boolean z) {
        this.mUseIncSupp = z;
    }

    protected boolean isIncSupp() {
        return this.mUseIncSupp;
    }

    long getDummyAlloc(Allocation allocation) {
        if (allocation == null) {
            return 0;
        }
        Type type = allocation.getType();
        long nIncAllocationCreateTyped = this.mRS.nIncAllocationCreateTyped(allocation.getID(this.mRS), type.getDummyType(this.mRS, type.getElement().getDummyElement(this.mRS)), type.getX() * type.getElement().getBytesSize());
        allocation.setIncAllocID(nIncAllocationCreateTyped);
        return nIncAllocationCreateTyped;
    }

    protected KernelID createKernelID(int i, int i2, Element element, Element element2) {
        KernelID kernelID = (KernelID) this.mKIDs.get(i);
        if (kernelID != null) {
            return kernelID;
        }
        long nScriptKernelIDCreate = this.mRS.nScriptKernelIDCreate(getID(this.mRS), i, i2, this.mUseIncSupp);
        if (nScriptKernelIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        KernelID kernelID2 = new KernelID(nScriptKernelIDCreate, this.mRS, this, i, i2);
        this.mKIDs.put(i, kernelID2);
        return kernelID2;
    }

    protected InvokeID createInvokeID(int i) {
        InvokeID invokeID = (InvokeID) this.mIIDs.get(i);
        if (invokeID != null) {
            return invokeID;
        }
        long nScriptInvokeIDCreate = this.mRS.nScriptInvokeIDCreate(getID(this.mRS), i);
        if (nScriptInvokeIDCreate == 0) {
            throw new RSDriverException("Failed to create KernelID");
        }
        InvokeID invokeID2 = new InvokeID(nScriptInvokeIDCreate, this.mRS, this, i);
        this.mIIDs.put(i, invokeID2);
        return invokeID2;
    }

    protected FieldID createFieldID(int i, Element element) {
        FieldID fieldID = (FieldID) this.mFIDs.get(i);
        if (fieldID != null) {
            return fieldID;
        }
        long nScriptFieldIDCreate = this.mRS.nScriptFieldIDCreate(getID(this.mRS), i, this.mUseIncSupp);
        if (nScriptFieldIDCreate == 0) {
            throw new RSDriverException("Failed to create FieldID");
        }
        FieldID fieldID2 = new FieldID(nScriptFieldIDCreate, this.mRS, this, i);
        this.mFIDs.put(i, fieldID2);
        return fieldID2;
    }

    protected void invoke(int i) {
        this.mRS.nScriptInvoke(getID(this.mRS), i, this.mUseIncSupp);
    }

    protected void invoke(int i, FieldPacker fieldPacker) {
        if (fieldPacker != null) {
            this.mRS.nScriptInvokeV(getID(this.mRS), i, fieldPacker.getData(), this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptInvoke(getID(this.mRS), i, this.mUseIncSupp);
    }

    public void bindAllocation(Allocation allocation, int i) {
        this.mRS.validate();
        if (allocation != null) {
            this.mRS.nScriptBindAllocation(getID(this.mRS), allocation.getID(this.mRS), i, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptBindAllocation(getID(this.mRS), 0, i, this.mUseIncSupp);
    }

    public void setTimeZone(String str) {
        this.mRS.validate();
        try {
            this.mRS.nScriptSetTimeZone(getID(this.mRS), str.getBytes("UTF-8"), this.mUseIncSupp);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    protected void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker) {
        long j = 0;
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long id;
        if (allocation != null) {
            id = allocation.getID(this.mRS);
        } else {
            id = 0;
        }
        if (allocation2 != null) {
            j = allocation2.getID(this.mRS);
        }
        byte[] bArr = null;
        if (fieldPacker != null) {
            bArr = fieldPacker.getData();
        }
        if (this.mUseIncSupp) {
            int i2 = i;
            this.mRS.nScriptForEach(getID(this.mRS), i2, getDummyAlloc(allocation), getDummyAlloc(allocation2), bArr, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptForEach(getID(this.mRS), i, id, j, bArr, this.mUseIncSupp);
    }

    protected void forEach(int i, Allocation allocation, Allocation allocation2, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        if (allocation == null && allocation2 == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        } else if (launchOptions == null) {
            forEach(i, allocation, allocation2, fieldPacker);
        } else {
            long j = 0;
            long j2 = 0;
            if (allocation != null) {
                j = allocation.getID(this.mRS);
            }
            if (allocation2 != null) {
                j2 = allocation2.getID(this.mRS);
            }
            byte[] bArr = null;
            if (fieldPacker != null) {
                bArr = fieldPacker.getData();
            }
            int i2;
            if (this.mUseIncSupp) {
                j = getDummyAlloc(allocation);
                j2 = getDummyAlloc(allocation2);
                i2 = i;
                this.mRS.nScriptForEachClipped(getID(this.mRS), i2, j, j2, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
                return;
            }
            i2 = i;
            this.mRS.nScriptForEachClipped(getID(this.mRS), i2, j, j2, bArr, launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend, this.mUseIncSupp);
        }
    }

    Script(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    protected void forEach(int i, Allocation[] allocationArr, Allocation allocation, FieldPacker fieldPacker) {
        forEach(i, allocationArr, allocation, fieldPacker, null);
    }

    protected void forEach(int i, Allocation[] allocationArr, Allocation allocation, FieldPacker fieldPacker, LaunchOptions launchOptions) {
        int i2;
        int[] iArr = null;
        this.mRS.validate();
        if (allocationArr != null) {
            for (BaseObj validateObject : allocationArr) {
                this.mRS.validateObject(validateObject);
            }
        }
        this.mRS.validateObject(allocation);
        if (allocationArr == null && allocation == null) {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
        long[] jArr;
        byte[] data;
        if (allocationArr != null) {
            jArr = new long[allocationArr.length];
            for (i2 = 0; i2 < allocationArr.length; i2++) {
                jArr[i2] = allocationArr[i2].getID(this.mRS);
            }
        } else {
            jArr = null;
        }
        long j = 0;
        if (allocation != null) {
            j = allocation.getID(this.mRS);
        }
        if (fieldPacker != null) {
            data = fieldPacker.getData();
        } else {
            data = null;
        }
        if (launchOptions != null) {
            iArr = new int[]{launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend};
        }
        this.mRS.nScriptForEach(getID(this.mRS), i, jArr, j, data, iArr);
    }

    protected void reduce(int i, Allocation[] allocationArr, Allocation allocation, LaunchOptions launchOptions) {
        this.mRS.validate();
        if (allocationArr == null || allocationArr.length < 1) {
            throw new RSIllegalArgumentException("At least one input is required.");
        } else if (allocation == null) {
            throw new RSIllegalArgumentException("aout is required to be non-null.");
        } else {
            int i2;
            for (BaseObj validateObject : allocationArr) {
                this.mRS.validateObject(validateObject);
            }
            long[] jArr = new long[allocationArr.length];
            for (i2 = 0; i2 < allocationArr.length; i2++) {
                jArr[i2] = allocationArr[i2].getID(this.mRS);
            }
            long id = allocation.getID(this.mRS);
            int[] iArr = null;
            if (launchOptions != null) {
                iArr = new int[]{launchOptions.xstart, launchOptions.xend, launchOptions.ystart, launchOptions.yend, launchOptions.zstart, launchOptions.zend};
            }
            this.mRS.nScriptReduce(getID(this.mRS), i, jArr, id, iArr);
        }
    }

    public void setVar(int i, float f) {
        this.mRS.nScriptSetVarF(getID(this.mRS), i, f, this.mUseIncSupp);
    }

    public void setVar(int i, double d) {
        this.mRS.nScriptSetVarD(getID(this.mRS), i, d, this.mUseIncSupp);
    }

    public void setVar(int i, int i2) {
        this.mRS.nScriptSetVarI(getID(this.mRS), i, i2, this.mUseIncSupp);
    }

    public void setVar(int i, long j) {
        this.mRS.nScriptSetVarJ(getID(this.mRS), i, j, this.mUseIncSupp);
    }

    public void setVar(int i, boolean z) {
        this.mRS.nScriptSetVarI(getID(this.mRS), i, z ? 1 : 0, this.mUseIncSupp);
    }

    public void setVar(int i, BaseObj baseObj) {
        long j = 0;
        if (this.mUseIncSupp) {
            long dummyAlloc = getDummyAlloc((Allocation) baseObj);
            RenderScript renderScript = this.mRS;
            long id = getID(this.mRS);
            if (baseObj != null) {
                j = dummyAlloc;
            }
            renderScript.nScriptSetVarObj(id, i, j, this.mUseIncSupp);
            return;
        }
        renderScript = this.mRS;
        id = getID(this.mRS);
        if (baseObj != null) {
            j = baseObj.getID(this.mRS);
        }
        renderScript.nScriptSetVarObj(id, i, j, this.mUseIncSupp);
    }

    public void setVar(int i, FieldPacker fieldPacker) {
        this.mRS.nScriptSetVarV(getID(this.mRS), i, fieldPacker.getData(), this.mUseIncSupp);
    }

    public void setVar(int i, FieldPacker fieldPacker, Element element, int[] iArr) {
        if (this.mUseIncSupp) {
            int i2 = i;
            this.mRS.nScriptSetVarVE(getID(this.mRS), i2, fieldPacker.getData(), element.getDummyElement(this.mRS), iArr, this.mUseIncSupp);
            return;
        }
        this.mRS.nScriptSetVarVE(getID(this.mRS), i, fieldPacker.getData(), element.getID(this.mRS), iArr, this.mUseIncSupp);
    }
}
