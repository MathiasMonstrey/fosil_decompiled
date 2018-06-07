package com.fossil;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public class ase implements atz {
    private GoogleSignInAccount bfe;
    private Status mStatus;

    public ase(GoogleSignInAccount googleSignInAccount, Status status) {
        this.bfe = googleSignInAccount;
        this.mStatus = status;
    }

    public GoogleSignInAccount JZ() {
        return this.bfe;
    }

    public Status Ka() {
        return this.mStatus;
    }

    public boolean Kb() {
        return this.mStatus.Kb();
    }
}
