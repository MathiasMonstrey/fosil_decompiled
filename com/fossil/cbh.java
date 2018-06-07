package com.fossil;

public final class cbh implements cav {
    private final String beB;
    private final String bvf;

    public cbh(cav com_fossil_cav) {
        this.beB = com_fossil_cav.getId();
        this.bvf = com_fossil_cav.TV();
    }

    public final String TV() {
        return this.bvf;
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getId() {
        return this.beB;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.beB == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.beB);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.bvf);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
