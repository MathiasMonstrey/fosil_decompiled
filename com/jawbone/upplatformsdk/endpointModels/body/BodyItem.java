package com.jawbone.upplatformsdk.endpointModels.body;

import com.fossil.cga;
import com.jawbone.upplatformsdk.endpointModels.DefaultItem;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkUtils;

public class BodyItem extends DefaultItem {
    @cga("bmi")
    protected Float bmi;
    @cga("body_fat")
    protected Float bodyFat;
    @cga("details")
    protected BodyDetails details;
    @cga("lean_mass")
    protected Float leanMass;
    @cga("note")
    protected String note;
    @cga("place_acc")
    protected Integer placeAcc;
    @cga("place_lat")
    protected Float placeLat;
    @cga("place_lon")
    protected Float placeLon;
    @cga("place_name")
    protected String placeName;
    @cga("weight")
    protected Float weight;

    public Float getPlaceLat() {
        return this.placeLat;
    }

    public void setPlaceLat(Float f) {
        this.placeLat = f;
    }

    public Float getPlaceLon() {
        return this.placeLon;
    }

    public void setPlaceLon(Float f) {
        this.placeLon = f;
    }

    public Integer getPlaceAcc() {
        return this.placeAcc;
    }

    public void setPlaceAcc(Integer num) {
        this.placeAcc = num;
    }

    public String getPlaceName() {
        return this.placeName;
    }

    public void setPlaceName(String str) {
        this.placeName = str;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public Float getLeanMass() {
        return this.leanMass;
    }

    public void setLeanMass(Float f) {
        this.leanMass = f;
    }

    public Float getWeight() {
        return this.weight;
    }

    public void setWeight(Float f) {
        this.weight = f;
    }

    public Float getBodyFat() {
        return this.bodyFat;
    }

    public void setBodyFat(Float f) {
        this.bodyFat = f;
    }

    public Float getBmi() {
        return this.bmi;
    }

    public void setBmi(Float f) {
        this.bmi = f;
    }

    public BodyDetails getDetails() {
        return this.details;
    }

    public void setDetails(BodyDetails bodyDetails) {
        this.details = bodyDetails;
    }

    public String toString() {
        return UpPlatformSdkUtils.toJson(this);
    }
}
