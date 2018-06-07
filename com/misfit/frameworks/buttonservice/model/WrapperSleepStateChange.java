package com.misfit.frameworks.buttonservice.model;

import com.fossil.cfj;
import java.util.List;
import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel
public class WrapperSleepStateChange {
    public long index;
    public int state;

    @ParcelConstructor
    public WrapperSleepStateChange(int i, long j) {
        this.state = i;
        this.index = j;
    }

    public int getState() {
        return this.state;
    }

    public long getIndex() {
        return this.index;
    }

    public static List<WrapperSleepStateChange> getSleepStateChanges(String str, int i) {
        List<WrapperSleepStateChange> list = (List) new cfj().m6197a(str, new 1().getType());
        list.add(new WrapperSleepStateChange(-1, (long) i));
        return list;
    }
}
