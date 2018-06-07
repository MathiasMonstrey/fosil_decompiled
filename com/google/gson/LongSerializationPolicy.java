package com.google.gson;

import com.fossil.cfp;
import com.fossil.cft;

public enum LongSerializationPolicy {
    DEFAULT {
        public cfp serialize(Long l) {
            return new cft(l);
        }
    },
    STRING {
        public cfp serialize(Long l) {
            return new cft(String.valueOf(l));
        }
    };

    public abstract cfp serialize(Long l);
}
