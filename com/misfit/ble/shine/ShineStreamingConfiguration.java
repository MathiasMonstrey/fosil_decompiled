package com.misfit.ble.shine;

public class ShineStreamingConfiguration {
    public long mConnectionHeartbeatInterval = -1;
    public int mNumberOfMappedEventPackets = -1;

    public ShineStreamingConfiguration clone() {
        ShineStreamingConfiguration shineStreamingConfiguration = new ShineStreamingConfiguration();
        shineStreamingConfiguration.mNumberOfMappedEventPackets = this.mNumberOfMappedEventPackets;
        shineStreamingConfiguration.mConnectionHeartbeatInterval = this.mConnectionHeartbeatInterval;
        return shineStreamingConfiguration;
    }
}
