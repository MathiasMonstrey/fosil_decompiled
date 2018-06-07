package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class WidgetModule_ProvideWidgetLocalDataSourceFactory implements emi<WidgetDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!WidgetModule_ProvideWidgetLocalDataSourceFactory.class.desiredAssertionStatus());
    private final WidgetModule module;

    public WidgetModule_ProvideWidgetLocalDataSourceFactory(WidgetModule widgetModule) {
        if ($assertionsDisabled || widgetModule != null) {
            this.module = widgetModule;
            return;
        }
        throw new AssertionError();
    }

    public WidgetDataSource get() {
        return (WidgetDataSource) emj.f(this.module.provideWidgetLocalDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<WidgetDataSource> create(WidgetModule widgetModule) {
        return new WidgetModule_ProvideWidgetLocalDataSourceFactory(widgetModule);
    }

    public static WidgetDataSource proxyProvideWidgetLocalDataSource(WidgetModule widgetModule) {
        return widgetModule.provideWidgetLocalDataSource();
    }
}
