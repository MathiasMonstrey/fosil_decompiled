package com.fossil;

import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonToken;

public interface afe {
    JsonToken AE();

    NumberType AF();
}
