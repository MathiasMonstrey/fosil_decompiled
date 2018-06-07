package com.fossil;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v8.renderscript.Allocation;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class cc {
    private static final String Fm = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> Fn = new HashSet();
    private static final boolean Fo = m5960S(System.getProperty("java.vm.version"));

    static final class C1990a {
        private static void m5952a(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = cc.m5961a(classLoader, "pathList").get(classLoader);
            cc.m5964a(obj, "dexElements", C1990a.m5953a(obj, new ArrayList(list), file));
        }

        private static Object[] m5953a(Object obj, ArrayList<File> arrayList, File file) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) cc.m5962a(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file});
        }
    }

    static final class C1991b {
        private static void m5955a(ClassLoader classLoader, List<File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
            Object obj = cc.m5961a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            cc.m5964a(obj, "dexElements", C1991b.m5956a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field b = cc.m5961a(classLoader, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr = (IOException[]) b.get(classLoader);
                if (iOExceptionArr == null) {
                    obj = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    Object obj2 = new IOException[(arrayList.size() + iOExceptionArr.length)];
                    arrayList.toArray(obj2);
                    System.arraycopy(iOExceptionArr, 0, obj2, arrayList.size(), iOExceptionArr.length);
                    obj = obj2;
                }
                b.set(classLoader, obj);
            }
        }

        private static Object[] m5956a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            return (Object[]) cc.m5962a(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    static final class C1992c {
        private static void m5958a(ClassLoader classLoader, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException {
            int size = list.size();
            Field b = cc.m5961a(classLoader, "path");
            StringBuilder stringBuilder = new StringBuilder((String) b.get(classLoader));
            Object[] objArr = new String[size];
            Object[] objArr2 = new File[size];
            Object[] objArr3 = new ZipFile[size];
            Object[] objArr4 = new DexFile[size];
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File file = (File) listIterator.next();
                String absolutePath = file.getAbsolutePath();
                stringBuilder.append(':').append(absolutePath);
                int previousIndex = listIterator.previousIndex();
                objArr[previousIndex] = absolutePath;
                objArr2[previousIndex] = file;
                objArr3[previousIndex] = new ZipFile(file);
                objArr4[previousIndex] = DexFile.loadDex(absolutePath, absolutePath + ".dex", 0);
            }
            b.set(classLoader, stringBuilder.toString());
            cc.m5964a((Object) classLoader, "mPaths", objArr);
            cc.m5964a((Object) classLoader, "mFiles", objArr2);
            cc.m5964a((Object) classLoader, "mZips", objArr3);
            cc.m5964a((Object) classLoader, "mDexs", objArr4);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m5968h(android.content.Context r6) {
        /*
        r4 = 20;
        r3 = 4;
        r0 = "MultiDex";
        r1 = "install";
        android.util.Log.i(r0, r1);
        r0 = Fo;
        if (r0 == 0) goto L_0x0016;
    L_0x000e:
        r0 = "MultiDex";
        r1 = "VM has multidex support, MultiDex support library is disabled.";
        android.util.Log.i(r0, r1);
    L_0x0015:
        return;
    L_0x0016:
        r0 = android.os.Build.VERSION.SDK_INT;
        if (r0 >= r3) goto L_0x0045;
    L_0x001a:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Multi dex installation failed. SDK ";
        r1 = r1.append(r2);
        r2 = android.os.Build.VERSION.SDK_INT;
        r1 = r1.append(r2);
        r2 = " is unsupported. Min SDK version is ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = ".";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0045:
        r0 = m5969i(r6);	 Catch:{ Exception -> 0x005d }
        if (r0 == 0) goto L_0x0015;
    L_0x004b:
        r1 = Fn;	 Catch:{ Exception -> 0x005d }
        monitor-enter(r1);	 Catch:{ Exception -> 0x005d }
        r2 = r0.sourceDir;	 Catch:{ all -> 0x005a }
        r3 = Fn;	 Catch:{ all -> 0x005a }
        r3 = r3.contains(r2);	 Catch:{ all -> 0x005a }
        if (r3 == 0) goto L_0x0088;
    L_0x0058:
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        r0 = move-exception;
        r1 = "MultiDex";
        r2 = "Multidex installation failure";
        android.util.Log.e(r1, r2, r0);
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Multi dex installation failed (";
        r2 = r2.append(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = ").";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0088:
        r3 = Fn;	 Catch:{ all -> 0x005a }
        r3.add(r2);	 Catch:{ all -> 0x005a }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        if (r2 <= r4) goto L_0x00d9;
    L_0x0091:
        r2 = "MultiDex";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r3.<init>();	 Catch:{ all -> 0x005a }
        r4 = "MultiDex is not guaranteed to work in SDK version ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x005a }
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = ": SDK version higher than ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = 20;
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = " should be backed by ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "runtime with built-in multidex capabilty but it's not the ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "case here: java.vm.version=\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "java.vm.version";
        r4 = java.lang.System.getProperty(r4);	 Catch:{ all -> 0x005a }
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r4 = "\"";
        r3 = r3.append(r4);	 Catch:{ all -> 0x005a }
        r3 = r3.toString();	 Catch:{ all -> 0x005a }
        android.util.Log.w(r2, r3);	 Catch:{ all -> 0x005a }
    L_0x00d9:
        r2 = r6.getClassLoader();	 Catch:{ RuntimeException -> 0x00e9 }
        if (r2 != 0) goto L_0x00f4;
    L_0x00df:
        r0 = "MultiDex";
        r2 = "Context class loader is null. Must be running in test mode. Skip patching.";
        android.util.Log.e(r0, r2);	 Catch:{ all -> 0x005a }
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00e9:
        r0 = move-exception;
        r2 = "MultiDex";
        r3 = "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.";
        android.util.Log.w(r2, r3, r0);	 Catch:{ all -> 0x005a }
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        goto L_0x0015;
    L_0x00f4:
        m5970j(r6);	 Catch:{ Throwable -> 0x0118 }
    L_0x00f7:
        r3 = new java.io.File;	 Catch:{ all -> 0x005a }
        r4 = r0.dataDir;	 Catch:{ all -> 0x005a }
        r5 = Fm;	 Catch:{ all -> 0x005a }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x005a }
        r4 = 0;
        r4 = com.fossil.ce.m6039a(r6, r0, r3, r4);	 Catch:{ all -> 0x005a }
        r5 = m5971k(r4);	 Catch:{ all -> 0x005a }
        if (r5 == 0) goto L_0x0121;
    L_0x010b:
        m5963a(r2, r3, r4);	 Catch:{ all -> 0x005a }
    L_0x010e:
        monitor-exit(r1);	 Catch:{ all -> 0x005a }
        r0 = "MultiDex";
        r1 = "install done";
        android.util.Log.i(r0, r1);
        goto L_0x0015;
    L_0x0118:
        r3 = move-exception;
        r4 = "MultiDex";
        r5 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning.";
        android.util.Log.w(r4, r5, r3);	 Catch:{ all -> 0x005a }
        goto L_0x00f7;
    L_0x0121:
        r4 = "MultiDex";
        r5 = "Files were not valid zip files.  Forcing a reload.";
        android.util.Log.w(r4, r5);	 Catch:{ all -> 0x005a }
        r4 = 1;
        r0 = com.fossil.ce.m6039a(r6, r0, r3, r4);	 Catch:{ all -> 0x005a }
        r4 = m5971k(r0);	 Catch:{ all -> 0x005a }
        if (r4 == 0) goto L_0x0137;
    L_0x0133:
        m5963a(r2, r3, r0);	 Catch:{ all -> 0x005a }
        goto L_0x010e;
    L_0x0137:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x005a }
        r2 = "Zip files were not valid.";
        r0.<init>(r2);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ all -> 0x005a }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.cc.h(android.content.Context):void");
    }

    private static ApplicationInfo m5969i(Context context) throws NameNotFoundException {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, Allocation.USAGE_SHARED);
        } catch (Throwable e) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e);
            return null;
        }
    }

    static boolean m5960S(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        Log.i("MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static void m5963a(ClassLoader classLoader, File file, List<File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
        if (!list.isEmpty()) {
            if (VERSION.SDK_INT >= 19) {
                C1991b.m5955a(classLoader, list, file);
            } else if (VERSION.SDK_INT >= 14) {
                C1990a.m5952a(classLoader, (List) list, file);
            } else {
                C1992c.m5958a(classLoader, list);
            }
        }
    }

    private static boolean m5971k(List<File> list) {
        for (File j : list) {
            if (!ce.m6050j(j)) {
                return false;
            }
        }
        return true;
    }

    private static Field m5961a(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method m5962a(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static void m5964a(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field a = m5961a(obj, str);
        Object[] objArr2 = (Object[]) a.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        a.set(obj, objArr3);
    }

    private static void m5970j(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (file2.delete()) {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                } else {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                }
            }
            if (file.delete()) {
                Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
            } else {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
            }
        }
    }
}
