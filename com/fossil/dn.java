package com.fossil;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

public class dn {
    public final Map<String, Object> values = new HashMap();
    public View view;

    public boolean equals(Object obj) {
        if ((obj instanceof dn) && this.view == ((dn) obj).view && this.values.equals(((dn) obj).values)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.view.hashCode() * 31) + this.values.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.view + "\n") + "    values:";
        String str2 = str;
        for (String str3 : this.values.keySet()) {
            str2 = str2 + "    " + str3 + ": " + this.values.get(str3) + "\n";
        }
        return str2;
    }
}
