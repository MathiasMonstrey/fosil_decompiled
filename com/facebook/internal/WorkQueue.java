package com.facebook.internal;

import com.facebook.FacebookSdk;
import java.util.concurrent.Executor;

public class WorkQueue {
    static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
    public static final int DEFAULT_MAX_CONCURRENT = 8;
    private final Executor executor;
    private final int maxConcurrent;
    private WorkNode pendingJobs;
    private int runningCount;
    private WorkNode runningJobs;
    private final Object workLock;

    public interface WorkItem {
        boolean cancel();

        boolean isRunning();

        void moveToFront();
    }

    class WorkNode implements WorkItem {
        static final /* synthetic */ boolean $assertionsDisabled = (!WorkQueue.class.desiredAssertionStatus());
        private final Runnable callback;
        private boolean isRunning;
        private WorkNode next;
        private WorkNode prev;

        WorkNode(Runnable runnable) {
            this.callback = runnable;
        }

        public boolean cancel() {
            synchronized (WorkQueue.this.workLock) {
                if (isRunning()) {
                    return false;
                }
                WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                return true;
            }
        }

        public void moveToFront() {
            synchronized (WorkQueue.this.workLock) {
                if (!isRunning()) {
                    WorkQueue.this.pendingJobs = removeFromList(WorkQueue.this.pendingJobs);
                    WorkQueue.this.pendingJobs = addToList(WorkQueue.this.pendingJobs, true);
                }
            }
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        Runnable getCallback() {
            return this.callback;
        }

        WorkNode getNext() {
            return this.next;
        }

        void setIsRunning(boolean z) {
            this.isRunning = z;
        }

        WorkNode addToList(WorkNode workNode, boolean z) {
            if (!$assertionsDisabled && this.next != null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.prev == null) {
                WorkNode workNode2;
                if (workNode == null) {
                    this.prev = this;
                    this.next = this;
                    workNode2 = this;
                } else {
                    this.next = workNode;
                    this.prev = workNode.prev;
                    workNode2 = this.next;
                    this.prev.next = this;
                    workNode2.prev = this;
                    workNode2 = workNode;
                }
                if (z) {
                    return this;
                }
                return workNode2;
            } else {
                throw new AssertionError();
            }
        }

        WorkNode removeFromList(WorkNode workNode) {
            if (!$assertionsDisabled && this.next == null) {
                throw new AssertionError();
            } else if ($assertionsDisabled || this.prev != null) {
                if (workNode == this) {
                    if (this.next == this) {
                        workNode = null;
                    } else {
                        workNode = this.next;
                    }
                }
                this.next.prev = this.prev;
                this.prev.next = this.next;
                this.prev = null;
                this.next = null;
                return workNode;
            } else {
                throw new AssertionError();
            }
        }

        void verify(boolean z) {
            if (!$assertionsDisabled && this.prev.next != this) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && this.next.prev != this) {
                throw new AssertionError();
            } else if (!$assertionsDisabled && isRunning() != z) {
                throw new AssertionError();
            }
        }
    }

    public WorkQueue() {
        this(8);
    }

    public WorkQueue(int i) {
        this(i, FacebookSdk.getExecutor());
    }

    public WorkQueue(int i, Executor executor) {
        this.workLock = new Object();
        this.runningJobs = null;
        this.runningCount = 0;
        this.maxConcurrent = i;
        this.executor = executor;
    }

    public WorkItem addActiveWorkItem(Runnable runnable) {
        return addActiveWorkItem(runnable, true);
    }

    public WorkItem addActiveWorkItem(Runnable runnable, boolean z) {
        WorkItem workNode = new WorkNode(runnable);
        synchronized (this.workLock) {
            this.pendingJobs = workNode.addToList(this.pendingJobs, z);
        }
        startItem();
        return workNode;
    }

    public void validate() {
        synchronized (this.workLock) {
            int i = 0;
            if (this.runningJobs != null) {
                WorkNode workNode = this.runningJobs;
                do {
                    workNode.verify(true);
                    i++;
                    workNode = workNode.getNext();
                } while (workNode != this.runningJobs);
            }
            if ($assertionsDisabled || this.runningCount == r0) {
            } else {
                throw new AssertionError();
            }
        }
    }

    private void startItem() {
        finishItemAndStartNew(null);
    }

    private void finishItemAndStartNew(WorkNode workNode) {
        WorkNode workNode2 = null;
        synchronized (this.workLock) {
            if (workNode != null) {
                this.runningJobs = workNode.removeFromList(this.runningJobs);
                this.runningCount--;
            }
            if (this.runningCount < this.maxConcurrent) {
                workNode2 = this.pendingJobs;
                if (workNode2 != null) {
                    this.pendingJobs = workNode2.removeFromList(this.pendingJobs);
                    this.runningJobs = workNode2.addToList(this.runningJobs, false);
                    this.runningCount++;
                    workNode2.setIsRunning(true);
                }
            }
        }
        if (workNode2 != null) {
            execute(workNode2);
        }
    }

    private void execute(final WorkNode workNode) {
        this.executor.execute(new Runnable() {
            public void run() {
                try {
                    workNode.getCallback().run();
                } finally {
                    WorkQueue.this.finishItemAndStartNew(workNode);
                }
            }
        });
    }
}
