package com.portfolio.platform.data.source;

import com.fossil.ciw;
import com.fossil.emi;
import com.fossil.eru;

public final class PresetRepository_Factory implements emi<PresetRepository> {
    static final /* synthetic */ boolean $assertionsDisabled = (!PresetRepository_Factory.class.desiredAssertionStatus());
    private final eru<ciw> appExecutorsProvider;
    private final eru<PresetDataSource> mappingLocalSetDataSourceProvider;
    private final eru<PresetDataSource> mappingRemoteSetDataSourceProvider;

    public PresetRepository_Factory(eru<PresetDataSource> com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource, eru<PresetDataSource> com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource2, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource != null) {
            this.mappingRemoteSetDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource;
            if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource2 != null) {
                this.mappingLocalSetDataSourceProvider = com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource2;
                if ($assertionsDisabled || com_fossil_eru_com_fossil_ciw != null) {
                    this.appExecutorsProvider = com_fossil_eru_com_fossil_ciw;
                    return;
                }
                throw new AssertionError();
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }

    public PresetRepository get() {
        return new PresetRepository((PresetDataSource) this.mappingRemoteSetDataSourceProvider.get(), (PresetDataSource) this.mappingLocalSetDataSourceProvider.get(), (ciw) this.appExecutorsProvider.get());
    }

    public static emi<PresetRepository> create(eru<PresetDataSource> com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource, eru<PresetDataSource> com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource2, eru<ciw> com_fossil_eru_com_fossil_ciw) {
        return new PresetRepository_Factory(com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource, com_fossil_eru_com_portfolio_platform_data_source_PresetDataSource2, com_fossil_eru_com_fossil_ciw);
    }
}
