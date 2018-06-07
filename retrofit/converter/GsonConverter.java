package retrofit.converter;

import com.fossil.cfj;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class GsonConverter implements Converter {
    private String charset;
    private final cfj gson;

    static class JsonTypedOutput implements TypedOutput {
        private final byte[] jsonBytes;
        private final String mimeType;

        JsonTypedOutput(byte[] bArr, String str) {
            this.jsonBytes = bArr;
            this.mimeType = "application/json; charset=" + str;
        }

        public String fileName() {
            return null;
        }

        public String mimeType() {
            return this.mimeType;
        }

        public long length() {
            return (long) this.jsonBytes.length;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.jsonBytes);
        }
    }

    public GsonConverter(cfj com_fossil_cfj) {
        this(com_fossil_cfj, "UTF-8");
    }

    public GsonConverter(cfj com_fossil_cfj, String str) {
        this.gson = com_fossil_cfj;
        this.charset = str;
    }

    public Object fromBody(TypedInput typedInput, Type type) throws ConversionException {
        Reader inputStreamReader;
        Throwable e;
        String str = this.charset;
        if (typedInput.mimeType() != null) {
            str = MimeUtil.parseCharset(typedInput.mimeType(), str);
        }
        InputStreamReader inputStreamReader2 = null;
        try {
            inputStreamReader = new InputStreamReader(typedInput.in(), str);
            try {
                Object a = this.gson.a(inputStreamReader, type);
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e2) {
                    }
                }
                return a;
            } catch (IOException e3) {
                e = e3;
                try {
                    throw new ConversionException(e);
                } catch (Throwable th) {
                    e = th;
                    inputStreamReader2 = inputStreamReader;
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw e;
                }
            } catch (JsonParseException e5) {
                e = e5;
                Reader reader = inputStreamReader;
                try {
                    throw new ConversionException(e);
                } catch (Throwable th2) {
                    e = th2;
                    if (inputStreamReader2 != null) {
                        inputStreamReader2.close();
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            inputStreamReader = null;
            throw new ConversionException(e);
        } catch (JsonParseException e7) {
            e = e7;
            throw new ConversionException(e);
        }
    }

    public TypedOutput toBody(Object obj) {
        try {
            return new JsonTypedOutput(this.gson.toJson(obj).getBytes(this.charset), this.charset);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }
}
