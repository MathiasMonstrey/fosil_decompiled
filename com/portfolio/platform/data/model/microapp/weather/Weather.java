package com.portfolio.platform.data.model.microapp.weather;

import com.fossil.cga;

public class Weather {
    @cga("lat")
    protected float lat;
    @cga("lng")
    protected float lng;
    @cga("temperature")
    protected Temperature temperature;

    public float getLat() {
        return this.lat;
    }

    public float getLng() {
        return this.lng;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }
}
