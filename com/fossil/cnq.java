package com.fossil;

import android.text.TextUtils;
import android.util.Log;
import com.fossil.wearables.fsl.appfilter.AppFilterProvider;
import com.fossil.wearables.fsl.appfilter.AppFilterProviderImpl;
import com.fossil.wearables.fsl.contact.ContactProvider;
import com.fossil.wearables.fsl.contact.ContactProviderImpl;
import com.fossil.wearables.fsl.fitness.FitnessProvider;
import com.fossil.wearables.fsl.fitness.FitnessProviderFactory;
import com.fossil.wearables.fsl.goaltracking.GoalTrackingProviderImpl;
import com.fossil.wearables.fsl.location.LocationProvider;
import com.fossil.wearables.fsl.location.LocationProviderImpl;
import com.fossil.wearables.fsl.sharedPrefs.SharedPrefs;
import com.fossil.wearables.fsl.sharedPrefs.SharedPrefsImpl;
import com.fossil.wearables.fsl.sleep.MFSleepSessionProvider;
import com.fossil.wearables.fsl.sleep.MFSleepSessionProviderImp;
import com.misfit.frameworks.common.log.MFLogger;
import com.portfolio.platform.PortfolioApp;
import com.portfolio.platform.data.model.MFUser;

public class cnq {
    private static final String TAG = cnq.class.getSimpleName();
    private static cnq czF;
    private cog cAa;
    private cph cAb;
    private SharedPrefs cAc;
    private cpd cAd;
    private ContactProvider czG;
    private LocationProvider czH;
    private AppFilterProvider czI;
    private FitnessProvider czJ;
    private coq czK;
    private cok czL;
    private cpb czM;
    private MFSleepSessionProvider czN;
    private cor czO;
    private cot czP;
    private cpf czQ;
    private GoalTrackingProviderImpl czR;
    private coz czS;
    private coe czT;
    private cpl czU;
    private cpj czV;
    private coi czW;
    private cov czX;
    private com czY;
    private cox czZ;

    private cnq() {
    }

    public static cnq acd() {
        if (czF == null) {
            czF = new cnq();
        }
        return czF;
    }

    public cpj ace() {
        if (this.czV == null) {
            this.czV = new cpk(PortfolioApp.ZQ().getApplicationContext(), "user.db");
        }
        return this.czV;
    }

    public synchronized coi acf() {
        if (this.czW == null) {
            this.czW = new coj(PortfolioApp.ZQ().getApplicationContext(), "dataVersion.db");
        }
        return this.czW;
    }

