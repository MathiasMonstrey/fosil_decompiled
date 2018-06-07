package com.fossil.wearables.fsl.fitness;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

class Reconciler {
    double calories;
    double distance;
    double steps;

    Reconciler(SampleRaw sampleRaw, List<SampleRaw> list) {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        BigDecimal bigDecimal2 = BigDecimal.ZERO;
        BigDecimal bigDecimal3 = BigDecimal.ZERO;
        BigDecimal bigDecimal4 = bigDecimal;
        bigDecimal = bigDecimal2;
        bigDecimal2 = bigDecimal3;
        for (SampleRaw sampleRaw2 : list) {
            BigDecimal bigDecimal5 = new BigDecimal(((double) ovelappingTimeInterval(sampleRaw.startTime, sampleRaw.endTime, sampleRaw2.startTime, sampleRaw2.endTime)) / ((double) sampleRaw.getDuration()));
            bigDecimal4 = bigDecimal4.add(reconciledAmount(new BigDecimal(sampleRaw.steps), new BigDecimal(sampleRaw2.steps), bigDecimal5));
            bigDecimal = bigDecimal.add(reconciledAmount(new BigDecimal(sampleRaw.calories), new BigDecimal(sampleRaw2.calories), bigDecimal5));
            bigDecimal2 = bigDecimal2.add(reconciledAmount(new BigDecimal(sampleRaw.distance), new BigDecimal(sampleRaw2.distance), bigDecimal5));
        }
        this.steps = sampleRaw.steps + bigDecimal4.setScale(0, 4).doubleValue();
        this.calories = bigDecimal.setScale(0, 4).doubleValue() + sampleRaw.calories;
        this.distance = bigDecimal2.setScale(0, 4).doubleValue() + sampleRaw.distance;
    }

    private BigDecimal reconciledAmount(BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3) {
        BigDecimal multiply = bigDecimal.multiply(bigDecimal3);
        BigDecimal multiply2 = bigDecimal2.multiply(bigDecimal3);
        if (multiply.compareTo(multiply2) > 0) {
            return multiply2.negate();
        }
        return multiply.negate();
    }

    static long ovelappingTimeInterval(Date date, Date date2, Date date3, Date date4) {
        if (date.getTime() <= date3.getTime()) {
            date = date3;
        }
        if (date2.getTime() >= date4.getTime()) {
            date2 = date4;
        }
        return Math.max(0, date2.getTime() - date.getTime());
    }
}
