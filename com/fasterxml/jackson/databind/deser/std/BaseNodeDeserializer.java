package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fossil.agz;
import com.fossil.ajs;
import com.fossil.akh;
import com.fossil.akv;
import com.fossil.amr;
import java.io.IOException;

abstract class BaseNodeDeserializer<T extends agz> extends StdDeserializer<T> {
    public BaseNodeDeserializer(Class<T> cls) {
        super((Class) cls);
    }

    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, ajs com_fossil_ajs) throws IOException {
        return com_fossil_ajs.deserializeTypedFromAny(jsonParser, deserializationContext);
    }

    public boolean isCachable() {
        return true;
    }

    protected void _reportProblem(JsonParser jsonParser, String str) throws JsonMappingException {
        throw new JsonMappingException(str, jsonParser.zY());
    }

    protected void _handleDuplicateField(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, akv com_fossil_akv, agz com_fossil_agz, agz com_fossil_agz2) throws JsonProcessingException {
        if (deserializationContext.isEnabled(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            _reportProblem(jsonParser, "Duplicate field '" + str + "' for ObjectNode: not allowed when FAIL_ON_READING_DUP_TREE_KEY enabled");
        }
    }

    protected final akv deserializeObject(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        String zR;
        akv objectNode = jsonNodeFactory.objectNode();
        if (jsonParser.Ab()) {
            zR = jsonParser.zR();
        } else {
            JsonToken zU = jsonParser.zU();
            if (zU != JsonToken.END_OBJECT) {
                if (zU != JsonToken.FIELD_NAME) {
                    throw deserializationContext.mappingException(handledType(), jsonParser.zU());
                }
                zR = jsonParser.zW();
            }
            return objectNode;
        }
        while (zR != null) {
            agz deserializeObject;
            switch (jsonParser.zP().id()) {
                case 1:
                    deserializeObject = deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                case 3:
                    deserializeObject = deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                case 6:
                    deserializeObject = jsonNodeFactory.textNode(jsonParser.getText());
                    break;
                case 7:
                    deserializeObject = _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                case 9:
                    deserializeObject = jsonNodeFactory.booleanNode(true);
                    break;
                case 10:
                    deserializeObject = jsonNodeFactory.booleanNode(false);
                    break;
                case 11:
                    deserializeObject = jsonNodeFactory.nullNode();
                    break;
                case 12:
                    deserializeObject = _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
                default:
                    deserializeObject = deserializeAny(jsonParser, deserializationContext, jsonNodeFactory);
                    break;
            }
            agz b = objectNode.m3672b(zR, deserializeObject);
            if (b != null) {
                _handleDuplicateField(jsonParser, deserializationContext, jsonNodeFactory, zR, objectNode, b, deserializeObject);
            }
            zR = jsonParser.zR();
        }
        return objectNode;
    }

    protected final akh deserializeArray(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        akh arrayNode = jsonNodeFactory.arrayNode();
        while (true) {
            JsonToken zP = jsonParser.zP();
            if (zP == null) {
                throw deserializationContext.mappingException("Unexpected end-of-input when binding data into ArrayNode");
            }
            switch (zP.id()) {
                case 1:
                    arrayNode.m3659a(deserializeObject(jsonParser, deserializationContext, jsonNodeFactory));
                    continue;
                case 3:
                    arrayNode.m3659a(deserializeArray(jsonParser, deserializationContext, jsonNodeFactory));
                    continue;
                case 4:
                    return arrayNode;
                case 6:
                    break;
                case 7:
                    arrayNode.m3659a(_fromInt(jsonParser, deserializationContext, jsonNodeFactory));
                    continue;
                case 9:
                    arrayNode.m3659a(jsonNodeFactory.booleanNode(true));
                    continue;
                case 10:
                    arrayNode.m3659a(jsonNodeFactory.booleanNode(false));
                    continue;
                case 11:
                    arrayNode.m3659a(jsonNodeFactory.nullNode());
                    continue;
                case 12:
                    arrayNode.m3659a(_fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                default:
                    arrayNode.m3659a(deserializeAny(jsonParser, deserializationContext, jsonNodeFactory));
                    continue;
            }
            arrayNode.m3659a(jsonNodeFactory.textNode(jsonParser.getText()));
        }
    }

    protected final agz deserializeAny(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        switch (jsonParser.zV()) {
            case 1:
            case 2:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 3:
                return deserializeArray(jsonParser, deserializationContext, jsonNodeFactory);
            case 5:
                return deserializeObject(jsonParser, deserializationContext, jsonNodeFactory);
            case 6:
                return jsonNodeFactory.textNode(jsonParser.getText());
            case 7:
                return _fromInt(jsonParser, deserializationContext, jsonNodeFactory);
            case 8:
                return _fromFloat(jsonParser, deserializationContext, jsonNodeFactory);
            case 9:
                return jsonNodeFactory.booleanNode(true);
            case 10:
                return jsonNodeFactory.booleanNode(false);
            case 11:
                return jsonNodeFactory.nullNode();
            case 12:
                return _fromEmbedded(jsonParser, deserializationContext, jsonNodeFactory);
            default:
                throw deserializationContext.mappingException(handledType());
        }
    }

    protected final agz _fromInt(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        NumberType Ai;
        int deserializationFeatures = deserializationContext.getDeserializationFeatures();
        if ((F_MASK_INT_COERCIONS & deserializationFeatures) == 0) {
            Ai = jsonParser.Ai();
        } else if (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.enabledIn(deserializationFeatures)) {
            Ai = NumberType.BIG_INTEGER;
        } else if (DeserializationFeature.USE_LONG_FOR_INTS.enabledIn(deserializationFeatures)) {
            Ai = NumberType.LONG;
        } else {
            Ai = jsonParser.Ai();
        }
        if (Ai == NumberType.INT) {
            return jsonNodeFactory.numberNode(jsonParser.getIntValue());
        }
        if (Ai == NumberType.LONG) {
            return jsonNodeFactory.numberNode(jsonParser.Al());
        }
        return jsonNodeFactory.numberNode(jsonParser.Am());
    }

    protected final agz _fromFloat(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        if (jsonParser.Ai() == NumberType.BIG_DECIMAL || deserializationContext.isEnabled(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
            return jsonNodeFactory.numberNode(jsonParser.Ap());
        }
        return jsonNodeFactory.numberNode(jsonParser.Ao());
    }

    protected final agz _fromEmbedded(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws IOException {
        Object Aq = jsonParser.Aq();
        if (Aq == null) {
            return jsonNodeFactory.nullNode();
        }
        if (Aq.getClass() == byte[].class) {
            return jsonNodeFactory.binaryNode((byte[]) Aq);
        }
        if (Aq instanceof amr) {
            return jsonNodeFactory.rawValueNode((amr) Aq);
        }
        if (Aq instanceof agz) {
            return (agz) Aq;
        }
        return jsonNodeFactory.pojoNode(Aq);
    }
}
