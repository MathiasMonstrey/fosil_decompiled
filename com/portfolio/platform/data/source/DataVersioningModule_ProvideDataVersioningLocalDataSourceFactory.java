package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory implements emi<DataVersioningDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory.class.desiredAssertionStatus());
    private final DataVersioningModule module;

    public DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory(DataVersioningModule dataVersioningModule) {
        if ($assertionsDisabled || dataVersioningModule != null) {
            this.module = dataVersioningModule;
            return;
        }
        throw new AssertionError();
    }

    public DataVersioningDataSource get() {
        return (DataVersioningDataSource) emj.f(this.module.provideDataVersioningLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<DataVersioningDataSource> create(DataVersioningModule dataVersioningModule) {
        return new DataVersioningModule_ProvideDataVersioningLocalDataSourceFactory(dataVersioningModule);
    }

    public static DataVersioningDataSource proxyProvideDataVersioningLocalDataSource(DataVersioningModule dataVersioningModule) {
        return dataVersioningModule.provideDataVersioningLocalDataSource();
    }
}
