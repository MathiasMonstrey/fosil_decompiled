package com.fossil;

import com.fasterxml.jackson.core.Base64Variant;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;

public class agp extends JsonParser {
    protected JsonParser aPO;

    public agp(JsonParser jsonParser) {
        this.aPO = jsonParser;
    }

    public void bm(Object obj) {
        this.aPO.bm(obj);
    }

    public afa getCodec() {
        return this.aPO.getCodec();
    }

    public JsonParser mo887a(Feature feature) {
        this.aPO.mo887a(feature);
        return this;
    }

    public boolean isEnabled(Feature feature) {
        return this.aPO.isEnabled(feature);
    }

    public int zB() {
        return this.aPO.zB();
    }

    public JsonParser fm(int i) {
        this.aPO.fm(i);
        return this;
    }

    public void mo905a(aex com_fossil_aex) {
        this.aPO.mo905a(com_fossil_aex);
    }

    public void close() throws IOException {
        this.aPO.close();
    }

    public JsonToken zU() {
        return this.aPO.zU();
    }

    public int zV() {
        return this.aPO.zV();
    }

    public boolean fn(int i) {
        return this.aPO.fn(i);
    }

    public boolean mo865a(JsonToken jsonToken) {
        return this.aPO.mo865a(jsonToken);
    }

    public String zW() throws IOException {
        return this.aPO.zW();
    }

    public JsonLocation zZ() {
        return this.aPO.zZ();
    }

    public aez zX() {
        return this.aPO.zX();
    }

    public boolean Aa() {
        return this.aPO.Aa();
    }

    public boolean Ab() {
        return this.aPO.Ab();
    }

    public void Ac() {
        this.aPO.Ac();
    }

    public String getText() throws IOException {
        return this.aPO.getText();
    }

    public boolean Ag() {
        return this.aPO.Ag();
    }

    public char[] Ad() throws IOException {
        return this.aPO.Ad();
    }

    public int Ae() throws IOException {
        return this.aPO.Ae();
    }

    public int Af() throws IOException {
        return this.aPO.Af();
    }

    public BigInteger Am() throws IOException {
        return this.aPO.Am();
    }

    public byte Aj() throws IOException {
        return this.aPO.Aj();
    }

    public short Ak() throws IOException {
        return this.aPO.Ak();
    }

    public BigDecimal Ap() throws IOException {
        return this.aPO.Ap();
    }

    public double Ao() throws IOException {
        return this.aPO.Ao();
    }

    public float An() throws IOException {
        return this.aPO.An();
    }

    public int getIntValue() throws IOException {
        return this.aPO.getIntValue();
    }

    public long Al() throws IOException {
        return this.aPO.Al();
    }

    public NumberType Ai() throws IOException {
        return this.aPO.Ai();
    }

    public Number Ah() throws IOException {
        return this.aPO.Ah();
    }

    public int As() throws IOException {
        return this.aPO.As();
    }

    public int fo(int i) throws IOException {
        return this.aPO.fo(i);
    }

    public long At() throws IOException {
        return this.aPO.At();
    }

    public long getValueAsLong(long j) throws IOException {
        return this.aPO.getValueAsLong(j);
    }

    public String Au() throws IOException {
        return this.aPO.Au();
    }

    public String aY(String str) throws IOException {
        return this.aPO.aY(str);
    }

    public Object Aq() throws IOException {
        return this.aPO.Aq();
    }

    public byte[] mo906a(Base64Variant base64Variant) throws IOException {
        return this.aPO.mo906a(base64Variant);
    }

    public int mo904a(Base64Variant base64Variant, OutputStream outputStream) throws IOException {
        return this.aPO.mo904a(base64Variant, outputStream);
    }

    public JsonLocation zY() {
        return this.aPO.zY();
    }

    public JsonToken zP() throws IOException {
        return this.aPO.zP();
    }

    public JsonToken zQ() throws IOException {
        return this.aPO.zQ();
    }

    public JsonParser zT() throws IOException {
        this.aPO.zT();
        return this;
    }

    public boolean Av() {
        return this.aPO.Av();
    }

    public boolean Aw() {
        return this.aPO.Aw();
    }

    public Object Ax() throws IOException {
        return this.aPO.Ax();
    }

    public Object Ay() throws IOException {
        return this.aPO.Ay();
    }
}
