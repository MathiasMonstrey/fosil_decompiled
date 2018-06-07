package com.fossil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class wb {
    private final abi<ul, String> aCZ = new abi(1000);

    wb() {
    }

    public String m13979k(ul ulVar) {
        String str;
        synchronized (this.aCZ) {
            str = (String) this.aCZ.get(ulVar);
        }
        if (str == null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                ulVar.mo4200a(instance);
                str = abl.M(instance.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.aCZ) {
                this.aCZ.put(ulVar, str);
            }
        }
        return str;
    }
}
