package io.reactivex.internal.operators.observable;

import com.fossil.eqf;
import com.fossil.eqg;
import com.fossil.eqh;
import com.fossil.eqh.b;
import com.fossil.eqn;
import com.fossil.eqp;
import com.fossil.erb;
import com.fossil.ere;
import com.fossil.erf;
import com.fossil.erh;
import com.fossil.erp;
import com.fossil.ers;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableObserveOn<T> extends erf<T, T> {
    final int bufferSize;
    final eqh dRu;
    final boolean delayError;

    static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements eqg<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final eqg<? super T> actual;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        boolean outputFused;
        ere<T> queue;
        eqn f1654s;
        int sourceMode;
        final b worker;

        ObserveOnObserver(eqg<? super T> com_fossil_eqg__super_T, b bVar, boolean z, int i) {
            this.actual = com_fossil_eqg__super_T;
            this.worker = bVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        public void onSubscribe(eqn com_fossil_eqn) {
            if (DisposableHelper.validate(this.f1654s, com_fossil_eqn)) {
                this.f1654s = com_fossil_eqn;
                if (com_fossil_eqn instanceof erb) {
                    erb com_fossil_erb = (erb) com_fossil_eqn;
                    int requestFusion = com_fossil_erb.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = com_fossil_erb;
                        this.done = true;
                        this.actual.onSubscribe(this);
                        schedule();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = com_fossil_erb;
                        this.actual.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new erh(this.bufferSize);
                this.actual.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        public void onError(Throwable th) {
            if (this.done) {
                ers.onError(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.f1654s.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }

        void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.o(this);
            }
        }

        void drainNormal() {
            ere com_fossil_ere = this.queue;
            eqg com_fossil_eqg = this.actual;
            int i = 1;
            while (!checkTerminated(this.done, com_fossil_ere.isEmpty(), com_fossil_eqg)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        Object poll = com_fossil_ere.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, com_fossil_eqg)) {
                            if (z2) {
                                i = addAndGet(-i);
                                if (i == 0) {
                                    return;
                                }
                            }
                            com_fossil_eqg.onNext(poll);
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        eqp.k(th);
                        this.f1654s.dispose();
                        com_fossil_ere.clear();
                        com_fossil_eqg.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        void drainFused() {
            int i = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.actual.onNext(null);
                    if (z) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.actual.onError(th2);
                        } else {
                            this.actual.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
                this.actual.onError(this.error);
                this.worker.dispose();
                return;
            }
        }

        public void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        boolean checkTerminated(boolean z, boolean z2, eqg<? super T> com_fossil_eqg__super_T) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            }
            if (z) {
                Throwable th = this.error;
                if (this.delayError) {
                    if (z2) {
                        if (th != null) {
                            com_fossil_eqg__super_T.onError(th);
                        } else {
                            com_fossil_eqg__super_T.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else if (th != null) {
                    this.queue.clear();
                    com_fossil_eqg__super_T.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (z2) {
                    com_fossil_eqg__super_T.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
            return false;
        }

        public int requestFusion(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void clear() {
            this.queue.clear();
        }

        public boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    public ObservableObserveOn(eqf<T> com_fossil_eqf_T, eqh com_fossil_eqh, boolean z, int i) {
        super(com_fossil_eqf_T);
        this.dRu = com_fossil_eqh;
        this.delayError = z;
        this.bufferSize = i;
    }

    protected void m16329b(eqg<? super T> com_fossil_eqg__super_T) {
        if (this.dRu instanceof erp) {
            this.dRt.a(com_fossil_eqg__super_T);
            return;
        }
        this.dRt.a(new ObserveOnObserver(com_fossil_eqg__super_T, this.dRu.aGG(), this.delayError, this.bufferSize));
    }
}
