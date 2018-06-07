package com.jawbone.upplatformsdk.builders;

import java.util.HashMap;

public class Params {
    private static final String DATE = "date";
    private static final String END_TIME = "end_time";
    private static final String PAGE_TOKEN = "page_token";
    private static final String START_TIME = "start_time";
    private static final String UPDATED_AFTER = "updated_after";

    public static class Builder {
        Integer date;
        Integer endTime;
        Integer pageToken;
        Integer startTime;
        Integer updatedAfter;

        public Builder setDate(Integer num) {
            this.date = num;
            return this;
        }

        public Builder setPageToken(Integer num) {
            this.pageToken = num;
            return this;
        }

        public Builder setStartTime(Integer num) {
            this.startTime = num;
            return this;
        }

        public Builder setEndTime(Integer num) {
            this.endTime = num;
            return this;
        }

        public Builder setUpdatedAfter(Integer num) {
            this.updatedAfter = num;
            return this;
        }

        public HashMap<String, Integer> build() {
            HashMap<String, Integer> hashMap = new HashMap();
            if (this.date != null) {
                hashMap.put("date", this.date);
            }
            if (this.pageToken != null) {
                hashMap.put(Params.PAGE_TOKEN, this.pageToken);
            }
            if (this.startTime != null) {
                hashMap.put("start_time", this.startTime);
            }
            if (this.endTime != null) {
                hashMap.put("end_time", this.endTime);
            }
            if (this.updatedAfter != null) {
                hashMap.put(Params.UPDATED_AFTER, this.updatedAfter);
            }
            return hashMap;
        }
    }
}
