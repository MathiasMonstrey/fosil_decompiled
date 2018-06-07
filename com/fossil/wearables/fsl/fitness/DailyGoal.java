package com.fossil.wearables.fsl.fitness;

import com.j256.ormlite.field.DatabaseField;
import java.net.URI;

public class DailyGoal {
    public static final String COLUMN_DAY = "day";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MONTH = "month";
    public static final String COLUMN_STEPS = "steps";
    public static final String COLUMN_YEAR = "year";
    public static final String TABLE_NAME = "dailygoal";
    @DatabaseField(columnName = "day")
    protected int day;
    @DatabaseField(columnName = "id", id = true)
    protected String id;
    @DatabaseField(columnName = "month")
    protected int month;
    @DatabaseField(columnName = "steps")
    protected int steps;
    private URI uri;
    @DatabaseField(columnName = "year")
    protected int year;

    public DailyGoal(int i, int i2, int i3, int i4) {
        this.year = i;
        this.month = i2;
        this.day = i3;
        this.steps = i4;
        this.uri = FitnessURI.generateURI(this);
        this.id = this.uri.toASCIIString();
    }

    public URI getUri() {
        if (this.uri == null && this.id != null) {
            this.uri = URI.create(this.id);
        }
        return this.uri;
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getSteps() {
        return this.steps;
    }

    public String toString() {
        return "[DailyGoal: date=" + this.year + "/" + this.month + "/" + this.day + "steps=" + this.steps + "]";
    }
}
