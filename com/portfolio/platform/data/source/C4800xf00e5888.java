package com.portfolio.platform.data.source;

import com.fossil.emi;
import com.fossil.emj;

public final class C4800xf00e5888 implements emi<NotificationsDataSource> {
    static final /* synthetic */ boolean $assertionsDisabled = (!C4800xf00e5888.class.desiredAssertionStatus());
    private final NotificationsRepositoryModule module;

    public C4800xf00e5888(NotificationsRepositoryModule notificationsRepositoryModule) {
        if ($assertionsDisabled || notificationsRepositoryModule != null) {
            this.module = notificationsRepositoryModule;
            return;
        }
        throw new AssertionError();
    }

    public NotificationsDataSource get() {
        return (NotificationsDataSource) emj.f(this.module.provideLocalNotificationsDataSource(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static emi<NotificationsDataSource> create(NotificationsRepositoryModule notificationsRepositoryModule) {
        return new C4800xf00e5888(notificationsRepositoryModule);
    }

    public static NotificationsDataSource proxyProvideLocalNotificationsDataSource(NotificationsRepositoryModule notificationsRepositoryModule) {
        return notificationsRepositoryModule.provideLocalNotificationsDataSource();
    }
}
