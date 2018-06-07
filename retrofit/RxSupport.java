package retrofit;

import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

final class RxSupport {
    private final ErrorHandler errorHandler;
    private final Executor executor;
    private final RequestInterceptor requestInterceptor;

    interface Invoker {
        ResponseWrapper invoke(RequestInterceptor requestInterceptor);
    }

    RxSupport(Executor executor, ErrorHandler errorHandler, RequestInterceptor requestInterceptor) {
        this.executor = executor;
        this.errorHandler = errorHandler;
        this.requestInterceptor = requestInterceptor;
    }

    Observable createRequestObservable(final Invoker invoker) {
        return Observable.create(new OnSubscribe<Object>() {
            public void call(Subscriber<? super Object> subscriber) {
                Object requestInterceptorTape = new RequestInterceptorTape();
                RxSupport.this.requestInterceptor.intercept(requestInterceptorTape);
                Object futureTask = new FutureTask(RxSupport.this.getRunnable(subscriber, invoker, requestInterceptorTape), null);
                subscriber.add(Subscriptions.from(futureTask));
                RxSupport.this.executor.execute(futureTask);
            }
        });
    }

    private Runnable getRunnable(final Subscriber<? super Object> subscriber, final Invoker invoker, final RequestInterceptorTape requestInterceptorTape) {
        return new Runnable() {
            public void run() {
                try {
                    if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(invoker.invoke(requestInterceptorTape).responseBody);
                        subscriber.onCompleted();
                    }
                } catch (RetrofitError e) {
                    subscriber.onError(RxSupport.this.errorHandler.handleError(e));
                }
            }
        };
    }
}
