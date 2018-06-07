package com.portfolio.platform.response.device;

import com.fossil.cfj;
import com.misfit.frameworks.network.responses.MFResponse;
import com.portfolio.platform.data.model.Installation;
import org.json.JSONObject;

public class MFInstallationResponse extends MFResponse {
    private Installation installation;

    public Installation getInstallation() {
        return this.installation;
    }

    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        this.installation = (Installation) new cfj().c(jSONObject.toString(), Installation.class);
    }
}
