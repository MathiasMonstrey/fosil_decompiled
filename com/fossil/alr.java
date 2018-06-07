package com.fossil;

import com.fasterxml.jackson.core.JsonGenerator;

public abstract class alr {

    static final class C1673a extends ald {
        protected final Class<?>[] _views;
        protected final ald aUA;

        public /* synthetic */ ald mo1082b(amo com_fossil_amo) {
            return m3756d(com_fossil_amo);
        }

        protected C1673a(ald com_fossil_ald, Class<?>[] clsArr) {
            super(com_fossil_ald);
            this.aUA = com_fossil_ald;
            this._views = clsArr;
        }

        public C1673a m3756d(amo com_fossil_amo) {
            return new C1673a(this.aUA.mo1082b(com_fossil_amo), this._views);
        }

        public void mo1081a(ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.aUA.mo1081a((ahb) com_fossil_ahb_java_lang_Object);
        }

        public void mo1083b(ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.aUA.mo1083b((ahb) com_fossil_ahb_java_lang_Object);
        }

        public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
            Class activeView = com_fossil_ahg.getActiveView();
            if (activeView != null) {
                int i = 0;
                int length = this._views.length;
                while (i < length && !this._views[i].isAssignableFrom(activeView)) {
                    i++;
                }
                if (i == length) {
                    this.aUA.mo1073c(obj, jsonGenerator, com_fossil_ahg);
                    return;
                }
            }
            this.aUA.mo1072b(obj, jsonGenerator, com_fossil_ahg);
        }

        public void mo1074d(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
            Class activeView = com_fossil_ahg.getActiveView();
            if (activeView != null) {
                int i = 0;
                int length = this._views.length;
                while (i < length && !this._views[i].isAssignableFrom(activeView)) {
                    i++;
                }
                if (i == length) {
                    this.aUA.m3702e(obj, jsonGenerator, com_fossil_ahg);
                    return;
                }
            }
            this.aUA.mo1074d(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    static final class C1674b extends ald {
        protected final Class<?> _view;
        protected final ald aUA;

        public /* synthetic */ ald mo1082b(amo com_fossil_amo) {
            return m3763e(com_fossil_amo);
        }

        protected C1674b(ald com_fossil_ald, Class<?> cls) {
            super(com_fossil_ald);
            this.aUA = com_fossil_ald;
            this._view = cls;
        }

        public C1674b m3763e(amo com_fossil_amo) {
            return new C1674b(this.aUA.mo1082b(com_fossil_amo), this._view);
        }

        public void mo1081a(ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.aUA.mo1081a((ahb) com_fossil_ahb_java_lang_Object);
        }

        public void mo1083b(ahb<Object> com_fossil_ahb_java_lang_Object) {
            this.aUA.mo1083b((ahb) com_fossil_ahb_java_lang_Object);
        }

        public void mo1072b(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
            Class activeView = com_fossil_ahg.getActiveView();
            if (activeView == null || this._view.isAssignableFrom(activeView)) {
                this.aUA.mo1072b(obj, jsonGenerator, com_fossil_ahg);
            } else {
                this.aUA.mo1073c(obj, jsonGenerator, com_fossil_ahg);
            }
        }

        public void mo1074d(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws Exception {
            Class activeView = com_fossil_ahg.getActiveView();
            if (activeView == null || this._view.isAssignableFrom(activeView)) {
                this.aUA.mo1074d(obj, jsonGenerator, com_fossil_ahg);
            } else {
                this.aUA.m3702e(obj, jsonGenerator, com_fossil_ahg);
            }
        }
    }

    public static ald m3764a(ald com_fossil_ald, Class<?>[] clsArr) {
        if (clsArr.length == 1) {
            return new C1674b(com_fossil_ald, clsArr[0]);
        }
        return new C1673a(com_fossil_ald, clsArr);
    }
}
