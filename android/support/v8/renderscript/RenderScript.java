package android.support.v8.renderscript;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Element.DataType;
import android.util.Log;
import android.view.Surface;
import java.io.File;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class RenderScript {
    private static final String CACHE_PATH = "com.android.renderscript.cache";
    public static final int CREATE_FLAG_NONE = 0;
    static final boolean DEBUG = false;
    static final boolean LOG_ENABLED = false;
    static final String LOG_TAG = "RenderScript_jni";
    static final int SUPPORT_LIB_API = 23;
    static final int SUPPORT_LIB_VERSION = 2301;
    static Object lock = new Object();
    private static String mBlackList = "";
    static String mCachePath;
    private static ArrayList<RenderScript> mProcessContextList = new ArrayList();
    static Method registerNativeAllocation;
    static Method registerNativeFree;
    static boolean sInitialized;
    private static int sNative = -1;
    static int sPointerSize;
    static Object sRuntime;
    private static int sSdkVersion = -1;
    static boolean sUseGCHooks;
    private static boolean useIOlib = false;
    private static boolean useNative;
    private Context mApplicationContext;
    long mContext;
    private int mContextFlags = 0;
    private int mContextSdkVersion = 0;
    ContextType mContextType = ContextType.NORMAL;
    private boolean mDestroyed = false;
    private int mDispatchAPILevel = 0;
    Element mElement_ALLOCATION;
    Element mElement_A_8;
    Element mElement_BOOLEAN;
    Element mElement_CHAR_2;
    Element mElement_CHAR_3;
    Element mElement_CHAR_4;
    Element mElement_DOUBLE_2;
    Element mElement_DOUBLE_3;
    Element mElement_DOUBLE_4;
    Element mElement_ELEMENT;
    Element mElement_F32;
    Element mElement_F64;
    Element mElement_FLOAT_2;
    Element mElement_FLOAT_3;
    Element mElement_FLOAT_4;
    Element mElement_I16;
    Element mElement_I32;
    Element mElement_I64;
    Element mElement_I8;
    Element mElement_INT_2;
    Element mElement_INT_3;
    Element mElement_INT_4;
    Element mElement_LONG_2;
    Element mElement_LONG_3;
    Element mElement_LONG_4;
    Element mElement_MATRIX_2X2;
    Element mElement_MATRIX_3X3;
    Element mElement_MATRIX_4X4;
    Element mElement_RGBA_4444;
    Element mElement_RGBA_5551;
    Element mElement_RGBA_8888;
    Element mElement_RGB_565;
    Element mElement_RGB_888;
    Element mElement_SAMPLER;
    Element mElement_SCRIPT;
    Element mElement_SHORT_2;
    Element mElement_SHORT_3;
    Element mElement_SHORT_4;
    Element mElement_TYPE;
    Element mElement_U16;
    Element mElement_U32;
    Element mElement_U64;
    Element mElement_U8;
    Element mElement_UCHAR_2;
    Element mElement_UCHAR_3;
    Element mElement_UCHAR_4;
    Element mElement_UINT_2;
    Element mElement_UINT_3;
    Element mElement_UINT_4;
    Element mElement_ULONG_2;
    Element mElement_ULONG_3;
    Element mElement_ULONG_4;
    Element mElement_USHORT_2;
    Element mElement_USHORT_3;
    Element mElement_USHORT_4;
    private boolean mEnableMultiInput = false;
    RSErrorHandler mErrorCallback = null;
    long mIncCon;
    boolean mIncLoaded;
    private boolean mIsProcessContext = false;
    RSMessageHandler mMessageCallback = null;
    MessageThread mMessageThread;
    private String mNativeLibDir;
    ReentrantReadWriteLock mRWLock;
    Sampler mSampler_CLAMP_LINEAR;
    Sampler mSampler_CLAMP_LINEAR_MIP_LINEAR;
    Sampler mSampler_CLAMP_NEAREST;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_LINEAR_MIP_LINEAR;
    Sampler mSampler_MIRRORED_REPEAT_NEAREST;
    Sampler mSampler_WRAP_LINEAR;
    Sampler mSampler_WRAP_LINEAR_MIP_LINEAR;
    Sampler mSampler_WRAP_NEAREST;

    public enum ContextType {
        NORMAL(0),
        DEBUG(1),
        PROFILE(2);
        
        int mID;

        private ContextType(int i) {
            this.mID = i;
        }
    }

    static class MessageThread extends Thread {
        static final int RS_ERROR_FATAL_UNKNOWN = 4096;
        static final int RS_MESSAGE_TO_CLIENT_ERROR = 3;
        static final int RS_MESSAGE_TO_CLIENT_EXCEPTION = 1;
        static final int RS_MESSAGE_TO_CLIENT_NONE = 0;
        static final int RS_MESSAGE_TO_CLIENT_RESIZE = 2;
        static final int RS_MESSAGE_TO_CLIENT_USER = 4;
        int[] mAuxData = new int[2];
        RenderScript mRS;
        boolean mRun = true;

        MessageThread(RenderScript renderScript) {
            super("RSMessageThread");
            this.mRS = renderScript;
        }

        public void run() {
            int[] iArr = new int[16];
            this.mRS.nContextInitToClient(this.mRS.mContext);
            while (this.mRun) {
                iArr[0] = 0;
                int nContextPeekMessage = this.mRS.nContextPeekMessage(this.mRS.mContext, this.mAuxData);
                int i = this.mAuxData[1];
                int i2 = this.mAuxData[0];
                if (nContextPeekMessage == 4) {
                    if ((i >> 2) >= iArr.length) {
                        iArr = new int[((i + 3) >> 2)];
                    }
                    if (this.mRS.nContextGetUserMessage(this.mRS.mContext, iArr) != 4) {
                        throw new RSDriverException("Error processing message from RenderScript.");
                    } else if (this.mRS.mMessageCallback != null) {
                        this.mRS.mMessageCallback.mData = iArr;
                        this.mRS.mMessageCallback.mID = i2;
                        this.mRS.mMessageCallback.mLength = i;
                        this.mRS.mMessageCallback.run();
                    } else {
                        throw new RSInvalidStateException("Received a message from the script with no message handler installed.");
                    }
                } else if (nContextPeekMessage == 3) {
                    String nContextGetErrorMessage = this.mRS.nContextGetErrorMessage(this.mRS.mContext);
                    if (i2 >= RS_ERROR_FATAL_UNKNOWN) {
                        throw new RSRuntimeException("Fatal error " + i2 + ", details: " + nContextGetErrorMessage);
                    } else if (this.mRS.mErrorCallback != null) {
                        this.mRS.mErrorCallback.mErrorMessage = nContextGetErrorMessage;
                        this.mRS.mErrorCallback.mErrorNum = i2;
                        this.mRS.mErrorCallback.run();
                    } else {
                        Log.e(RenderScript.LOG_TAG, "non fatal RS error, " + nContextGetErrorMessage);
                    }
                } else {
                    try {
                        sleep(1, 0);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public enum Priority {
        LOW(15),
        NORMAL(-4);
        
        int mID;

        private Priority(int i) {
            this.mID = i;
        }
    }

    public static class RSErrorHandler implements Runnable {
        protected String mErrorMessage;
        protected int mErrorNum;

        public void run() {
        }
    }

    public static class RSMessageHandler implements Runnable {
        protected int[] mData;
        protected int mID;
        protected int mLength;

        public void run() {
        }
    }

    static native int rsnSystemGetPointerSize();

    native void nContextDeinitToClient(long j);

    native String nContextGetErrorMessage(long j);

    native int nContextGetUserMessage(long j, int[] iArr);

    native void nContextInitToClient(long j);

    native int nContextPeekMessage(long j, int[] iArr);

    native long nDeviceCreate();

    native void nDeviceDestroy(long j);

    native void nDeviceSetConfig(long j, int i, int i2);

    native long nIncDeviceCreate();

    native void nIncDeviceDestroy(long j);

    native boolean nIncLoadSO(int i, String str);

    native boolean nLoadIOSO();

    native boolean nLoadSO(boolean z, int i, String str);

    native void rsnAllocationCopyFromBitmap(long j, long j2, Bitmap bitmap);

    native void rsnAllocationCopyToBitmap(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateBitmapBackedAllocation(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateBitmapRef(long j, long j2, Bitmap bitmap);

    native long rsnAllocationCreateFromAssetStream(long j, int i, int i2, int i3);

    native long rsnAllocationCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native long rsnAllocationCreateTyped(long j, long j2, int i, int i2, long j3);

    native long rsnAllocationCubeCreateFromBitmap(long j, long j2, int i, Bitmap bitmap, int i2);

    native void rsnAllocationData1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, long j3, int i7, int i8, int i9, int i10);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    native void rsnAllocationData2D(long j, long j2, int i, int i2, int i3, int i4, Bitmap bitmap);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j3, int i8, int i9, int i10, int i11);

    native void rsnAllocationData3D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, int i9, int i10, boolean z);

    native void rsnAllocationElementData1D(long j, long j2, int i, int i2, int i3, byte[] bArr, int i4);

    native void rsnAllocationGenerateMipmaps(long j, long j2);

    native ByteBuffer rsnAllocationGetByteBuffer(long j, long j2, int i, int i2, int i3);

    native long rsnAllocationGetStride(long j, long j2);

    native long rsnAllocationGetType(long j, long j2);

    native void rsnAllocationIoReceive(long j, long j2);

    native void rsnAllocationIoSend(long j, long j2);

    native void rsnAllocationRead(long j, long j2, Object obj, int i, int i2, boolean z);

    native void rsnAllocationRead1D(long j, long j2, int i, int i2, int i3, Object obj, int i4, int i5, int i6, boolean z);

    native void rsnAllocationRead2D(long j, long j2, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, int i8, int i9, boolean z);

    native void rsnAllocationResize1D(long j, long j2, int i);

    native void rsnAllocationResize2D(long j, long j2, int i, int i2);

    native void rsnAllocationSetSurface(long j, long j2, Surface surface);

    native void rsnAllocationSyncAll(long j, long j2, int i);

    native long rsnClosureCreate(long j, long j2, long j3, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4);

    native void rsnClosureSetArg(long j, long j2, int i, long j3, int i2);

    native void rsnClosureSetGlobal(long j, long j2, long j3, long j4, int i);

    native long rsnContextCreate(long j, int i, int i2, int i3, String str);

    native void rsnContextDestroy(long j);

    native void rsnContextDump(long j, int i);

    native void rsnContextFinish(long j);

    native void rsnContextSendMessage(long j, int i, int[] iArr);

    native void rsnContextSetPriority(long j, int i);

    native long rsnElementCreate(long j, long j2, int i, boolean z, int i2);

    native long rsnElementCreate2(long j, long[] jArr, String[] strArr, int[] iArr);

    native void rsnElementGetNativeData(long j, long j2, int[] iArr);

    native void rsnElementGetSubElements(long j, long j2, long[] jArr, String[] strArr, int[] iArr);

    native long rsnIncAllocationCreateTyped(long j, long j2, long j3, long j4, int i);

    native long rsnIncContextCreate(long j, int i, int i2, int i3);

    native void rsnIncContextDestroy(long j);

    native void rsnIncContextFinish(long j);

    native long rsnIncElementCreate(long j, long j2, int i, boolean z, int i2);

    native void rsnIncObjDestroy(long j, long j2);

    native long rsnIncTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    native long rsnInvokeClosureCreate(long j, long j2, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr);

    native void rsnObjDestroy(long j, long j2);

    native long rsnSamplerCreate(long j, int i, int i2, int i3, int i4, int i5, float f);

    native void rsnScriptBindAllocation(long j, long j2, long j3, int i, boolean z);

    native long rsnScriptCCreate(long j, String str, String str2, byte[] bArr, int i);

    native long rsnScriptFieldIDCreate(long j, long j2, int i, boolean z);

    native void rsnScriptForEach(long j, long j2, int i, long[] jArr, long j3, byte[] bArr, int[] iArr);

    native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, boolean z);

    native void rsnScriptForEach(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, boolean z);

    native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    native void rsnScriptForEachClipped(long j, long j2, long j3, int i, long j4, long j5, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z);

    native long rsnScriptGroup2Create(long j, String str, String str2, long[] jArr);

    native void rsnScriptGroup2Execute(long j, long j2);

    native long rsnScriptGroupCreate(long j, long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5);

    native void rsnScriptGroupExecute(long j, long j2);

    native void rsnScriptGroupSetInput(long j, long j2, long j3, long j4);

    native void rsnScriptGroupSetOutput(long j, long j2, long j3, long j4);

    native void rsnScriptIntrinsicBLAS_BNNM(long j, long j2, long j3, int i, int i2, int i3, long j4, int i4, long j5, int i5, long j6, int i6, int i7, boolean z);

    native void rsnScriptIntrinsicBLAS_Complex(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j4, long j5, float f3, float f4, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Double(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j4, long j5, double d2, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Single(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j4, long j5, float f2, long j6, int i10, int i11, int i12, int i13, boolean z);

    native void rsnScriptIntrinsicBLAS_Z(long j, long j2, long j3, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j4, long j5, double d3, double d4, long j6, int i10, int i11, int i12, int i13, boolean z);

    native long rsnScriptIntrinsicCreate(long j, int i, long j2, boolean z);

    native void rsnScriptInvoke(long j, long j2, int i, boolean z);

    native long rsnScriptInvokeIDCreate(long j, long j2, int i);

    native void rsnScriptInvokeV(long j, long j2, int i, byte[] bArr, boolean z);

    native long rsnScriptKernelIDCreate(long j, long j2, int i, int i2, boolean z);

    native void rsnScriptReduce(long j, long j2, int i, long[] jArr, long j3, int[] iArr);

    native void rsnScriptSetTimeZone(long j, long j2, byte[] bArr, boolean z);

    native void rsnScriptSetVarD(long j, long j2, int i, double d, boolean z);

    native void rsnScriptSetVarF(long j, long j2, int i, float f, boolean z);

    native void rsnScriptSetVarI(long j, long j2, int i, int i2, boolean z);

    native void rsnScriptSetVarJ(long j, long j2, int i, long j3, boolean z);

    native void rsnScriptSetVarObj(long j, long j2, int i, long j3, boolean z);

    native void rsnScriptSetVarV(long j, long j2, int i, byte[] bArr, boolean z);

    native void rsnScriptSetVarVE(long j, long j2, int i, byte[] bArr, long j3, int[] iArr, boolean z);

    native long rsnTypeCreate(long j, long j2, int i, int i2, int i3, boolean z, boolean z2, int i4);

    native void rsnTypeGetNativeData(long j, long j2, long[] jArr);

    public static void setBlackList(String str) {
        if (str != null) {
            mBlackList = str;
        }
    }

    public static void forceCompat() {
        sNative = 0;
    }

    int getDispatchAPILevel() {
        return this.mDispatchAPILevel;
    }

    boolean isUseNative() {
        return useNative;
    }

    private static boolean setupNative(int i, Context context) {
        if (VERSION.SDK_INT < i && VERSION.SDK_INT < 21) {
            sNative = 0;
        }
        if (sNative == -1) {
            int intValue;
            try {
                intValue = ((Integer) Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{"debug.rs.forcecompat", new Integer(0)})).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            if (VERSION.SDK_INT < 19 || r0 != 0) {
                sNative = 0;
            } else {
                sNative = 1;
            }
            if (sNative == 1) {
                try {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), Allocation.USAGE_SHARED);
                    long j = 0;
                    try {
                        j = ((Long) Class.forName("android.renderscript.RenderScript").getDeclaredMethod("getMinorID", new Class[0]).invoke(null, new Object[0])).longValue();
                    } catch (Exception e2) {
                    }
                    if (applicationInfo.metaData != null) {
                        if (applicationInfo.metaData.getBoolean("com.android.support.v8.renderscript.EnableAsyncTeardown") && r2 == 0) {
                            sNative = 0;
                        }
                        if (applicationInfo.metaData.getBoolean("com.android.support.v8.renderscript.EnableBlurWorkaround") && VERSION.SDK_INT <= 19) {
                            sNative = 0;
                        }
                    }
                } catch (NameNotFoundException e3) {
                    return true;
                }
            }
        }
        if (sNative != 1) {
            return false;
        }
        if (mBlackList.length() > 0) {
            if (mBlackList.contains('(' + Build.MANUFACTURER + ':' + Build.PRODUCT + ':' + Build.MODEL + ')')) {
                sNative = 0;
                return false;
            }
        }
        return true;
    }

    public static void setupDiskCache(File file) {
        File file2 = new File(file, CACHE_PATH);
        mCachePath = file2.getAbsolutePath();
        file2.mkdirs();
    }

    synchronized long nContextCreate(long j, int i, int i2, int i3, String str) {
        return rsnContextCreate(j, i, i2, i3, str);
    }

    synchronized void nContextDestroy() {
        validate();
        WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mContext;
        this.mContext = 0;
        writeLock.unlock();
        rsnContextDestroy(j);
    }

    synchronized void nContextSetPriority(int i) {
        validate();
        rsnContextSetPriority(this.mContext, i);
    }

    synchronized void nContextDump(int i) {
        validate();
        rsnContextDump(this.mContext, i);
    }

    synchronized void nContextFinish() {
        validate();
        rsnContextFinish(this.mContext);
    }

    synchronized void nContextSendMessage(int i, int[] iArr) {
        validate();
        rsnContextSendMessage(this.mContext, i, iArr);
    }

    void nObjDestroy(long j) {
        if (this.mContext != 0) {
            rsnObjDestroy(this.mContext, j);
        }
    }

    synchronized long nElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnElementCreate(this.mContext, j, i, z, i2);
    }

    synchronized long nElementCreate2(long[] jArr, String[] strArr, int[] iArr) {
        validate();
        return rsnElementCreate2(this.mContext, jArr, strArr, iArr);
    }

    synchronized void nElementGetNativeData(long j, int[] iArr) {
        validate();
        rsnElementGetNativeData(this.mContext, j, iArr);
    }

    synchronized void nElementGetSubElements(long j, long[] jArr, String[] strArr, int[] iArr) {
        validate();
        rsnElementGetSubElements(this.mContext, j, jArr, strArr, iArr);
    }

    synchronized long nTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnTypeCreate(this.mContext, j, i, i2, i3, z, z2, i4);
    }

    synchronized void nTypeGetNativeData(long j, long[] jArr) {
        validate();
        rsnTypeGetNativeData(this.mContext, j, jArr);
    }

    synchronized long nAllocationCreateTyped(long j, int i, int i2, long j2) {
        validate();
        return rsnAllocationCreateTyped(this.mContext, j, i, i2, j2);
    }

    synchronized long nAllocationCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    synchronized long nAllocationCreateBitmapBackedAllocation(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCreateBitmapBackedAllocation(this.mContext, j, i, bitmap, i2);
    }

    synchronized long nAllocationCubeCreateFromBitmap(long j, int i, Bitmap bitmap, int i2) {
        validate();
        return rsnAllocationCubeCreateFromBitmap(this.mContext, j, i, bitmap, i2);
    }

    synchronized long nAllocationCreateBitmapRef(long j, Bitmap bitmap) {
        validate();
        return rsnAllocationCreateBitmapRef(this.mContext, j, bitmap);
    }

    synchronized long nAllocationCreateFromAssetStream(int i, int i2, int i3) {
        validate();
        return rsnAllocationCreateFromAssetStream(this.mContext, i, i2, i3);
    }

    synchronized void nAllocationCopyToBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyToBitmap(this.mContext, j, bitmap);
    }

    synchronized void nAllocationSyncAll(long j, int i) {
        validate();
        rsnAllocationSyncAll(this.mContext, j, i);
    }

    synchronized void nAllocationSetSurface(long j, Surface surface) {
        validate();
        rsnAllocationSetSurface(this.mContext, j, surface);
    }

    synchronized void nAllocationIoSend(long j) {
        validate();
        rsnAllocationIoSend(this.mContext, j);
    }

    synchronized void nAllocationIoReceive(long j) {
        validate();
        rsnAllocationIoReceive(this.mContext, j);
    }

    synchronized ByteBuffer nAllocationGetByteBuffer(long j, int i, int i2, int i3) {
        validate();
        return rsnAllocationGetByteBuffer(this.mContext, j, i, i2, i3);
    }

    synchronized long nAllocationGetStride(long j) {
        validate();
        return rsnAllocationGetStride(this.mContext, j);
    }

    synchronized void nAllocationGenerateMipmaps(long j) {
        validate();
        rsnAllocationGenerateMipmaps(this.mContext, j);
    }

    synchronized void nAllocationCopyFromBitmap(long j, Bitmap bitmap) {
        validate();
        rsnAllocationCopyFromBitmap(this.mContext, j, bitmap);
    }

    synchronized void nAllocationData1D(long j, int i, int i2, int i3, Object obj, int i4, DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationData1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    synchronized void nAllocationElementData1D(long j, int i, int i2, int i3, byte[] bArr, int i4) {
        validate();
        rsnAllocationElementData1D(this.mContext, j, i, i2, i3, bArr, i4);
    }

    synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, long j2, int i7, int i8, int i9, int i10) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, j2, i7, i8, i9, i10);
    }

    synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    synchronized void nAllocationData2D(long j, int i, int i2, int i3, int i4, Bitmap bitmap) {
        validate();
        rsnAllocationData2D(this.mContext, j, i, i2, i3, i4, bitmap);
    }

    synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, int i9, int i10, int i11) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, j2, i8, i9, i10, i11);
    }

    synchronized void nAllocationData3D(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj, int i8, DataType dataType, int i9, boolean z) {
        validate();
        rsnAllocationData3D(this.mContext, j, i, i2, i3, i4, i5, i6, i7, obj, i8, dataType.mID, i9, z);
    }

    synchronized void nAllocationRead(long j, Object obj, DataType dataType, int i, boolean z) {
        validate();
        rsnAllocationRead(this.mContext, j, obj, dataType.mID, i, z);
    }

    synchronized void nAllocationRead1D(long j, int i, int i2, int i3, Object obj, int i4, DataType dataType, int i5, boolean z) {
        validate();
        rsnAllocationRead1D(this.mContext, j, i, i2, i3, obj, i4, dataType.mID, i5, z);
    }

    synchronized void nAllocationRead2D(long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj, int i7, DataType dataType, int i8, boolean z) {
        validate();
        rsnAllocationRead2D(this.mContext, j, i, i2, i3, i4, i5, i6, obj, i7, dataType.mID, i8, z);
    }

    synchronized long nAllocationGetType(long j) {
        validate();
        return rsnAllocationGetType(this.mContext, j);
    }

    synchronized void nAllocationResize1D(long j, int i) {
        validate();
        rsnAllocationResize1D(this.mContext, j, i);
    }

    synchronized void nAllocationResize2D(long j, int i, int i2) {
        validate();
        rsnAllocationResize2D(this.mContext, j, i, i2);
    }

    synchronized void nScriptBindAllocation(long j, long j2, int i, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptBindAllocation(j3, j, j2, i, z);
    }

    synchronized void nScriptSetTimeZone(long j, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetTimeZone(j2, j, bArr, z);
    }

    synchronized void nScriptInvoke(long j, int i, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvoke(j2, j, i, z);
    }

    synchronized void nScriptForEach(long j, int i, long j2, long j3, byte[] bArr, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, z);
        } else {
            rsnScriptForEach(this.mContext, this.mIncCon, j, i, j2, j3, bArr, z);
        }
    }

    synchronized void nScriptForEachClipped(long j, int i, long j2, long j3, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        validate();
        if (bArr == null) {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, i2, i3, i4, i5, i6, i7, z);
        } else {
            rsnScriptForEachClipped(this.mContext, this.mIncCon, j, i, j2, j3, bArr, i2, i3, i4, i5, i6, i7, z);
        }
    }

    synchronized void nScriptForEach(long j, int i, long[] jArr, long j2, byte[] bArr, int[] iArr) {
        if (this.mEnableMultiInput) {
            validate();
            rsnScriptForEach(this.mContext, j, i, jArr, j2, bArr, iArr);
        } else {
            Log.e(LOG_TAG, "Multi-input kernels are not supported, please change targetSdkVersion to >= 23");
            throw new RSRuntimeException("Multi-input kernels are not supported before API 23)");
        }
    }

    synchronized void nScriptReduce(long j, int i, long[] jArr, long j2, int[] iArr) {
        validate();
        rsnScriptReduce(this.mContext, j, i, jArr, j2, iArr);
    }

    synchronized void nScriptInvokeV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptInvokeV(j2, j, i, bArr, z);
    }

    synchronized void nScriptSetVarI(long j, int i, int i2, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarI(j2, j, i, i2, z);
    }

    synchronized void nScriptSetVarJ(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarJ(j3, j, i, j2, z);
    }

    synchronized void nScriptSetVarF(long j, int i, float f, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarF(j2, j, i, f, z);
    }

    synchronized void nScriptSetVarD(long j, int i, double d, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarD(j2, j, i, d, z);
    }

    synchronized void nScriptSetVarV(long j, int i, byte[] bArr, boolean z) {
        validate();
        long j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        rsnScriptSetVarV(j2, j, i, bArr, z);
    }

    synchronized void nScriptSetVarVE(long j, int i, byte[] bArr, long j2, int[] iArr, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarVE(j3, j, i, bArr, j2, iArr, z);
    }

    synchronized void nScriptSetVarObj(long j, int i, long j2, boolean z) {
        validate();
        long j3 = this.mContext;
        if (z) {
            j3 = this.mIncCon;
        }
        rsnScriptSetVarObj(j3, j, i, j2, z);
    }

    synchronized long nScriptCCreate(String str, String str2, byte[] bArr, int i) {
        validate();
        return rsnScriptCCreate(this.mContext, str, str2, bArr, i);
    }

    synchronized long nScriptIntrinsicCreate(int i, long j, boolean z) {
        long rsnScriptIntrinsicCreate;
        validate();
        if (!z) {
            rsnScriptIntrinsicCreate = rsnScriptIntrinsicCreate(this.mContext, i, j, z);
        } else if (VERSION.SDK_INT < 21) {
            Log.e(LOG_TAG, "Incremental Intrinsics are not supported, please change targetSdkVersion to >= 21");
            throw new RSRuntimeException("Incremental Intrinsics are not supported before Lollipop (API 21)");
        } else {
            if (!this.mIncLoaded) {
                try {
                    System.loadLibrary("RSSupport");
                    if (nIncLoadSO(23, this.mNativeLibDir + "/libRSSupport.so")) {
                        this.mIncLoaded = true;
                    } else {
                        throw new RSRuntimeException("Error loading libRSSupport library for Incremental Intrinsic Support");
                    }
                } catch (UnsatisfiedLinkError e) {
                    Log.e(LOG_TAG, "Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                    throw new RSRuntimeException("Error loading RS Compat library for Incremental Intrinsic Support: " + e);
                }
            }
            if (this.mIncCon == 0) {
                this.mIncCon = nIncContextCreate(nIncDeviceCreate(), 0, 0, 0);
            }
            rsnScriptIntrinsicCreate = rsnScriptIntrinsicCreate(this.mIncCon, i, j, z);
        }
        return rsnScriptIntrinsicCreate;
    }

    synchronized long nScriptKernelIDCreate(long j, int i, int i2, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptKernelIDCreate(j2, j, i, i2, z);
    }

    synchronized long nScriptInvokeIDCreate(long j, int i) {
        validate();
        return rsnScriptInvokeIDCreate(this.mContext, j, i);
    }

    synchronized long nScriptFieldIDCreate(long j, int i, boolean z) {
        long j2;
        validate();
        j2 = this.mContext;
        if (z) {
            j2 = this.mIncCon;
        }
        return rsnScriptFieldIDCreate(j2, j, i, z);
    }

    synchronized long nScriptGroupCreate(long[] jArr, long[] jArr2, long[] jArr3, long[] jArr4, long[] jArr5) {
        validate();
        return rsnScriptGroupCreate(this.mContext, jArr, jArr2, jArr3, jArr4, jArr5);
    }

    synchronized void nScriptGroupSetInput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetInput(this.mContext, j, j2, j3);
    }

    synchronized void nScriptGroupSetOutput(long j, long j2, long j3) {
        validate();
        rsnScriptGroupSetOutput(this.mContext, j, j2, j3);
    }

    synchronized void nScriptGroupExecute(long j) {
        validate();
        rsnScriptGroupExecute(this.mContext, j);
    }

    synchronized long nSamplerCreate(int i, int i2, int i3, int i4, int i5, float f) {
        validate();
        return rsnSamplerCreate(this.mContext, i, i2, i3, i4, i5, f);
    }

    synchronized long nClosureCreate(long j, long j2, long[] jArr, long[] jArr2, int[] iArr, long[] jArr3, long[] jArr4) {
        long rsnClosureCreate;
        validate();
        rsnClosureCreate = rsnClosureCreate(this.mContext, j, j2, jArr, jArr2, iArr, jArr3, jArr4);
        if (rsnClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnClosureCreate;
    }

    synchronized long nInvokeClosureCreate(long j, byte[] bArr, long[] jArr, long[] jArr2, int[] iArr) {
        long rsnInvokeClosureCreate;
        validate();
        rsnInvokeClosureCreate = rsnInvokeClosureCreate(this.mContext, j, bArr, jArr, jArr2, iArr);
        if (rsnInvokeClosureCreate == 0) {
            throw new RSRuntimeException("Failed creating closure.");
        }
        return rsnInvokeClosureCreate;
    }

    synchronized void nClosureSetArg(long j, int i, long j2, int i2) {
        validate();
        rsnClosureSetArg(this.mContext, j, i, j2, i2);
    }

    synchronized void nClosureSetGlobal(long j, long j2, long j3, int i) {
        validate();
        rsnClosureSetGlobal(this.mContext, j, j2, j3, i);
    }

    synchronized long nScriptGroup2Create(String str, String str2, long[] jArr) {
        validate();
        return rsnScriptGroup2Create(this.mContext, str, str2, jArr);
    }

    synchronized void nScriptGroup2Execute(long j) {
        validate();
        rsnScriptGroup2Execute(this.mContext, j);
    }

    synchronized void nScriptIntrinsicBLAS_Single(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, long j2, long j3, float f2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Single(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, j2, j3, f2, j4, i10, i11, i12, i13, z);
    }

    synchronized void nScriptIntrinsicBLAS_Double(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, long j2, long j3, double d2, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Double(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, j2, j3, d2, j4, i10, i11, i12, i13, z);
    }

    synchronized void nScriptIntrinsicBLAS_Complex(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, float f, float f2, long j2, long j3, float f3, float f4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Complex(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, f, f2, j2, j3, f3, f4, j4, i10, i11, i12, i13, z);
    }

    synchronized void nScriptIntrinsicBLAS_Z(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, double d, double d2, long j2, long j3, double d3, double d4, long j4, int i10, int i11, int i12, int i13, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_Z(this.mContext, this.mIncCon, j, i, i2, i3, i4, i5, i6, i7, i8, i9, d, d2, j2, j3, d3, d4, j4, i10, i11, i12, i13, z);
    }

    synchronized void nScriptIntrinsicBLAS_BNNM(long j, int i, int i2, int i3, long j2, int i4, long j3, int i5, long j4, int i6, int i7, boolean z) {
        validate();
        rsnScriptIntrinsicBLAS_BNNM(this.mContext, this.mIncCon, j, i, i2, i3, j2, i4, j3, i5, j4, i6, i7, z);
    }

    synchronized long nIncContextCreate(long j, int i, int i2, int i3) {
        return rsnIncContextCreate(j, i, i2, i3);
    }

    synchronized void nIncContextDestroy() {
        validate();
        WriteLock writeLock = this.mRWLock.writeLock();
        writeLock.lock();
        long j = this.mIncCon;
        this.mIncCon = 0;
        writeLock.unlock();
        rsnIncContextDestroy(j);
    }

    synchronized void nIncContextFinish() {
        validate();
        rsnIncContextFinish(this.mIncCon);
    }

    void nIncObjDestroy(long j) {
        if (this.mIncCon != 0) {
            rsnIncObjDestroy(this.mIncCon, j);
        }
    }

    synchronized long nIncElementCreate(long j, int i, boolean z, int i2) {
        validate();
        return rsnIncElementCreate(this.mIncCon, j, i, z, i2);
    }

    synchronized long nIncTypeCreate(long j, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        validate();
        return rsnIncTypeCreate(this.mIncCon, j, i, i2, i3, z, z2, i4);
    }

    synchronized long nIncAllocationCreateTyped(long j, long j2, int i) {
        validate();
        return rsnIncAllocationCreateTyped(this.mContext, this.mIncCon, j, j2, i);
    }

    public void setMessageHandler(RSMessageHandler rSMessageHandler) {
        this.mMessageCallback = rSMessageHandler;
    }

    public RSMessageHandler getMessageHandler() {
        return this.mMessageCallback;
    }

    public void sendMessage(int i, int[] iArr) {
        nContextSendMessage(i, iArr);
    }

    public void setErrorHandler(RSErrorHandler rSErrorHandler) {
        this.mErrorCallback = rSErrorHandler;
    }

    public RSErrorHandler getErrorHandler() {
        return this.mErrorCallback;
    }

    void validateObject(BaseObj baseObj) {
        if (baseObj != null && baseObj.mRS != this) {
            throw new RSIllegalArgumentException("Attempting to use an object across contexts.");
        }
    }

    void validate() {
        if (this.mContext == 0) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    boolean usingIO() {
        return useIOlib;
    }

    public void setPriority(Priority priority) {
        validate();
        nContextSetPriority(priority.mID);
    }

    RenderScript(Context context) {
        if (context != null) {
            this.mApplicationContext = context.getApplicationContext();
            this.mNativeLibDir = this.mApplicationContext.getApplicationInfo().nativeLibraryDir;
        }
        this.mIncCon = 0;
        this.mIncLoaded = false;
        this.mRWLock = new ReentrantReadWriteLock();
    }

    public final Context getApplicationContext() {
        return this.mApplicationContext;
    }

    private static RenderScript internalCreate(Context context, int i, ContextType contextType, int i2) {
        int i3;
        String str = null;
        RenderScript renderScript = new RenderScript(context);
        if (sSdkVersion == -1) {
            sSdkVersion = i;
        } else if (sSdkVersion != i) {
            throw new RSRuntimeException("Can't have two contexts with different SDK versions in support lib");
        }
        useNative = setupNative(sSdkVersion, context);
        synchronized (lock) {
            if (!sInitialized) {
                try {
                    Class cls = Class.forName("dalvik.system.VMRuntime");
                    sRuntime = cls.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]);
                    registerNativeAllocation = cls.getDeclaredMethod("registerNativeAllocation", new Class[]{Integer.TYPE});
                    registerNativeFree = cls.getDeclaredMethod("registerNativeFree", new Class[]{Integer.TYPE});
                    sUseGCHooks = true;
                } catch (UnsatisfiedLinkError e) {
                    Log.e(LOG_TAG, "Error loading RS jni library: " + e);
                    throw new RSRuntimeException("Error loading RS jni library: " + e + " Support lib API: " + SUPPORT_LIB_VERSION);
                } catch (Exception e2) {
                    Log.e(LOG_TAG, "No GC methods");
                    sUseGCHooks = false;
                }
                if (VERSION.SDK_INT >= 23 || renderScript.mNativeLibDir == null) {
                    System.loadLibrary("rsjni");
                } else {
                    System.load(renderScript.mNativeLibDir + "/librsjni.so");
                }
                sInitialized = true;
                sPointerSize = rsnSystemGetPointerSize();
            }
        }
        if (useNative) {
            Log.v(LOG_TAG, "RS native mode");
        } else {
            Log.v(LOG_TAG, "RS compat mode");
        }
        if (VERSION.SDK_INT >= 14) {
            useIOlib = true;
        }
        if (i < VERSION.SDK_INT) {
            i3 = VERSION.SDK_INT;
        } else {
            i3 = i;
        }
        if (VERSION.SDK_INT < 23 && renderScript.mNativeLibDir != null) {
            str = renderScript.mNativeLibDir + "/libRSSupport.so";
        }
        if (!renderScript.nLoadSO(useNative, i3, str)) {
            if (useNative) {
                Log.v(LOG_TAG, "Unable to load libRS.so, falling back to compat mode");
                useNative = false;
            }
            try {
                if (VERSION.SDK_INT >= 23 || renderScript.mNativeLibDir == null) {
                    System.loadLibrary("RSSupport");
                } else {
                    System.load(str);
                }
                if (!renderScript.nLoadSO(false, i3, str)) {
                    Log.e(LOG_TAG, "Error loading RS Compat library: nLoadSO() failed; Support lib version: 2301");
                    throw new RSRuntimeException("Error loading libRSSupport library, Support lib version: 2301");
                }
            } catch (UnsatisfiedLinkError e3) {
                Log.e(LOG_TAG, "Error loading RS Compat library: " + e3 + " Support lib version: " + SUPPORT_LIB_VERSION);
                throw new RSRuntimeException("Error loading RS Compat library: " + e3 + " Support lib version: " + SUPPORT_LIB_VERSION);
            }
        }
        if (useIOlib) {
            try {
                System.loadLibrary("RSSupportIO");
            } catch (UnsatisfiedLinkError e4) {
                useIOlib = false;
            }
            if (!(useIOlib && renderScript.nLoadIOSO())) {
                Log.v(LOG_TAG, "Unable to load libRSSupportIO.so, USAGE_IO not supported");
                useIOlib = false;
            }
        }
        if (i3 >= 23) {
            renderScript.mEnableMultiInput = true;
            try {
                System.loadLibrary("blasV8");
            } catch (UnsatisfiedLinkError e5) {
                Log.v(LOG_TAG, "Unable to load BLAS lib, ONLY BNNM will be supported: " + e5);
            }
        }
        renderScript.mContext = renderScript.nContextCreate(renderScript.nDeviceCreate(), 0, i, contextType.mID, renderScript.mNativeLibDir);
        renderScript.mContextType = contextType;
        renderScript.mContextFlags = i2;
        renderScript.mContextSdkVersion = i;
        renderScript.mDispatchAPILevel = i3;
        if (renderScript.mContext == 0) {
            throw new RSDriverException("Failed to create RS context.");
        }
        renderScript.mMessageThread = new MessageThread(renderScript);
        renderScript.mMessageThread.start();
        return renderScript;
    }

    public static RenderScript create(Context context) {
        return create(context, ContextType.NORMAL);
    }

    public static RenderScript create(Context context, ContextType contextType) {
        return create(context, contextType, 0);
    }

    public static RenderScript create(Context context, ContextType contextType, int i) {
        return create(context, context.getApplicationInfo().targetSdkVersion, contextType, i);
    }

    public static RenderScript create(Context context, int i) {
        return create(context, i, ContextType.NORMAL, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType) {
        return create(context, i, contextType, 0);
    }

    public static RenderScript create(Context context, int i, ContextType contextType, int i2) {
        RenderScript renderScript;
        synchronized (mProcessContextList) {
            Iterator it = mProcessContextList.iterator();
            while (it.hasNext()) {
                renderScript = (RenderScript) it.next();
                if (renderScript.mContextType == contextType && renderScript.mContextFlags == i2 && renderScript.mContextSdkVersion == i) {
                    break;
                }
            }
            renderScript = internalCreate(context, i, contextType, i2);
            renderScript.mIsProcessContext = true;
            mProcessContextList.add(renderScript);
        }
        return renderScript;
    }

    public static void releaseAllContexts() {
        ArrayList arrayList;
        synchronized (mProcessContextList) {
            arrayList = mProcessContextList;
            mProcessContextList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RenderScript renderScript = (RenderScript) it.next();
            renderScript.mIsProcessContext = false;
            renderScript.destroy();
        }
        arrayList.clear();
    }

    public static RenderScript createMultiContext(Context context, ContextType contextType, int i, int i2) {
        return internalCreate(context, i2, contextType, i);
    }

    public void contextDump() {
        validate();
        nContextDump(0);
    }

    public void finish() {
        nContextFinish();
    }

    private void helpDestroy() {
        boolean z;
        boolean z2 = false;
        synchronized (this) {
            if (this.mDestroyed) {
                z = false;
            } else {
                this.mDestroyed = true;
                z = true;
            }
        }
        if (z) {
            nContextFinish();
            if (this.mIncCon != 0) {
                nIncContextFinish();
                nIncContextDestroy();
                this.mIncCon = 0;
            }
            nContextDeinitToClient(this.mContext);
            this.mMessageThread.mRun = false;
            this.mMessageThread.interrupt();
            z = false;
            while (!z) {
                try {
                    this.mMessageThread.join();
                    z = true;
                } catch (InterruptedException e) {
                    z2 = true;
                }
            }
            if (z2) {
                Log.v(LOG_TAG, "Interrupted during wait for MessageThread to join");
                Thread.currentThread().interrupt();
            }
            nContextDestroy();
        }
    }

    protected void finalize() throws Throwable {
        helpDestroy();
        super.finalize();
    }

    public void destroy() {
        if (!this.mIsProcessContext) {
            validate();
            helpDestroy();
        }
    }

    boolean isAlive() {
        return this.mContext != 0;
    }

    long safeID(BaseObj baseObj) {
        if (baseObj != null) {
            return baseObj.getID(this);
        }
        return 0;
    }
}
