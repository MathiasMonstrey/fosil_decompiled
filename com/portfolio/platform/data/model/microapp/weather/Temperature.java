package com.portfolio.platform.data.model.microapp.weather;

import com.fossil.cga;

public class Temperature {
    @cga("currently")
    protected float currently;
    @cga("max")
    protected float max;
    @cga("min")
    protected float min;
    @cga("unit")
    protected String unit;

    public float getCurrently() {
        return this.currently;
    }

    public float getMax() {
        return this.max;
    }

    public float getMin() {
        return this.min;
    }

    public String getUnit() {
        return this.unit;
    }
}
