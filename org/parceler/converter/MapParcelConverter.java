package org.parceler.converter;

import android.os.Parcel;
import java.util.Map;
import java.util.Map.Entry;
import org.parceler.TypeRangeParcelConverter;

public abstract class MapParcelConverter<K, V, M extends Map<K, V>> implements TypeRangeParcelConverter<Map<K, V>, M> {
    private static final int NULL = -1;

    public abstract M createMap();

    public abstract K mapKeyFromParcel(Parcel parcel);

    public abstract void mapKeyToParcel(K k, Parcel parcel);

    public abstract V mapValueFromParcel(Parcel parcel);

    public abstract void mapValueToParcel(V v, Parcel parcel);

    public void toParcel(Map<K, V> map, Parcel parcel) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Entry entry : map.entrySet()) {
            mapKeyToParcel(entry.getKey(), parcel);
            mapValueToParcel(entry.getValue(), parcel);
        }
    }

    public M fromParcel(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        M createMap = createMap();
        for (int i = 0; i < readInt; i++) {
            createMap.put(mapKeyFromParcel(parcel), mapValueFromParcel(parcel));
        }
        return createMap;
    }
}
