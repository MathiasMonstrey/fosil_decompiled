package com.fossil;

import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.portfolio.platform.PortfolioApp;

public class cmz {
    private static cmz cyE;
    private int cyF;
    private int cyG;

    public static cmz abN() {
        if (cyE == null) {
            cyE = new cmz();
        }
        return cyE;
    }

    private cmz() {
        Display defaultDisplay = ((WindowManager) PortfolioApp.ZQ().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        this.cyF = point.x;
        this.cyG = point.y;
    }

    public int abO() {
        return this.cyF;
    }
}
