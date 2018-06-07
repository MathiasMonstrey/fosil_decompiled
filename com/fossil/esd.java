package com.fossil;

import java.util.Map;

interface esd<K, V> extends Map<K, V> {
    V dk(K k);
}
