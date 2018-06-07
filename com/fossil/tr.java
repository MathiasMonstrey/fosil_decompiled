package com.fossil;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.io.InputStream;

public class tr<ModelType, TranscodeType> extends tv<ModelType, wk, Bitmap, TranscodeType> {
    private final vl axR;
    private xs axS = xs.aDT;
    private DecodeFormat axT;
    private un<InputStream, Bitmap> axU;
    private un<ParcelFileDescriptor, Bitmap> axV;

    public /* synthetic */ tv aX(Object obj) {
        return aW(obj);
    }

    public /* synthetic */ tv aZ(int i, int i2) {
        return aY(i, i2);
    }

    public /* synthetic */ tv az(boolean z) {
        return ay(z);
    }

    public /* synthetic */ tv mo4165b(Priority priority) {
        return m13710a(priority);
    }

    public /* synthetic */ tv mo4166b(DiskCacheStrategy diskCacheStrategy) {
        return m13711a(diskCacheStrategy);
    }

    public /* synthetic */ tv mo4167b(aam com_fossil_aam) {
        return m13712a(com_fossil_aam);
    }

    public /* synthetic */ tv mo4168b(tv tvVar) {
        return m13713a(tvVar);
    }

    public /* synthetic */ tv mo4169b(uk ukVar) {
        return m13714a(ukVar);
    }

    public /* synthetic */ tv mo4170b(ul ulVar) {
        return m13715a(ulVar);
    }

    public /* synthetic */ tv mo4171b(un unVar) {
        return m13716a(unVar);
    }

    public /* synthetic */ tv mo4172b(up[] upVarArr) {
        return m13717a(upVarArr);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return tq();
    }

    public /* synthetic */ tv et(int i) {
        return es(i);
    }

    public /* synthetic */ tv eu(int i) {
        return er(i);
    }

    public /* synthetic */ tv tt() {
        return tq();
    }

    public /* synthetic */ tv tu() {
        return tp();
    }

    tr(aab<ModelType, wk, Bitmap, TranscodeType> com_fossil_aab_ModelType__com_fossil_wk__android_graphics_Bitmap__TranscodeType, Class<TranscodeType> cls, tv<ModelType, ?, ?, ?> tvVar) {
        super(com_fossil_aab_ModelType__com_fossil_wk__android_graphics_Bitmap__TranscodeType, cls, tvVar);
        this.axR = tvVar.axY.tE();
        this.axT = tvVar.axY.tL();
        this.axU = new yb(this.axR, this.axT);
        this.axV = new xu(this.axR, this.axT);
    }

    public tr<ModelType, TranscodeType> m13716a(un<wk, Bitmap> unVar) {
        super.mo4171b((un) unVar);
        return this;
    }

    public tr<ModelType, TranscodeType> m13710a(Priority priority) {
        super.mo4165b(priority);
        return this;
    }

    public tr<ModelType, TranscodeType> m13718a(xq... xqVarArr) {
        super.mo4172b((up[]) xqVarArr);
        return this;
    }

    public tr<ModelType, TranscodeType> tn() {
        return m13718a(this.axY.tG());
    }

    public tr<ModelType, TranscodeType> to() {
        return m13718a(this.axY.tH());
    }

    public tr<ModelType, TranscodeType> m13717a(up<Bitmap>... upVarArr) {
        super.mo4172b((up[]) upVarArr);
        return this;
    }

    public tr<ModelType, TranscodeType> tp() {
        super.tu();
        return this;
    }

    public tr<ModelType, TranscodeType> er(int i) {
        super.eu(i);
        return this;
    }

    public tr<ModelType, TranscodeType> m13712a(aam<TranscodeType> com_fossil_aam_TranscodeType) {
        super.mo4167b((aam) com_fossil_aam_TranscodeType);
        return this;
    }

    public tr<ModelType, TranscodeType> es(int i) {
        super.et(i);
        return this;
    }

    public tr<ModelType, TranscodeType> ay(boolean z) {
        super.az(z);
        return this;
    }

    public tr<ModelType, TranscodeType> m13711a(DiskCacheStrategy diskCacheStrategy) {
        super.mo4166b(diskCacheStrategy);
        return this;
    }

    public tr<ModelType, TranscodeType> aY(int i, int i2) {
        super.aZ(i, i2);
        return this;
    }

    public tr<ModelType, TranscodeType> m13713a(tv<?, ?, ?, TranscodeType> tvVar) {
        super.mo4168b((tv) tvVar);
        return this;
    }

    public tr<ModelType, TranscodeType> m13714a(uk<wk> ukVar) {
        super.mo4169b((uk) ukVar);
        return this;
    }

    public tr<ModelType, TranscodeType> m13715a(ul ulVar) {
        super.mo4170b(ulVar);
        return this;
    }

    public tr<ModelType, TranscodeType> aW(ModelType modelType) {
        super.aX(modelType);
        return this;
    }

    public tr<ModelType, TranscodeType> tq() {
        return (tr) super.tt();
    }

    public aaz<TranscodeType> mo4173c(ImageView imageView) {
        return super.mo4173c(imageView);
    }

    void tr() {
        to();
    }

    void ts() {
        tn();
    }
}
