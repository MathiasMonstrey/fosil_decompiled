package com.fossil.wearables.fsl.countdown;

import java.util.List;

public interface CountDownProvider {
    void deleteCountDown(long j);

    void deleteCountDown(String str);

    CountDown getActiveCountDown();

    List<CountDown> getAllCountDown();

    CountDown getCountDown(String str, long j);

    CountDown getCountDownByClientId(String str);

    CountDown getCountDownById(long j);

    CountDown getCountDownByServerId(String str);

    List<CountDown> getCountDownsByStatus(int i);

    List<CountDown> getPastCountDownsPaging(long j, long j2);

    void saveCountDown(CountDown countDown);

    void setCountDownStatus(String str, CountDownStatus countDownStatus);
}
