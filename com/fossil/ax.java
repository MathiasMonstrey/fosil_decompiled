package com.fossil;

import com.fossil.ju.C3763a;
import com.fossil.ju.C3764b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class ax<T> {
    private final C3763a<ArrayList<T>> yT = new C3764b(10);
    private final jv<T, ArrayList<T>> yU = new jv();
    private final ArrayList<T> yV = new ArrayList();
    private final HashSet<T> yW = new HashSet();

    public void m4663h(T t) {
        if (!this.yU.containsKey(t)) {
            this.yU.put(t, null);
        }
    }

    public boolean contains(T t) {
        return this.yU.containsKey(t);
    }

    public void m4662a(T t, T t2) {
        if (this.yU.containsKey(t) && this.yU.containsKey(t2)) {
            ArrayList arrayList = (ArrayList) this.yU.get(t);
            if (arrayList == null) {
                arrayList = gh();
                this.yU.put(t, arrayList);
            }
            arrayList.add(t2);
            return;
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    public List m4664i(T t) {
        return (List) this.yU.get(t);
    }

    public List m4665j(T t) {
        List list = null;
        int size = this.yU.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.yU.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    List list2 = list;
                }
                arrayList.add(this.yU.keyAt(i));
                list = arrayList;
            }
        }
        return list;
    }

    public boolean m4666k(T t) {
        int size = this.yU.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.yU.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        int size = this.yU.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.yU.valueAt(i);
            if (arrayList != null) {
                m4661a(arrayList);
            }
        }
        this.yU.clear();
    }

    public ArrayList<T> gg() {
        this.yV.clear();
        this.yW.clear();
        int size = this.yU.size();
        for (int i = 0; i < size; i++) {
            m4660a(this.yU.keyAt(i), this.yV, this.yW);
        }
        return this.yV;
    }

    private void m4660a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.yU.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m4660a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    private ArrayList<T> gh() {
        ArrayList<T> arrayList = (ArrayList) this.yT.ea();
        if (arrayList == null) {
            return new ArrayList();
        }
        return arrayList;
    }

    private void m4661a(ArrayList<T> arrayList) {
        arrayList.clear();
        this.yT.mo3248e(arrayList);
    }
}
