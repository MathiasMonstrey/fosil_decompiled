package com.fossil;

import android.content.SharedPreferences;
import com.ua.sdk.UaException;
import com.ua.sdk.cache.DiskCache;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public class eli extends eij<eld> implements elh {
    private final eix<eld> dLG;
    private final SharedPreferences sharedPreferences;

    public eli(eix<eld> com_fossil_eix_com_fossil_eld, egi com_fossil_egi, egh com_fossil_egh, DiskCache<eld> diskCache, eiq<eld> com_fossil_eiq_com_fossil_eld, ExecutorService executorService, SharedPreferences sharedPreferences) {
        super(com_fossil_egi, com_fossil_egh, diskCache, com_fossil_eiq_com_fossil_eld, executorService);
        this.dLG = (eix) eiy.m10771e(com_fossil_eix_com_fossil_eld, "mediaService");
        this.sharedPreferences = (SharedPreferences) eiy.dd(sharedPreferences);
    }

    public eld mo2945f(ece<eld> com_fossil_ece_com_fossil_eld) throws UaException {
        if (com_fossil_ece_com_fossil_eld == null) {
            throw new UaException("ref can't be null");
        }
        String string = this.sharedPreferences.getString("mmdk_user_last_saved", "");
        eld com_fossil_elf = new elf();
        com_fossil_elf.m10861e(com_fossil_ece_com_fossil_eld);
        com_fossil_elf.me(String.format(Locale.US, "http://drzetlglcbfx.cloudfront.net/profile/%s/picture?size=%s?%s", new Object[]{com_fossil_ece_com_fossil_eld.getId(), "Large", string}));
        com_fossil_elf.md(String.format(Locale.US, "http://drzetlglcbfx.cloudfront.net/profile/%s/picture?size=%s?%s", new Object[]{com_fossil_ece_com_fossil_eld.getId(), "Medium", string}));
        com_fossil_elf.mc(String.format(Locale.US, "http://drzetlglcbfx.cloudfront.net/profile/%s/picture?size=%s?%s", new Object[]{com_fossil_ece_com_fossil_eld.getId(), "Small", string}));
        return com_fossil_elf;
    }
}
