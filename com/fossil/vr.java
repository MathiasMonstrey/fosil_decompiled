package com.fossil;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
public class vr implements vp {
    private static final Config[] aCC = new Config[]{Config.ARGB_8888, null};
    private static final Config[] aCD = new Config[]{Config.RGB_565};
    private static final Config[] aCE = new Config[]{Config.ARGB_4444};
    private static final Config[] aCF = new Config[]{Config.ALPHA_8};
    private final C4166b aCG = new C4166b();
    private final Map<Config, NavigableMap<Integer, Integer>> aCH = new HashMap();
    private final vn<C4165a, Bitmap> aCl = new vn();

    static /* synthetic */ class C41641 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Config.values().length];

        static {
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static final class C4165a implements vq {
        private final C4166b aCI;
        private Config aCn;
        private int size;

        public C4165a(C4166b c4166b) {
            this.aCI = c4166b;
        }

        public void m13942c(int i, Config config) {
            this.size = i;
            this.aCn = config;
        }

        public void va() {
            this.aCI.m13906a(this);
        }

        public String toString() {
            return vr.m13945a(this.size, this.aCn);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C4165a)) {
                return false;
            }
            C4165a c4165a = (C4165a) obj;
            if (this.size != c4165a.size) {
                return false;
            }
            if (this.aCn == null) {
                if (c4165a.aCn != null) {
                    return false;
                }
            } else if (!this.aCn.equals(c4165a.aCn)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.aCn != null ? this.aCn.hashCode() : 0) + (this.size * 31);
        }
    }

    static class C4166b extends vk<C4165a> {
        C4166b() {
        }

        protected /* synthetic */ vq vc() {
            return vi();
        }

        public C4165a m13943d(int i, Config config) {
            C4165a c4165a = (C4165a) vd();
            c4165a.m13942c(i, config);
            return c4165a;
        }

        protected C4165a vi() {
            return new C4165a(this);
        }
    }

    public void mo4210f(Bitmap bitmap) {
        C4165a d = this.aCG.m13943d(abl.p(bitmap), bitmap.getConfig());
        this.aCl.m13932a(d, bitmap);
        NavigableMap a = m13946a(bitmap.getConfig());
        Integer num = (Integer) a.get(Integer.valueOf(d.size));
        a.put(Integer.valueOf(d.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    public Bitmap mo4208b(int i, int i2, Config config) {
        int i3 = abl.i(i, i2, config);
        Bitmap bitmap = (Bitmap) this.aCl.m13933b(m13944a(this.aCG.m13943d(i3, config), i3, config));
        if (bitmap != null) {
            m13947a(Integer.valueOf(abl.p(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    private C4165a m13944a(C4165a c4165a, int i, Config config) {
        Config[] b = m13949b(config);
        int length = b.length;
        int i2 = 0;
        while (i2 < length) {
            Config config2 = b[i2];
            Integer num = (Integer) m13946a(config2).ceilingKey(Integer.valueOf(i));
            if (num == null || num.intValue() > i * 8) {
                i2++;
            } else {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return c4165a;
                        }
                    } else if (config2.equals(config)) {
                        return c4165a;
                    }
                }
                this.aCG.m13906a(c4165a);
                return this.aCG.m13943d(num.intValue(), config2);
            }
        }
        return c4165a;
    }

    public Bitmap uZ() {
        Bitmap bitmap = (Bitmap) this.aCl.removeLast();
        if (bitmap != null) {
            m13947a(Integer.valueOf(abl.p(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    private void m13947a(Integer num, Config config) {
        NavigableMap a = m13946a(config);
        Integer num2 = (Integer) a.get(num);
        if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> m13946a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.aCH.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.aCH.put(config, treeMap);
        return treeMap;
    }

    public String mo4211g(Bitmap bitmap) {
        return m13945a(abl.p(bitmap), bitmap.getConfig());
    }

    public String mo4209c(int i, int i2, Config config) {
        return m13945a(abl.i(i, i2, config), config);
    }

    public int mo4212h(Bitmap bitmap) {
        return abl.p(bitmap);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.aCl).append(", sortedSizes=(");
        for (Entry entry : this.aCH.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.aCH.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        return append.append(")}").toString();
    }

    private static String m13945a(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Config[] m13949b(Config config) {
        switch (C41641.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
            case 1:
                return aCC;
            case 2:
                return aCD;
            case 3:
                return aCE;
            case 4:
                return aCF;
            default:
                return new Config[]{config};
        }
    }
}
