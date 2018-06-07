package com.fossil.wearables.fsl.fitness;

import com.fossil.wearables.fsl.fitness.exception.InvalidTimezoneIDException;
import com.fossil.wearables.fsl.utils.DateStringSQLiteType;
import com.j256.ormlite.field.DatabaseField;
import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.TimeZone;

public class SampleRaw implements Serializable {
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_DISTANCE = "distance";
    public static final String COLUMN_END_TIME = "endTime";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_MOVEMENT_TYPE_VALUE = "movementTypeValue";
    public static final String COLUMN_PIN_TYPE = "pinType";
    public static final String COLUMN_SOURCE_ID = "sourceId";
    public static final String COLUMN_SOURCE_TYPE_VALUE = "sourceTypeValue";
    public static final String COLUMN_START_TIME = "startTime";
    public static final String COLUMN_STEPS = "steps";
    public static final String COLUMN_TIMEZONE_ID = "timeZoneID";
    public static final String TABLE_NAME = "sampleraw";
    @DatabaseField(columnName = "calories")
    protected double calories;
    @DatabaseField(columnName = "distance")
    protected double distance;
    @DatabaseField(columnName = "endTime", persisterClass = DateStringSQLiteType.class)
    protected Date endTime;
    @DatabaseField(columnName = "id", id = true)
    protected String id;
    @DatabaseField(columnName = "movementTypeValue")
    protected String movementTypeValue;
    @DatabaseField(columnName = "pinType")
    private int pinType;
    @DatabaseField(columnName = "sourceId")
    protected String sourceId;
    @DatabaseField(columnName = "sourceTypeValue")
    protected String sourceTypeValue;
    @DatabaseField(columnName = "startTime", persisterClass = DateStringSQLiteType.class)
    protected Date startTime;
    @DatabaseField(columnName = "steps")
    protected double steps;
    @DatabaseField(columnName = "timeZoneID")
    protected String timeZoneID;
    private URI uri;

    protected SampleRaw() {
    }

    public SampleRaw(Date date, Date date2, String str, String str2, FitnessSourceType fitnessSourceType, FitnessMovementType fitnessMovementType, double d, double d2, double d3) throws InvalidTimezoneIDException {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (timeZone == null || !timeZone.getID().equals(str)) {
            throw new InvalidTimezoneIDException(str);
        }
        init(date, date2, timeZone, str2, fitnessSourceType, fitnessMovementType, d, d2, d3);
    }

    public SampleRaw(Date date, Date date2, TimeZone timeZone, String str, FitnessSourceType fitnessSourceType, FitnessMovementType fitnessMovementType, double d, double d2, double d3) {
        init(date, date2, timeZone, str, fitnessSourceType, fitnessMovementType, d, d2, d3);
    }

    private void init(Date date, Date date2, TimeZone timeZone, String str, FitnessSourceType fitnessSourceType, FitnessMovementType fitnessMovementType, double d, double d2, double d3) {
        this.sourceTypeValue = fitnessSourceType.getName();
        if (fitnessSourceType == FitnessSourceType.Mock) {
            this.sourceId = "000000000000000";
        } else {
            this.sourceId = str;
        }
        this.startTime = date;
        this.endTime = date2;
        this.steps = d;
        this.calories = d2;
        this.distance = d3;
        this.movementTypeValue = fitnessMovementType.getName();
        this.timeZoneID = timeZone.getID();
        this.pinType = 0;
        this.uri = FitnessURI.generateURI(this);
        this.id = this.uri.toASCIIString();
    }

    String getSourceTypeValue() {
        return this.sourceTypeValue;
    }

    String getMovementTypeValue() {
        return this.movementTypeValue;
    }

    String getTimeZoneID() {
        return this.timeZoneID;
    }

    public URI getUri() {
        if (this.uri == null && this.id != null) {
            this.uri = URI.create(this.id);
        }
        return this.uri;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date date) {
        this.startTime = date;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date date) {
        this.endTime = date;
    }

    public double getSteps() {
        return this.steps;
    }

    public void setSteps(double d) {
        this.steps = d;
    }

    public double getCalories() {
        return this.calories;
    }

    public void setCalories(double d) {
        this.calories = d;
    }

    public double getDistance() {
        return this.distance;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public FitnessMovementType getMovementType() {
        return FitnessMovementType.valueFor(this.movementTypeValue);
    }

    public FitnessSourceType getSourceType() {
        return FitnessSourceType.valueOf(this.sourceTypeValue);
    }

    public TimeZone getTimeZone() throws InvalidTimezoneIDException {
        TimeZone timeZone = TimeZone.getTimeZone(getTimeZoneID());
        if (timeZone != null && timeZone.getID().equals(getTimeZoneID())) {
            return timeZone;
        }
        throw new InvalidTimezoneIDException(getTimeZoneID());
    }

    public void setTimeZone(String str) throws InvalidTimezoneIDException {
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (timeZone == null || !timeZone.getID().equals(str)) {
            throw new InvalidTimezoneIDException(str);
        }
        this.timeZoneID = timeZone.getID();
    }

    public long getDuration() {
        return this.endTime.getTime() - this.startTime.getTime();
    }

    public String toString() {
        return "[SampleRaw: startTime=" + this.startTime + ", endTime=" + this.endTime + ", steps=" + this.steps + ", calories=" + this.calories + ", distance=" + this.distance + ", source=" + this.sourceId + ", movementType=" + this.movementTypeValue + ", pinType=" + this.pinType + "]";
    }

    public int getPinType() {
        return this.pinType;
    }

    public void setPinType(int i) {
        this.pinType = i;
    }
}
