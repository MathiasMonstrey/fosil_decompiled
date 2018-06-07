package com.fossil;

import com.ua.sdk.MeasurementSystem;
import com.ua.sdk.user.Gender;
import java.util.Date;

public class elc extends eil {
    @cga("access_token")
    String accessToken;
    @cga("password")
    String cBN;
    @cga("gender")
    Gender dFq;
    @cga("date_joined")
    Date dFu;
    @cga("expires_in")
    Long dGy;
    @cga("last_initial")
    String dKU;
    @cga("introduction")
    String dKV;
    @cga("hobbies")
    String dKW;
    @cga("goal_statement")
    String dKX;
    @cga("birthdate")
    ech dKZ;
    @cga("weight")
    Double dKe;
    @cga("sharing")
    elb dLA;
    @cga("location")
    eje dLB;
    @cga("height")
    Double dLa;
    @cga("last_login")
    Date dLb;
    @cga("display_measurement_system")
    MeasurementSystem dLc;
    @cga("profile_statement")
    String dLy;
    @cga("communication")
    ekp dLz;
    @cga("display_name")
    String displayName;
    @cga("email")
    String email;
    @cga("first_name")
    String firstName;
    @cga("id")
    String id;
    @cga("last_name")
    String lastName;
    @cga("refresh_token")
    String refreshToken;
    @cga("time_zone")
    String timeZone;
    @cga("username")
    String username;

    public static elc m10854f(ekn com_fossil_ekn) {
        if (com_fossil_ekn == null) {
            return null;
        }
        ekr com_fossil_ekr = (ekr) com_fossil_ekn;
        elc com_fossil_elc = new elc();
        com_fossil_elc.id = com_fossil_ekn.getId();
        com_fossil_elc.username = com_fossil_ekn.getUsername();
        com_fossil_elc.email = com_fossil_ekn.getEmail();
        com_fossil_elc.cBN = com_fossil_ekr.getPassword();
        com_fossil_elc.firstName = com_fossil_ekn.getFirstName();
        com_fossil_elc.lastName = com_fossil_ekn.getLastName();
        com_fossil_elc.dKU = com_fossil_ekn.aEf();
        com_fossil_elc.displayName = com_fossil_ekn.getDisplayName();
        com_fossil_elc.dKV = com_fossil_ekn.aEq();
        com_fossil_elc.dKW = com_fossil_ekn.aEr();
        com_fossil_elc.dKX = com_fossil_ekn.aEs();
        com_fossil_elc.dLy = com_fossil_ekn.aEt();
        com_fossil_elc.dKZ = com_fossil_ekn.aEg();
        com_fossil_elc.dFq = com_fossil_ekn.aEh();
        com_fossil_elc.dLa = com_fossil_ekn.aEi();
        com_fossil_elc.dKe = com_fossil_ekn.aEj();
        com_fossil_elc.timeZone = com_fossil_ekn.getTimeZone();
        com_fossil_elc.dFu = com_fossil_ekn.aEk();
        com_fossil_elc.dLb = com_fossil_ekn.aEl();
        com_fossil_elc.dLc = com_fossil_ekn.aEm();
        com_fossil_elc.dLz = (ekp) com_fossil_ekr.aEn();
        com_fossil_elc.dLA = (elb) com_fossil_ekr.aEo();
        com_fossil_elc.dLB = (eje) com_fossil_ekr.aEp();
        com_fossil_elc.m10510A(com_fossil_ekr.aDq());
        return com_fossil_elc;
    }

    public static ekr m10853a(elc com_fossil_elc) {
        Long l = null;
        if (com_fossil_elc == null) {
            return null;
        }
        ekr com_fossil_ekr = new ekr();
        com_fossil_ekr.setId(com_fossil_elc.id);
        com_fossil_ekr.setUsername(com_fossil_elc.username);
        com_fossil_ekr.setEmail(com_fossil_elc.email);
        egb aEA = com_fossil_ekr.aEA();
        aEA.setAccessToken(com_fossil_elc.accessToken);
        if (com_fossil_elc.dGy != null) {
            l = Long.valueOf(System.currentTimeMillis() + (com_fossil_elc.dGy.longValue() * 1000));
        }
        aEA.mo2855e(l);
        aEA.setRefreshToken(com_fossil_elc.refreshToken);
        com_fossil_ekr.setFirstName(com_fossil_elc.firstName);
        com_fossil_ekr.setLastName(com_fossil_elc.lastName);
        com_fossil_ekr.lX(com_fossil_elc.dKU);
        com_fossil_ekr.setDisplayName(com_fossil_elc.displayName);
        com_fossil_ekr.lY(com_fossil_elc.dKV);
        com_fossil_ekr.lZ(com_fossil_elc.dKW);
        com_fossil_ekr.ma(com_fossil_elc.dKX);
        com_fossil_ekr.mb(com_fossil_elc.dLy);
        com_fossil_ekr.m10821a(com_fossil_elc.dKZ);
        com_fossil_ekr.m10825a(com_fossil_elc.dFq);
        com_fossil_ekr.m10826c(com_fossil_elc.dLa);
        com_fossil_ekr.m10827d(com_fossil_elc.dKe);
        com_fossil_ekr.setTimeZone(com_fossil_elc.timeZone);
        com_fossil_ekr.m10818B(com_fossil_elc.dFu);
        com_fossil_ekr.m10819C(com_fossil_elc.dLb);
        com_fossil_ekr.m10828f(com_fossil_elc.dLc);
        com_fossil_ekr.m10823a(com_fossil_elc.dLz);
        com_fossil_ekr.m10824a(com_fossil_elc.dLA);
        com_fossil_ekr.m10822a(com_fossil_elc.dLB);
        for (String str : com_fossil_elc.aDr()) {
            com_fossil_ekr.m10512b(str, com_fossil_elc.lz(str));
        }
        return com_fossil_ekr;
    }
}
