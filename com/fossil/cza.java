package com.fossil;

import com.fossil.ckb.C2126d;
import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.MFDeviceModel;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.data.source.DeviceRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class cza extends ckb<C2559b, Object, C2560c> {
    private static final String TAG = czc.class.getSimpleName();
    private DeviceRepository mDeviceRepository;
    private cnr mSharedPreferencesManager;

    public static final class C2558a {
        public static Firmware m7956if(String str) {
            boolean z = true;
            switch (str.hashCode()) {
                case -1951128539:
                    if (str.equals("HW0.0.0.15r.v2")) {
                        z = false;
                        break;
                    }
                    break;
                case -854215618:
                    if (str.equals("HW0.0.1.0r.v2_autotest_v5")) {
                        z = true;
                        break;
                    }
                    break;
                case -733438869:
                    if (str.equals("HW0.0.0.14r.prod.v3_disable_hibernation")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    return new Firmware("HW0.0.0.15r.v2", MFDeviceModel.SAM, true, R.raw.sam_ota_20170808_hw0_0_0_15r_v2_crc_encr);
                case true:
                    return new Firmware("HW0.0.1.0r.v2_autotest_v5", MFDeviceModel.SAM, true, R.raw.sam_ota_hw0_0_1_0r_v2_autotest_v5);
                case true:
                    return new Firmware("HW0.0.0.14r.prod.v3_disable_hibernation", MFDeviceModel.SAM, true, R.raw.sam_ota_hw0_0_0_14r_prod_v3_disable_hibernation);
                default:
                    return new Firmware("HW0.0.1.0r.v2_autotest_v5", MFDeviceModel.SAM, true, R.raw.sam_ota_hw0_0_1_0r_v2_autotest_v5);
            }
        }
    }

    public static final class C2559b implements C2132b {
        private final String cFB;
        private final Firmware cLN;

        public C2559b(String str, Firmware firmware) {
            this.cFB = (String) cco.ce(str);
            this.cLN = (Firmware) cco.ce(firmware);
        }

        public String getDeviceSerial() {
            return this.cFB;
        }

        public Firmware ake() {
            return this.cLN;
        }
    }

    public static final class C2560c implements C2131a {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7958a((C2559b) c2132b);
    }

    public cza(DeviceRepository deviceRepository, cnr com_fossil_cnr) {
        this.mDeviceRepository = (DeviceRepository) cco.ce(deviceRepository);
        this.mSharedPreferencesManager = (cnr) cco.ce(com_fossil_cnr);
    }

    protected void m7958a(C2559b c2559b) {
        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(PortfolioApp.ZQ().aaa(), null);
        if (deviceBySerial == null) {
            MFLogger.m12671e(TAG, "Error when update firmware, no device exists in DB with serial=" + c2559b.getDeviceSerial());
            return;
        }
        Firmware ake = c2559b.ake();
        if (MFDeviceModel.isSame(ake.getDeviceModel(), deviceBySerial.getSku())) {
            byte[] c = m7957c(ake);
            if (c == null) {
                C2126d abr = abr();
                if (abr != null) {
                    abr.onError(new C2560c());
                    return;
                }
                return;
            }
            this.mSharedPreferencesManager.av(deviceBySerial.getDeviceId(), deviceBySerial.getFirmwareRevision());
            MFLogger.m12670d(TAG, "Start update firmware with version=" + ake.getVersionNumber() + ", currentVersion=" + deviceBySerial.getFirmwareRevision());
            PortfolioApp.ZQ().m12693a(c2559b.getDeviceSerial(), c, ake.isEmbedded(), ake.getChecksum(), ake.getVersionNumber(), PortfolioApp.ZQ().aad());
            return;
        }
        MFLogger.m12671e(TAG, "Firmware is not comparable with device model. Cannot OTA.");
    }

    private byte[] m7957c(Firmware firmware) {
        Object e;
        byte[] bArr = null;
        Firmware firmware2 = (Firmware) cco.ce(firmware);
        String versionNumber = firmware2.getVersionNumber();
        if (versionNumber == null) {
            return bArr;
        }
        if (firmware2.isEmbedded()) {
            try {
                return etz.m11205z(PortfolioApp.ZQ().getResources().openRawResource(firmware2.getResourceId()));
            } catch (Exception e2) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e2);
                return bArr;
            }
        }
        FileInputStream fileInputStream;
        byte[] bArr2;
        try {
            fileInputStream = new FileInputStream(PortfolioApp.ZQ().getFilesDir() + "/" + ety.getName(versionNumber));
        } catch (FileNotFoundException e3) {
            MFLogger.m12670d(TAG, "Firmware not found, wait for downloading");
            fileInputStream = bArr;
        } catch (Exception e22) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e22);
            fileInputStream = bArr;
        }
        if (fileInputStream != null) {
            try {
                int size = (int) fileInputStream.getChannel().size();
                bArr2 = new byte[size];
                try {
                    int read = fileInputStream.read(bArr2);
                    if (read != size) {
                        MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - expectedSize=" + size + ", readSize=" + read);
                    }
                    fileInputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e);
                    return bArr2;
                }
            } catch (Exception e222) {
                Exception exception = e222;
                bArr2 = bArr;
                e = exception;
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e);
                return bArr2;
            }
        }
        bArr2 = bArr;
        return bArr2;
    }
}
