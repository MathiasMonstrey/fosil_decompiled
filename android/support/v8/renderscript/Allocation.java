package android.support.v8.renderscript;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.support.v8.renderscript.Element.DataKind;
import android.support.v8.renderscript.Element.DataType;
import android.support.v8.renderscript.Type.Builder;
import android.support.v8.renderscript.Type.CubemapFace;
import android.util.Log;
import android.view.Surface;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

public class Allocation extends BaseObj {
    public static final int USAGE_GRAPHICS_TEXTURE = 2;
    public static final int USAGE_IO_INPUT = 32;
    public static final int USAGE_IO_OUTPUT = 64;
    public static final int USAGE_SCRIPT = 1;
    public static final int USAGE_SHARED = 128;
    static Options mBitmapOptions = new Options();
    Allocation mAdaptedAllocation;
    boolean mAutoPadding = false;
    Bitmap mBitmap;
    ByteBuffer mByteBuffer = null;
    long mByteBufferStride = 0;
    boolean mConstrainedFace;
    boolean mConstrainedLOD;
    boolean mConstrainedY;
    boolean mConstrainedZ;
    int mCurrentCount;
    int mCurrentDimX;
    int mCurrentDimY;
    int mCurrentDimZ;
    boolean mIncAllocDestroyed;
    long mIncCompatAllocation;
    boolean mReadAllowed = true;
    CubemapFace mSelectedFace = CubemapFace.POSITIVE_X;
    int mSelectedLOD;
    int mSelectedY;
    int mSelectedZ;
    int mSize;
    Type mType;
    int mUsage;
    boolean mWriteAllowed = true;

    static /* synthetic */ class C12871 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public enum MipmapControl {
        MIPMAP_NONE(0),
        MIPMAP_FULL(1),
        MIPMAP_ON_SYNC_TO_TEXTURE(2);
        
        int mID;

        private MipmapControl(int i) {
            this.mID = i;
        }
    }

    private DataType validateObjectIsPrimitiveArray(Object obj, boolean z) {
        Class cls = obj.getClass();
        if (cls.isArray()) {
            cls = cls.getComponentType();
            if (!cls.isPrimitive()) {
                throw new RSIllegalArgumentException("Object passed is not an Array of primitives.");
            } else if (cls == Long.TYPE) {
                if (!z) {
                    return DataType.SIGNED_64;
                }
                validateIsInt64();
                return this.mType.mElement.mType;
            } else if (cls == Integer.TYPE) {
                if (!z) {
                    return DataType.SIGNED_32;
                }
                validateIsInt32();
                return this.mType.mElement.mType;
            } else if (cls == Short.TYPE) {
                if (!z) {
                    return DataType.SIGNED_16;
                }
                validateIsInt16();
                return this.mType.mElement.mType;
            } else if (cls == Byte.TYPE) {
                if (!z) {
                    return DataType.SIGNED_8;
                }
                validateIsInt8();
                return this.mType.mElement.mType;
            } else if (cls == Float.TYPE) {
                if (z) {
                    validateIsFloat32();
                }
                return DataType.FLOAT_32;
            } else if (cls != Double.TYPE) {
                return null;
            } else {
                if (z) {
                    validateIsFloat64();
                }
                return DataType.FLOAT_64;
            }
        }
        throw new RSIllegalArgumentException("Object passed is not an array of primitives.");
    }

    public long getIncAllocID() {
        return this.mIncCompatAllocation;
    }

    public void setIncAllocID(long j) {
        this.mIncCompatAllocation = j;
    }

    private long getIDSafe() {
        if (this.mAdaptedAllocation != null) {
            return this.mAdaptedAllocation.getID(this.mRS);
        }
        return getID(this.mRS);
    }

    public Element getElement() {
        return this.mType.getElement();
    }

    public int getUsage() {
        return this.mUsage;
    }

    public void setAutoPadding(boolean z) {
        this.mAutoPadding = z;
    }

    public int getBytesSize() {
        if (this.mType.mDimYuv != 0) {
            return (int) Math.ceil(((double) (this.mType.getCount() * this.mType.getElement().getBytesSize())) * 1.5d);
        }
        return this.mType.getCount() * this.mType.getElement().getBytesSize();
    }

