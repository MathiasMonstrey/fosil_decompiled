package com.misfit.frameworks.buttonservice.enums;

public enum SupportedDevice {
    RMM("Smart Device"),
    RAY("Ray"),
    QMOTION("Q Motion"),
    SHINE("Shine"),
    FLASH("Flash"),
    KATE_SPADE("Kate Spade"),
    MICHAEL_KORS("Michael Kors"),
    SAM_FACTORY("Watch"),
    SAM("Smartwatch"),
    SAM_FOSSIL("Fossil"),
    SAM_FOSSIL_FULL_OLD("FossilQ Smartwatch"),
    SAM_FOSSIL_FULL_NEW("FossilQ Hybrid"),
    SAM_CHAP("Chaps"),
    SAM_CHAP_FULL_OLD("Chaps Smartwatch"),
    SAM_CHAP_FULL_NEW("Chaps Hybrid"),
    SAM_SKAGEN("Skagen"),
    SAM_SKAGEN_FULL_OLD("Skagen Smartwatch"),
    SAM_SKAGEN_FULL_NEW("Skagen Hybrid"),
    SAM_ARMANI("Armani"),
    SAM_ARMANI_FULL_OLD("Emporio Armani Smartwatch"),
    SAM_ARMANI_FULL_NEW("Emporio Armani Hybrid"),
    SAM_MICHAEL_KORS("Mk"),
    SAM_MK_FULL_OLD("MK Access Smartwatch"),
    SAM_MK_FULL_NEW("MK Access Hybrid"),
    SAM_DIESEL("Diesel"),
    SAM_DIESEL_FULL_OLD("DieselOn Smartwatch"),
    SAM_DIESEL_FULL_NEW("DieselOn Hybrid"),
    SAM_KATE_SPADE("ksny"),
    SAM_KATE_SPADE_FULL_OLD("ksny Smartwatch"),
    SAM_KATE_SPADE_FULL_NEW("ksny hybrid"),
    SAM_ARMANI_EXCHANGE("AX"),
    SAM_ARMANI_EXCHANGE_FULL_OLD("AX Smartwatch"),
    SAM_ARMANI_EXCHANGE_FULL_NEW("AX Hybrid"),
    SAM_RELIC("Relic"),
    SAM_RELIC_FULL_NEW("Relic Hybrid"),
    SAM_MARC_JACOBS("MARC J"),
    SAM_MARC_JACOBS_FULL_NEW("Marc Jacobs Hybrid"),
    SAM_DKNY("DKNY"),
    SAM_DKNY_FULL("DKNY Hybrid"),
    SAM_MICHELE("Michele"),
    SAM_MICHELE_FULL("Michele Hybrid"),
    SAM_TORY_BURCH("Tory"),
    SAM_TORY_BURCH_FULL("Tory Burch Hybrid");
    
    private String name;

    private SupportedDevice(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
