package com.fossil;

import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.portfolio.platform.downloader.FileDownloader.DownloadEvent;

public final class clx {

    public static abstract class C2162d {
        protected final String TAG = getClass().getCanonicalName();
    }

    public static class C2163a extends C2162d {
        private boolean cwY;
        private String serial;

        public C2163a(String str, boolean z) {
            this.cwY = z;
            this.serial = str;
        }
    }

    public static class C2164b extends C2162d {
        private boolean cwY;
        private String uri;

        public String getUri() {
            return this.uri;
        }

        public boolean Kb() {
            return this.cwY;
        }

        public C2164b(boolean z, String str) {
            this.cwY = z;
            this.uri = str;
        }
    }

    public static class C2165c extends C2162d {
        private boolean cwZ;
        private int hour;
        private boolean isRepeat;
        private int minute;
        private String serial;

        public C2165c(String str, int i, int i2, boolean z, boolean z2) {
            this.isRepeat = z;
            this.serial = str;
            this.hour = i;
            this.minute = i2;
            this.cwZ = z2;
        }
    }

    public static class C2166e extends C2162d {
    }

    public static class C2167f extends C2162d {
    }

    public static class C2168g extends C2162d {
        private boolean cwY;
        private String serial;

        public C2168g(String str, boolean z) {
            this.serial = str;
            this.cwY = z;
        }

        public String getSerial() {
            return this.serial;
        }

        public boolean Kb() {
            return this.cwY;
        }
    }

    public static class C2169h extends C2162d {
        private boolean cwY;

        public C2169h(boolean z) {
            this.cwY = z;
        }
    }

    public static class C2170i extends C2162d {
        private boolean cwY;

        public C2170i(boolean z) {
            this.cwY = z;
        }
    }

    public static class C2171j extends C2162d {
        private boolean cwY;
        private String serial;

        public C2171j(String str, boolean z) {
            this.cwY = z;
            this.serial = str;
        }
    }

    public static class C2172k extends C2162d {
        private boolean cwY;
        private String serial;

        public C2172k(String str, boolean z) {
            this.serial = str;
            this.cwY = z;
        }
    }

    public static class C2173l extends C2162d {
        private boolean cwY;
        private DownloadEvent cwx;

        public C2173l(boolean z, DownloadEvent downloadEvent) {
            this.cwY = z;
            this.cwx = downloadEvent;
        }
    }

    public static class C2174m extends C2162d {
        private boolean cwY;
        private int offset;
        private String serial;

        public C2174m(String str, boolean z, int i) {
            this.cwY = z;
            this.serial = str;
            this.offset = i;
        }
    }

    public static class C2175n extends C2162d {
        private boolean cwY;
        private int cxa;
        private String serial;

        public C2175n(String str, boolean z, int i) {
            this.cwY = z;
            this.serial = str;
            this.cxa = i;
        }
    }

    public static class C2176o extends C2162d {
        private int cxb;
        private int cxc;
        private int cxd;
        private String mSerial;

        public String getSerial() {
            return this.mSerial;
        }

        public int abw() {
            return this.cxb;
        }

        public C2176o(String str, int i, int i2, int i3) {
            this.cxc = i;
            this.cxd = i2;
            this.cxb = i3;
            this.mSerial = str;
        }
    }

    public static class C2177p extends C2162d {
        private int cxb;
        private int cxc;
        private int cxd;
        private String mSerial;

        public String getSerial() {
            return this.mSerial;
        }

        public int abw() {
            return this.cxb;
        }

        public C2177p(String str, int i, int i2, int i3) {
            this.cxc = i;
            this.cxd = i2;
            this.cxb = i3;
            this.mSerial = str;
        }
    }

    public static abstract class C2178u extends C2162d {
        protected String serial;

        public C2178u(String str) {
            this.serial = str;
        }
    }

    public static class C2179q extends C2178u {
        public C2179q(String str) {
            super(str);
        }
    }

    public static class C2180r extends C2178u {
        private MisfitDeviceProfile cxe;

        public C2180r(MisfitDeviceProfile misfitDeviceProfile) {
            super(misfitDeviceProfile.getDeviceSerial());
            this.cxe = misfitDeviceProfile;
        }
    }

    public static class C2181s extends C2178u {
        private int cxf;

        public C2181s(String str, int i) {
            super(str);
            this.cxf = i;
        }
    }

    public static class C2182t extends C2178u {
        private boolean cwY;

        public C2182t(String str, boolean z) {
            super(str);
            this.cwY = z;
        }
    }

    public static class C2183v extends C2178u {
        private int level;

        public C2183v(String str, int i) {
            super(str);
            this.level = i;
        }
    }

    public static class C2184w extends C2178u {
        public C2184w(String str) {
            super(str);
        }
    }

    public static class C2185x extends C2162d {
        private boolean cwY;
        private String serial;

        public C2185x(String str, boolean z) {
            this.cwY = z;
            this.serial = str;
        }
    }

    public static class C2186y extends C2162d {
        private boolean cwY;
        private String serial;

        public C2186y(String str, boolean z) {
            this.cwY = z;
            this.serial = str;
        }
    }

    public static class C2187z extends C2162d {
        private int event;
        private String serial;

        public String getSerial() {
            return this.serial;
        }

        public int abw() {
            return this.event;
        }

        public C2187z(String str, int i) {
            this.event = i;
            this.serial = str;
        }
    }
}
