package com.fossil;

import android.os.Bundle;
import com.fossil.ats.C1879a.C1882c;
import com.fossil.ats.C1890b;
import com.fossil.ats.C1893g;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public final class arz {
    public static final C1893g<bdb> bdZ = new C1893g();
    private static C1893g<bcx> bea = new C1893g();
    public static final C1893g<asi> beb = new C1893g();
    private static final C1890b<bdb, C1883a> bec = new ath();
    private static final C1890b<bcx, Object> bed = new ati();
    private static final C1890b<asi, GoogleSignInOptions> bee = new atj();
    public static final ats<atm> bef = atk.bfF;
    public static final ats<C1883a> beg = new ats("Auth.CREDENTIALS_API", bec, bdZ);
    public static final ats<GoogleSignInOptions> beh = new ats("Auth.GOOGLE_SIGN_IN_API", bee, beb);
    private static ats<Object> bei = new ats("Auth.ACCOUNT_STATUS_API", bed, bea);
    public static final asc bej = new bdh();
    public static final asa bek = new bda();
    private static bcv bel = new bcw();
    public static final asd bem = new ash();

    public static final class C1883a implements C1882c {
        private final String ben;
        private final PasswordSpecification beo;

        public final Bundle JJ() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", this.ben);
            bundle.putParcelable("password_specification", this.beo);
            return bundle;
        }
    }
}
