package retrofit.client;

import com.fossil.dve;
import com.fossil.dvh;
import com.fossil.dvi;
import com.fossil.dvj;
import com.fossil.dvj.a;
import com.fossil.dvk;
import com.fossil.dvl;
import com.fossil.dvm;
import com.fossil.eti;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class OkClient implements Client {
    private final dvi client;

    private static dvi generateDefaultOkHttp() {
        dvi com_fossil_dvi = new dvi();
        com_fossil_dvi.c(15000, TimeUnit.MILLISECONDS);
        com_fossil_dvi.d(20000, TimeUnit.MILLISECONDS);
        return com_fossil_dvi;
    }

    public OkClient() {
        this(generateDefaultOkHttp());
    }

    public OkClient(dvi com_fossil_dvi) {
        if (com_fossil_dvi == null) {
            throw new NullPointerException("client == null");
        }
        this.client = com_fossil_dvi;
    }

    public Response execute(Request request) throws IOException {
        return parseResponse(this.client.c(createRequest(request)).ayt());
    }

    static dvj createRequest(Request request) {
        a a = new a().kL(request.getUrl()).a(request.getMethod(), createRequestBody(request.getBody()));
        List headers = request.getHeaders();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            Header header = (Header) headers.get(i);
            String value = header.getValue();
            if (value == null) {
                value = "";
            }
            a.aZ(header.getName(), value);
        }
        return a.azx();
    }

    static Response parseResponse(dvl com_fossil_dvl) {
        return new Response(com_fossil_dvl.azy().azr(), com_fossil_dvl.azA(), com_fossil_dvl.message(), createHeaders(com_fossil_dvl.azt()), createResponseBody(com_fossil_dvl.azC()));
    }

    private static dvk createRequestBody(final TypedOutput typedOutput) {
        if (typedOutput == null) {
            return null;
        }
        final dvh kJ = dvh.kJ(typedOutput.mimeType());
        return new dvk() {
            public dvh contentType() {
                return kJ;
            }

            public void writeTo(eti com_fossil_eti) throws IOException {
                typedOutput.writeTo(com_fossil_eti.aHf());
            }

            public long contentLength() {
                return typedOutput.length();
            }
        };
    }

    private static TypedInput createResponseBody(final dvm com_fossil_dvm) {
        if (com_fossil_dvm.contentLength() == 0) {
            return null;
        }
        return new TypedInput() {
            public String mimeType() {
                dvh contentType = com_fossil_dvm.contentType();
                return contentType == null ? null : contentType.toString();
            }

            public long length() {
                return com_fossil_dvm.contentLength();
            }

            public InputStream in() throws IOException {
                return com_fossil_dvm.azG();
            }
        };
    }

    private static List<Header> createHeaders(dve com_fossil_dve) {
        int size = com_fossil_dve.size();
        List<Header> arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new Header(com_fossil_dve.my(i), com_fossil_dve.mz(i)));
        }
        return arrayList;
    }
}
