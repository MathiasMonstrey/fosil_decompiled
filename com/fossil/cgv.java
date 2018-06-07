package com.fossil;

import com.facebook.internal.ServerProtocol;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class cgv implements Closeable {
    private static final char[] bUc = ")]}'\n".toCharArray();
    private boolean bQT = false;
    private int bSi = 0;
    private String[] bSj;
    private int[] bSk;
    private final char[] bUd = new char[1024];
    private int bUe = 0;
    private int bUf = 0;
    int bUg = 0;
    private long bUh;
    private int bUi;
    private String bUj;
    private int[] bUk = new int[32];
    private final Reader in;
    private int limit = 0;
    private int pos = 0;

    static class C20621 extends cgf {
        C20621() {
        }

        public void mo1698h(cgv com_fossil_cgv) throws IOException {
            if (com_fossil_cgv instanceof cgm) {
                ((cgm) com_fossil_cgv).WW();
                return;
            }
            int i = com_fossil_cgv.bUg;
            if (i == 0) {
                i = com_fossil_cgv.Xf();
            }
            if (i == 13) {
                com_fossil_cgv.bUg = 9;
            } else if (i == 12) {
                com_fossil_cgv.bUg = 8;
            } else if (i == 14) {
                com_fossil_cgv.bUg = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + com_fossil_cgv.WT() + com_fossil_cgv.WX());
            }
        }
    }

    static {
        cgf.bRH = new C20621();
    }

    public cgv(Reader reader) {
        int[] iArr = this.bUk;
        int i = this.bSi;
        this.bSi = i + 1;
        iArr[i] = 6;
        this.bSj = new String[32];
        this.bSk = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    public final void setLenient(boolean z) {
        this.bQT = z;
    }

    public final boolean isLenient() {
        return this.bQT;
    }

    public void beginArray() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 3) {
            iS(1);
            this.bSk[this.bSi - 1] = 0;
            this.bUg = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + WT() + WX());
    }

    public void endArray() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 4) {
            this.bSi--;
            int[] iArr = this.bSk;
            int i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bUg = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + WT() + WX());
    }

    public void beginObject() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 1) {
            iS(3);
            this.bUg = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + WT() + WX());
    }

    public void endObject() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 2) {
            this.bSi--;
            this.bSj[this.bSi] = null;
            int[] iArr = this.bSk;
            int i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
            this.bUg = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + WT() + WX());
    }

    public boolean hasNext() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken WT() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    int Xf() throws IOException {
        int bH;
        int i = this.bUk[this.bSi - 1];
        if (i == 1) {
            this.bUk[this.bSi - 1] = 2;
        } else if (i == 2) {
            switch (bH(true)) {
                case 44:
                    break;
                case 59:
                    Xk();
                    break;
                case 93:
                    this.bUg = 4;
                    return 4;
                default:
                    throw fx("Unterminated array");
            }
        } else if (i == 3 || i == 5) {
            this.bUk[this.bSi - 1] = 4;
            if (i == 5) {
                switch (bH(true)) {
                    case 44:
                        break;
                    case 59:
                        Xk();
                        break;
                    case 125:
                        this.bUg = 2;
                        return 2;
                    default:
                        throw fx("Unterminated object");
                }
            }
            bH = bH(true);
            switch (bH) {
                case 34:
                    this.bUg = 13;
                    return 13;
                case 39:
                    Xk();
                    this.bUg = 12;
                    return 12;
                case 125:
                    if (i != 5) {
                        this.bUg = 2;
                        return 2;
                    }
                    throw fx("Expected name");
                default:
                    Xk();
                    this.pos--;
                    if (m6251d((char) bH)) {
                        this.bUg = 14;
                        return 14;
                    }
                    throw fx("Expected name");
            }
        } else if (i == 4) {
            this.bUk[this.bSi - 1] = 5;
            switch (bH(true)) {
                case 58:
                    break;
                case 61:
                    Xk();
                    if ((this.pos < this.limit || iT(1)) && this.bUd[this.pos] == '>') {
                        this.pos++;
                        break;
                    }
                default:
                    throw fx("Expected ':'");
            }
        } else if (i == 6) {
            if (this.bQT) {
                Xn();
            }
            this.bUk[this.bSi - 1] = 7;
        } else if (i == 7) {
            if (bH(false) == -1) {
                this.bUg = 17;
                return 17;
            }
            Xk();
            this.pos--;
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        switch (bH(true)) {
            case 34:
                this.bUg = 9;
                return 9;
            case 39:
                Xk();
                this.bUg = 8;
                return 8;
            case 44:
            case 59:
                break;
            case 91:
                this.bUg = 3;
                return 3;
            case 93:
                if (i == 1) {
                    this.bUg = 4;
                    return 4;
                }
                break;
            case 123:
                this.bUg = 1;
                return 1;
            default:
                this.pos--;
                bH = Xg();
                if (bH != 0) {
                    return bH;
                }
                bH = Xh();
                if (bH != 0) {
                    return bH;
                }
                if (m6251d(this.bUd[this.pos])) {
                    Xk();
                    this.bUg = 10;
                    return 10;
                }
                throw fx("Expected value");
        }
        if (i == 1 || i == 2) {
            Xk();
            this.pos--;
            this.bUg = 7;
            return 7;
        }
        throw fx("Unexpected value");
    }

    private int Xg() throws IOException {
        String str;
        int i;
        char c = this.bUd[this.pos];
        String str2;
        if (c == 't' || c == 'T') {
            str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            if (this.pos + i2 >= this.limit && !iT(i2 + 1)) {
                return 0;
            }
            char c2 = this.bUd[this.pos + i2];
            if (c2 != str.charAt(i2) && c2 != r1.charAt(i2)) {
                return 0;
            }
            i2++;
        }
        if ((this.pos + length < this.limit || iT(length + 1)) && m6251d(this.bUd[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.bUg = i;
        return i;
    }

    private int Xh() throws IOException {
        char[] cArr = this.bUd;
        int i = this.pos;
        long j = 0;
        Object obj = null;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        int i5 = this.limit;
        int i6 = i;
        while (true) {
            Object obj2;
            if (i6 + i4 == i5) {
                if (i4 == cArr.length) {
                    return 0;
                }
                if (iT(i4 + 1)) {
                    i6 = this.pos;
                    i5 = this.limit;
                } else if (i3 != 2 && i2 != 0 && (j != Long.MIN_VALUE || obj != null)) {
                    if (obj == null) {
                        j = -j;
                    }
                    this.bUh = j;
                    this.pos += i4;
                    this.bUg = 15;
                    return 15;
                } else if (i3 == 2 && i3 != 4 && i3 != 7) {
                    return 0;
                } else {
                    this.bUi = i4;
                    this.bUg = 16;
                    return 16;
                }
            }
            char c = cArr[i6 + i4];
            int i7;
            switch (c) {
                case '+':
                    if (i3 != 5) {
                        return 0;
                    }
                    i = 6;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case '-':
                    if (i3 == 0) {
                        i = 1;
                        i7 = i2;
                        obj2 = 1;
                        i3 = i7;
                        continue;
                    } else if (i3 == 5) {
                        i = 6;
                        i3 = i2;
                        obj2 = obj;
                        break;
                    } else {
                        return 0;
                    }
                case '.':
                    if (i3 != 2) {
                        return 0;
                    }
                    i = 3;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                case 'E':
                case 'e':
                    if (i3 != 2 && i3 != 4) {
                        return 0;
                    }
                    i = 5;
                    i3 = i2;
                    obj2 = obj;
                    continue;
                default:
                    if (c >= '0' && c <= '9') {
                        if (i3 != 1 && i3 != 0) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 != 5 && i3 != 6) {
                                        i = i3;
                                        i3 = i2;
                                        obj2 = obj;
                                        break;
                                    }
                                    i = 7;
                                    i3 = i2;
                                    obj2 = obj;
                                    break;
                                }
                                i = 4;
                                i3 = i2;
                                obj2 = obj;
                                break;
                            } else if (j != 0) {
                                long j2 = (10 * j) - ((long) (c - 48));
                                i = (j > -922337203685477580L || (j == -922337203685477580L && j2 < j)) ? 1 : 0;
                                i &= i2;
                                obj2 = obj;
                                j = j2;
                                i7 = i3;
                                i3 = i;
                                i = i7;
                                break;
                            } else {
                                return 0;
                            }
                        }
                        j = (long) (-(c - 48));
                        i = 2;
                        i3 = i2;
                        obj2 = obj;
                        continue;
                    } else if (m6251d(c)) {
                        return 0;
                    }
                    break;
            }
            if (i3 != 2) {
            }
            if (i3 == 2) {
            }
            this.bUi = i4;
            this.bUg = 16;
            return 16;
            i4++;
            obj = obj2;
            i2 = i3;
            i3 = i;
        }
    }

    private boolean m6251d(char c) throws IOException {
        switch (c) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case ' ':
            case ',':
            case ':':
            case '[':
            case ']':
            case '{':
            case '}':
                break;
            case '#':
            case '/':
            case ';':
            case '=':
            case '\\':
                Xk();
                break;
            default:
                return true;
        }
        return false;
    }

    public String nextName() throws IOException {
        String Xi;
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 14) {
            Xi = Xi();
        } else if (i == 12) {
            Xi = m6252e('\'');
        } else if (i == 13) {
            Xi = m6252e('\"');
        } else {
            throw new IllegalStateException("Expected a name but was " + WT() + WX());
        }
        this.bUg = 0;
        this.bSj[this.bSi - 1] = Xi;
        return Xi;
    }

    public String nextString() throws IOException {
        String Xi;
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 10) {
            Xi = Xi();
        } else if (i == 8) {
            Xi = m6252e('\'');
        } else if (i == 9) {
            Xi = m6252e('\"');
        } else if (i == 11) {
            Xi = this.bUj;
            this.bUj = null;
        } else if (i == 15) {
            Xi = Long.toString(this.bUh);
        } else if (i == 16) {
            Xi = new String(this.bUd, this.pos, this.bUi);
            this.pos += this.bUi;
        } else {
            throw new IllegalStateException("Expected a string but was " + WT() + WX());
        }
        this.bUg = 0;
        int[] iArr = this.bSk;
        int i2 = this.bSi - 1;
        iArr[i2] = iArr[i2] + 1;
        return Xi;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 5) {
            this.bUg = 0;
            int[] iArr = this.bSk;
            i = this.bSi - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        } else if (i == 6) {
            this.bUg = 0;
            int[] iArr2 = this.bSk;
            int i2 = this.bSi - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + WT() + WX());
        }
    }

    public void nextNull() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 7) {
            this.bUg = 0;
            int[] iArr = this.bSk;
            int i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + WT() + WX());
    }

    public double nextDouble() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 15) {
            this.bUg = 0;
            int[] iArr = this.bSk;
            int i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.bUh;
        }
        if (i == 16) {
            this.bUj = new String(this.bUd, this.pos, this.bUi);
            this.pos += this.bUi;
        } else if (i == 8 || i == 9) {
            this.bUj = m6252e(i == 8 ? '\'' : '\"');
        } else if (i == 10) {
            this.bUj = Xi();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + WT() + WX());
        }
        this.bUg = 11;
        double parseDouble = Double.parseDouble(this.bUj);
        if (this.bQT || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.bUj = null;
            this.bUg = 0;
            int[] iArr2 = this.bSk;
            int i3 = this.bSi - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + WX());
    }

    public long nextLong() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        if (i == 15) {
            this.bUg = 0;
            int[] iArr = this.bSk;
            int i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.bUh;
        }
        long parseLong;
        if (i == 16) {
            this.bUj = new String(this.bUd, this.pos, this.bUi);
            this.pos += this.bUi;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.bUj = Xi();
            } else {
                this.bUj = m6252e(i == 8 ? '\'' : '\"');
            }
            try {
                parseLong = Long.parseLong(this.bUj);
                this.bUg = 0;
                int[] iArr2 = this.bSk;
                int i3 = this.bSi - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException e) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + WT() + WX());
        }
        this.bUg = 11;
        double parseDouble = Double.parseDouble(this.bUj);
        parseLong = (long) parseDouble;
        if (((double) parseLong) != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.bUj + WX());
        }
        this.bUj = null;
        this.bUg = 0;
        iArr2 = this.bSk;
        i3 = this.bSi - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return parseLong;
    }

    private String m6252e(char c) throws IOException {
        char[] cArr = this.bUd;
        StringBuilder stringBuilder = new StringBuilder();
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                int i4 = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    return stringBuilder.toString();
                }
                if (c2 == '\\') {
                    this.pos = i4;
                    stringBuilder.append(cArr, i, (i4 - i) - 1);
                    stringBuilder.append(Xm());
                    i = this.pos;
                    i2 = this.limit;
                    i4 = i;
                } else if (c2 == '\n') {
                    this.bUe++;
                    this.bUf = i4;
                }
                i3 = i4;
            }
            stringBuilder.append(cArr, i, i3 - i);
            this.pos = i3;
        } while (iT(1));
        throw fx("Unterminated string");
    }

    private String Xi() throws IOException {
        StringBuilder stringBuilder = null;
        int i = 0;
        while (true) {
            String str;
            if (this.pos + i < this.limit) {
                switch (this.bUd[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        Xk();
                        break;
                    default:
                        i++;
                        continue;
                }
            } else if (i >= this.bUd.length) {
                if (stringBuilder == null) {
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append(this.bUd, this.pos, i);
                this.pos = i + this.pos;
                if (iT(1)) {
                    i = 0;
                } else {
                    i = 0;
                }
            } else if (iT(i + 1)) {
            }
            if (stringBuilder == null) {
                str = new String(this.bUd, this.pos, i);
            } else {
                stringBuilder.append(this.bUd, this.pos, i);
                str = stringBuilder.toString();
            }
            this.pos = i + this.pos;
            return str;
        }
    }

    private void m6253f(char c) throws IOException {
        char[] cArr = this.bUd;
        do {
            int i = this.pos;
            int i2 = this.limit;
            int i3 = i;
            while (i3 < i2) {
                i = i3 + 1;
                char c2 = cArr[i3];
                if (c2 == c) {
                    this.pos = i;
                    return;
                }
                if (c2 == '\\') {
                    this.pos = i;
                    Xm();
                    i = this.pos;
                    i2 = this.limit;
                } else if (c2 == '\n') {
                    this.bUe++;
                    this.bUf = i;
                }
                i3 = i;
            }
            this.pos = i3;
        } while (iT(1));
        throw fx("Unterminated string");
    }

    private void Xj() throws IOException {
        do {
            int i = 0;
            while (this.pos + i < this.limit) {
                switch (this.bUd[this.pos + i]) {
                    case '\t':
                    case '\n':
                    case '\f':
                    case '\r':
                    case ' ':
                    case ',':
                    case ':':
                    case '[':
                    case ']':
                    case '{':
                    case '}':
                        break;
                    case '#':
                    case '/':
                    case ';':
                    case '=':
                    case '\\':
                        Xk();
                        break;
                    default:
                        i++;
                }
                this.pos = i + this.pos;
                return;
            }
            this.pos = i + this.pos;
        } while (iT(1));
    }

    public int nextInt() throws IOException {
        int i = this.bUg;
        if (i == 0) {
            i = Xf();
        }
        int[] iArr;
        int i2;
        if (i == 15) {
            i = (int) this.bUh;
            if (this.bUh != ((long) i)) {
                throw new NumberFormatException("Expected an int but was " + this.bUh + WX());
            }
            this.bUg = 0;
            iArr = this.bSk;
            i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
        } else {
            if (i == 16) {
                this.bUj = new String(this.bUd, this.pos, this.bUi);
                this.pos += this.bUi;
            } else if (i == 8 || i == 9 || i == 10) {
                if (i == 10) {
                    this.bUj = Xi();
                } else {
                    this.bUj = m6252e(i == 8 ? '\'' : '\"');
                }
                try {
                    i = Integer.parseInt(this.bUj);
                    this.bUg = 0;
                    iArr = this.bSk;
                    i2 = this.bSi - 1;
                    iArr[i2] = iArr[i2] + 1;
                } catch (NumberFormatException e) {
                }
            } else {
                throw new IllegalStateException("Expected an int but was " + WT() + WX());
            }
            this.bUg = 11;
            double parseDouble = Double.parseDouble(this.bUj);
            i = (int) parseDouble;
            if (((double) i) != parseDouble) {
                throw new NumberFormatException("Expected an int but was " + this.bUj + WX());
            }
            this.bUj = null;
            this.bUg = 0;
            iArr = this.bSk;
            i2 = this.bSi - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return i;
    }

    public void close() throws IOException {
        this.bUg = 0;
        this.bUk[0] = 8;
        this.bSi = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.bUg;
            if (i2 == 0) {
                i2 = Xf();
            }
            if (i2 == 3) {
                iS(1);
                i++;
            } else if (i2 == 1) {
                iS(3);
                i++;
            } else if (i2 == 4) {
                this.bSi--;
                i--;
            } else if (i2 == 2) {
                this.bSi--;
                i--;
            } else if (i2 == 14 || i2 == 10) {
                Xj();
            } else if (i2 == 8 || i2 == 12) {
                m6253f('\'');
            } else if (i2 == 9 || i2 == 13) {
                m6253f('\"');
            } else if (i2 == 16) {
                this.pos += this.bUi;
            }
            this.bUg = 0;
        } while (i != 0);
        int[] iArr = this.bSk;
        int i3 = this.bSi - 1;
        iArr[i3] = iArr[i3] + 1;
        this.bSj[this.bSi - 1] = "null";
    }

    private void iS(int i) {
        if (this.bSi == this.bUk.length) {
            Object obj = new int[(this.bSi * 2)];
            Object obj2 = new int[(this.bSi * 2)];
            Object obj3 = new String[(this.bSi * 2)];
            System.arraycopy(this.bUk, 0, obj, 0, this.bSi);
            System.arraycopy(this.bSk, 0, obj2, 0, this.bSi);
            System.arraycopy(this.bSj, 0, obj3, 0, this.bSi);
            this.bUk = obj;
            this.bSk = obj2;
            this.bSj = obj3;
        }
        int[] iArr = this.bUk;
        int i2 = this.bSi;
        this.bSi = i2 + 1;
        iArr[i2] = i;
    }

    private boolean iT(int i) throws IOException {
        Object obj = this.bUd;
        this.bUf -= this.pos;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(obj, this.pos, obj, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            int read = this.in.read(obj, this.limit, obj.length - this.limit);
            if (read == -1) {
                return false;
            }
            this.limit = read + this.limit;
            if (this.bUe == 0 && this.bUf == 0 && this.limit > 0 && obj[0] == '﻿') {
                this.pos++;
                this.bUf++;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int bH(boolean z) throws IOException {
        char[] cArr = this.bUd;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (iT(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + WX());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.bUe++;
                this.bUf = i3;
                i = i3;
            } else if (c == ' ' || c == '\r') {
                i = i3;
            } else if (c == '\t') {
                i = i3;
            } else if (c == '/') {
                this.pos = i3;
                if (i3 == i2) {
                    this.pos--;
                    boolean iT = iT(2);
                    this.pos++;
                    if (!iT) {
                        return c;
                    }
                }
                Xk();
                switch (cArr[this.pos]) {
                    case '*':
                        this.pos++;
                        if (fw("*/")) {
                            i = this.pos + 2;
                            i2 = this.limit;
                            break;
                        }
                        throw fx("Unterminated comment");
                    case '/':
                        this.pos++;
                        Xl();
                        i = this.pos;
                        i2 = this.limit;
                        break;
                    default:
                        return c;
                }
            } else if (c == '#') {
                this.pos = i3;
                Xk();
                Xl();
                i = this.pos;
                i2 = this.limit;
            } else {
                this.pos = i3;
                return c;
            }
        }
    }

    private void Xk() throws IOException {
        if (!this.bQT) {
            throw fx("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void Xl() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || iT(1)) {
                char[] cArr = this.bUd;
                int i = this.pos;
                this.pos = i + 1;
                c = cArr[i];
                if (c == '\n') {
                    this.bUe++;
                    this.bUf = this.pos;
                    return;
                }
            } else {
                return;
            }
        } while (c != '\r');
    }

    private boolean fw(String str) throws IOException {
        while (true) {
            if (this.pos + str.length() > this.limit && !iT(str.length())) {
                return false;
            }
            if (this.bUd[this.pos] == '\n') {
                this.bUe++;
                this.bUf = this.pos + 1;
            } else {
                int i = 0;
                while (i < str.length()) {
                    if (this.bUd[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + WX();
    }

    private String WX() {
        return " at line " + (this.bUe + 1) + " column " + ((this.pos - this.bUf) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder append = new StringBuilder().append('$');
        int i = this.bSi;
        for (int i2 = 0; i2 < i; i2++) {
            switch (this.bUk[i2]) {
                case 1:
                case 2:
                    append.append('[').append(this.bSk[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    append.append('.');
                    if (this.bSj[i2] == null) {
                        break;
                    }
                    append.append(this.bSj[i2]);
                    break;
                default:
                    break;
            }
        }
        return append.toString();
    }

    private char Xm() throws IOException {
        if (this.pos != this.limit || iT(1)) {
            char[] cArr = this.bUd;
            int i = this.pos;
            this.pos = i + 1;
            char c = cArr[i];
            switch (c) {
                case '\n':
                    this.bUe++;
                    this.bUf = this.pos;
                    return c;
                case '\"':
                case '\'':
                case '/':
                case '\\':
                    return c;
                case 'b':
                    return '\b';
                case 'f':
                    return '\f';
                case 'n':
                    return '\n';
                case 'r':
                    return '\r';
                case 't':
                    return '\t';
                case 'u':
                    if (this.pos + 4 <= this.limit || iT(4)) {
                        int i2 = this.pos;
                        int i3 = i2 + 4;
                        int i4 = i2;
                        c = '\u0000';
                        for (i = i4; i < i3; i++) {
                            char c2 = this.bUd[i];
                            c = (char) (c << 4);
                            if (c2 >= '0' && c2 <= '9') {
                                c = (char) (c + (c2 - 48));
                            } else if (c2 >= 'a' && c2 <= 'f') {
                                c = (char) (c + ((c2 - 97) + 10));
                            } else if (c2 < 'A' || c2 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.bUd, this.pos, 4));
                            } else {
                                c = (char) (c + ((c2 - 65) + 10));
                            }
                        }
                        this.pos += 4;
                        return c;
                    }
                    throw fx("Unterminated escape sequence");
                default:
                    throw fx("Invalid escape sequence");
            }
        }
        throw fx("Unterminated escape sequence");
    }

    private IOException fx(String str) throws IOException {
        throw new MalformedJsonException(str + WX());
    }

    private void Xn() throws IOException {
        bH(true);
        this.pos--;
        if (this.pos + bUc.length <= this.limit || iT(bUc.length)) {
            int i = 0;
            while (i < bUc.length) {
                if (this.bUd[this.pos + i] == bUc[i]) {
                    i++;
                } else {
                    return;
                }
            }
            this.pos += bUc.length;
        }
    }
}
