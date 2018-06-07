package com.portfolio.platform.data.source.loader;

import com.fossil.emg;
import com.fossil.eru;
import com.portfolio.platform.data.source.WidgetRepository;

public final class WidgetLoader_MembersInjector implements emg<WidgetLoader> {
    static final /* synthetic */ boolean $assertionsDisabled = (!WidgetLoader_MembersInjector.class.desiredAssertionStatus());
    private final eru<WidgetRepository> mRepositoryProvider;

    public WidgetLoader_MembersInjector(eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository) {
        if ($assertionsDisabled || com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository != null) {
            this.mRepositoryProvider = com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository;
            return;
        }
        throw new AssertionError();
    }

    public static emg<WidgetLoader> create(eru<WidgetRepository> com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository) {
        return new WidgetLoader_MembersInjector(com_fossil_eru_com_portfolio_platform_data_source_WidgetRepository);
    }

    public void injectMembers(WidgetLoader widgetLoader) {
        if (widgetLoader == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        widgetLoader.mRepository = (WidgetRepository) this.mRepositoryProvider.get();
    }
}
