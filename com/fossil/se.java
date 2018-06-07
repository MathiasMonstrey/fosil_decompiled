package com.fossil;

import com.fossil.rd.C4040b;
import java.util.List;

class se {
    final C4041a apd;

    interface C4041a {
        C4040b mo4068a(int i, int i2, int i3, Object obj);

        void mo4069g(C4040b c4040b);
    }

    public se(C4041a c4041a) {
        this.apd = c4041a;
    }

    void m13512s(List<C4040b> list) {
        while (true) {
            int t = m13509t(list);
            if (t != -1) {
                m13507a(list, t, t + 1);
            } else {
                return;
            }
        }
    }

    private void m13507a(List<C4040b> list, int i, int i2) {
        C4040b c4040b = (C4040b) list.get(i);
        C4040b c4040b2 = (C4040b) list.get(i2);
        switch (c4040b2.In) {
            case 1:
                m13508b(list, i, c4040b, i2, c4040b2);
                return;
            case 2:
                m13510a(list, i, c4040b, i2, c4040b2);
                return;
            case 4:
                m13511c(list, i, c4040b, i2, c4040b2);
                return;
            default:
                return;
        }
    }

    void m13510a(List<C4040b> list, int i, C4040b c4040b, int i2, C4040b c4040b2) {
        int i3;
        C4040b c4040b3;
        int i4 = 0;
        if (c4040b.ake < c4040b.akg) {
            i3 = (c4040b2.ake == c4040b.ake && c4040b2.akg == c4040b.akg - c4040b.ake) ? 1 : 0;
        } else if (c4040b2.ake == c4040b.akg + 1 && c4040b2.akg == c4040b.ake - c4040b.akg) {
            i4 = 1;
            i3 = 1;
        } else {
            i3 = 0;
            i4 = 1;
        }
        if (c4040b.akg < c4040b2.ake) {
            c4040b2.ake--;
        } else if (c4040b.akg < c4040b2.ake + c4040b2.akg) {
            c4040b2.akg--;
            c4040b.In = 2;
            c4040b.akg = 1;
            if (c4040b2.akg == 0) {
                list.remove(i2);
                this.apd.mo4069g(c4040b2);
                return;
            }
            return;
        }
        if (c4040b.ake <= c4040b2.ake) {
            c4040b2.ake++;
            c4040b3 = null;
        } else if (c4040b.ake < c4040b2.ake + c4040b2.akg) {
            c4040b3 = this.apd.mo4068a(2, c4040b.ake + 1, (c4040b2.ake + c4040b2.akg) - c4040b.ake, null);
            c4040b2.akg = c4040b.ake - c4040b2.ake;
        } else {
            c4040b3 = null;
        }
        if (i3 != 0) {
            list.set(i, c4040b2);
            list.remove(i2);
            this.apd.mo4069g(c4040b);
            return;
        }
        if (i4 != 0) {
            if (c4040b3 != null) {
                if (c4040b.ake > c4040b3.ake) {
                    c4040b.ake -= c4040b3.akg;
                }
                if (c4040b.akg > c4040b3.ake) {
                    c4040b.akg -= c4040b3.akg;
                }
            }
            if (c4040b.ake > c4040b2.ake) {
                c4040b.ake -= c4040b2.akg;
            }
            if (c4040b.akg > c4040b2.ake) {
                c4040b.akg -= c4040b2.akg;
            }
        } else {
            if (c4040b3 != null) {
                if (c4040b.ake >= c4040b3.ake) {
                    c4040b.ake -= c4040b3.akg;
                }
                if (c4040b.akg >= c4040b3.ake) {
                    c4040b.akg -= c4040b3.akg;
                }
            }
            if (c4040b.ake >= c4040b2.ake) {
                c4040b.ake -= c4040b2.akg;
            }
            if (c4040b.akg >= c4040b2.ake) {
                c4040b.akg -= c4040b2.akg;
            }
        }
        list.set(i, c4040b2);
        if (c4040b.ake != c4040b.akg) {
            list.set(i2, c4040b);
        } else {
            list.remove(i2);
        }
        if (c4040b3 != null) {
            list.add(i, c4040b3);
        }
    }

    private void m13508b(List<C4040b> list, int i, C4040b c4040b, int i2, C4040b c4040b2) {
        int i3 = 0;
        if (c4040b.akg < c4040b2.ake) {
            i3 = -1;
        }
        if (c4040b.ake < c4040b2.ake) {
            i3++;
        }
        if (c4040b2.ake <= c4040b.ake) {
            c4040b.ake += c4040b2.akg;
        }
        if (c4040b2.ake <= c4040b.akg) {
            c4040b.akg += c4040b2.akg;
        }
        c4040b2.ake = i3 + c4040b2.ake;
        list.set(i, c4040b2);
        list.set(i2, c4040b);
    }

    void m13511c(List<C4040b> list, int i, C4040b c4040b, int i2, C4040b c4040b2) {
        Object obj;
        Object obj2 = null;
        if (c4040b.akg < c4040b2.ake) {
            c4040b2.ake--;
            obj = null;
        } else if (c4040b.akg < c4040b2.ake + c4040b2.akg) {
            c4040b2.akg--;
            obj = this.apd.mo4068a(4, c4040b.ake, 1, c4040b2.akf);
        } else {
            obj = null;
        }
        if (c4040b.ake <= c4040b2.ake) {
            c4040b2.ake++;
        } else if (c4040b.ake < c4040b2.ake + c4040b2.akg) {
            int i3 = (c4040b2.ake + c4040b2.akg) - c4040b.ake;
            obj2 = this.apd.mo4068a(4, c4040b.ake + 1, i3, c4040b2.akf);
            c4040b2.akg -= i3;
        }
        list.set(i2, c4040b);
        if (c4040b2.akg > 0) {
            list.set(i, c4040b2);
        } else {
            list.remove(i);
            this.apd.mo4069g(c4040b2);
        }
        if (obj != null) {
            list.add(i, obj);
        }
        if (obj2 != null) {
            list.add(i, obj2);
        }
    }

    private int m13509t(List<C4040b> list) {
        Object obj = null;
        int size = list.size() - 1;
        while (size >= 0) {
            Object obj2;
            if (((C4040b) list.get(size)).In != 8) {
                obj2 = 1;
            } else if (obj != null) {
                return size;
            } else {
                obj2 = obj;
            }
            size--;
            obj = obj2;
        }
        return -1;
    }
}
