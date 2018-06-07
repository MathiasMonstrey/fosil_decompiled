package com.misfit.frameworks.common.model.Cucumber;

import com.misfit.frameworks.common.model.MFBRpm;

public class CucumberSession {
    private CucumberMapInfo[] arrayMapInfo;
    private MFBRpm[] chart;
    private CucumberSessionInfo info;

    public CucumberSessionInfo getInfo() {
        return this.info;
    }

    public void setInfo(CucumberSessionInfo cucumberSessionInfo) {
        this.info = cucumberSessionInfo;
    }

    public MFBRpm[] getChart() {
        return this.chart;
    }

    public void setChart(MFBRpm[] mFBRpmArr) {
        this.chart = mFBRpmArr;
    }

    public CucumberMapInfo[] getArrayMapInfo() {
        return this.arrayMapInfo;
    }

    public void setArrayMapInfo(CucumberMapInfo[] cucumberMapInfoArr) {
        this.arrayMapInfo = cucumberMapInfoArr;
    }
}
