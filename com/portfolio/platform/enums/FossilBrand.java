package com.portfolio.platform.enums;

import com.portfolio.platform.PortfolioApp;

public enum FossilBrand {
    PORTFOLIO(0, "White Type"),
    KATESPADE(1, "Kate Spade"),
    MICHAELKORS(2, "Micheal Kors"),
    DIESEL(3, "Diesel"),
    SKAGEN(4, " Skagen"),
    CHAPS(5, "Chaps"),
    EA(6, "Emporio Armani"),
    AX(7, "Armani Exchange"),
    MJ(8, "Marc Jacobs"),
    RELIC(9, "Relic"),
    FOSSIL(10, "Fossil");
    
    private static final FossilBrand[] cwM = null;
    private static final FossilBrand[] cwN = null;
    private static final FossilBrand[] cwO = null;
    private static final FossilBrand[] cwP = null;
    private static final FossilBrand[] cwQ = null;
    private static final FossilBrand[] cwR = null;
    private static final FossilBrand[] cwS = null;
    private String name;
    private int value;

    static {
        cwM = new FossilBrand[]{PORTFOLIO, MICHAELKORS, SKAGEN, DIESEL, KATESPADE};
        cwN = new FossilBrand[]{PORTFOLIO, MICHAELKORS};
        cwO = new FossilBrand[]{SKAGEN, DIESEL, KATESPADE};
        cwP = new FossilBrand[]{PORTFOLIO};
        cwQ = new FossilBrand[]{KATESPADE};
        cwR = new FossilBrand[]{KATESPADE};
        cwS = new FossilBrand[]{PORTFOLIO, KATESPADE, DIESEL, SKAGEN, CHAPS, EA, AX};
    }

    private FossilBrand(int i, String str) {
        this.value = i;
        this.name = str;
    }

    public static FossilBrand fromInt(int i) {
        for (FossilBrand fossilBrand : values()) {
            if (fossilBrand.getValue() == i) {
                return fossilBrand;
            }
        }
        return PORTFOLIO;
    }

    public int getValue() {
        return this.value;
    }

    public static boolean isSupportNewPairingFlow(FossilBrand fossilBrand) {
        for (FossilBrand fossilBrand2 : cwM) {
            if (fossilBrand == fossilBrand2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupportNewPairingFlow1(FossilBrand fossilBrand) {
        for (FossilBrand fossilBrand2 : cwN) {
            if (fossilBrand == fossilBrand2) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupport(FossilBrand[] fossilBrandArr) {
        FossilBrand aag = PortfolioApp.ZQ().aag();
        for (FossilBrand fossilBrand : fossilBrandArr) {
            if (aag == fossilBrand) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBrandAcceptedShowLinkOnboardingMode() {
        FossilBrand aag = PortfolioApp.ZQ().aag();
        for (FossilBrand fossilBrand : cwS) {
            if (aag == fossilBrand) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public static FossilBrand[] getSupportNewPairingFlow2() {
        return cwO;
    }

    public static FossilBrand[] getSupportMicroApp() {
        return cwP;
    }

    public static FossilBrand[] getNotSupportToggleMode() {
        return cwQ;
    }

    public static FossilBrand[] getSupportCountDown() {
        return cwR;
    }
}
