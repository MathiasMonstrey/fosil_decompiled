package com.fossil;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class tt<ModelType> extends tv<ModelType, wk, yu, yf> {
    public /* synthetic */ tv aX(Object obj) {
        return aY(obj);
    }

    public /* synthetic */ tv aZ(int i, int i2) {
        return ba(i, i2);
    }

    public /* synthetic */ tv az(boolean z) {
        return aA(z);
    }

    public /* synthetic */ tv mo4165b(Priority priority) {
        return m13740c(priority);
    }

    public /* synthetic */ tv mo4166b(DiskCacheStrategy diskCacheStrategy) {
        return m13741c(diskCacheStrategy);
    }

    public /* synthetic */ tv mo4167b(aam com_fossil_aam) {
        return m13742c(com_fossil_aam);
    }

    public /* synthetic */ tv mo4168b(tv tvVar) {
        return m13743c(tvVar);
    }

    public /* synthetic */ tv mo4169b(uk ukVar) {
        return m13744c(ukVar);
    }

    public /* synthetic */ tv mo4170b(ul ulVar) {
        return m13745c(ulVar);
    }

    public /* synthetic */ tv mo4171b(un unVar) {
        return m13746c(unVar);
    }

    public /* synthetic */ tv mo4172b(up[] upVarArr) {
        return m13748d(upVarArr);
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return tz();
    }

    public /* synthetic */ tv et(int i) {
        return ew(i);
    }

    public /* synthetic */ tv eu(int i) {
        return ev(i);
    }

    public /* synthetic */ tv tt() {
        return tz();
    }

    public /* synthetic */ tv tu() {
        return ty();
    }

    tt(Context context, Class<ModelType> cls, aab<ModelType, wk, yu, yf> com_fossil_aab_ModelType__com_fossil_wk__com_fossil_yu__com_fossil_yf, tx txVar, zs zsVar, zm zmVar) {
        super(context, cls, com_fossil_aab_ModelType__com_fossil_wk__com_fossil_yu__com_fossil_yf, yf.class, txVar, zsVar, zmVar);
        tx();
    }

    public tt<ModelType> m13729a(tt<?> ttVar) {
        super.mo4168b((tv) ttVar);
        return this;
    }

    public tt<ModelType> m13743c(tv<?, ?, ?, yf> tvVar) {
        super.mo4168b((tv) tvVar);
        return this;
    }

    public tt<ModelType> m13746c(un<wk, yu> unVar) {
        super.mo4171b((un) unVar);
        return this;
    }

    public tt<ModelType> m13740c(Priority priority) {
        super.mo4165b(priority);
        return this;
    }

    public tt<ModelType> m13730b(xq... xqVarArr) {
        return m13747c((up[]) xqVarArr);
    }

    public tt<ModelType> tv() {
        return m13748d(this.axY.tI());
    }

    public tt<ModelType> tw() {
        return m13748d(this.axY.tJ());
    }

    public tt<ModelType> m13747c(up<Bitmap>... upVarArr) {
        up[] upVarArr2 = new yz[upVarArr.length];
        for (int i = 0; i < upVarArr.length; i++) {
            upVarArr2[i] = new yz(this.axY.tE(), upVarArr[i]);
        }
        return m13748d(upVarArr2);
    }

    public tt<ModelType> m13748d(up<yu>... upVarArr) {
        super.mo4172b((up[]) upVarArr);
        return this;
    }

    public final tt<ModelType> tx() {
        super.mo4167b(new aaj());
        return this;
    }

    public tt<ModelType> ty() {
        super.tu();
        return this;
    }

    public tt<ModelType> m13742c(aam<yf> com_fossil_aam_com_fossil_yf) {
        super.mo4167b((aam) com_fossil_aam_com_fossil_yf);
        return this;
    }

    public tt<ModelType> ev(int i) {
        super.eu(i);
        return this;
    }

    public tt<ModelType> ew(int i) {
        super.et(i);
        return this;
    }

    public tt<ModelType> m13741c(DiskCacheStrategy diskCacheStrategy) {
        super.mo4166b(diskCacheStrategy);
        return this;
    }

    public tt<ModelType> aA(boolean z) {
        super.az(z);
        return this;
    }

    public tt<ModelType> ba(int i, int i2) {
        super.aZ(i, i2);
        return this;
    }

    public tt<ModelType> m13744c(uk<wk> ukVar) {
        super.mo4169b((uk) ukVar);
        return this;
    }

    public tt<ModelType> m13745c(ul ulVar) {
        super.mo4170b(ulVar);
        return this;
    }

    public tt<ModelType> aY(ModelType modelType) {
        super.aX(modelType);
        return this;
    }

    public tt<ModelType> tz() {
        return (tt) super.tt();
    }

    public aaz<yf> mo4173c(ImageView imageView) {
        return super.mo4173c(imageView);
    }

    void tr() {
        tw();
    }

    void ts() {
        tv();
    }
}
