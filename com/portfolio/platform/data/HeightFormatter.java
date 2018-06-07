package com.portfolio.platform.data;

import com.fossil.wearables.fossil.R;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.view.NumberPickerLarge.Formatter;
import java.io.Serializable;
import java.util.Locale;

public class HeightFormatter implements Formatter, Serializable {
    public static final int UNIT_FEET = 0;
    public static final int UNIT_INCHES = 1;
    private int unit;

    public HeightFormatter(int i) {
        this.unit = i;
    }

    public String format(int i) {
        if (this.unit == 0) {
            return String.format(Locale.US, PortfolioApp.ZQ().getString(R.string.feet_format), new Object[]{Integer.valueOf(i)});
        } else if (this.unit == 1) {
            return String.format(Locale.US, PortfolioApp.ZQ().getString(R.string.inches_format), new Object[]{Integer.valueOf(i)});
        } else {
            return String.format(Locale.US, PortfolioApp.ZQ().getString(R.string.normal_format), new Object[]{Integer.valueOf(i)});
        }
    }
}
