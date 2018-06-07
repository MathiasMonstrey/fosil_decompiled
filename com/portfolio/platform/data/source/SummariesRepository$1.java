package com.portfolio.platform.data.source;

class SummariesRepository$1 implements Runnable {
    final /* synthetic */ SummariesRepository this$0;

    SummariesRepository$1(SummariesRepository summariesRepository) {
        this.this$0 = summariesRepository;
    }

    public void run() {
        for (SummariesRepository$SummariesRepositoryObserver onSummariesChanged : SummariesRepository.access$000(this.this$0)) {
            onSummariesChanged.onSummariesChanged();
        }
    }
}
