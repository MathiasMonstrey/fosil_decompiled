package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4761x9c0a2c29 implements emi<DataVersioningDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4761x9c0a2c29.class.desiredAssertionStatus());
    private final DataVersioningModule module;

    public C4761x9c0a2c29(DataVersioningModule dataVersioningModule) {
        if ($assertionsDisabled || dataVersioningModule != null) {
            this.module = dataVersioningModule;
            return;
        }
        throw new AssertionError();
    }

    public DataVersioningDataSource get() {
        return (DataVersioningDataSource) emj.f(this.module.provideDataVersioningRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<DataVersioningDataSource> create(DataVersioningModule dataVersioningModule) {
        return new C4761x9c0a2c29(dataVersioningModule);
    }

    public static DataVersioningDataSource proxyProvideDataVersioningRemoteDataSource(DataVersioningModule dataVersioningModule) {
        return dataVersioningModule.provideDataVersioningRemoteDataSource();
    }
}
