package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fossil.agz;
import com.fossil.aha;
import com.fossil.aha.C1637a;
import com.fossil.ahg;
import com.fossil.ahh;
import com.fossil.ajg;
import com.fossil.ajp;
import com.fossil.ajv;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

@ahh
public class SerializableSerializer extends StdSerializer<aha> {
    private static final AtomicReference<ObjectMapper> aVb = new AtomicReference();
    public static final SerializableSerializer instance = new SerializableSerializer();

    protected SerializableSerializer() {
        super(aha.class);
    }

    public boolean isEmpty(ahg com_fossil_ahg, aha com_fossil_aha) {
        if (com_fossil_aha instanceof C1637a) {
            return ((C1637a) com_fossil_aha).mo1055a(com_fossil_ahg);
        }
        return false;
    }

    public void serialize(aha com_fossil_aha, JsonGenerator jsonGenerator, ahg com_fossil_ahg) throws IOException {
        com_fossil_aha.serialize(jsonGenerator, com_fossil_ahg);
    }

    public final void serializeWithType(aha com_fossil_aha, JsonGenerator jsonGenerator, ahg com_fossil_ahg, ajv com_fossil_ajv) throws IOException {
        com_fossil_aha.serializeWithType(jsonGenerator, com_fossil_ahg, com_fossil_ajv);
    }

    public agz getSchema(ahg com_fossil_ahg, Type type) throws JsonMappingException {
        String str;
        String str2 = null;
        agz createObjectNode = createObjectNode();
        String str3 = "any";
        if (type != null) {
            Class rawClass = TypeFactory.rawClass(type);
            if (rawClass.isAnnotationPresent(ajp.class)) {
                ajp com_fossil_ajp = (ajp) rawClass.getAnnotation(ajp.class);
                String Gf = com_fossil_ajp.Gf();
                if ("##irrelevant".equals(com_fossil_ajp.Gg())) {
                    str = null;
                } else {
                    str = com_fossil_ajp.Gg();
                }
                if ("##irrelevant".equals(com_fossil_ajp.Gh())) {
                    str3 = Gf;
                } else {
                    str2 = com_fossil_ajp.Gh();
                    str3 = Gf;
                }
                createObjectNode.m3675t("type", str3);
                if (str != null) {
                    try {
                        createObjectNode.m3669a("properties", GP().readTree(str));
                    } catch (IOException e) {
                        throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaObjectPropertiesDefinition value");
                    }
                }
                if (str2 != null) {
                    try {
                        createObjectNode.m3669a("items", GP().readTree(str2));
                    } catch (IOException e2) {
                        throw new JsonMappingException("Failed to parse @JsonSerializableSchema.schemaItemDefinition value");
                    }
                }
                return createObjectNode;
            }
        }
        str = null;
        createObjectNode.m3675t("type", str3);
        if (str != null) {
            createObjectNode.m3669a("properties", GP().readTree(str));
        }
        if (str2 != null) {
            createObjectNode.m3669a("items", GP().readTree(str2));
        }
        return createObjectNode;
    }

    private static final synchronized ObjectMapper GP() {
        ObjectMapper objectMapper;
        synchronized (SerializableSerializer.class) {
            objectMapper = (ObjectMapper) aVb.get();
            if (objectMapper == null) {
                objectMapper = new ObjectMapper();
                aVb.set(objectMapper);
            }
        }
        return objectMapper;
    }

    public void acceptJsonFormatVisitor(ajg com_fossil_ajg, JavaType javaType) throws JsonMappingException {
        com_fossil_ajg.mo1023k(javaType);
    }
}
