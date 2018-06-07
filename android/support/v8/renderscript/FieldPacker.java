package android.support.v8.renderscript;

import android.util.Log;
import com.misfit.ble.setting.eventmapping.GoalTrackingEventMapping;
import java.util.BitSet;

public class FieldPacker {
    private BitSet mAlignment;
    private byte[] mData;
    private int mLen;
    private int mPos;

    public FieldPacker(int i) {
        this.mPos = 0;
        this.mLen = i;
        this.mData = new byte[i];
        this.mAlignment = new BitSet();
    }

    public FieldPacker(byte[] bArr) {
        this.mPos = bArr.length;
        this.mLen = bArr.length;
        this.mData = bArr;
        this.mAlignment = new BitSet();
    }

    static FieldPacker createFromArray(Object[] objArr) {
        FieldPacker fieldPacker = new FieldPacker(RenderScript.sPointerSize * 8);
        for (Object addSafely : objArr) {
            fieldPacker.addSafely(addSafely);
        }
        fieldPacker.resize(fieldPacker.mPos);
        return fieldPacker;
    }

    public void align(int i) {
        if (i <= 0 || ((i - 1) & i) != 0) {
            throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + i);
        }
        while ((this.mPos & (i - 1)) != 0) {
            this.mAlignment.flip(this.mPos);
            byte[] bArr = this.mData;
            int i2 = this.mPos;
            this.mPos = i2 + 1;
            bArr[i2] = (byte) 0;
        }
    }

    public void subalign(int i) {
        if (((i - 1) & i) != 0) {
            throw new RSIllegalArgumentException("argument must be a non-negative non-zero power of 2: " + i);
        }
        while ((this.mPos & (i - 1)) != 0) {
            this.mPos--;
        }
        if (this.mPos > 0) {
            while (this.mAlignment.get(this.mPos - 1)) {
                this.mPos--;
                this.mAlignment.flip(this.mPos);
            }
        }
    }

    public void reset() {
        this.mPos = 0;
    }

    public void reset(int i) {
        if (i < 0 || i > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = i;
    }

    public void skip(int i) {
        int i2 = this.mPos + i;
        if (i2 < 0 || i2 > this.mLen) {
            throw new RSIllegalArgumentException("out of range argument: " + i);
        }
        this.mPos = i2;
    }

    public void addI8(byte b) {
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = b;
    }

    public byte subI8() {
        subalign(1);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        return bArr[i];
    }

    public void addI16(short s) {
        align(2);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (s & 255);
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) (s >> 8);
    }

    public short subI16() {
        subalign(2);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        short s = (short) ((bArr[i] & 255) << 8);
        byte[] bArr2 = this.mData;
        int i2 = this.mPos - 1;
        this.mPos = i2;
        return (short) (s | ((short) (bArr2[i2] & 255)));
    }

    public void addI32(int i) {
        align(4);
        byte[] bArr = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = this.mData;
        i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) ((i >> 8) & 255);
        bArr = this.mData;
        i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) ((i >> 16) & 255);
        bArr = this.mData;
        i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) ((i >> 24) & 255);
    }

    public int subI32() {
        subalign(4);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        int i2 = (bArr[i] & 255) << 24;
        byte[] bArr2 = this.mData;
        int i3 = this.mPos - 1;
        this.mPos = i3;
        i2 |= (bArr2[i3] & 255) << 16;
        bArr2 = this.mData;
        i3 = this.mPos - 1;
        this.mPos = i3;
        i2 |= (bArr2[i3] & 255) << 8;
        bArr2 = this.mData;
        i3 = this.mPos - 1;
        this.mPos = i3;
        return i2 | (bArr2[i3] & 255);
    }

    public void addI64(long j) {
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 8) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 16) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 24) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 32) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 40) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 48) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
    }

    public long subI64() {
        subalign(8);
        byte[] bArr = this.mData;
        int i = this.mPos - 1;
        this.mPos = i;
        long j = 0 | ((((long) bArr[i]) & 255) << 56);
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 48;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 40;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 32;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 24;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 16;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        j |= (((long) bArr[i]) & 255) << 8;
        bArr = this.mData;
        i = this.mPos - 1;
        this.mPos = i;
        return j | (((long) bArr[i]) & 255);
    }

    public void addU8(short s) {
        if (s < (short) 0 || s > GoalTrackingEventMapping.INVALID_GOAL_ID_NUMBER) {
            Log.e("rs", "FieldPacker.addU8( " + s + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) s;
    }

    public void addU16(int i) {
        if (i < 0 || i > 65535) {
            Log.e("rs", "FieldPacker.addU16( " + i + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(2);
        byte[] bArr = this.mData;
        int i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        bArr = this.mData;
        i2 = this.mPos;
        this.mPos = i2 + 1;
        bArr[i2] = (byte) (i >> 8);
    }

    public void addU32(long j) {
        if (j < 0 || j > 4294967295L) {
            Log.e("rs", "FieldPacker.addU32( " + j + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(4);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 8) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 16) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 24) & 255));
    }

    public void addU64(long j) {
        if (j < 0) {
            Log.e("rs", "FieldPacker.addU64( " + j + " )");
            throw new IllegalArgumentException("Saving value out of range for type");
        }
        align(8);
        byte[] bArr = this.mData;
        int i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 8) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 16) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 24) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 32) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 40) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 48) & 255));
        bArr = this.mData;
        i = this.mPos;
        this.mPos = i + 1;
        bArr[i] = (byte) ((int) ((j >> 56) & 255));
    }

    public void addF32(float f) {
        addI32(Float.floatToRawIntBits(f));
    }

    public float subF32() {
        return Float.intBitsToFloat(subI32());
    }

    public void addF64(double d) {
        addI64(Double.doubleToRawLongBits(d));
    }

    public double subF64() {
        return Double.longBitsToDouble(subI64());
    }

    public void addObj(BaseObj baseObj) {
        if (baseObj != null) {
            if (RenderScript.sPointerSize == 8) {
                addI64(baseObj.getID(null));
                addI64(0);
                addI64(0);
                addI64(0);
                return;
            }
            addI32((int) baseObj.getID(null));
        } else if (RenderScript.sPointerSize == 8) {
            addI64(0);
            addI64(0);
            addI64(0);
            addI64(0);
        } else {
            addI32(0);
        }
    }

    public void addF32(Float2 float2) {
        addF32(float2.f1238x);
        addF32(float2.f1239y);
    }

    public void addF32(Float3 float3) {
        addF32(float3.f1240x);
        addF32(float3.f1241y);
        addF32(float3.f1242z);
    }

    public void addF32(Float4 float4) {
        addF32(float4.f1244x);
        addF32(float4.f1245y);
        addF32(float4.f1246z);
        addF32(float4.f1243w);
    }

    public void addF64(Double2 double2) {
        addF64(double2.f1229x);
        addF64(double2.f1230y);
    }

    public void addF64(Double3 double3) {
        addF64(double3.f1231x);
        addF64(double3.f1232y);
        addF64(double3.f1233z);
    }

    public void addF64(Double4 double4) {
        addF64(double4.f1235x);
        addF64(double4.f1236y);
        addF64(double4.f1237z);
        addF64(double4.f1234w);
    }

    public void addI8(Byte2 byte2) {
        addI8(byte2.f1220x);
        addI8(byte2.f1221y);
    }

    public void addI8(Byte3 byte3) {
        addI8(byte3.f1222x);
        addI8(byte3.f1223y);
        addI8(byte3.f1224z);
    }

    public void addI8(Byte4 byte4) {
        addI8(byte4.f1226x);
        addI8(byte4.f1227y);
        addI8(byte4.f1228z);
        addI8(byte4.f1225w);
    }

    public void addU8(Short2 short2) {
        addU8(short2.f1265x);
        addU8(short2.f1266y);
    }

    public void addU8(Short3 short3) {
        addU8(short3.f1267x);
        addU8(short3.f1268y);
        addU8(short3.f1269z);
    }

    public void addU8(Short4 short4) {
        addU8(short4.f1271x);
        addU8(short4.f1272y);
        addU8(short4.f1273z);
        addU8(short4.f1270w);
    }

    public void addI16(Short2 short2) {
        addI16(short2.f1265x);
        addI16(short2.f1266y);
    }

    public void addI16(Short3 short3) {
        addI16(short3.f1267x);
        addI16(short3.f1268y);
        addI16(short3.f1269z);
    }

    public void addI16(Short4 short4) {
        addI16(short4.f1271x);
        addI16(short4.f1272y);
        addI16(short4.f1273z);
        addI16(short4.f1270w);
    }

    public void addU16(Int2 int2) {
        addU16(int2.f1247x);
        addU16(int2.f1248y);
    }

    public void addU16(Int3 int3) {
        addU16(int3.f1249x);
        addU16(int3.f1250y);
        addU16(int3.f1251z);
    }

    public void addU16(Int4 int4) {
        addU16(int4.f1253x);
        addU16(int4.f1254y);
        addU16(int4.f1255z);
        addU16(int4.f1252w);
    }

    public void addI32(Int2 int2) {
        addI32(int2.f1247x);
        addI32(int2.f1248y);
    }

    public void addI32(Int3 int3) {
        addI32(int3.f1249x);
        addI32(int3.f1250y);
        addI32(int3.f1251z);
    }

    public void addI32(Int4 int4) {
        addI32(int4.f1253x);
        addI32(int4.f1254y);
        addI32(int4.f1255z);
        addI32(int4.f1252w);
    }

    public void addU32(Long2 long2) {
        addU32(long2.f1256x);
        addU32(long2.f1257y);
    }

    public void addU32(Long3 long3) {
        addU32(long3.f1258x);
        addU32(long3.f1259y);
        addU32(long3.f1260z);
    }

    public void addU32(Long4 long4) {
        addU32(long4.f1262x);
        addU32(long4.f1263y);
        addU32(long4.f1264z);
        addU32(long4.f1261w);
    }

    public void addI64(Long2 long2) {
        addI64(long2.f1256x);
        addI64(long2.f1257y);
    }

    public void addI64(Long3 long3) {
        addI64(long3.f1258x);
        addI64(long3.f1259y);
        addI64(long3.f1260z);
    }

    public void addI64(Long4 long4) {
        addI64(long4.f1262x);
        addI64(long4.f1263y);
        addI64(long4.f1264z);
        addI64(long4.f1261w);
    }

    public void addU64(Long2 long2) {
        addU64(long2.f1256x);
        addU64(long2.f1257y);
    }

    public void addU64(Long3 long3) {
        addU64(long3.f1258x);
        addU64(long3.f1259y);
        addU64(long3.f1260z);
    }

    public void addU64(Long4 long4) {
        addU64(long4.f1262x);
        addU64(long4.f1263y);
        addU64(long4.f1264z);
        addU64(long4.f1261w);
    }

    public Float2 subFloat2() {
        Float2 float2 = new Float2();
        float2.f1239y = subF32();
        float2.f1238x = subF32();
        return float2;
    }

    public Float3 subFloat3() {
        Float3 float3 = new Float3();
        float3.f1242z = subF32();
        float3.f1241y = subF32();
        float3.f1240x = subF32();
        return float3;
    }

    public Float4 subFloat4() {
        Float4 float4 = new Float4();
        float4.f1243w = subF32();
        float4.f1246z = subF32();
        float4.f1245y = subF32();
        float4.f1244x = subF32();
        return float4;
    }

    public Double2 subDouble2() {
        Double2 double2 = new Double2();
        double2.f1230y = subF64();
        double2.f1229x = subF64();
        return double2;
    }

    public Double3 subDouble3() {
        Double3 double3 = new Double3();
        double3.f1233z = subF64();
        double3.f1232y = subF64();
        double3.f1231x = subF64();
        return double3;
    }

    public Double4 subDouble4() {
        Double4 double4 = new Double4();
        double4.f1234w = subF64();
        double4.f1237z = subF64();
        double4.f1236y = subF64();
        double4.f1235x = subF64();
        return double4;
    }

    public Byte2 subByte2() {
        Byte2 byte2 = new Byte2();
        byte2.f1221y = subI8();
        byte2.f1220x = subI8();
        return byte2;
    }

    public Byte3 subByte3() {
        Byte3 byte3 = new Byte3();
        byte3.f1224z = subI8();
        byte3.f1223y = subI8();
        byte3.f1222x = subI8();
        return byte3;
    }

    public Byte4 subByte4() {
        Byte4 byte4 = new Byte4();
        byte4.f1225w = subI8();
        byte4.f1228z = subI8();
        byte4.f1227y = subI8();
        byte4.f1226x = subI8();
        return byte4;
    }

    public Short2 subShort2() {
        Short2 short2 = new Short2();
        short2.f1266y = subI16();
        short2.f1265x = subI16();
        return short2;
    }

    public Short3 subShort3() {
        Short3 short3 = new Short3();
        short3.f1269z = subI16();
        short3.f1268y = subI16();
        short3.f1267x = subI16();
        return short3;
    }

    public Short4 subShort4() {
        Short4 short4 = new Short4();
        short4.f1270w = subI16();
        short4.f1273z = subI16();
        short4.f1272y = subI16();
        short4.f1271x = subI16();
        return short4;
    }

    public Int2 subInt2() {
        Int2 int2 = new Int2();
        int2.f1248y = subI32();
        int2.f1247x = subI32();
        return int2;
    }

    public Int3 subInt3() {
        Int3 int3 = new Int3();
        int3.f1251z = subI32();
        int3.f1250y = subI32();
        int3.f1249x = subI32();
        return int3;
    }

    public Int4 subInt4() {
        Int4 int4 = new Int4();
        int4.f1252w = subI32();
        int4.f1255z = subI32();
        int4.f1254y = subI32();
        int4.f1253x = subI32();
        return int4;
    }

    public Long2 subLong2() {
        Long2 long2 = new Long2();
        long2.f1257y = subI64();
        long2.f1256x = subI64();
        return long2;
    }

    public Long3 subLong3() {
        Long3 long3 = new Long3();
        long3.f1260z = subI64();
        long3.f1259y = subI64();
        long3.f1258x = subI64();
        return long3;
    }

    public Long4 subLong4() {
        Long4 long4 = new Long4();
        long4.f1261w = subI64();
        long4.f1264z = subI64();
        long4.f1263y = subI64();
        long4.f1262x = subI64();
        return long4;
    }

    public void addMatrix(Matrix4f matrix4f) {
        for (float addF32 : matrix4f.mMat) {
            addF32(addF32);
        }
    }

    public Matrix4f subMatrix4f() {
        Matrix4f matrix4f = new Matrix4f();
        for (int length = matrix4f.mMat.length - 1; length >= 0; length--) {
            matrix4f.mMat[length] = subF32();
        }
        return matrix4f;
    }

    public void addMatrix(Matrix3f matrix3f) {
        for (float addF32 : matrix3f.mMat) {
            addF32(addF32);
        }
    }

    public Matrix3f subMatrix3f() {
        Matrix3f matrix3f = new Matrix3f();
        for (int length = matrix3f.mMat.length - 1; length >= 0; length--) {
            matrix3f.mMat[length] = subF32();
        }
        return matrix3f;
    }

    public void addMatrix(Matrix2f matrix2f) {
        for (float addF32 : matrix2f.mMat) {
            addF32(addF32);
        }
    }

    public Matrix2f subMatrix2f() {
        Matrix2f matrix2f = new Matrix2f();
        for (int length = matrix2f.mMat.length - 1; length >= 0; length--) {
            matrix2f.mMat[length] = subF32();
        }
        return matrix2f;
    }

    public void addBoolean(boolean z) {
        addI8((byte) (z ? 1 : 0));
    }

    public boolean subBoolean() {
        if (subI8() == (byte) 1) {
            return true;
        }
        return false;
    }

    public final byte[] getData() {
        return this.mData;
    }

    public int getPos() {
        return this.mPos;
    }

    private static void addToPack(FieldPacker fieldPacker, Object obj) {
        if (obj instanceof Boolean) {
            fieldPacker.addBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            fieldPacker.addI8(((Byte) obj).byteValue());
        } else if (obj instanceof Short) {
            fieldPacker.addI16(((Short) obj).shortValue());
        } else if (obj instanceof Integer) {
            fieldPacker.addI32(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            fieldPacker.addI64(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            fieldPacker.addF32(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            fieldPacker.addF64(((Double) obj).doubleValue());
        } else if (obj instanceof Byte2) {
            fieldPacker.addI8((Byte2) obj);
        } else if (obj instanceof Byte3) {
            fieldPacker.addI8((Byte3) obj);
        } else if (obj instanceof Byte4) {
            fieldPacker.addI8((Byte4) obj);
        } else if (obj instanceof Short2) {
            fieldPacker.addI16((Short2) obj);
        } else if (obj instanceof Short3) {
            fieldPacker.addI16((Short3) obj);
        } else if (obj instanceof Short4) {
            fieldPacker.addI16((Short4) obj);
        } else if (obj instanceof Int2) {
            fieldPacker.addI32((Int2) obj);
        } else if (obj instanceof Int3) {
            fieldPacker.addI32((Int3) obj);
        } else if (obj instanceof Int4) {
            fieldPacker.addI32((Int4) obj);
        } else if (obj instanceof Long2) {
            fieldPacker.addI64((Long2) obj);
        } else if (obj instanceof Long3) {
            fieldPacker.addI64((Long3) obj);
        } else if (obj instanceof Long4) {
            fieldPacker.addI64((Long4) obj);
        } else if (obj instanceof Float2) {
            fieldPacker.addF32((Float2) obj);
        } else if (obj instanceof Float3) {
            fieldPacker.addF32((Float3) obj);
        } else if (obj instanceof Float4) {
            fieldPacker.addF32((Float4) obj);
        } else if (obj instanceof Double2) {
            fieldPacker.addF64((Double2) obj);
        } else if (obj instanceof Double3) {
            fieldPacker.addF64((Double3) obj);
        } else if (obj instanceof Double4) {
            fieldPacker.addF64((Double4) obj);
        } else if (obj instanceof Matrix2f) {
            fieldPacker.addMatrix((Matrix2f) obj);
        } else if (obj instanceof Matrix3f) {
            fieldPacker.addMatrix((Matrix3f) obj);
        } else if (obj instanceof Matrix4f) {
            fieldPacker.addMatrix((Matrix4f) obj);
        } else if (obj instanceof BaseObj) {
            fieldPacker.addObj((BaseObj) obj);
        }
    }

    private static int getPackedSize(Object obj) {
        if ((obj instanceof Boolean) || (obj instanceof Byte)) {
            return 1;
        }
        if (obj instanceof Short) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 4;
        }
        if (obj instanceof Long) {
            return 8;
        }
        if (obj instanceof Float) {
            return 4;
        }
        if (obj instanceof Double) {
            return 8;
        }
        if (obj instanceof Byte2) {
            return 2;
        }
        if (obj instanceof Byte3) {
            return 3;
        }
        if (obj instanceof Byte4) {
            return 4;
        }
        if (obj instanceof Short2) {
            return 4;
        }
        if (obj instanceof Short3) {
            return 6;
        }
        if (obj instanceof Short4) {
            return 8;
        }
        if (obj instanceof Int2) {
            return 8;
        }
        if (obj instanceof Int3) {
            return 12;
        }
        if (obj instanceof Int4) {
            return 16;
        }
        if (obj instanceof Long2) {
            return 16;
        }
        if (obj instanceof Long3) {
            return 24;
        }
        if (obj instanceof Long4) {
            return 32;
        }
        if (obj instanceof Float2) {
            return 8;
        }
        if (obj instanceof Float3) {
            return 12;
        }
        if (obj instanceof Float4) {
            return 16;
        }
        if (obj instanceof Double2) {
            return 16;
        }
        if (obj instanceof Double3) {
            return 24;
        }
        if (obj instanceof Double4) {
            return 32;
        }
        if (obj instanceof Matrix2f) {
            return 16;
        }
        if (obj instanceof Matrix3f) {
            return 36;
        }
        if (obj instanceof Matrix4f) {
            return 64;
        }
        if (!(obj instanceof BaseObj)) {
            return 0;
        }
        if (RenderScript.sPointerSize == 8) {
            return 32;
        }
        return 4;
    }

    static FieldPacker createFieldPack(Object[] objArr) {
        int i = 0;
        int i2 = 0;
        for (Object packedSize : objArr) {
            i2 += getPackedSize(packedSize);
        }
        FieldPacker fieldPacker = new FieldPacker(i2);
        i2 = objArr.length;
        while (i < i2) {
            addToPack(fieldPacker, objArr[i]);
            i++;
        }
        return fieldPacker;
    }

    private boolean resize(int i) {
        if (i == this.mLen) {
            return false;
        }
        Object obj = new byte[i];
        System.arraycopy(this.mData, 0, obj, 0, this.mPos);
        this.mData = obj;
        this.mLen = i;
        return true;
    }

    private void addSafely(Object obj) {
        int i = this.mPos;
        Object obj2;
        do {
            obj2 = null;
            try {
                addToPack(this, obj);
                continue;
            } catch (ArrayIndexOutOfBoundsException e) {
                this.mPos = i;
                resize(this.mLen * 2);
                obj2 = 1;
                continue;
            }
        } while (obj2 != null);
    }
}
