package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.enums.Command;
import com.misfit.frameworks.common.enums.HTTPMethod;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.misfit.frameworks.network.enums.MFUrls;
import com.misfit.frameworks.network.request.MFBaseRequest;
import com.misfit.frameworks.network.responses.MFLoginResponse;
import com.misfit.frameworks.network.responses.MFResponse;
import org.apache.http.Header;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.auth.BasicScheme;

public class cqi extends MFBaseRequest {
    private String cBN;
    private String email;

    public cqi(Context context, String str, String str2) {
        super(context);
        this.email = str;
        this.cBN = str2;
    }

    protected Object initJsonData() {
        return null;
    }

    protected HTTPMethod initHttpMethod() {
        return HTTPMethod.GET;
    }

    protected MFResponse initResponse() {
        MFResponse mFLoginResponse = new MFLoginResponse();
        mFLoginResponse.setCommand(Command.LOGIN_EMAIL);
        return mFLoginResponse;
    }

    protected MFConfiguration initConfiguration() {
        Header authenticate = BasicScheme.authenticate(new UsernamePasswordCredentials(this.email, this.cBN), "utf-8", false);
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(authenticate.getName(), authenticate.getValue());
        return new MFConfiguration(dqz.aum().cs(this.context), mFHeader);
    }

    protected String initApiMethod() {
        return MFUrls.URL_LOGIN_WITH_EMAIL;
    }
}
