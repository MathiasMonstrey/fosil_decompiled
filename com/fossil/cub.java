package com.fossil;

import com.fossil.dau.C2614b;
import com.fossil.dbx.C2639b;
import com.fossil.dha.C2764b;
import com.fossil.dkr.C2908b;
import java.util.Date;

public class cub {
    private final String cFB;
    private final fj cFC;
    private final C2614b cFZ;
    private final C2764b cGa;
    private final C2639b cGb;
    private final C2908b cGc;
    private final Date mDate;

    public cub(C2614b c2614b, C2764b c2764b, C2639b c2639b, C2908b c2908b, String str, fj fjVar, Date date) {
        this.cFZ = c2614b;
        this.cGa = c2764b;
        this.cGb = c2639b;
        this.cGc = c2908b;
        this.cFB = str;
        this.cFC = fjVar;
        this.mDate = date;
    }

    C2614b agX() {
        return this.cFZ;
    }

    C2764b agY() {
        return this.cGa;
    }

    C2639b agZ() {
        return this.cGb;
    }

    C2908b aha() {
        return this.cGc;
    }

    fj ahb() {
        return this.cFC;
    }

    Date ahc() {
        return this.mDate;
    }
}
