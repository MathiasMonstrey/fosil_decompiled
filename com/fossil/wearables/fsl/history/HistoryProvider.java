package com.fossil.wearables.fsl.history;

import java.util.Calendar;
import java.util.List;

public interface HistoryProvider {
    List<HistoryItem> getAllItems();

    List<HistoryItem> getItems(Calendar calendar);

    List<HistoryItem> getLatestItems(long j);

    void removeAllItems();

    void removeItem(HistoryItem historyItem);

    void removeItems(List<HistoryItem> list);

    void saveItem(HistoryItem historyItem);
}
