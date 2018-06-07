package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fossil.ahg;
import com.fossil.ajl;
import com.fossil.akv;
import com.fossil.alc;
import com.fossil.ald;
import com.fossil.alj;
import com.fossil.alk;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SimpleBeanPropertyFilter implements alc, alj {

    public static class FilterExceptFilter extends SimpleBeanPropertyFilter implements Serializable {
        private static final long serialVersionUID = 1;
        protected final Set<String> _propertiesToInclude;

        public FilterExceptFilter(Set<String> set) {
            this._propertiesToInclude = set;
        }

        protected boolean include(ald com_fossil_ald) {
            return this._propertiesToInclude.contains(com_fossil_ald.getName());
        }

        protected boolean include(alk com_fossil_alk) {
            return this._propertiesToInclude.contains(com_fossil_alk.getName());
        }
    }

    public static class SerializeExceptFilter extends SimpleBeanPropertyFilter implements Serializable {
        static final SerializeExceptFilter INCLUDE_ALL = new SerializeExceptFilter();
        private static final long serialVersionUID = 1;
        protected final Set<String> _propertiesToExclude;

        SerializeExceptFilter() {
            this._propertiesToExclude = Collections.emptySet();
        }

        public SerializeExceptFilter(Set<String> set) {
            this._propertiesToExclude = set;
        }

        protected boolean include(ald com_fossil_ald) {
            return !this._propertiesToExclude.contains(com_fossil_ald.getName());
        }

        protected boolean include(alk com_fossil_alk) {
            return !this._propertiesToExclude.contains(com_fossil_alk.getName());
        }
    }

    protected SimpleBeanPropertyFilter() {
    }

    public static SimpleBeanPropertyFilter serializeAll() {
        return SerializeExceptFilter.INCLUDE_ALL;
    }

    @Deprecated
    public static SimpleBeanPropertyFilter serializeAll(Set<String> set) {
        return new FilterExceptFilter(set);
    }

    public static SimpleBeanPropertyFilter filterOutAllExcept(Set<String> set) {
        return new FilterExceptFilter(set);
    }

    public static SimpleBeanPropertyFilter filterOutAllExcept(String... strArr) {
        Object hashSet = new HashSet(strArr.length);
        Collections.addAll(hashSet, strArr);
        return new FilterExceptFilter(hashSet);
    }

    public static SimpleBeanPropertyFilter serializeAllExcept(Set<String> set) {
        return new SerializeExceptFilter(set);
    }

    public static SimpleBeanPropertyFilter serializeAllExcept(String... strArr) {
        Object hashSet = new HashSet(strArr.length);
        Collections.addAll(hashSet, strArr);
        return new SerializeExceptFilter(hashSet);
    }

    public static alj from(final alc com_fossil_alc) {
        return new alj() {
            public void serializeAsField(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alk com_fossil_alk) throws Exception {
                com_fossil_alc.serializeAsField(obj, jsonGenerator, com_fossil_ahg, (ald) com_fossil_alk);
            }

            public void depositSchemaProperty(alk com_fossil_alk, akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException {
                com_fossil_alc.depositSchemaProperty((ald) com_fossil_alk, com_fossil_akv, com_fossil_ahg);
            }

            public void depositSchemaProperty(alk com_fossil_alk, ajl com_fossil_ajl, ahg com_fossil_ahg) throws JsonMappingException {
                com_fossil_alc.depositSchemaProperty((ald) com_fossil_alk, com_fossil_ajl, com_fossil_ahg);
            }
        };
    }

    protected boolean include(ald com_fossil_ald) {
        return true;
    }

    protected boolean include(alk com_fossil_alk) {
        return true;
    }

    protected boolean includeElement(Object obj) {
        return true;
    }

    @Deprecated
    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ald com_fossil_ald) throws Exception {
        if (include(com_fossil_ald)) {
            com_fossil_ald.mo1072b(obj, jsonGenerator, com_fossil_ahg);
        } else if (!jsonGenerator.zG()) {
            com_fossil_ald.mo1073c(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    @Deprecated
    public void depositSchemaProperty(ald com_fossil_ald, akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException {
        if (include(com_fossil_ald)) {
            com_fossil_ald.mo1071a(com_fossil_akv, com_fossil_ahg);
        }
    }

    @Deprecated
    public void depositSchemaProperty(ald com_fossil_ald, ajl com_fossil_ajl, ahg com_fossil_ahg) throws JsonMappingException {
        if (include(com_fossil_ald)) {
            com_fossil_ald.depositSchemaProperty(com_fossil_ajl);
        }
    }

    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alk com_fossil_alk) throws Exception {
        if (include(com_fossil_alk)) {
            com_fossil_alk.mo1072b(obj, jsonGenerator, com_fossil_ahg);
        } else if (!jsonGenerator.zG()) {
            com_fossil_alk.mo1073c(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    public void serializeAsElement(Object obj, JsonGenerator jsonGenerator, ahg com_fossil_ahg, alk com_fossil_alk) throws Exception {
        if (includeElement(obj)) {
            com_fossil_alk.mo1074d(obj, jsonGenerator, com_fossil_ahg);
        }
    }

    @Deprecated
    public void depositSchemaProperty(alk com_fossil_alk, akv com_fossil_akv, ahg com_fossil_ahg) throws JsonMappingException {
        if (include(com_fossil_alk)) {
            com_fossil_alk.mo1071a(com_fossil_akv, com_fossil_ahg);
        }
    }

    public void depositSchemaProperty(alk com_fossil_alk, ajl com_fossil_ajl, ahg com_fossil_ahg) throws JsonMappingException {
        if (include(com_fossil_alk)) {
            com_fossil_alk.depositSchemaProperty(com_fossil_ajl);
        }
    }
}
