package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4801x106f6963 implements emi<NotificationsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4801x106f6963.class.desiredAssertionStatus());
    private final NotificationsRepositoryModule module;

    public C4801x106f6963(NotificationsRepositoryModule notificationsRepositoryModule) {
        if ($assertionsDisabled || notificationsRepositoryModule != null) {
            this.module = notificationsRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public NotificationsDataSource get() {
        return (NotificationsDataSource) emj.f(this.module.provideRemoteNotificationsDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<NotificationsDataSource> create(NotificationsRepositoryModule notificationsRepositoryModule) {
        return new C4801x106f6963(notificationsRepositoryModule);
    }

    public static NotificationsDataSource proxyProvideRemoteNotificationsDataSource(NotificationsRepositoryModule notificationsRepositoryModule) {
        return notificationsRepositoryModule.provideRemoteNotificationsDataSource();
    }
}
