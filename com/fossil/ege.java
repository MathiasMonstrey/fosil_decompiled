package com.fossil;

public class ege {
    @cga("access_token")
    String accessToken;
    @cga("expires_in")
    Long dGy;
    @cga("refresh_token")
    String refreshToken;

    public String getAccessToken() {
        return this.accessToken;
    }

    public Long aDb() {
        return this.dGy;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public static egb m10653a(ege com_fossil_ege) {
        egb com_fossil_egc = new egc();
        com_fossil_egc.setAccessToken(com_fossil_ege.getAccessToken());
        com_fossil_egc.setRefreshToken(com_fossil_ege.getRefreshToken());
        com_fossil_egc.mo2855e(Long.valueOf(System.currentTimeMillis() + (com_fossil_ege.aDb().longValue() * 1000)));
        return com_fossil_egc;
    }
}
