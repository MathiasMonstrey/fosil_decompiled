package com.fossil;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.GenericRequest;

public class tv<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    protected final tx axY;
    protected final Class<ModelType> aya;
    protected final Class<TranscodeType> ayb;
    protected final zs ayc;
    protected final zm ayd;
    private zw<ModelType, DataType, ResourceType, TranscodeType> aye;
    private ModelType ayf;
    private ul ayg;
    private boolean ayh;
    private int ayi;
    private int ayj;
    private aag<? super ModelType, TranscodeType> ayk;
    private Float ayl;
    private tv<?, ?, ?, TranscodeType> aym;
    private Float ayn;
    private Drawable ayo;
    private Drawable ayp;
    private boolean ayq;
    private aam<TranscodeType> ayr;
    private int ays;
    private int ayt;
    private DiskCacheStrategy ayu;
    private up<ResourceType> ayv;
    private boolean ayw;
    private boolean ayx;
    private Drawable ayy;
    private int ayz;
    protected final Context context;
    private Priority priority;

    static /* synthetic */ class C41212 {
        static final /* synthetic */ int[] ayC = new int[ScaleType.values().length];

        static {
            try {
                ayC[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ayC[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ayC[ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ayC[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return tt();
    }

    tv(aab<ModelType, DataType, ResourceType, TranscodeType> com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType, Class<TranscodeType> cls, tv<ModelType, ?, ?, ?> tvVar) {
        this(tvVar.context, tvVar.aya, com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType, cls, tvVar.axY, tvVar.ayc, tvVar.ayd);
        this.ayf = tvVar.ayf;
        this.ayh = tvVar.ayh;
        this.ayg = tvVar.ayg;
        this.ayu = tvVar.ayu;
        this.ayq = tvVar.ayq;
    }

    tv(Context context, Class<ModelType> cls, aab<ModelType, DataType, ResourceType, TranscodeType> com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType, Class<TranscodeType> cls2, tx txVar, zs zsVar, zm zmVar) {
        zw zwVar = null;
        this.ayg = abc.wS();
        this.ayn = Float.valueOf(1.0f);
        this.priority = null;
        this.ayq = true;
        this.ayr = aan.wL();
        this.ays = -1;
        this.ayt = -1;
        this.ayu = DiskCacheStrategy.RESULT;
        this.ayv = xm.vC();
        this.context = context;
        this.aya = cls;
        this.ayb = cls2;
        this.axY = txVar;
        this.ayc = zsVar;
        this.ayd = zmVar;
        if (com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType != null) {
            zwVar = new zw(com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType);
        }
        this.aye = zwVar;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && com_fossil_aab_ModelType__DataType__ResourceType__TranscodeType == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4168b(tv<?, ?, ?, TranscodeType> tvVar) {
        if (equals(tvVar)) {
            throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        }
        this.aym = tvVar;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4171b(un<DataType, ResourceType> unVar) {
        if (this.aye != null) {
            this.aye.m14178d((un) unVar);
        }
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4169b(uk<DataType> ukVar) {
        if (this.aye != null) {
            this.aye.m14177d((uk) ukVar);
        }
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4166b(DiskCacheStrategy diskCacheStrategy) {
        this.ayu = diskCacheStrategy;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4165b(Priority priority) {
        this.priority = priority;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4172b(up<ResourceType>... upVarArr) {
        this.ayw = true;
        if (upVarArr.length == 1) {
            this.ayv = upVarArr[0];
        } else {
            this.ayv = new um(upVarArr);
        }
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> tu() {
        return mo4167b(aan.wL());
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> eu(int i) {
        return mo4167b(new aap(this.context, i));
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4167b(aam<TranscodeType> com_fossil_aam_TranscodeType) {
        if (com_fossil_aam_TranscodeType == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.ayr = com_fossil_aam_TranscodeType;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> et(int i) {
        this.ayi = i;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> az(boolean z) {
        this.ayq = !z;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> aZ(int i, int i2) {
        if (abl.bg(i, i2)) {
            this.ayt = i;
            this.ays = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> mo4170b(ul ulVar) {
        if (ulVar == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.ayg = ulVar;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> aX(ModelType modelType) {
        this.ayf = modelType;
        this.ayh = true;
        return this;
    }

    public tv<ModelType, DataType, ResourceType, TranscodeType> tt() {
        try {
            tv<ModelType, DataType, ResourceType, TranscodeType> tvVar = (tv) super.clone();
            tvVar.aye = this.aye != null ? this.aye.ws() : null;
            return tvVar;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends aaz<TranscodeType>> Y m13700a(Y y) {
        abl.wX();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.ayh) {
            aad wD = y.wD();
            if (wD != null) {
                wD.clear();
                this.ayc.m14171b(wD);
                wD.recycle();
            }
            wD = m13699b((aaz) y);
            y.f(wD);
            this.ayd.mo4445a(y);
            this.ayc.m14170a(wD);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public aaz<TranscodeType> mo4173c(ImageView imageView) {
        abl.wX();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.ayw || imageView.getScaleType() == null)) {
            switch (C41212.ayC[imageView.getScaleType().ordinal()]) {
                case 1:
                    ts();
                    break;
                case 2:
                case 3:
                case 4:
                    tr();
                    break;
            }
        }
        return m13700a(this.axY.m13760a(imageView, this.ayb));
    }

    public aac<TranscodeType> bc(int i, int i2) {
        final aac com_fossil_aaf = new aaf(this.axY.tK(), i, i2);
        this.axY.tK().post(new Runnable(this) {
            final /* synthetic */ tv ayB;

            public void run() {
                if (!com_fossil_aaf.isCancelled()) {
                    this.ayB.m13700a(com_fossil_aaf);
                }
            }
        });
        return com_fossil_aaf;
    }

    void ts() {
    }

    void tr() {
    }

    private Priority tC() {
        if (this.priority == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (this.priority == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    private aad m13699b(aaz<TranscodeType> com_fossil_aaz_TranscodeType) {
        if (this.priority == null) {
            this.priority = Priority.NORMAL;
        }
        return m13698a(com_fossil_aaz_TranscodeType, null);
    }

    private aad m13698a(aaz<TranscodeType> com_fossil_aaz_TranscodeType, aai com_fossil_aai) {
        aad com_fossil_aai2;
        if (this.aym != null) {
            if (this.ayx) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.aym.ayr.equals(aan.wL())) {
                this.aym.ayr = this.ayr;
            }
            if (this.aym.priority == null) {
                this.aym.priority = tC();
            }
            if (abl.bg(this.ayt, this.ays) && !abl.bg(this.aym.ayt, this.aym.ays)) {
                this.aym.aZ(this.ayt, this.ays);
            }
            com_fossil_aai2 = new aai(com_fossil_aai);
            aad a = m13697a(com_fossil_aaz_TranscodeType, this.ayn.floatValue(), this.priority, com_fossil_aai2);
            this.ayx = true;
            aad a2 = this.aym.m13698a(com_fossil_aaz_TranscodeType, com_fossil_aai2);
            this.ayx = false;
            com_fossil_aai2.a(a, a2);
            return com_fossil_aai2;
        } else if (this.ayl == null) {
            return m13697a(com_fossil_aaz_TranscodeType, this.ayn.floatValue(), this.priority, com_fossil_aai);
        } else {
            com_fossil_aai2 = new aai(com_fossil_aai);
            com_fossil_aai2.a(m13697a(com_fossil_aaz_TranscodeType, this.ayn.floatValue(), this.priority, com_fossil_aai2), m13697a(com_fossil_aaz_TranscodeType, this.ayl.floatValue(), tC(), com_fossil_aai2));
            return com_fossil_aai2;
        }
    }

    private aad m13697a(aaz<TranscodeType> com_fossil_aaz_TranscodeType, float f, Priority priority, aae com_fossil_aae) {
        return GenericRequest.a(this.aye, this.ayf, this.ayg, this.context, priority, com_fossil_aaz_TranscodeType, f, this.ayo, this.ayi, this.ayp, this.ayj, this.ayy, this.ayz, this.ayk, com_fossil_aae, this.axY.tF(), this.ayv, this.ayb, this.ayq, this.ayr, this.ayt, this.ays, this.ayu);
    }
}
