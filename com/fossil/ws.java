package com.fossil;

import android.util.Log;
import java.io.InputStream;
import java.io.OutputStream;

public class ws implements uk<InputStream> {
    public boolean m14008a(InputStream inputStream, OutputStream outputStream) {
        byte[] bytes = abe.wT().getBytes();
        while (true) {
            try {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    outputStream.write(bytes, 0, read);
                } else {
                    abe.wT().L(bytes);
                    return true;
                }
            } catch (Throwable e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                abe.wT().L(bytes);
                return false;
            } catch (Throwable th) {
                abe.wT().L(bytes);
            }
        }
    }

    public String getId() {
        return "";
    }
}