    public synchronized cpl acg() {
        String str = "Guest";
        if (this.czU == null) {
            this.czU = new cpm(PortfolioApp.ZQ().getApplicationContext(), str + "_" + "widgets.db");
        } else {
            String str2 = str + "_" + "widgets.db";
            CharSequence charSequence = "";
            if (this.czU != null) {
                charSequence = this.czU.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getWidgetProvider previousDbPath=" + charSequence + ", newPath=" + str2);
            if (!(TextUtils.isEmpty(charSequence) || str2.equals(charSequence))) {
                this.czU = new cpm(PortfolioApp.ZQ().getApplicationContext(), str2);
            }
        }
        return this.czU;
    }

    public synchronized com ach() {
        String str = "Guest";
        if (this.czY == null) {
            this.czY = new con(PortfolioApp.ZQ().getApplicationContext(), str + "_" + "explore.db");
        } else {
            String str2 = str + "_" + "explore.db";
            CharSequence charSequence = "";
            if (this.czY != null) {
                charSequence = this.czY.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getExploreProvider previousDbPath=" + charSequence + ", newPath=" + str2);
            if (!(TextUtils.isEmpty(charSequence) || str2.equals(charSequence))) {
                this.czY = new con(PortfolioApp.ZQ().getApplicationContext(), str2);
            }
        }
        return this.czY;
    }

    public synchronized cox aci() {
        String str = "Guest";
        if (this.czZ == null) {
            this.czZ = new coy(PortfolioApp.ZQ().getApplicationContext(), str + "_" + "landingPage.db");
        } else {
            String str2 = str + "_" + "landingPage.db";
            CharSequence charSequence = "";
            if (this.czZ != null) {
                charSequence = this.czZ.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getLandingPageProvider previousDbPath=" + charSequence + ", newPath=" + str2);
            if (!(TextUtils.isEmpty(charSequence) || str2.equals(charSequence))) {
                this.czZ = new coy(PortfolioApp.ZQ().getApplicationContext(), str2);
            }
        }
        return this.czZ;
    }

    public synchronized cov acj() {
        String str = "Guest";
        if (this.czX == null) {
            this.czX = new cow(PortfolioApp.ZQ().getApplicationContext(), str + "_" + "integrations.db");
        } else {
            String str2 = str + "_" + "integrations.db";
            CharSequence charSequence = "";
            if (this.czX != null) {
                charSequence = this.czX.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getIntegrationProvider previousDbPath=" + charSequence + ", newPath=" + str2);
            if (!(TextUtils.isEmpty(charSequence) || str2.equals(charSequence))) {
                this.czX = new cow(PortfolioApp.ZQ().getApplicationContext(), str2);
            }
        }
        return this.czX;
    }

    public synchronized ContactProvider ack() {
        String acz = acz();
        if (this.czG == null) {
            this.czG = new cop(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + ContactProviderImpl.DB_NAME);
        } else {
            String str = acz + "_" + ContactProviderImpl.DB_NAME;
            CharSequence charSequence = "";
            if (this.czG != null) {
                charSequence = this.czG.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getContactProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czG = new cop(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czG;
    }

    public synchronized LocationProvider acl() {
        String acz = acz();
        if (this.czH == null) {
            this.czH = new LocationProviderImpl(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + LocationProviderImpl.DB_NAME);
        } else {
            String str = acz + "_" + LocationProviderImpl.DB_NAME;
            CharSequence charSequence = "";
            if (this.czH != null) {
                charSequence = this.czH.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getLocationProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czH = new LocationProviderImpl(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czH;
    }

    public synchronized AppFilterProvider acm() {
        String acz = acz();
        if (this.czI == null) {
            this.czI = new coo(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + AppFilterProviderImpl.DB_NAME);
        } else {
            String str = acz + "_" + AppFilterProviderImpl.DB_NAME;
            CharSequence charSequence = "";
            if (this.czI != null) {
                charSequence = this.czI.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getAppFilterProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czI = new coo(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czI;
    }

    public synchronized MFSleepSessionProvider acn() {
        String acz = acz();
        if (this.czN == null) {
            this.czN = new MFSleepSessionProviderImp(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + MFSleepSessionProviderImp.DB_NAME);
        } else {
            String str = acz + "_" + MFSleepSessionProviderImp.DB_NAME;
            CharSequence charSequence = "";
            if (this.czN != null) {
                charSequence = this.czN.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getSleepProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czN = new MFSleepSessionProviderImp(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czN;
    }

    public synchronized cor aco() {
        String acz = acz();
        if (this.czO == null) {
            this.czO = new cor(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + MFSleepSessionProviderImp.DB_NAME);
        } else {
            String str = acz + "_" + MFSleepSessionProviderImp.DB_NAME;
            CharSequence charSequence = "";
            if (this.czO != null) {
                charSequence = this.czO.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getExtendSleepProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czO = new cor(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czO;
    }

    public synchronized cok acp() {
        String acz = acz();
        MFLogger.m12670d(TAG, "Inside .getDeviceProvider with userId=" + acz);
        if (this.czL == null) {
            this.czL = new col(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "deviceModel.db");
        } else {
            String str = acz + "_" + "deviceModel.db";
            try {
                CharSequence dbPath = this.czL.getDbPath();
                if (TextUtils.isEmpty(dbPath) || !str.equals(dbPath)) {
                    this.czL = new col(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "getDeviceProvider - ex=" + e);
                if (TextUtils.isEmpty(null) || !str.equals(null)) {
                    this.czL = new col(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            } catch (Throwable th) {
                if (TextUtils.isEmpty(null) || !str.equals(null)) {
                    this.czL = new col(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            }
        }
        return this.czL;
    }

    public synchronized cpf acq() {
        String str;
        String acz = acz();
        if (this.czQ == null) {
            this.czQ = new cpg(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "pin.db");
        } else {
            str = acz + "_" + "pin.db";
            try {
                acz = this.czQ.getDbPath();
                if (eux.mT(acz) || !str.equals(acz)) {
                    this.czQ = new cpg(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            } catch (Exception e) {
                MFLogger.m12671e(TAG, "getPinProvider - ex=" + e);
                if (eux.mT(null) || !str.equals(null)) {
                    this.czQ = new cpg(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            } catch (Throwable th) {
                if (eux.mT(null) || !str.equals(null)) {
                    this.czQ = new cpg(PortfolioApp.ZQ().getApplicationContext(), str);
                }
            }
        }
        return this.czQ;
    }

    public synchronized FitnessProvider acr() {
        String acz = acz();
        if (this.czJ == null) {
            this.czJ = FitnessProviderFactory.createInstance(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + FitnessProviderFactory.DB_NAME);
        } else {
            String str = acz + "_" + FitnessProviderFactory.DB_NAME;
            CharSequence charSequence = "";
            if (this.czJ != null) {
                charSequence = this.czJ.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getFitnessProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czJ = FitnessProviderFactory.createInstance(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czJ;
    }

    public synchronized coq acs() {
        String acz = acz();
        if (this.czK == null) {
            this.czK = new coq(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + FitnessProviderFactory.DB_NAME);
        } else {
            String str = acz + "_" + FitnessProviderFactory.DB_NAME;
            CharSequence charSequence = "";
            if (this.czK != null) {
                charSequence = this.czK.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getExtendFitnessProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czK = new coq(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czK;
    }

    public synchronized coz act() {
        String acz = acz();
        if (this.czS == null) {
            this.czS = new cpa(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "firmwares.db");
        } else {
            String str = acz + "_" + "firmwares.db";
            CharSequence charSequence = "";
            if (this.czS != null) {
                charSequence = this.czS.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getFirmwareProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czS = new cpa(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czS;
    }

    public synchronized coe acu() {
        String acz = acz();
        if (this.czT == null) {
            this.czT = new cof(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "alarm.db");
        } else {
            String str = acz + "_" + "alarm.db";
            CharSequence charSequence = "";
            if (this.czT != null) {
                charSequence = this.czT.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getAlarmProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czT = new cof(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czT;
    }

    public synchronized cpb acv() {
        String acz = acz();
        if (this.czM == null) {
            this.czM = new cpc(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "microAppSetting.db");
        } else {
            String str = acz + "_" + "microAppSetting.db";
            CharSequence charSequence = "";
            if (this.czM != null) {
                charSequence = this.czM.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getMicroAppSettingProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.czM = new cpc(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.czM;
    }

    public synchronized cog acw() {
        String acz = acz();
        if (this.cAa == null) {
            this.cAa = new coh(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "challenge.db");
        } else {
            acz = acz + "_" + "challenge.db";
            String str = "";
            CharSequence dbPath = this.cAa.getDbPath();
            MFLogger.m12670d(TAG, "Inside .getBuddyChallengeProvider previousDbPath=" + dbPath + ", newPath=" + acz);
            if (!(TextUtils.isEmpty(dbPath) || acz.equals(dbPath))) {
                this.cAa = new coh(PortfolioApp.ZQ().getApplicationContext(), acz);
            }
        }
        return this.cAa;
    }

    public synchronized cph acx() {
        String acz = acz();
        if (this.cAb == null) {
            this.cAb = new cpi(PortfolioApp.ZQ().getApplicationContext(), acz + "_" + "secondTimezone.db");
        } else {
            String str = acz + "_" + "secondTimezone.db";
            CharSequence charSequence = "";
            if (this.cAb != null) {
                charSequence = this.cAb.getDbPath();
            }
            MFLogger.m12670d(TAG, "Inside .getSecondTimezoneProvider previousDbPath=" + charSequence + ", newPath=" + str);
            if (!(TextUtils.isEmpty(charSequence) || str.equals(charSequence))) {
                this.cAb = new cpi(PortfolioApp.ZQ().getApplicationContext(), str);
            }
        }
        return this.cAb;
    }

    public synchronized cok gw(String str) {
        if (this.czL == null) {
            String str2 = str + "_" + "deviceModel.db";
            Log.e(TAG, "Get device provider, current path " + str2);
            this.czL = new col(PortfolioApp.ZQ().getApplicationContext(), str2);
        }
        return this.czL;
    }

    public synchronized cot acy() {
        if (this.czP == null) {
            this.czP = new cou(PortfolioApp.ZQ().getApplicationContext(), acz() + "_" + "hourNotification.db");
        }
        return this.czP;
    }

    public String acz() {
        if (this.czV != null) {
            MFUser currentUser = this.czV.getCurrentUser();
            if (!(currentUser == null || TextUtils.isEmpty(currentUser.getUserId()))) {
                return currentUser.getUserId();
            }
        }
        return "Anonymous";
    }

    public SharedPrefs acA() {
        if (this.cAc != null) {
            return this.cAc;
        }
        this.cAc = new SharedPrefsImpl(acz());
        return this.cAc;
    }

    public cpd acB() {
        if (this.cAd == null) {
            this.cAd = new cpe(PortfolioApp.ZQ().getApplicationContext(), "phone_favorites_contact.db");
        }
        return this.cAd;
    }

    public void reset() {
        this.czG = null;
        this.czH = null;
        this.czI = null;
        this.czJ = null;
        this.czN = null;
        this.czQ = null;
        this.czL = null;
        this.czR = null;
        this.czK = null;
        this.czP = null;
        this.czO = null;
        this.czT = null;
        this.czV = null;
        this.czW = null;
        this.czM = null;
        this.cAa = null;
        this.cAc = null;
    }
}
