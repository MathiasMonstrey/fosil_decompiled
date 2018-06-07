package com.portfolio.platform.data.model;

import java.util.Comparator;

public class MessageComparator implements Comparator<LightAndHaptics> {
    public int compare(LightAndHaptics lightAndHaptics, LightAndHaptics lightAndHaptics2) {
        return lightAndHaptics.getPriority().compareTo(lightAndHaptics2.getPriority());
    }
}
