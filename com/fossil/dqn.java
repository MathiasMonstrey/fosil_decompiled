package com.fossil;

import android.content.Context;
import com.misfit.frameworks.common.constants.Constants;
import com.misfit.frameworks.network.configuration.MFConfiguration;
import com.misfit.frameworks.network.configuration.MFHeader;
import com.portfolio.platform.PortfolioApp;

public class dqn {
    public static MFConfiguration bK(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + PortfolioApp.ZQ().aam().YV().getUserAccessToken());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }

    public static MFConfiguration bL(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + PortfolioApp.ZQ().aam().YV().acM());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }

    public static MFConfiguration bM(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + PortfolioApp.ZQ().aam().YV().acN());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }

    public static MFConfiguration bN(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + PortfolioApp.ZQ().aam().YV().acO());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }

    public static MFConfiguration bO(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + PortfolioApp.ZQ().aam().YV().acP());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }

    public static MFConfiguration bP(Context context) {
        MFHeader mFHeader = new MFHeader();
        mFHeader.addHeader(Constants.YO_HEADER_TOKEN, "Bearer " + dqp.aui());
        return new MFConfiguration(dqz.aum().cs(context), mFHeader);
    }
}
