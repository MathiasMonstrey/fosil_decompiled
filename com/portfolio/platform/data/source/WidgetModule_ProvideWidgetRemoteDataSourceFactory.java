package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class WidgetModule_ProvideWidgetRemoteDataSourceFactory implements emi<WidgetDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!WidgetModule_ProvideWidgetRemoteDataSourceFactory.class.desiredAssertionStatus());
    private final WidgetModule module;

    public WidgetModule_ProvideWidgetRemoteDataSourceFactory(WidgetModule widgetModule) {
        if ($assertionsDisabled || widgetModule != null) {
            this.module = widgetModule;
            return;
        }
        throw new AssertionError();
    }

    public WidgetDataSource get() {
        return (WidgetDataSource) emj.f(this.module.provideWidgetRemoteDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<WidgetDataSource> create(WidgetModule widgetModule) {
        return new WidgetModule_ProvideWidgetRemoteDataSourceFactory(widgetModule);
    }

    public static WidgetDataSource proxyProvideWidgetRemoteDataSource(WidgetModule widgetModule) {
        return widgetModule.provideWidgetRemoteDataSource();
    }
}
