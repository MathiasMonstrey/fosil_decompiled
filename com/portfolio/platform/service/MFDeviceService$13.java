package com.portfolio.platform.service;

import com.portfolio.platform.data.source.interfaces.ShortcutDownloadingObserver;

class MFDeviceService$13 implements ShortcutDownloadingObserver {
    final /* synthetic */ MFDeviceService cDk;

    MFDeviceService$13(MFDeviceService mFDeviceService) {
        this.cDk = mFDeviceService;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onStatusChanged(java.lang.String r7, java.lang.String r8) {
        /*
        r6 = this;
        r2 = 1;
        r0 = 0;
        r1 = -1;
        r3 = com.portfolio.platform.service.MFDeviceService.access$500();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "onStatusChanged status=";
        r4 = r4.append(r5);
        r4 = r4.append(r7);
        r4 = r4.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r3, r4);
        r3 = "INIT_STATUS";
        r3 = r7.equals(r3);
        if (r3 == 0) goto L_0x002b;
    L_0x0025:
        r0 = r6.cDk;
        com.portfolio.platform.service.MFDeviceService.b(r0, r7);
    L_0x002a:
        return;
    L_0x002b:
        r3 = r6.cDk;
        r3 = com.portfolio.platform.service.MFDeviceService.f(r3);
        if (r3 != 0) goto L_0x00c1;
    L_0x0033:
        r0 = r6.cDk;
        com.portfolio.platform.service.MFDeviceService.b(r0, r7);
    L_0x0038:
        r0 = r6.cDk;
        r0 = r0.cmQ;
        r1 = r6.cDk;
        r1 = com.portfolio.platform.service.MFDeviceService.f(r1);
        r0.gD(r1);
        r0 = com.portfolio.platform.service.MFDeviceService.access$500();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "onStatusChanged mDownloadingStatus=";
        r1 = r1.append(r2);
        r2 = r6.cDk;
        r2 = com.portfolio.platform.service.MFDeviceService.f(r2);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r0, r1);
        r0 = r6.cDk;
        r0 = com.portfolio.platform.service.MFDeviceService.f(r0);
        r1 = "DOWNLOADS_COMPLETED";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x002a;
    L_0x0073:
        r0 = com.portfolio.platform.PortfolioApp.ZQ();
        r0 = r0.aaa();
        r1 = com.portfolio.platform.service.MFDeviceService.access$500();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "setMicroAppMappingInBackground serial=";
        r2 = r2.append(r3);
        r2 = r2.append(r8);
        r3 = " activeSerial=";
        r2 = r2.append(r3);
        r2 = r2.append(r0);
        r2 = r2.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r1, r2);
        r1 = r0.equals(r8);
        if (r1 == 0) goto L_0x002a;
    L_0x00a5:
        r1 = com.portfolio.platform.service.MFDeviceService.access$500();
        r2 = "set micro app mapping to device";
        com.misfit.frameworks.common.log.MFLogger.d(r1, r2);
        r1 = new com.fossil.cth$a;
        r1.<init>(r0);
        r0 = r6.cDk;
        r0 = r0.czo;
        r2 = r6.cDk;
        r2 = r2.cCO;
        r3 = 0;
        r0.a(r2, r1, r3);
        goto L_0x002a;
    L_0x00c1:
        r3 = com.portfolio.platform.service.MFDeviceService.access$500();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "onStatusChanged check mDownloadingStatus=";
        r4 = r4.append(r5);
        r5 = r6.cDk;
        r5 = com.portfolio.platform.service.MFDeviceService.f(r5);
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.misfit.frameworks.common.log.MFLogger.d(r3, r4);
        r3 = r6.cDk;
        r3 = com.portfolio.platform.service.MFDeviceService.f(r3);
        r4 = r3.hashCode();
        switch(r4) {
            case -2117910956: goto L_0x012d;
            case -1453582409: goto L_0x0105;
            case -1230725971: goto L_0x0119;
            case -662619185: goto L_0x010f;
            case -468356210: goto L_0x0123;
            case 1959694849: goto L_0x00fb;
            default: goto L_0x00ee;
        };
    L_0x00ee:
        r3 = r1;
    L_0x00ef:
        switch(r3) {
            case 0: goto L_0x00f4;
            case 1: goto L_0x0137;
            case 2: goto L_0x0169;
            case 3: goto L_0x0169;
            case 4: goto L_0x0170;
            case 5: goto L_0x0181;
            default: goto L_0x00f2;
        };
    L_0x00f2:
        goto L_0x0038;
    L_0x00f4:
        r0 = r6.cDk;
        com.portfolio.platform.service.MFDeviceService.b(r0, r7);
        goto L_0x0038;
    L_0x00fb:
        r4 = "INIT_STATUS";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x0103:
        r3 = r0;
        goto L_0x00ef;
    L_0x0105:
        r4 = "DOWNLOADS_COMPLETED";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x010d:
        r3 = r2;
        goto L_0x00ef;
    L_0x010f:
        r4 = "PRESETS_DOWNLOADING";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x0117:
        r3 = 2;
        goto L_0x00ef;
    L_0x0119:
        r4 = "DECLARATION_FILES_DOWNLOADING";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x0121:
        r3 = 3;
        goto L_0x00ef;
    L_0x0123:
        r4 = "ACTIVE_PRESET_DOWNLOADED";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x012b:
        r3 = 4;
        goto L_0x00ef;
    L_0x012d:
        r4 = "DECLARATION_FILES_DOWNLOADED";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x00ee;
    L_0x0135:
        r3 = 5;
        goto L_0x00ef;
    L_0x0137:
        r3 = r7.hashCode();
        switch(r3) {
            case -1230725971: goto L_0x0156;
            case -662619185: goto L_0x014d;
            default: goto L_0x013e;
        };
    L_0x013e:
        r0 = r1;
    L_0x013f:
        switch(r0) {
            case 0: goto L_0x0144;
            case 1: goto L_0x0160;
            default: goto L_0x0142;
        };
    L_0x0142:
        goto L_0x002a;
    L_0x0144:
        r0 = r6.cDk;
        r1 = "DECLARATION_FILES_DOWNLOADED";
        com.portfolio.platform.service.MFDeviceService.b(r0, r1);
        goto L_0x002a;
    L_0x014d:
        r2 = "PRESETS_DOWNLOADING";
        r2 = r7.equals(r2);
        if (r2 == 0) goto L_0x013e;
    L_0x0155:
        goto L_0x013f;
    L_0x0156:
        r0 = "DECLARATION_FILES_DOWNLOADING";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x013e;
    L_0x015e:
        r0 = r2;
        goto L_0x013f;
    L_0x0160:
        r0 = r6.cDk;
        r1 = "ACTIVE_PRESET_DOWNLOADED";
        com.portfolio.platform.service.MFDeviceService.b(r0, r1);
        goto L_0x002a;
    L_0x0169:
        r0 = r6.cDk;
        com.portfolio.platform.service.MFDeviceService.b(r0, r7);
        goto L_0x0038;
    L_0x0170:
        r0 = "DECLARATION_FILES_DOWNLOADED";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0038;
    L_0x0178:
        r0 = r6.cDk;
        r1 = "DOWNLOADS_COMPLETED";
        com.portfolio.platform.service.MFDeviceService.b(r0, r1);
        goto L_0x0038;
    L_0x0181:
        r0 = "ACTIVE_PRESET_DOWNLOADED";
        r0 = r7.equals(r0);
        if (r0 == 0) goto L_0x0038;
    L_0x0189:
        r0 = r6.cDk;
        r1 = "DOWNLOADS_COMPLETED";
        com.portfolio.platform.service.MFDeviceService.b(r0, r1);
        goto L_0x0038;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.portfolio.platform.service.MFDeviceService$13.onStatusChanged(java.lang.String, java.lang.String):void");
    }
}
