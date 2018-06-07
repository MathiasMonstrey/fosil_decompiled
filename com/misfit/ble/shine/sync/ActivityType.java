package com.misfit.ble.shine.sync;

public enum ActivityType {
    UNKNOWN_TYPE(0),
    RUNNING_TYPE(1),
    CYCLING_TYPE(2),
    SWIMMING_TYPE(3),
    WALKING_TYPE(4),
    TENNIS_TYPE(5),
    BASKETBALL_TYPE(6),
    FOOTBALL_TYPE(7),
    YOGA_TYPE(8),
    DANCING_TYPE(9),
    SLEEP_TYPE(10);
    
    private final int id;

    private ActivityType(int i) {
        this.id = i;
    }

    public int getId() {
        return this.id;
    }
}
