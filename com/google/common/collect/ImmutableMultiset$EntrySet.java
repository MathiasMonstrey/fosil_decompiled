package com.google.common.collect;

import com.fossil.cdj.a;

final class ImmutableMultiset$EntrySet extends ImmutableSet$Indexed<a<E>> {
    private static final long serialVersionUID = 0;
    final /* synthetic */ ImmutableMultiset this$0;

    private ImmutableMultiset$EntrySet(ImmutableMultiset immutableMultiset) {
        this.this$0 = immutableMultiset;
    }

    boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    a<E> get(int i) {
        return this.this$0.getEntry(i);
    }

    public int size() {
        return this.this$0.elementSet().size();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (aVar.getCount() > 0 && this.this$0.count(aVar.getElement()) == aVar.getCount()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.this$0.hashCode();
    }

    Object writeReplace() {
        return new ImmutableMultiset$EntrySetSerializedForm(this.this$0);
    }
}
