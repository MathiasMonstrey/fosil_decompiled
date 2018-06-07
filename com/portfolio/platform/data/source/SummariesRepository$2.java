package com.portfolio.platform.data.source;

import com.misfit.frameworks.network.responses.MFResponse;
import java.util.Date;

class SummariesRepository$2 implements SummariesDataSource$UpdateStepGoalCallback {
    final /* synthetic */ SummariesRepository this$0;
    final /* synthetic */ SummariesDataSource$UpdateStepGoalCallback val$callback;
    final /* synthetic */ Date val$date;
    final /* synthetic */ int val$stepGoal;

    SummariesRepository$2(SummariesRepository summariesRepository, Date date, int i, SummariesDataSource$UpdateStepGoalCallback summariesDataSource$UpdateStepGoalCallback) {
        this.this$0 = summariesRepository;
        this.val$date = date;
        this.val$stepGoal = i;
        this.val$callback = summariesDataSource$UpdateStepGoalCallback;
    }

    public void onUpdateStepGoalFinish(MFResponse mFResponse, boolean z) {
        if (z) {
            SummariesRepository.access$100(this.this$0).updateLastStepGoal(this.val$date, this.val$stepGoal, null);
        }
        if (this.val$callback != null) {
            this.val$callback.onUpdateStepGoalFinish(mFResponse, z);
        }
    }
}
