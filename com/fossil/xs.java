package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class xs implements xn<InputStream> {
    private static final Set<ImageType> aDR = EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG);
    private static final Queue<Options> aDS = abl.eR(0);
    public static final xs aDT = new C42141();
    public static final xs aDU = new C42152();
    public static final xs aDV = new C42163();

    static class C42141 extends xs {
        C42141() {
        }

        protected int mo4431p(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        public String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    }

    static class C42152 extends xs {
        C42152() {
        }

        protected int mo4431p(int i, int i2, int i3, int i4) {
            int i5 = 1;
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return max << i5;
        }

        public String getId() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    }

    static class C42163 extends xs {
        C42163() {
        }

        protected int mo4431p(int i, int i2, int i3, int i4) {
            return 0;
        }

        public String getId() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    }

    private static android.graphics.Bitmap.Config m14046a(java.io.InputStream r6, com.bumptech.glide.load.DecodeFormat r7) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0071 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r5 = 5;
        r0 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0005:
        r0 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x0012;
    L_0x000f:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.mark(r0);
        r0 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0 = r0.hasAlpha();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r6.reset();	 Catch:{ IOException -> 0x0029 }
    L_0x0024:
        if (r0 == 0) goto L_0x0089;
    L_0x0026:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        goto L_0x0011;
    L_0x0029:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0024;
    L_0x0032:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = 5;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        if (r2 == 0) goto L_0x005c;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x0044:
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3.<init>();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r4 = "Cannot determine whether the image has alpha or not from header for format ";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r7);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        android.util.Log.w(r2, r3, r0);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x005c:
        r6.reset();
        r0 = r1;
        goto L_0x0024;
    L_0x0061:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0071;
    L_0x006a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
    L_0x0071:
        r0 = r1;
        goto L_0x0024;
    L_0x0073:
        r0 = move-exception;
        r6.reset();	 Catch:{ IOException -> 0x0078 }
    L_0x0077:
        throw r0;
    L_0x0078:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0077;
    L_0x0081:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0077;
    L_0x0089:
        r0 = android.graphics.Bitmap.Config.RGB_565;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.xs.a(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    private static boolean m14052d(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0046 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = 5;
        r0 = 19;
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r0 > r1) goto L_0x0009;
    L_0x0007:
        r0 = 1;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4.mark(r0);
        r0 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r0.vL();	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = aDR;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r1.contains(r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r4.reset();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x0008;
    L_0x002a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0008;
    L_0x0032:
        r0 = move-exception;
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = 5;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        if (r1 == 0) goto L_0x0043;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x003c:
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = "Cannot determine the image type from header";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        android.util.Log.w(r1, r2, r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x0043:
        r4.reset();
    L_0x0046:
        r0 = 0;
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        r1 = "Downsampler";
        r1 = android.util.Log.isLoggable(r1, r3);
        if (r1 == 0) goto L_0x0046;
    L_0x0051:
        r1 = "Downsampler";
        r2 = "Cannot reset the input stream";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0046;
    L_0x0059:
        r0 = move-exception;
        r4.reset();	 Catch:{ IOException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x005d;
    L_0x0067:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.xs.d(java.io.InputStream):boolean");
    }

    public android.graphics.Bitmap m14054a(java.io.InputStream r21, com.fossil.vl r22, int r23, int r24, com.bumptech.glide.load.DecodeFormat r25) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00be in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r20 = this;
        r16 = com.fossil.abe.wT();
        r17 = r16.getBytes();
        r18 = r16.getBytes();
        r9 = vE();
        r8 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
        r0 = r21;
        r1 = r18;
        r8.<init>(r0, r1);
        r19 = com.fossil.abg.g(r8);
        r10 = new com.fossil.abj;
        r0 = r19;
        r10.<init>(r0);
        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r0 = r19;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0.mark(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;
        r2 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r0 = r19;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2 = r2.getOrientation();	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r19.reset();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r15 = r2;
    L_0x003b:
        r0 = r17;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r9.inTempStorage = r0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r0.m14055a(r10, r8, r9);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 1;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = com.fossil.yc.eM(r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r23;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r24;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r13 = r2.m14053h(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r10;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r10 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r11 = r4;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r12 = r5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r14 = r25;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = r6.m14047a(r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r19.wU();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x006c:
        r3 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        throw r3;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0072:
        r2 = move-exception;
        r16.L(r17);
        r0 = r16;
        r1 = r18;
        r0.L(r1);
        r19.release();
        m14048a(r9);
        throw r2;
    L_0x0084:
        r3 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x0095;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x008e:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0095:
        r15 = r2;
        goto L_0x003b;
    L_0x0097:
        r2 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = 5;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        if (r4 == 0) goto L_0x00a8;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a1:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = "Cannot determine the image orientation from header";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        android.util.Log.w(r4, r5, r2);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a8:
        r19.reset();
        r15 = r3;
        goto L_0x003b;
    L_0x00ad:
        r2 = move-exception;
        r4 = "Downsampler";
        r5 = 5;
        r4 = android.util.Log.isLoggable(r4, r5);
        if (r4 == 0) goto L_0x00be;
    L_0x00b7:
        r4 = "Downsampler";
        r5 = "Cannot reset the input stream";
        android.util.Log.w(r4, r5, r2);
    L_0x00be:
        r15 = r3;
        goto L_0x003b;
    L_0x00c1:
        r2 = move-exception;
        r19.reset();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c5:
        throw r2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00c6:
        r3 = move-exception;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d0:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d8:
        r2 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r3 == 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00db:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = com.fossil.yc.m14068a(r3, r0, r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r3.equals(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00e7:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r0.mo4217j(r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00ef:
        r3.recycle();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00f2:
        r16.L(r17);
        r0 = r16;
        r1 = r18;
        r0.L(r1);
        r19.release();
        m14048a(r9);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.xs.a(java.io.InputStream, com.fossil.vl, int, int, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap");
    }

    protected abstract int mo4431p(int i, int i2, int i3, int i4);

    private int m14053h(int i, int i2, int i3, int i4, int i5) {
        int p;
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i == 90 || i == 270) {
            p = mo4431p(i3, i2, i4, i5);
        } else {
            p = mo4431p(i2, i3, i4, i5);
        }
        return Math.max(1, p == 0 ? 0 : Integer.highestOneBit(p));
    }

    private Bitmap m14047a(abj com_fossil_abj, RecyclableBufferedInputStream recyclableBufferedInputStream, Options options, vl vlVar, int i, int i2, int i3, DecodeFormat decodeFormat) {
        Config a = m14046a((InputStream) com_fossil_abj, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = a;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && m14052d(com_fossil_abj)) {
            m14049a(options, vlVar.mo4216h((int) Math.ceil(((double) i) / ((double) i3)), (int) Math.ceil(((double) i2) / ((double) i3)), a));
        }
        return m14050b(com_fossil_abj, recyclableBufferedInputStream, options);
    }

    public int[] m14055a(abj com_fossil_abj, RecyclableBufferedInputStream recyclableBufferedInputStream, Options options) {
        options.inJustDecodeBounds = true;
        m14050b(com_fossil_abj, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static Bitmap m14050b(abj com_fossil_abj, RecyclableBufferedInputStream recyclableBufferedInputStream, Options options) {
        if (options.inJustDecodeBounds) {
            com_fossil_abj.mark(5242880);
        } else {
            recyclableBufferedInputStream.vR();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(com_fossil_abj, null, options);
        try {
            if (options.inJustDecodeBounds) {
                com_fossil_abj.reset();
            }
        } catch (Throwable e) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return decodeStream;
    }

    @TargetApi(11)
    private static void m14049a(Options options, Bitmap bitmap) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    @TargetApi(11)
    private static synchronized Options vE() {
        Options options;
        synchronized (xs.class) {
            synchronized (aDS) {
                options = (Options) aDS.poll();
            }
            if (options == null) {
                options = new Options();
                m14051b(options);
            }
        }
        return options;
    }

    private static void m14048a(Options options) {
        m14051b(options);
        synchronized (aDS) {
            aDS.offer(options);
        }
    }

    @TargetApi(11)
    private static void m14051b(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }
}
