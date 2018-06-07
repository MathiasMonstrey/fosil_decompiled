package com.fossil;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

final class cf {

    static class C2023a {
        long Fr;
        long Fs;

        C2023a() {
        }
    }

    static long m6131h(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            long a = m6129a(randomAccessFile, m6130a(randomAccessFile));
            return a;
        } finally {
            randomAccessFile.close();
        }
    }

    static C2023a m6130a(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long j = 0;
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j2 = length - 65536;
        if (j2 >= 0) {
            j = j2;
        }
        int reverseBytes = Integer.reverseBytes(101010256);
        j2 = length;
        do {
            randomAccessFile.seek(j2);
            if (randomAccessFile.readInt() == reverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                C2023a c2023a = new C2023a();
                c2023a.Fs = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                c2023a.Fr = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & 4294967295L;
                return c2023a;
            }
            j2--;
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }

    static long m6129a(RandomAccessFile randomAccessFile, C2023a c2023a) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = c2023a.Fs;
        randomAccessFile.seek(c2023a.Fr);
        byte[] bArr = new byte[16384];
        int read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        while (read != -1) {
            crc32.update(bArr, 0, read);
            j -= (long) read;
            if (j == 0) {
                break;
            }
            read = randomAccessFile.read(bArr, 0, (int) Math.min(16384, j));
        }
        return crc32.getValue();
    }
}
