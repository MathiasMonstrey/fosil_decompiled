package com.fossil;

import com.fossil.ckb.C2131a;
import com.fossil.ckb.C2132b;
import com.fossil.ckb.C2133c;
import com.fossil.wearables.fossil.R;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.MFDeviceModel;
import com.portfolio.platform.data.model.DeviceModel;
import com.portfolio.platform.data.model.Firmware;
import com.portfolio.platform.data.source.DataVersioningRepository;
import com.portfolio.platform.data.source.DeviceRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class czc extends ckb<C2562b, C2564d, C2563c> {
    private static final String TAG = czc.class.getSimpleName();
    private DataVersioningRepository cFG;
    private DeviceRepository mDeviceRepository;
    private cnr mSharedPreferencesManager;

    public static final class C2561a {
        public static Firmware m7960if(String str) {
            if (MFDeviceModel.SAM.equalsIgnoreCase(str)) {
                return new Firmware("HW0.0.1.0r.v2_autotest_v5", true, R.raw.sam_ota_hw0_0_1_0r_v2_autotest_v5);
            }
            return null;
        }

        public static List<Firmware> akg() {
            List<Firmware> arrayList = new ArrayList();
            arrayList.add(new Firmware("HW0.0.1.0r.v2_autotest_v5", true, R.raw.sam_ota_hw0_0_1_0r_v2_autotest_v5));
            return arrayList;
        }
    }

    public static final class C2562b implements C2132b {
        private final String cFB;

        public C2562b(String str) {
            this.cFB = str;
        }

        public String getDeviceSerial() {
            return this.cFB;
        }
    }

    public static final class C2563c implements C2131a {
    }

    public static final class C2564d implements C2133c {
    }

    protected /* synthetic */ void mo2022b(C2132b c2132b) {
        m7962a((C2562b) c2132b);
    }

    public czc(DeviceRepository deviceRepository, cnr com_fossil_cnr, DataVersioningRepository dataVersioningRepository) {
        this.mDeviceRepository = deviceRepository;
        this.mSharedPreferencesManager = com_fossil_cnr;
        this.cFG = dataVersioningRepository;
    }

    protected void m7962a(C2562b c2562b) {
        DeviceModel deviceBySerial = this.mDeviceRepository.getDeviceBySerial(c2562b.getDeviceSerial(), null);
        if (deviceBySerial == null) {
            MFLogger.m12671e(TAG, "Error when update firmware, can't find latest device on db serial=" + c2562b.getDeviceSerial());
            return;
        }
        Firmware hr;
        if ("release".equalsIgnoreCase("release") || !this.mSharedPreferencesManager.acE()) {
            hr = cnq.acd().act().hr(deviceBySerial.getSku());
            if (hr == null) {
                MFLogger.m12671e(TAG, "Error when update firmware, can't find latest fw of model=" + deviceBySerial.getSku());
                this.cFG.removeDataVersion("firmwares");
                return;
            }
        }
        hr = C2561a.m7960if(deviceBySerial.getSku());
        if (hr == null) {
            hr = cnq.acd().act().hr(deviceBySerial.getSku());
            if (hr == null) {
                MFLogger.m12671e(TAG, "Error when update firmware, can't find latest fw of model=" + deviceBySerial.getSku());
                return;
            }
        }
        Firmware firmware = hr;
        byte[] c = m7961c(firmware);
        if (c == null) {
            abr().onError(new C2563c());
            return;
        }
        this.mSharedPreferencesManager.av(deviceBySerial.getDeviceId(), deviceBySerial.getFirmwareRevision());
        MFLogger.m12670d(TAG, "Start update firmware with version=" + firmware.getVersionNumber() + ", currentVersion=" + deviceBySerial.getFirmwareRevision());
        PortfolioApp.ZQ().m12693a(c2562b.getDeviceSerial(), c, firmware.isEmbedded(), firmware.getChecksum(), firmware.getVersionNumber(), PortfolioApp.ZQ().aad());
    }

    private byte[] m7961c(Firmware firmware) {
        byte[] bArr;
        Object e;
        byte[] bArr2 = null;
        Firmware firmware2 = (Firmware) cco.ce(firmware);
        String versionNumber = firmware2.getVersionNumber();
        if (versionNumber == null) {
            return bArr2;
        }
        if (firmware2.isEmbedded()) {
            try {
                return etz.m11205z(PortfolioApp.ZQ().getResources().openRawResource(firmware2.getResourceId()));
            } catch (Exception e2) {
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e2);
                return bArr2;
            }
        }
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(PortfolioApp.ZQ().getFilesDir() + "/" + ety.getName(versionNumber));
        } catch (FileNotFoundException e3) {
            MFLogger.m12670d(TAG, "Firmware not found, wait for downloading");
            fileInputStream = bArr2;
        } catch (Exception e22) {
            MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e22);
            fileInputStream = bArr2;
        }
        if (fileInputStream != null) {
            try {
                int size = (int) fileInputStream.getChannel().size();
                bArr = new byte[size];
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != size) {
                        MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - expectedSize=" + size + ", readSize=" + read);
                    }
                    fileInputStream.close();
                } catch (Exception e4) {
                    e = e4;
                    MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e);
                    return bArr;
                }
            } catch (Exception e222) {
                Exception exception = e222;
                bArr = bArr2;
                e = exception;
                MFLogger.m12671e(TAG, "Error inside " + TAG + ".getOtaData - e=" + e);
                return bArr;
            }
        }
        bArr = bArr2;
        return bArr;
    }
}
