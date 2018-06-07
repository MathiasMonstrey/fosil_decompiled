package com.fossil;

public interface tm<TTaskResult, TContinuationResult> {
    TContinuationResult then(tn<TTaskResult> tnVar) throws Exception;
}
