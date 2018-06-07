package dagger.internal;

import com.fossil.emg;
import com.fossil.emj;

public final class MembersInjectors {

    enum NoOpMembersInjector implements emg<Object> {
        INSTANCE;

        public void injectMembers(Object obj) {
            emj.ce(obj);
        }
    }

    public static <T> T m16264a(emg<T> com_fossil_emg_T, T t) {
        com_fossil_emg_T.injectMembers(t);
        return t;
    }

    public static <T> emg<T> aEQ() {
        return NoOpMembersInjector.INSTANCE;
    }
}
