package org.parceler.converter;

import android.os.Parcel;
import java.util.Collection;
import org.parceler.TypeRangeParcelConverter;

public abstract class CollectionParcelConverter<T, C extends Collection<T>> implements TypeRangeParcelConverter<Collection<T>, C> {
    private static final int NULL = -1;

    public abstract C createCollection();

    public abstract T itemFromParcel(Parcel parcel);

    public abstract void itemToParcel(T t, Parcel parcel);

    public void toParcel(Collection<T> collection, Parcel parcel) {
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        for (T itemToParcel : collection) {
            itemToParcel(itemToParcel, parcel);
        }
    }

    public C fromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        C createCollection = createCollection();
        for (int i = 0; i < readInt; i++) {
            createCollection.add(itemFromParcel(parcel));
        }
        return createCollection;
    }
}
