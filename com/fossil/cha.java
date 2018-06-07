package com.fossil;

import com.fossil.chf.C2066b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

class cha {
    private static final Logger bUq = Logger.getLogger(cha.class.getName());
    private static final Map<Integer, C2066b> bUr = Collections.synchronizedMap(new HashMap());
    private static final Map<String, C2066b> bUs = Collections.synchronizedMap(new HashMap());
    private static final Set<Integer> bUt = cgx.Xv();
    private static final Set<String> bUu = che.Xy();

    private cha() {
    }

    static chg m6401a(ObjectInputStream objectInputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i];
        while (true) {
            int read = objectInputStream.read(bArr, 0, i);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return chg.ao(byteArrayOutputStream.toByteArray());
            }
        }
    }
}
