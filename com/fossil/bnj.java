package com.fossil;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class bnj extends bqi {
    bnj(bpk com_fossil_bpk) {
        super(com_fossil_bpk);
    }

    private final Boolean m5324a(double d, bso com_fossil_bso) {
        try {
            return m5331a(new BigDecimal(d), com_fossil_bso, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean m5325a(long j, bso com_fossil_bso) {
        try {
            return m5331a(new BigDecimal(j), com_fossil_bso, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean m5326a(bsm com_fossil_bsm, bsv com_fossil_bsv, long j) {
        Boolean a;
        if (com_fossil_bsm.bDM != null) {
            a = m5325a(j, com_fossil_bsm.bDM);
            if (a == null) {
                return null;
            }
            if (!a.booleanValue()) {
                return Boolean.valueOf(false);
            }
        }
        Set hashSet = new HashSet();
        for (bsn com_fossil_bsn : com_fossil_bsm.bDK) {
            if (TextUtils.isEmpty(com_fossil_bsn.bDR)) {
                Pf().Re().m5439d("null or empty param name in filter. event", Pa().ef(com_fossil_bsv.name));
                return null;
            }
            hashSet.add(com_fossil_bsn.bDR);
        }
        Map jlVar = new jl();
        for (bsw com_fossil_bsw : com_fossil_bsv.bEs) {
            if (hashSet.contains(com_fossil_bsw.name)) {
                if (com_fossil_bsw.bEw != null) {
                    jlVar.put(com_fossil_bsw.name, com_fossil_bsw.bEw);
                } else if (com_fossil_bsw.bDx != null) {
                    jlVar.put(com_fossil_bsw.name, com_fossil_bsw.bDx);
                } else if (com_fossil_bsw.boy != null) {
                    jlVar.put(com_fossil_bsw.name, com_fossil_bsw.boy);
                } else {
                    Pf().Re().m5437a("Unknown value for param. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(com_fossil_bsw.name));
                    return null;
                }
            }
        }
        for (bsn com_fossil_bsn2 : com_fossil_bsm.bDK) {
            boolean equals = Boolean.TRUE.equals(com_fossil_bsn2.bDQ);
            String str = com_fossil_bsn2.bDR;
            if (TextUtils.isEmpty(str)) {
                Pf().Re().m5439d("Event has empty param name. event", Pa().ef(com_fossil_bsv.name));
                return null;
            }
            Object obj = jlVar.get(str);
            if (obj instanceof Long) {
                if (com_fossil_bsn2.bDP == null) {
                    Pf().Re().m5437a("No number filter for long param. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                    return null;
                }
                a = m5325a(((Long) obj).longValue(), com_fossil_bsn2.bDP);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof Double) {
                if (com_fossil_bsn2.bDP == null) {
                    Pf().Re().m5437a("No number filter for double param. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                    return null;
                }
                a = m5324a(((Double) obj).doubleValue(), com_fossil_bsn2.bDP);
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj instanceof String) {
                if (com_fossil_bsn2.bDO != null) {
                    a = m5330a((String) obj, com_fossil_bsn2.bDO);
                } else if (com_fossil_bsn2.bDP == null) {
                    Pf().Re().m5437a("No filter for String param. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                    return null;
                } else if (bsk.eK((String) obj)) {
                    a = m5329a((String) obj, com_fossil_bsn2.bDP);
                } else {
                    Pf().Re().m5437a("Invalid param value for number filter. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                    return null;
                }
                if (a == null) {
                    return null;
                }
                if (((!a.booleanValue() ? 1 : 0) ^ equals) != 0) {
                    return Boolean.valueOf(false);
                }
            } else if (obj == null) {
                Pf().Ri().m5437a("Missing param for filter. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                return Boolean.valueOf(false);
            } else {
                Pf().Re().m5437a("Unknown param type. event, param", Pa().ef(com_fossil_bsv.name), Pa().eg(str));
                return null;
            }
        }
        return Boolean.valueOf(true);
    }

    private static Boolean m5327a(Boolean bool, boolean z) {
        return bool == null ? null : Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean m5328a(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!(z || i == 1)) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    Pf().Re().m5439d("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean m5329a(String str, bso com_fossil_bso) {
        Boolean bool = null;
        if (bsk.eK(str)) {
            try {
                bool = m5331a(new BigDecimal(str), com_fossil_bso, 0.0d);
            } catch (NumberFormatException e) {
            }
        }
        return bool;
    }

    private final Boolean m5330a(String str, bsq com_fossil_bsq) {
        int i = 0;
        String str2 = null;
        awa.bO(com_fossil_bsq);
        if (str == null || com_fossil_bsq.bEa == null || com_fossil_bsq.bEa.intValue() == 0) {
            return null;
        }
        List list;
        if (com_fossil_bsq.bEa.intValue() == 6) {
            if (com_fossil_bsq.bEd == null || com_fossil_bsq.bEd.length == 0) {
                return null;
            }
        } else if (com_fossil_bsq.bEb == null) {
            return null;
        }
        int intValue = com_fossil_bsq.bEa.intValue();
        boolean z = com_fossil_bsq.bEc != null && com_fossil_bsq.bEc.booleanValue();
        String toUpperCase = (z || intValue == 1 || intValue == 6) ? com_fossil_bsq.bEb : com_fossil_bsq.bEb.toUpperCase(Locale.ENGLISH);
        if (com_fossil_bsq.bEd == null) {
            list = null;
        } else {
            String[] strArr = com_fossil_bsq.bEd;
            if (z) {
                list = Arrays.asList(strArr);
            } else {
                list = new ArrayList();
                int length = strArr.length;
                while (i < length) {
                    list.add(strArr[i].toUpperCase(Locale.ENGLISH));
                    i++;
                }
            }
        }
        if (intValue == 1) {
            str2 = toUpperCase;
        }
        return m5328a(str, intValue, z, toUpperCase, list, str2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean m5331a(java.math.BigDecimal r10, com.fossil.bso r11, double r12) {
        /*
        r8 = 4;
        r7 = -1;
        r1 = 0;
        r0 = 1;
        r2 = 0;
        com.fossil.awa.bO(r11);
        r3 = r11.bDS;
        if (r3 == 0) goto L_0x0014;
    L_0x000c:
        r3 = r11.bDS;
        r3 = r3.intValue();
        if (r3 != 0) goto L_0x0016;
    L_0x0014:
        r0 = r2;
    L_0x0015:
        return r0;
    L_0x0016:
        r3 = r11.bDS;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0028;
    L_0x001e:
        r3 = r11.bDV;
        if (r3 == 0) goto L_0x0026;
    L_0x0022:
        r3 = r11.bDW;
        if (r3 != 0) goto L_0x002e;
    L_0x0026:
        r0 = r2;
        goto L_0x0015;
    L_0x0028:
        r3 = r11.bDU;
        if (r3 != 0) goto L_0x002e;
    L_0x002c:
        r0 = r2;
        goto L_0x0015;
    L_0x002e:
        r3 = r11.bDS;
        r6 = r3.intValue();
        r3 = r11.bDS;
        r3 = r3.intValue();
        if (r3 != r8) goto L_0x0066;
    L_0x003c:
        r3 = r11.bDV;
        r3 = com.fossil.bsk.eK(r3);
        if (r3 == 0) goto L_0x004c;
    L_0x0044:
        r3 = r11.bDW;
        r3 = com.fossil.bsk.eK(r3);
        if (r3 != 0) goto L_0x004e;
    L_0x004c:
        r0 = r2;
        goto L_0x0015;
    L_0x004e:
        r4 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = r11.bDV;	 Catch:{ NumberFormatException -> 0x0063 }
        r4.<init>(r3);	 Catch:{ NumberFormatException -> 0x0063 }
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r11.bDW;	 Catch:{ NumberFormatException -> 0x0063 }
        r3.<init>(r5);	 Catch:{ NumberFormatException -> 0x0063 }
        r5 = r2;
    L_0x005d:
        if (r6 != r8) goto L_0x007e;
    L_0x005f:
        if (r4 != 0) goto L_0x0080;
    L_0x0061:
        r0 = r2;
        goto L_0x0015;
    L_0x0063:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x0066:
        r3 = r11.bDU;
        r3 = com.fossil.bsk.eK(r3);
        if (r3 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r2;
        goto L_0x0015;
    L_0x0070:
        r3 = new java.math.BigDecimal;	 Catch:{ NumberFormatException -> 0x007b }
        r4 = r11.bDU;	 Catch:{ NumberFormatException -> 0x007b }
        r3.<init>(r4);	 Catch:{ NumberFormatException -> 0x007b }
        r4 = r2;
        r5 = r3;
        r3 = r2;
        goto L_0x005d;
    L_0x007b:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0015;
    L_0x007e:
        if (r5 == 0) goto L_0x0083;
    L_0x0080:
        switch(r6) {
            case 1: goto L_0x0085;
            case 2: goto L_0x0092;
            case 3: goto L_0x00a0;
            case 4: goto L_0x00ee;
            default: goto L_0x0083;
        };
    L_0x0083:
        r0 = r2;
        goto L_0x0015;
    L_0x0085:
        r2 = r10.compareTo(r5);
        if (r2 != r7) goto L_0x0090;
    L_0x008b:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x0090:
        r0 = r1;
        goto L_0x008b;
    L_0x0092:
        r2 = r10.compareTo(r5);
        if (r2 != r0) goto L_0x009e;
    L_0x0098:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x009e:
        r0 = r1;
        goto L_0x0098;
    L_0x00a0:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 == 0) goto L_0x00e0;
    L_0x00a6:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.subtract(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r0) goto L_0x00de;
    L_0x00bf:
        r2 = new java.math.BigDecimal;
        r2.<init>(r12);
        r3 = new java.math.BigDecimal;
        r4 = 2;
        r3.<init>(r4);
        r2 = r2.multiply(r3);
        r2 = r5.add(r2);
        r2 = r10.compareTo(r2);
        if (r2 != r7) goto L_0x00de;
    L_0x00d8:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00de:
        r0 = r1;
        goto L_0x00d8;
    L_0x00e0:
        r2 = r10.compareTo(r5);
        if (r2 != 0) goto L_0x00ec;
    L_0x00e6:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x00ec:
        r0 = r1;
        goto L_0x00e6;
    L_0x00ee:
        r2 = r10.compareTo(r4);
        if (r2 == r7) goto L_0x0100;
    L_0x00f4:
        r2 = r10.compareTo(r3);
        if (r2 == r0) goto L_0x0100;
    L_0x00fa:
        r0 = java.lang.Boolean.valueOf(r0);
        goto L_0x0015;
    L_0x0100:
        r0 = r1;
        goto L_0x00fa;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fossil.bnj.a(java.math.BigDecimal, com.fossil.bso, double):java.lang.Boolean");
    }

    protected final void PH() {
    }

    final bsu[] m5332a(String str, bsv[] com_fossil_bsvArr, bta[] com_fossil_btaArr) {
        int intValue;
        bsz com_fossil_bsz;
        BitSet bitSet;
        BitSet bitSet2;
        Map map;
        Map map2;
        awa.df(str);
        Set hashSet = new HashSet();
        jl jlVar = new jl();
        Map jlVar2 = new jl();
        jl jlVar3 = new jl();
        Map ec = OZ().ec(str);
        if (ec != null) {
            for (Integer intValue2 : ec.keySet()) {
                intValue = intValue2.intValue();
                com_fossil_bsz = (bsz) ec.get(Integer.valueOf(intValue));
                bitSet = (BitSet) jlVar2.get(Integer.valueOf(intValue));
                bitSet2 = (BitSet) jlVar3.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    jlVar2.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    jlVar3.put(Integer.valueOf(intValue), bitSet2);
                }
                for (int i = 0; i < (com_fossil_bsz.bFc.length << 6); i++) {
                    if (bsk.m5588a(com_fossil_bsz.bFc, i)) {
                        Pf().Ri().m5437a("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (bsk.m5588a(com_fossil_bsz.bFd, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                bsu com_fossil_bsu = new bsu();
                jlVar.put(Integer.valueOf(intValue), com_fossil_bsu);
                com_fossil_bsu.bEq = Boolean.valueOf(false);
                com_fossil_bsu.bEp = com_fossil_bsz;
                com_fossil_bsu.bEo = new bsz();
                com_fossil_bsu.bEo.bFd = bsk.m5590a(bitSet);
                com_fossil_bsu.bEo.bFc = bsk.m5590a(bitSet2);
            }
        }
        if (com_fossil_bsvArr != null) {
            jl jlVar4 = new jl();
            for (bsv com_fossil_bsv : com_fossil_bsvArr) {
                bnv com_fossil_bnv;
                bnv R = OZ().m5349R(str, com_fossil_bsv.name);
                if (R == null) {
                    Pf().Re().m5437a("Event aggregate wasn't created during raw event logging. appId, event", bol.ei(str), Pa().ef(com_fossil_bsv.name));
                    com_fossil_bnv = new bnv(str, com_fossil_bsv.name, 1, 1, com_fossil_bsv.bEt.longValue());
                } else {
                    com_fossil_bnv = R.QX();
                }
                OZ().m5360a(com_fossil_bnv);
                long j = com_fossil_bnv.byk;
                map = (Map) jlVar4.get(com_fossil_bsv.name);
                if (map == null) {
                    map = OZ().m5354W(str, com_fossil_bsv.name);
                    if (map == null) {
                        map = new jl();
                    }
                    jlVar4.put(com_fossil_bsv.name, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue22 : r7.keySet()) {
                    int intValue3 = intValue22.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue3))) {
                        Pf().Ri().m5439d("Skipping failed audience ID", Integer.valueOf(intValue3));
                    } else {
                        bitSet = (BitSet) jlVar2.get(Integer.valueOf(intValue3));
                        bitSet2 = (BitSet) jlVar3.get(Integer.valueOf(intValue3));
                        if (((bsu) jlVar.get(Integer.valueOf(intValue3))) == null) {
                            bsu com_fossil_bsu2 = new bsu();
                            jlVar.put(Integer.valueOf(intValue3), com_fossil_bsu2);
                            com_fossil_bsu2.bEq = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            jlVar2.put(Integer.valueOf(intValue3), bitSet);
                            bitSet2 = new BitSet();
                            jlVar3.put(Integer.valueOf(intValue3), bitSet2);
                        }
                        for (bsm com_fossil_bsm : (List) r7.get(Integer.valueOf(intValue3))) {
                            if (Pf().ig(2)) {
                                Pf().Ri().m5438a("Evaluating filter. audience, filter, event", Integer.valueOf(intValue3), com_fossil_bsm.bDI, Pa().ef(com_fossil_bsm.bDJ));
                                Pf().Ri().m5439d("Filter definition", Pa().m5427a(com_fossil_bsm));
                            }
                            if (com_fossil_bsm.bDI == null || com_fossil_bsm.bDI.intValue() > 256) {
                                Pf().Re().m5437a("Invalid event filter ID. appId, id", bol.ei(str), String.valueOf(com_fossil_bsm.bDI));
                            } else if (bitSet.get(com_fossil_bsm.bDI.intValue())) {
                                Pf().Ri().m5437a("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), com_fossil_bsm.bDI);
                            } else {
                                Object obj;
                                Boolean a = m5326a(com_fossil_bsm, com_fossil_bsv, j);
                                bon Ri = Pf().Ri();
                                String str2 = "Event filter result";
                                if (a == null) {
                                    obj = "null";
                                } else {
                                    Boolean bool = a;
                                }
                                Ri.m5439d(str2, obj);
                                if (a == null) {
                                    hashSet.add(Integer.valueOf(intValue3));
                                } else {
                                    bitSet2.set(com_fossil_bsm.bDI.intValue());
                                    if (a.booleanValue()) {
                                        bitSet.set(com_fossil_bsm.bDI.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (com_fossil_btaArr != null) {
            Map jlVar5 = new jl();
            for (bta com_fossil_bta : com_fossil_btaArr) {
                map = (Map) jlVar5.get(com_fossil_bta.name);
                if (map == null) {
                    map = OZ().m5355X(str, com_fossil_bta.name);
                    if (map == null) {
                        map = new jl();
                    }
                    jlVar5.put(com_fossil_bta.name, map);
                    map2 = map;
                } else {
                    map2 = map;
                }
                for (Integer intValue222 : r7.keySet()) {
                    int intValue4 = intValue222.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        Pf().Ri().m5439d("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        bitSet = (BitSet) jlVar2.get(Integer.valueOf(intValue4));
                        bitSet2 = (BitSet) jlVar3.get(Integer.valueOf(intValue4));
                        if (((bsu) jlVar.get(Integer.valueOf(intValue4))) == null) {
                            com_fossil_bsu2 = new bsu();
                            jlVar.put(Integer.valueOf(intValue4), com_fossil_bsu2);
                            com_fossil_bsu2.bEq = Boolean.valueOf(true);
                            bitSet = new BitSet();
                            jlVar2.put(Integer.valueOf(intValue4), bitSet);
                            bitSet2 = new BitSet();
                            jlVar3.put(Integer.valueOf(intValue4), bitSet2);
                        }
                        for (bsp com_fossil_bsp : (List) r7.get(Integer.valueOf(intValue4))) {
                            if (Pf().ig(2)) {
                                Pf().Ri().m5438a("Evaluating filter. audience, filter, property", Integer.valueOf(intValue4), com_fossil_bsp.bDI, Pa().eh(com_fossil_bsp.bDY));
                                Pf().Ri().m5439d("Filter definition", Pa().m5428a(com_fossil_bsp));
                            }
                            if (com_fossil_bsp.bDI == null || com_fossil_bsp.bDI.intValue() > 256) {
                                Pf().Re().m5437a("Invalid property filter ID. appId, id", bol.ei(str), String.valueOf(com_fossil_bsp.bDI));
                                hashSet.add(Integer.valueOf(intValue4));
                                break;
                            } else if (bitSet.get(com_fossil_bsp.bDI.intValue())) {
                                Pf().Ri().m5437a("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), com_fossil_bsp.bDI);
                            } else {
                                Object obj2;
                                bsn com_fossil_bsn = com_fossil_bsp.bDZ;
                                if (com_fossil_bsn == null) {
                                    Pf().Re().m5439d("Missing property filter. property", Pa().eh(com_fossil_bta.name));
                                    bool = null;
                                } else {
                                    boolean equals = Boolean.TRUE.equals(com_fossil_bsn.bDQ);
                                    if (com_fossil_bta.bEw != null) {
                                        if (com_fossil_bsn.bDP == null) {
                                            Pf().Re().m5439d("No number filter for long property. property", Pa().eh(com_fossil_bta.name));
                                            bool = null;
                                        } else {
                                            bool = m5327a(m5325a(com_fossil_bta.bEw.longValue(), com_fossil_bsn.bDP), equals);
                                        }
                                    } else if (com_fossil_bta.bDx != null) {
                                        if (com_fossil_bsn.bDP == null) {
                                            Pf().Re().m5439d("No number filter for double property. property", Pa().eh(com_fossil_bta.name));
                                            bool = null;
                                        } else {
                                            bool = m5327a(m5324a(com_fossil_bta.bDx.doubleValue(), com_fossil_bsn.bDP), equals);
                                        }
                                    } else if (com_fossil_bta.boy == null) {
                                        Pf().Re().m5439d("User property has no value, property", Pa().eh(com_fossil_bta.name));
                                        bool = null;
                                    } else if (com_fossil_bsn.bDO == null) {
                                        if (com_fossil_bsn.bDP == null) {
                                            Pf().Re().m5439d("No string or number filter defined. property", Pa().eh(com_fossil_bta.name));
                                        } else if (bsk.eK(com_fossil_bta.boy)) {
                                            bool = m5327a(m5329a(com_fossil_bta.boy, com_fossil_bsn.bDP), equals);
                                        } else {
                                            Pf().Re().m5437a("Invalid user property value for Numeric number filter. property, value", Pa().eh(com_fossil_bta.name), com_fossil_bta.boy);
                                        }
                                        bool = null;
                                    } else {
                                        bool = m5327a(m5330a(com_fossil_bta.boy, com_fossil_bsn.bDO), equals);
                                    }
                                }
                                bon Ri2 = Pf().Ri();
                                String str3 = "Property filter result";
                                if (bool == null) {
                                    obj2 = "null";
                                } else {
                                    a = bool;
                                }
                                Ri2.m5439d(str3, obj2);
                                if (bool == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet2.set(com_fossil_bsp.bDI.intValue());
                                    if (bool.booleanValue()) {
                                        bitSet.set(com_fossil_bsp.bDI.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bsu[] com_fossil_bsuArr = new bsu[jlVar2.size()];
        int i2 = 0;
        for (Integer intValue2222 : jlVar2.keySet()) {
            intValue = intValue2222.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue))) {
                com_fossil_bsu2 = (bsu) jlVar.get(Integer.valueOf(intValue));
                com_fossil_bsu = com_fossil_bsu2 == null ? new bsu() : com_fossil_bsu2;
                int i3 = i2 + 1;
                com_fossil_bsuArr[i2] = com_fossil_bsu;
                com_fossil_bsu.bDE = Integer.valueOf(intValue);
                com_fossil_bsu.bEo = new bsz();
                com_fossil_bsu.bEo.bFd = bsk.m5590a((BitSet) jlVar2.get(Integer.valueOf(intValue)));
                com_fossil_bsu.bEo.bFc = bsk.m5590a((BitSet) jlVar3.get(Integer.valueOf(intValue)));
                bnn OZ = OZ();
                com_fossil_bsz = com_fossil_bsu.bEo;
                OZ.RA();
                OZ.OP();
                awa.df(str);
                awa.bO(com_fossil_bsz);
                try {
                    byte[] bArr = new byte[com_fossil_bsz.MW()];
                    bci h = bci.m4843h(bArr, 0, bArr.length);
                    com_fossil_bsz.mo1264a(h);
                    h.MQ();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("audience_id", Integer.valueOf(intValue));
                    contentValues.put("current_results", bArr);
                    try {
                        if (OZ.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            OZ.Pf().Rc().m5439d("Failed to insert filter results (got -1). appId", bol.ei(str));
                        }
                        i2 = i3;
                    } catch (SQLiteException e) {
                        OZ.Pf().Rc().m5437a("Error storing filter results. appId", bol.ei(str), e);
                        i2 = i3;
                    }
                } catch (IOException e2) {
                    OZ.Pf().Rc().m5437a("Configuration loss. Failed to serialize filter results. appId", bol.ei(str), e2);
                    i2 = i3;
                }
            }
        }
        return (bsu[]) Arrays.copyOf(com_fossil_bsuArr, i2);
    }
}
