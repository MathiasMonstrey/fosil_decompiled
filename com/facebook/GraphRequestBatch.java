package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphRequestBatch extends AbstractList<GraphRequest> {
    private static AtomicInteger idGenerator = new AtomicInteger();
    private String batchApplicationId;
    private Handler callbackHandler;
    private List<Callback> callbacks;
    private final String id;
    private List<GraphRequest> requests;
    private int timeoutInMilliseconds;

    public interface Callback {
        void onBatchCompleted(GraphRequestBatch graphRequestBatch);
    }

    public interface OnProgressCallback extends Callback {
        void onBatchProgress(GraphRequestBatch graphRequestBatch, long j, long j2);
    }

    public GraphRequestBatch() {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList();
    }

    public GraphRequestBatch(Collection<GraphRequest> collection) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(collection);
    }

    public GraphRequestBatch(GraphRequest... graphRequestArr) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = Arrays.asList(graphRequestArr);
    }

    public GraphRequestBatch(GraphRequestBatch graphRequestBatch) {
        this.requests = new ArrayList();
        this.timeoutInMilliseconds = 0;
        this.id = Integer.valueOf(idGenerator.incrementAndGet()).toString();
        this.callbacks = new ArrayList();
        this.requests = new ArrayList(graphRequestBatch);
        this.callbackHandler = graphRequestBatch.callbackHandler;
        this.timeoutInMilliseconds = graphRequestBatch.timeoutInMilliseconds;
        this.callbacks = new ArrayList(graphRequestBatch.callbacks);
    }

    public int getTimeout() {
        return this.timeoutInMilliseconds;
    }

    public void setTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Argument timeoutInMilliseconds must be >= 0.");
        }
        this.timeoutInMilliseconds = i;
    }

    public void addCallback(Callback callback) {
        if (!this.callbacks.contains(callback)) {
            this.callbacks.add(callback);
        }
    }

    public void removeCallback(Callback callback) {
        this.callbacks.remove(callback);
    }

    public final boolean add(GraphRequest graphRequest) {
        return this.requests.add(graphRequest);
    }

    public final void add(int i, GraphRequest graphRequest) {
        this.requests.add(i, graphRequest);
    }

    public final void clear() {
        this.requests.clear();
    }

    public final GraphRequest get(int i) {
        return (GraphRequest) this.requests.get(i);
    }

    public final GraphRequest remove(int i) {
        return (GraphRequest) this.requests.remove(i);
    }

    public final GraphRequest set(int i, GraphRequest graphRequest) {
        return (GraphRequest) this.requests.set(i, graphRequest);
    }

    public final int size() {
        return this.requests.size();
    }

    final String getId() {
        return this.id;
    }

    final Handler getCallbackHandler() {
        return this.callbackHandler;
    }

    final void setCallbackHandler(Handler handler) {
        this.callbackHandler = handler;
    }

    final List<GraphRequest> getRequests() {
        return this.requests;
    }

    final List<Callback> getCallbacks() {
        return this.callbacks;
    }

    public final String getBatchApplicationId() {
        return this.batchApplicationId;
    }

    public final void setBatchApplicationId(String str) {
        this.batchApplicationId = str;
    }

    public final List<GraphResponse> executeAndWait() {
        return executeAndWaitImpl();
    }

    public final GraphRequestAsyncTask executeAsync() {
        return executeAsyncImpl();
    }

    List<GraphResponse> executeAndWaitImpl() {
        return GraphRequest.executeBatchAndWait(this);
    }

    GraphRequestAsyncTask executeAsyncImpl() {
        return GraphRequest.executeBatchAsync(this);
    }
}