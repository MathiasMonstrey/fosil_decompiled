package com.fossil;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class api<T> {
    private static final String aWB = api.class.getSimpleName();
    private final File baR;
    private final aqi<T> baS;

    public api(File file, String str, int i, aqk<T> com_fossil_aqk_T) {
        this.baR = file;
        this.baS = new aqg(new aqj(str, i, com_fossil_aqk_T));
    }

    public final T IV() {
        Closeable fileInputStream;
        Throwable e;
        Throwable th;
        T t = null;
        if (this.baR != null) {
            if (this.baR.exists()) {
                Object obj = null;
                try {
                    fileInputStream = new FileInputStream(this.baR);
                    try {
                        t = this.baS.mo1106j(fileInputStream);
                        aqv.m4252a(fileInputStream);
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            app.m4174b(3, aWB, "Error reading data file:" + this.baR.getName(), e);
                            obj = 1;
                            aqv.m4252a(fileInputStream);
                            if (obj != null) {
                                app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
                                this.baR.delete();
                            }
                            return t;
                        } catch (Throwable th2) {
                            th = th2;
                            aqv.m4252a(fileInputStream);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = t;
                    app.m4174b(3, aWB, "Error reading data file:" + this.baR.getName(), e);
                    obj = 1;
                    aqv.m4252a(fileInputStream);
                    if (obj != null) {
                        app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
                        this.baR.delete();
                    }
                    return t;
                } catch (Throwable e4) {
                    fileInputStream = t;
                    th = e4;
                    aqv.m4252a(fileInputStream);
                    throw th;
                }
                if (obj != null) {
                    app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
                    this.baR.delete();
                }
            } else {
                app.m4180g(5, aWB, "No data to read for file:" + this.baR.getName());
            }
        }
        return t;
    }

    public final void bJ(T t) {
        Throwable e;
        int i;
        Object obj = null;
        Closeable closeable = null;
        if (t == null) {
            app.m4180g(3, aWB, "No data to write for file:" + this.baR.getName());
            obj = 1;
        } else {
            try {
                if (aqu.m4247t(this.baR)) {
                    Closeable fileOutputStream = new FileOutputStream(this.baR);
                    try {
                        this.baS.mo1105a(fileOutputStream, t);
                        aqv.m4252a(fileOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        closeable = fileOutputStream;
                        try {
                            app.m4174b(3, aWB, "Error writing data file:" + this.baR.getName(), e);
                            aqv.m4252a(closeable);
                            i = 1;
                            if (obj == null) {
                                app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
                                this.baR.delete();
                            }
                        } catch (Throwable th) {
                            e = th;
                            aqv.m4252a(closeable);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        closeable = fileOutputStream;
                        aqv.m4252a(closeable);
                        throw e;
                    }
                }
                throw new IOException("Cannot create parent directory!");
            } catch (Exception e3) {
                e = e3;
                app.m4174b(3, aWB, "Error writing data file:" + this.baR.getName(), e);
                aqv.m4252a(closeable);
                i = 1;
                if (obj == null) {
                    app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
                    this.baR.delete();
                }
            }
        }
        if (obj == null) {
            app.m4180g(3, aWB, "Deleting data file:" + this.baR.getName());
            this.baR.delete();
        }
    }

    public final boolean Ie() {
        if (this.baR == null) {
            return false;
        }
        return this.baR.delete();
    }
}
