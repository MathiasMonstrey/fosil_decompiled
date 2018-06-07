package com.misfit.ble.shine.firmware;

public class CustomFirmware extends Firmware {
    public CustomFirmware(String str, String str2, byte[] bArr) {
        this.jk = str;
        this.fa = str2;
        this.jp = bArr;
    }

    public byte[] getFirmwareData() {
        return this.jp;
    }
}
