package com.portfolio.platform.helper;

import android.text.TextUtils;
import com.fossil.cnq;
import com.fossil.cnr;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.buttonservice.IButtonConnectivity;
import com.misfit.frameworks.buttonservice.enums.MFDeviceFamily;
import com.misfit.frameworks.buttonservice.model.MisfitDeviceProfile;
import com.misfit.frameworks.buttonservice.utils.DeviceIdentityUtils;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil;
import com.misfit.frameworks.buttonservice.utils.FossilDeviceSerialPatternUtil$DEVICE;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.MFDeviceModel;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.SKUModel;
import com.portfolio.platform.data.source.DeviceRepository;
import com.portfolio.platform.enums.FossilBrand;
import com.portfolio.platform.model.UAppSystemVersionModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeviceHelper {
    private static final String TAG = DeviceHelper.class.getSimpleName();
    private static float[] cya = null;
    public static final String[] cye = new String[]{MFDeviceModel.SAM, "HL.0.0", MFDeviceModel.MINI};
    private static DeviceHelper cyf;
    public static final MFDeviceFamily[] cyg = new MFDeviceFamily[]{MFDeviceFamily.DEVICE_FAMILY_SAM, MFDeviceFamily.DEVICE_FAMILY_SAM_SLIM, MFDeviceFamily.DEVICE_FAMILY_SAM_MINI, MFDeviceFamily.DEVICE_FAMILY_RMM};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyh = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.RMM, FossilDeviceSerialPatternUtil$DEVICE.Q_MOTION, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyi = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyj = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.RMM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI, FossilDeviceSerialPatternUtil$DEVICE.Q_MOTION, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyk = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.Q_MOTION, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyl = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI, FossilDeviceSerialPatternUtil$DEVICE.Q_MOTION};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cym = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyn = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.RMM, FossilDeviceSerialPatternUtil$DEVICE.Q_MOTION};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyo = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI};
    private static final FossilDeviceSerialPatternUtil$DEVICE[] cyp = new FossilDeviceSerialPatternUtil$DEVICE[]{FossilDeviceSerialPatternUtil$DEVICE.SAM, FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI};
    public cnr cmQ;
    private List<String> cyb;
    private List<String> cyc;
    private List<String> cyd;
    public DeviceRepository mDeviceRepository;

    static /* synthetic */ class C48941 {
        static final /* synthetic */ int[] cmY = new int[FossilBrand.values().length];

        static {
            f1639x76525c5a = new int[FossilDeviceSerialPatternUtil$DEVICE.values().length];
            try {
                f1639x76525c5a[FossilDeviceSerialPatternUtil$DEVICE.RMM.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f1639x76525c5a[FossilDeviceSerialPatternUtil$DEVICE.SAM.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f1639x76525c5a[FossilDeviceSerialPatternUtil$DEVICE.SAM_SLIM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f1639x76525c5a[FossilDeviceSerialPatternUtil$DEVICE.SAM_MINI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            cyq = new int[ImageStyle.values().length];
            try {
                cyq[ImageStyle.SMALL.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                cyq[ImageStyle.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                cyq[ImageStyle.LARGE.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                cyq[ImageStyle.WATCH_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                cyq[ImageStyle.WATCH_HOUR.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                cyq[ImageStyle.WATCH_MINUTE.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            try {
                cyq[ImageStyle.WATCH_SUBEYE.ordinal()] = 7;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    public enum ImageStyle {
        SMALL(0),
        NORMAL(1),
        LARGE(2),
        WATCH_HOUR(3),
        WATCH_MINUTE(4),
        WATCH_SUBEYE(5),
        WATCH_COMPLETED(6),
        HALF(7);
        
        private int value;

        private ImageStyle(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private DeviceHelper() {
        PortfolioApp.ZQ().aam().a(this);
        abI();
    }

    public static synchronized DeviceHelper abH() {
        DeviceHelper deviceHelper;
        synchronized (DeviceHelper.class) {
            if (cyf == null) {
                cyf = new DeviceHelper();
            }
            deviceHelper = cyf;
        }
        return deviceHelper;
    }

    public static MFDeviceFamily getDeviceFamily(String str) {
        return DeviceIdentityUtils.getDeviceFamily(str);
    }

    public void abI() {
        this.cyb = new ArrayList();
        this.cyc = new ArrayList();
        this.cyd = new ArrayList();
        if (!"release".equalsIgnoreCase("release") && (this.cmQ.acF() || PortfolioApp.ZQ().aag() == FossilBrand.PORTFOLIO)) {
            this.cyb.add(DeviceIdentityUtils.RAY_SERIAL_NUMBER_PREFIX);
            this.cyb.add(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
            this.cyb.addAll(Arrays.asList(DeviceIdentityUtils.Q_MOTION_PREFIX));
            this.cyb.add(DeviceIdentityUtils.RMM_SERIAL_NUMBER_PREFIX);
            this.cyb.add(DeviceIdentityUtils.FAKE_SAM_SERIAL_NUMBER_PREFIX);
            this.cyb.add(DeviceIdentityUtils.SAM_SERIAL_NUMBER_PREFIX);
            this.cyb.add(DeviceIdentityUtils.SAM_SLIM_SERIAL_NUMBER_PREFIX);
            this.cyc.add(DeviceIdentityUtils.FLASH_SERIAL_NUMBER_PREFIX);
            this.cyd.add(DeviceIdentityUtils.RAY_SERIAL_NUMBER_PREFIX);
            this.cyd.add(DeviceIdentityUtils.Q_MOTION_PREFIX[0]);
            this.cyd.add(DeviceIdentityUtils.Q_MOTION_PREFIX[1]);
            this.cyd.add(DeviceIdentityUtils.Q_MOTION_PREFIX[2]);
            this.cyd.add(DeviceIdentityUtils.Q_MOTION_PREFIX[3]);
        }
        int i = C48941.cmY[PortfolioApp.ZQ().aag().ordinal()];
        MFLogger.d(TAG, "debug=false, BUILD_TYPE=release, filterList=" + Arrays.toString(this.cyb.toArray()));
    }

    public boolean ga(String str) {
        if (!gf(str)) {
            return false;
        }
        if (this.mDeviceRepository.getSkuModelBySerial(str) != null) {
            return true;
        }
        return PortfolioApp.ZQ().aah().name().equals(FossilDeviceSerialPatternUtil.getBrandBySerial(str).name());
    }

    public MisfitDeviceProfile gb(String str) {
        Exception exception;
        IButtonConnectivity ZR = PortfolioApp.ZR();
        MisfitDeviceProfile misfitDeviceProfile = null;
        if (ZR == null) {
            return null;
        }
        try {
            MisfitDeviceProfile deviceProfile = ZR.getDeviceProfile(str);
            if (deviceProfile == null) {
                try {
                    DeviceModel hd = cnq.acd().acp().hd(str);
                    UAppSystemVersionModel uAppSystemVersionModel = cnq.acd().acp().getUAppSystemVersionModel(str);
                    if (hd != null) {
                        int minorVersion;
                        int majorVersion = uAppSystemVersionModel != null ? uAppSystemVersionModel.getMajorVersion() : 255;
                        if (uAppSystemVersionModel != null) {
                            minorVersion = uAppSystemVersionModel.getMinorVersion();
                        } else {
                            minorVersion = 255;
                        }
                        return new MisfitDeviceProfile(hd.getMacAddress(), hd.getProductDisplayName(), hd.getDeviceId(), hd.getSku(), hd.getFirmwareRevision(), hd.getBatteryLevel(), 0, 0, (short) majorVersion, (short) minorVersion);
                    }
                } catch (Exception e) {
                    exception = e;
                    misfitDeviceProfile = deviceProfile;
                    exception.printStackTrace();
                    return misfitDeviceProfile;
                }
            }
            return deviceProfile;
        } catch (Exception e2) {
            exception = e2;
            exception.printStackTrace();
            return misfitDeviceProfile;
        }
    }

    private static void abJ() {
        cya = new float[71];
        int i = 0;
        while (i <= 20) {
            cya[i] = (((float) i) * 0.005f) * 3.28f;
            i++;
        }
        while (i <= 35) {
            cya[i] = ((((float) (i - 20)) * 0.06f) + 0.1f) * 3.28f;
            i++;
        }
        while (i <= 50) {
            cya[i] = (1.0f + (((float) (i - 35)) * 0.06666667f)) * 3.28f;
            i++;
        }
        while (i <= 60) {
            cya[i] = (2.0f + (((float) (i - 50)) * 0.1f)) * 3.28f;
            i++;
        }
        while (i <= 63) {
            cya[i] = (3.0f + (((float) (i - 60)) * 0.33333334f)) * 3.28f;
            i++;
        }
        while (i <= 70) {
            cya[i] = (4.0f + (((float) (i - 60)) * 0.14285715f)) * 3.28f;
            i++;
        }
    }

    public static float jz(int i) {
        if (cya == null) {
            abJ();
        }
        int i2 = (-i) - 30;
        if (i2 >= 0 && i2 < cya.length) {
            return cya[i2];
        }
        if (i2 < 0) {
            return 0.0f;
        }
        return 16.4f;
    }

    private static boolean m15620a(String str, FossilDeviceSerialPatternUtil$DEVICE[] fossilDeviceSerialPatternUtil$DEVICEArr) {
        FossilDeviceSerialPatternUtil$DEVICE deviceBySerial = FossilDeviceSerialPatternUtil.getDeviceBySerial(str);
        for (FossilDeviceSerialPatternUtil$DEVICE fossilDeviceSerialPatternUtil$DEVICE : fossilDeviceSerialPatternUtil$DEVICEArr) {
            if (fossilDeviceSerialPatternUtil$DEVICE == deviceBySerial) {
                return true;
            }
        }
        return false;
    }

    public static boolean gc(String str) {
        return m15620a(str, cyk);
    }

    public boolean gd(String str) {
        return m15620a(str, cyl);
    }

    public static boolean ge(String str) {
        return m15620a(str, cyn);
    }

    public static boolean gf(String str) {
        return m15620a(str, cyo);
    }

    public static String gg(String str) {
        if (TextUtils.isEmpty(str)) {
            return "UNKNOWN";
        }
        if (DeviceIdentityUtils.isShine2(str)) {
            return "SHINE 2";
        }
        if (DeviceIdentityUtils.isFlash(str) || DeviceIdentityUtils.isFlashButton(str)) {
            return "FLASH";
        }
        if (DeviceIdentityUtils.isRay(str)) {
            return "RAY";
        }
        if (DeviceIdentityUtils.isQMotion(str)) {
            return "Q Motion";
        }
        return gh(str);
    }

    public static int m15619a(String str, ImageStyle imageStyle) {
        return m15621b(str, imageStyle);
    }

    public static int m15621b(String str, ImageStyle imageStyle) {
        if (!gf(str)) {
            return R.drawable.silhouette_watch_large;
        }
        switch (imageStyle) {
            case SMALL:
                return R.drawable.silhouette_watch_small;
            case NORMAL:
                return R.drawable.silhouette_watch_medium;
            case WATCH_HOUR:
                return R.drawable.generic_calibration_hour;
            case WATCH_MINUTE:
                return R.drawable.generic_calibration_minute;
            case WATCH_SUBEYE:
                return R.drawable.generic_calibration_subeye;
            default:
                return R.drawable.silhouette_watch_large;
        }
    }

    public static String gh(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            return "UNKNOWN";
        }
        SKUModel hl = cnq.acd().acp().hl(gi(str));
        if (hl == null) {
            return "Hybrid Smartwatch";
        }
        return hl.getDeviceName();
    }

    public static String gi(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 5) {
            return "";
        }
        if (FossilDeviceSerialPatternUtil.isQMotion(str)) {
            return str.substring(0, 5);
        }
        return str.substring(0, 6);
    }

    public static String gj(String str) {
        switch (FossilDeviceSerialPatternUtil$DEVICE.fromPrefix(str.toUpperCase().charAt(0))) {
            case RMM:
                return "CR1632";
            case SAM:
                return "CR2430";
            case SAM_SLIM:
                return "CR2412";
            case SAM_MINI:
                return "CR2025";
            default:
                return "UNKNOWN";
        }
    }

    public static boolean gk(String str) {
        return m15620a(str, cyp);
    }
}