    private void updateCacheInfo(Type type) {
        this.mCurrentDimX = type.getX();
        this.mCurrentDimY = type.getY();
        this.mCurrentDimZ = type.getZ();
        this.mCurrentCount = this.mCurrentDimX;
        if (this.mCurrentDimY > 1) {
            this.mCurrentCount *= this.mCurrentDimY;
        }
        if (this.mCurrentDimZ > 1) {
            this.mCurrentCount *= this.mCurrentDimZ;
        }
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
    }

    Allocation(long j, RenderScript renderScript, Type type, int i) {
        super(j, renderScript);
        if ((i & -228) != 0) {
            throw new RSIllegalArgumentException("Unknown usage specified.");
        }
        if ((i & 32) != 0) {
            this.mWriteAllowed = false;
            if ((i & -36) != 0) {
                throw new RSIllegalArgumentException("Invalid usage combination.");
            }
        }
        this.mType = type;
        this.mUsage = i;
        this.mIncCompatAllocation = 0;
        this.mIncAllocDestroyed = false;
        if (type != null) {
            this.mSize = this.mType.getCount() * this.mType.getElement().getBytesSize();
            updateCacheInfo(type);
        }
        if (RenderScript.sUseGCHooks) {
            try {
                RenderScript.registerNativeAllocation.invoke(RenderScript.sRuntime, new Object[]{Integer.valueOf(this.mSize)});
            } catch (Exception e) {
                Log.e("RenderScript_jni", "Couldn't invoke registerNativeAllocation:" + e);
                throw new RSRuntimeException("Couldn't invoke registerNativeAllocation:" + e);
            }
        }
    }

    protected void finalize() throws Throwable {
        if (RenderScript.sUseGCHooks) {
            RenderScript.registerNativeFree.invoke(RenderScript.sRuntime, new Object[]{Integer.valueOf(this.mSize)});
        }
        super.finalize();
    }

