package com.fossil;

import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public interface cfo<T> {
    T deserialize(cfp com_fossil_cfp, Type type, cfn com_fossil_cfn) throws JsonParseException;
}