    private void validateIsInt64() {
        if (this.mType.mElement.mType != DataType.SIGNED_64 && this.mType.mElement.mType != DataType.UNSIGNED_64) {
            throw new RSIllegalArgumentException("64 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt32() {
        if (this.mType.mElement.mType != DataType.SIGNED_32 && this.mType.mElement.mType != DataType.UNSIGNED_32) {
            throw new RSIllegalArgumentException("32 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt16() {
        if (this.mType.mElement.mType != DataType.SIGNED_16 && this.mType.mElement.mType != DataType.UNSIGNED_16) {
            throw new RSIllegalArgumentException("16 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsInt8() {
        if (this.mType.mElement.mType != DataType.SIGNED_8 && this.mType.mElement.mType != DataType.UNSIGNED_8) {
            throw new RSIllegalArgumentException("8 bit integer source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsFloat32() {
        if (this.mType.mElement.mType != DataType.FLOAT_32) {
            throw new RSIllegalArgumentException("32 bit float source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsFloat64() {
        if (this.mType.mElement.mType != DataType.FLOAT_64) {
            throw new RSIllegalArgumentException("64 bit float source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    private void validateIsObject() {
        if (this.mType.mElement.mType != DataType.RS_ELEMENT && this.mType.mElement.mType != DataType.RS_TYPE && this.mType.mElement.mType != DataType.RS_ALLOCATION && this.mType.mElement.mType != DataType.RS_SAMPLER && this.mType.mElement.mType != DataType.RS_SCRIPT) {
            throw new RSIllegalArgumentException("Object source does not match allocation type " + this.mType.mElement.mType);
        }
    }

    public Type getType() {
        return this.mType;
    }

    public void syncAll(int i) {
        switch (i) {
            case 1:
            case 2:
                this.mRS.validate();
                this.mRS.nAllocationSyncAll(getIDSafe(), i);
                return;
            default:
                throw new RSIllegalArgumentException("Source must be exactly one usage type.");
        }
    }

    public void ioSend() {
        if ((this.mUsage & 64) == 0) {
            throw new RSIllegalArgumentException("Can only send buffer if IO_OUTPUT usage specified.");
        }
        this.mRS.validate();
        this.mRS.nAllocationIoSend(getID(this.mRS));
    }

    public void ioSendOutput() {
        ioSend();
    }

    public ByteBuffer getByteBuffer() {
        int x = this.mType.getX() * this.mType.getElement().getBytesSize();
        if (this.mRS.getDispatchAPILevel() >= 21) {
            if (this.mByteBuffer == null || (this.mUsage & 32) != 0) {
                this.mByteBuffer = this.mRS.nAllocationGetByteBuffer(getID(this.mRS), x, this.mType.getY(), this.mType.getZ());
            }
            return this.mByteBuffer;
        } else if (this.mType.getZ() > 0) {
            return null;
        } else {
            byte[] bArr;
            if (this.mType.getY() > 0) {
                bArr = new byte[(this.mType.getY() * x)];
                copy2DRangeToUnchecked(0, 0, this.mType.getX(), this.mType.getY(), bArr, DataType.SIGNED_8, x * this.mType.getY());
            } else {
                bArr = new byte[x];
                copy1DRangeToUnchecked(0, this.mType.getX(), bArr);
            }
            ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(bArr).asReadOnlyBuffer();
            this.mByteBufferStride = (long) x;
            return asReadOnlyBuffer;
        }
    }

    public long getStride() {
        if (this.mByteBufferStride == 0) {
            if (this.mRS.getDispatchAPILevel() > 21) {
                this.mByteBufferStride = this.mRS.nAllocationGetStride(getID(this.mRS));
            } else {
                this.mByteBufferStride = (long) (this.mType.getX() * this.mType.getElement().getBytesSize());
            }
        }
        return this.mByteBufferStride;
    }

    public void ioReceive() {
        if ((this.mUsage & 32) == 0) {
            throw new RSIllegalArgumentException("Can only receive if IO_INPUT usage specified.");
        }
        this.mRS.validate();
        this.mRS.nAllocationIoReceive(getID(this.mRS));
    }

    public void copyFrom(BaseObj[] baseObjArr) {
        this.mRS.validate();
        validateIsObject();
        if (baseObjArr.length != this.mCurrentCount) {
            throw new RSIllegalArgumentException("Array size mismatch, allocation sizeX = " + this.mCurrentCount + ", array length = " + baseObjArr.length);
        } else if (RenderScript.sPointerSize == 8) {
            Object obj = new long[(baseObjArr.length * 4)];
            for (r0 = 0; r0 < baseObjArr.length; r0++) {
                obj[r0 * 4] = baseObjArr[r0].getID(this.mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, obj);
        } else {
            int[] iArr = new int[baseObjArr.length];
            for (r0 = 0; r0 < baseObjArr.length; r0++) {
                iArr[r0] = (int) baseObjArr[r0].getID(this.mRS);
            }
            copy1DRangeFromUnchecked(0, this.mCurrentCount, iArr);
        }
    }

    private void validateBitmapFormat(Bitmap bitmap) {
        Config config = bitmap.getConfig();
        if (config == null) {
            throw new RSIllegalArgumentException("Bitmap has an unsupported format for this operation");
        }
        switch (C12871.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                if (this.mType.getElement().mKind != DataKind.PIXEL_A) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                }
                return;
            case 2:
                if (this.mType.getElement().mKind != DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 4) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                }
                return;
            case 3:
                if (this.mType.getElement().mKind != DataKind.PIXEL_RGB || this.mType.getElement().getBytesSize() != 2) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                }
                return;
            case 4:
                if (this.mType.getElement().mKind != DataKind.PIXEL_RGBA || this.mType.getElement().getBytesSize() != 2) {
                    throw new RSIllegalArgumentException("Allocation kind is " + this.mType.getElement().mKind + ", type " + this.mType.getElement().mType + " of " + this.mType.getElement().getBytesSize() + " bytes, passed bitmap was " + config);
                }
                return;
            default:
                return;
        }
    }

    private void validateBitmapSize(Bitmap bitmap) {
        if (this.mCurrentDimX != bitmap.getWidth() || this.mCurrentDimY != bitmap.getHeight()) {
            throw new RSIllegalArgumentException("Cannot update allocation from bitmap, sizes mismatch");
        }
    }

    private void copyFromUnchecked(Object obj, DataType dataType, int i) {
        this.mRS.validate();
        if (this.mCurrentDimZ > 0) {
            copy3DRangeFromUnchecked(0, 0, 0, this.mCurrentDimX, this.mCurrentDimY, this.mCurrentDimZ, obj, dataType, i);
        } else if (this.mCurrentDimY > 0) {
            copy2DRangeFromUnchecked(0, 0, this.mCurrentDimX, this.mCurrentDimY, obj, dataType, i);
        } else {
            copy1DRangeFromUnchecked(0, this.mCurrentCount, obj, dataType, i);
        }
    }

    public void copyFromUnchecked(Object obj) {
        copyFromUnchecked(obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public void copyFromUnchecked(int[] iArr) {
        copyFromUnchecked(iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copyFromUnchecked(short[] sArr) {
        copyFromUnchecked(sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copyFromUnchecked(byte[] bArr) {
        copyFromUnchecked(bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copyFromUnchecked(float[] fArr) {
        copyFromUnchecked(fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copyFrom(Object obj) {
        copyFromUnchecked(obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copyFrom(int[] iArr) {
        validateIsInt32();
        copyFromUnchecked(iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copyFrom(short[] sArr) {
        validateIsInt16();
        copyFromUnchecked(sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copyFrom(byte[] bArr) {
        validateIsInt8();
        copyFromUnchecked(bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copyFrom(float[] fArr) {
        validateIsFloat32();
        copyFromUnchecked(fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copyFrom(Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, null);
            copyFrom(createBitmap);
            return;
        }
        validateBitmapSize(bitmap);
        validateBitmapFormat(bitmap);
        this.mRS.nAllocationCopyFromBitmap(getID(this.mRS), bitmap);
    }

    public void copyFrom(Allocation allocation) {
        this.mRS.validate();
        if (this.mType.equals(allocation.getType())) {
            copy2DRangeFrom(0, 0, this.mCurrentDimX, this.mCurrentDimY, allocation, 0, 0);
            return;
        }
        throw new RSIllegalArgumentException("Types of allocations must match.");
    }

    public void setFromFieldPacker(int i, FieldPacker fieldPacker) {
        this.mRS.validate();
        int bytesSize = this.mType.mElement.getBytesSize();
        byte[] data = fieldPacker.getData();
        int pos = fieldPacker.getPos();
        int i2 = pos / bytesSize;
        if (bytesSize * i2 != pos) {
            throw new RSIllegalArgumentException("Field packer length " + pos + " not divisible by element size " + bytesSize + ".");
        }
        copy1DRangeFromUnchecked(i, i2, data);
    }

    public void setFromFieldPacker(int i, int i2, FieldPacker fieldPacker) {
        this.mRS.validate();
        if (i2 >= this.mType.mElement.mElements.length) {
            throw new RSIllegalArgumentException("Component_number " + i2 + " out of range.");
        } else if (i < 0) {
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        } else {
            byte[] data = fieldPacker.getData();
            int pos = fieldPacker.getPos();
            int bytesSize = this.mType.mElement.mElements[i2].getBytesSize() * this.mType.mElement.mArraySizes[i2];
            if (pos != bytesSize) {
                throw new RSIllegalArgumentException("Field packer sizelength " + pos + " does not match component size " + bytesSize + ".");
            }
            this.mRS.nAllocationElementData1D(getIDSafe(), i, this.mSelectedLOD, i2, data, pos);
        }
    }

    private void data1DChecks(int i, int i2, int i3, int i4, boolean z) {
        this.mRS.validate();
        if (i < 0) {
            throw new RSIllegalArgumentException("Offset must be >= 0.");
        } else if (i2 < 1) {
            throw new RSIllegalArgumentException("Count must be >= 1.");
        } else if (i + i2 > this.mCurrentCount) {
            throw new RSIllegalArgumentException("Overflow, Available count " + this.mCurrentCount + ", got " + i2 + " at offset " + i + ".");
        } else if (z) {
            if (i3 < (i4 / 4) * 3) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
        } else if (i3 < i4) {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        }
    }

    public void generateMipmaps() {
        this.mRS.nAllocationGenerateMipmaps(getID(this.mRS));
    }

    private void copy1DRangeFromUnchecked(int i, int i2, Object obj, DataType dataType, int i3) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        boolean z = false;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            z = true;
        }
        data1DChecks(i, i2, i3 * dataType.mSize, bytesSize, z);
        this.mRS.nAllocationData1D(getIDSafe(), i, this.mSelectedLOD, i2, obj, bytesSize, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, Object obj) {
        copy1DRangeFromUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public void copy1DRangeFromUnchecked(int i, int i2, int[] iArr) {
        copy1DRangeFromUnchecked(i, i2, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, short[] sArr) {
        copy1DRangeFromUnchecked(i, i2, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, byte[] bArr) {
        copy1DRangeFromUnchecked(i, i2, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeFromUnchecked(int i, int i2, float[] fArr) {
        copy1DRangeFromUnchecked(i, i2, fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeFrom(int i, int i2, Object obj) {
        copy1DRangeFromUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy1DRangeFrom(int i, int i2, int[] iArr) {
        validateIsInt32();
        copy1DRangeFromUnchecked(i, i2, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeFrom(int i, int i2, short[] sArr) {
        validateIsInt16();
        copy1DRangeFromUnchecked(i, i2, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeFrom(int i, int i2, byte[] bArr) {
        validateIsInt8();
        copy1DRangeFromUnchecked(i, i2, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeFrom(int i, int i2, float[] fArr) {
        validateIsFloat32();
        copy1DRangeFromUnchecked(i, i2, fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeFrom(int i, int i2, Allocation allocation, int i3) {
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        this.mRS.nAllocationData2D(getIDSafe(), i4, 0, this.mSelectedLOD, this.mSelectedFace.mID, i5, 1, allocation.getID(this.mRS), i6, 0, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    private void validate2DRange(int i, int i2, int i3, int i4) {
        if (this.mAdaptedAllocation == null) {
            if (i < 0 || i2 < 0) {
                throw new RSIllegalArgumentException("Offset cannot be negative.");
            } else if (i4 < 0 || i3 < 0) {
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            } else if (i + i3 > this.mCurrentDimX || i2 + i4 > this.mCurrentDimY) {
                throw new RSIllegalArgumentException("Updated region larger than allocation.");
            }
        }
    }

    void copy2DRangeFromUnchecked(int i, int i2, int i3, int i4, Object obj, DataType dataType, int i5) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        int bytesSize = (this.mType.mElement.getBytesSize() * i3) * i4;
        boolean z = false;
        int i6 = dataType.mSize * i5;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i6) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            z = true;
        } else if (bytesSize > i6) {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        } else {
            bytesSize = i6;
        }
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, obj, bytesSize, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Object obj) {
        copy2DRangeFromUnchecked(i, i2, i3, i4, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, byte[] bArr) {
        validateIsInt8();
        copy2DRangeFromUnchecked(i, i2, i3, i4, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, short[] sArr) {
        validateIsInt16();
        copy2DRangeFromUnchecked(i, i2, i3, i4, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, int[] iArr) {
        validateIsInt32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, float[] fArr) {
        validateIsFloat32();
        copy2DRangeFromUnchecked(i, i2, i3, i4, fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copy2DRangeFrom(int i, int i2, int i3, int i4, Allocation allocation, int i5, int i6) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i4;
        int i11 = i5;
        int i12 = i6;
        this.mRS.nAllocationData2D(getIDSafe(), i7, i8, this.mSelectedLOD, this.mSelectedFace.mID, i9, i10, allocation.getID(this.mRS), i11, i12, allocation.mSelectedLOD, allocation.mSelectedFace.mID);
    }

    public void copy2DRangeFrom(int i, int i2, Bitmap bitmap) {
        this.mRS.validate();
        if (bitmap.getConfig() == null) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, null);
            copy2DRangeFrom(i, i2, createBitmap);
            return;
        }
        validateBitmapFormat(bitmap);
        validate2DRange(i, i2, bitmap.getWidth(), bitmap.getHeight());
        this.mRS.nAllocationData2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, bitmap);
    }

    private void validate3DRange(int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.mAdaptedAllocation == null) {
            if (i < 0 || i2 < 0 || i3 < 0) {
                throw new RSIllegalArgumentException("Offset cannot be negative.");
            } else if (i5 < 0 || i4 < 0 || i6 < 0) {
                throw new RSIllegalArgumentException("Height or width cannot be negative.");
            } else if (i + i4 > this.mCurrentDimX || i2 + i5 > this.mCurrentDimY || i3 + i6 > this.mCurrentDimZ) {
                throw new RSIllegalArgumentException("Updated region larger than allocation.");
            }
        }
    }

    private void copy3DRangeFromUnchecked(int i, int i2, int i3, int i4, int i5, int i6, Object obj, DataType dataType, int i7) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        int bytesSize = ((this.mType.mElement.getBytesSize() * i4) * i5) * i6;
        boolean z = false;
        int i8 = dataType.mSize * i7;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i8) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            z = true;
        } else if (bytesSize > i8) {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        } else {
            bytesSize = i8;
        }
        this.mRS.nAllocationData3D(getIDSafe(), i, i2, i3, this.mSelectedLOD, i4, i5, i6, obj, bytesSize, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
        copy3DRangeFromUnchecked(i, i2, i3, i4, i5, i6, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy3DRangeFrom(int i, int i2, int i3, int i4, int i5, int i6, Allocation allocation, int i7, int i8, int i9) {
        this.mRS.validate();
        validate3DRange(i, i2, i3, i4, i5, i6);
        int i10 = i;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        int i16 = i7;
        int i17 = i8;
        int i18 = i9;
        this.mRS.nAllocationData3D(getIDSafe(), i10, i11, i12, this.mSelectedLOD, i13, i14, i15, allocation.getID(this.mRS), i16, i17, i18, allocation.mSelectedLOD);
    }

    public void copyTo(Bitmap bitmap) {
        this.mRS.validate();
        validateBitmapFormat(bitmap);
        validateBitmapSize(bitmap);
        this.mRS.nAllocationCopyToBitmap(getID(this.mRS), bitmap);
    }

    private void copyTo(Object obj, DataType dataType, int i) {
        this.mRS.validate();
        boolean z = false;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            z = true;
        }
        if (z) {
            if (dataType.mSize * i < (this.mSize / 4) * 3) {
                throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
            }
        } else if (dataType.mSize * i < this.mSize) {
            throw new RSIllegalArgumentException("Size of output array cannot be smaller than size of allocation.");
        }
        this.mRS.nAllocationRead(getID(this.mRS), obj, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copyTo(Object obj) {
        copyTo(obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copyTo(byte[] bArr) {
        validateIsInt8();
        copyTo(bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copyTo(short[] sArr) {
        validateIsInt16();
        copyTo(sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copyTo(int[] iArr) {
        validateIsInt32();
        copyTo(iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copyTo(float[] fArr) {
        validateIsFloat32();
        copyTo(fArr, DataType.FLOAT_32, fArr.length);
    }

    private void copy1DRangeToUnchecked(int i, int i2, Object obj, DataType dataType, int i3) {
        int bytesSize = this.mType.mElement.getBytesSize() * i2;
        boolean z = false;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            z = true;
        }
        data1DChecks(i, i2, i3 * dataType.mSize, bytesSize, z);
        this.mRS.nAllocationRead1D(getIDSafe(), i, this.mSelectedLOD, i2, obj, bytesSize, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy1DRangeToUnchecked(int i, int i2, Object obj) {
        copy1DRangeToUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, false), Array.getLength(obj));
    }

    public void copy1DRangeToUnchecked(int i, int i2, int[] iArr) {
        copy1DRangeToUnchecked(i, i2, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, short[] sArr) {
        copy1DRangeToUnchecked(i, i2, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, byte[] bArr) {
        copy1DRangeToUnchecked(i, i2, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeToUnchecked(int i, int i2, float[] fArr) {
        copy1DRangeToUnchecked(i, i2, fArr, DataType.FLOAT_32, fArr.length);
    }

    public void copy1DRangeTo(int i, int i2, Object obj) {
        copy1DRangeToUnchecked(i, i2, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy1DRangeTo(int i, int i2, int[] iArr) {
        validateIsInt32();
        copy1DRangeToUnchecked(i, i2, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy1DRangeTo(int i, int i2, short[] sArr) {
        validateIsInt16();
        copy1DRangeToUnchecked(i, i2, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy1DRangeTo(int i, int i2, byte[] bArr) {
        validateIsInt8();
        copy1DRangeToUnchecked(i, i2, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy1DRangeTo(int i, int i2, float[] fArr) {
        validateIsFloat32();
        copy1DRangeToUnchecked(i, i2, fArr, DataType.FLOAT_32, fArr.length);
    }

    void copy2DRangeToUnchecked(int i, int i2, int i3, int i4, Object obj, DataType dataType, int i5) {
        this.mRS.validate();
        validate2DRange(i, i2, i3, i4);
        int bytesSize = (this.mType.mElement.getBytesSize() * i3) * i4;
        boolean z = false;
        int i6 = dataType.mSize * i5;
        if (this.mAutoPadding && this.mType.getElement().getVectorSize() == 3) {
            if ((bytesSize / 4) * 3 > i6) {
                throw new RSIllegalArgumentException("Array too small for allocation type.");
            }
            z = true;
        } else if (bytesSize > i6) {
            throw new RSIllegalArgumentException("Array too small for allocation type.");
        } else {
            bytesSize = i6;
        }
        this.mRS.nAllocationRead2D(getIDSafe(), i, i2, this.mSelectedLOD, this.mSelectedFace.mID, i3, i4, obj, bytesSize, dataType, this.mType.mElement.mType.mSize, z);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, Object obj) {
        copy2DRangeToUnchecked(i, i2, i3, i4, obj, validateObjectIsPrimitiveArray(obj, true), Array.getLength(obj));
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, byte[] bArr) {
        validateIsInt8();
        copy2DRangeToUnchecked(i, i2, i3, i4, bArr, DataType.SIGNED_8, bArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, short[] sArr) {
        validateIsInt16();
        copy2DRangeToUnchecked(i, i2, i3, i4, sArr, DataType.SIGNED_16, sArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, int[] iArr) {
        validateIsInt32();
        copy2DRangeToUnchecked(i, i2, i3, i4, iArr, DataType.SIGNED_32, iArr.length);
    }

    public void copy2DRangeTo(int i, int i2, int i3, int i4, float[] fArr) {
        validateIsFloat32();
        copy2DRangeToUnchecked(i, i2, i3, i4, fArr, DataType.FLOAT_32, fArr.length);
    }

    static {
        mBitmapOptions.inScaled = false;
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        if (type.getID(renderScript) == 0) {
            throw new RSInvalidStateException("Bad Type");
        } else if (renderScript.usingIO() || (i & 32) == 0) {
            long nAllocationCreateTyped = renderScript.nAllocationCreateTyped(type.getID(renderScript), mipmapControl.mID, i, 0);
            if (nAllocationCreateTyped != 0) {
                return new Allocation(nAllocationCreateTyped, renderScript, type, i);
            }
            throw new RSRuntimeException("Allocation creation failed.");
        } else {
            throw new RSRuntimeException("USAGE_IO not supported, Allocation creation failed.");
        }
    }

    public static Allocation createTyped(RenderScript renderScript, Type type, int i) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, i);
    }

    public static Allocation createTyped(RenderScript renderScript, Type type) {
        return createTyped(renderScript, type, MipmapControl.MIPMAP_NONE, 1);
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i, int i2) {
        renderScript.validate();
        Builder builder = new Builder(renderScript, element);
        builder.setX(i);
        Type create = builder.create();
        long nAllocationCreateTyped = renderScript.nAllocationCreateTyped(create.getID(renderScript), MipmapControl.MIPMAP_NONE.mID, i2, 0);
        if (nAllocationCreateTyped != 0) {
            return new Allocation(nAllocationCreateTyped, renderScript, create, i2);
        }
        throw new RSRuntimeException("Allocation creation failed.");
    }

    public static Allocation createSized(RenderScript renderScript, Element element, int i) {
        return createSized(renderScript, element, i, 1);
    }

    static Element elementFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        Config config = bitmap.getConfig();
        if (config == Config.ALPHA_8) {
            return Element.A_8(renderScript);
        }
        if (config == Config.ARGB_4444) {
            return Element.RGBA_4444(renderScript);
        }
        if (config == Config.ARGB_8888) {
            return Element.RGBA_8888(renderScript);
        }
        if (config == Config.RGB_565) {
            return Element.RGB_565(renderScript);
        }
        throw new RSInvalidStateException("Bad bitmap type: " + config);
    }

    static Type typeFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl) {
        Builder builder = new Builder(renderScript, elementFromBitmap(renderScript, bitmap));
        builder.setX(bitmap.getWidth());
        builder.setY(bitmap.getHeight());
        builder.setMipmaps(mipmapControl == MipmapControl.MIPMAP_FULL);
        return builder.create();
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        renderScript.validate();
        if (bitmap.getConfig() != null) {
            Type typeFromBitmap = typeFromBitmap(renderScript, bitmap, mipmapControl);
            long nAllocationCreateBitmapBackedAllocation;
            if (mipmapControl == MipmapControl.MIPMAP_NONE && typeFromBitmap.getElement().isCompatible(Element.RGBA_8888(renderScript)) && i == ScriptIntrinsicBLAS.NON_UNIT) {
                nAllocationCreateBitmapBackedAllocation = renderScript.nAllocationCreateBitmapBackedAllocation(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
                if (nAllocationCreateBitmapBackedAllocation == 0) {
                    throw new RSRuntimeException("Load failed.");
                }
                Allocation allocation = new Allocation(nAllocationCreateBitmapBackedAllocation, renderScript, typeFromBitmap, i);
                allocation.setBitmap(bitmap);
                return allocation;
            }
            nAllocationCreateBitmapBackedAllocation = renderScript.nAllocationCreateFromBitmap(typeFromBitmap.getID(renderScript), mipmapControl.mID, bitmap, i);
            if (nAllocationCreateBitmapBackedAllocation != 0) {
                return new Allocation(nAllocationCreateBitmapBackedAllocation, renderScript, typeFromBitmap, i);
            }
            throw new RSRuntimeException("Load failed.");
        } else if ((i & USAGE_SHARED) != 0) {
            throw new RSIllegalArgumentException("USAGE_SHARED cannot be used with a Bitmap that has a null config.");
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, 0.0f, 0.0f, null);
            return createFromBitmap(renderScript, createBitmap, mipmapControl, i);
        }
    }

    public void setSurface(Surface surface) {
        this.mRS.validate();
        if ((this.mUsage & 64) == 0) {
            throw new RSInvalidStateException("Allocation is not USAGE_IO_OUTPUT.");
        }
        this.mRS.nAllocationSetSurface(getID(this.mRS), surface);
    }

    public static Allocation createFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, ScriptIntrinsicBLAS.NON_UNIT);
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap, MipmapControl mipmapControl, int i) {
        boolean z = true;
        renderScript.validate();
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (width % 6 != 0) {
            throw new RSIllegalArgumentException("Cubemap height must be multiple of 6");
        } else if (width / 6 != height) {
            throw new RSIllegalArgumentException("Only square cube map faces supported");
        } else {
            boolean z2;
            if (((height - 1) & height) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Element elementFromBitmap = elementFromBitmap(renderScript, bitmap);
                Builder builder = new Builder(renderScript, elementFromBitmap);
                builder.setX(height);
                builder.setY(height);
                builder.setFaces(true);
                if (mipmapControl != MipmapControl.MIPMAP_FULL) {
                    z = false;
                }
                builder.setMipmaps(z);
                Type create = builder.create();
                long nAllocationCubeCreateFromBitmap = renderScript.nAllocationCubeCreateFromBitmap(create.getID(renderScript), mipmapControl.mID, bitmap, i);
                if (nAllocationCubeCreateFromBitmap != 0) {
                    return new Allocation(nAllocationCubeCreateFromBitmap, renderScript, create, i);
                }
                throw new RSRuntimeException("Load failed for bitmap " + bitmap + " element " + elementFromBitmap);
            }
            throw new RSIllegalArgumentException("Only power of 2 cube faces supported");
        }
    }

    public static Allocation createCubemapFromBitmap(RenderScript renderScript, Bitmap bitmap) {
        return createCubemapFromBitmap(renderScript, bitmap, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6, MipmapControl mipmapControl, int i) {
        return null;
    }

    public static Allocation createCubemapFromCubeFaces(RenderScript renderScript, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        return createCubemapFromCubeFaces(renderScript, bitmap, bitmap2, bitmap3, bitmap4, bitmap5, bitmap6, MipmapControl.MIPMAP_NONE, 2);
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i, MipmapControl mipmapControl, int i2) {
        renderScript.validate();
        if ((i2 & 224) != 0) {
            throw new RSIllegalArgumentException("Unsupported usage specified.");
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, i);
        Allocation createFromBitmap = createFromBitmap(renderScript, decodeResource, mipmapControl, i2);
        decodeResource.recycle();
        return createFromBitmap;
    }

    public static Allocation createFromBitmapResource(RenderScript renderScript, Resources resources, int i) {
        return createFromBitmapResource(renderScript, resources, i, MipmapControl.MIPMAP_NONE, 3);
    }

    public static Allocation createFromString(RenderScript renderScript, String str, int i) {
        renderScript.validate();
        try {
            byte[] bytes = str.getBytes("UTF-8");
            Allocation createSized = createSized(renderScript, Element.U8(renderScript), bytes.length, i);
            createSized.copyFrom(bytes);
            return createSized;
        } catch (Exception e) {
            throw new RSRuntimeException("Could not convert string to utf-8.");
        }
    }

    public void destroy() {
        Object obj = 1;
        if (this.mIncCompatAllocation != 0) {
            synchronized (this) {
                if (this.mIncAllocDestroyed) {
                    obj = null;
                } else {
                    this.mIncAllocDestroyed = true;
                }
            }
            if (obj != null) {
                ReadLock readLock = this.mRS.mRWLock.readLock();
                readLock.lock();
                if (this.mRS.isAlive()) {
                    this.mRS.nIncObjDestroy(this.mIncCompatAllocation);
                }
                readLock.unlock();
                this.mIncCompatAllocation = 0;
            }
        }
        if ((this.mUsage & 96) != 0) {
            setSurface(null);
        }
        super.destroy();
    }
}
