package kotlin;

import com.fossil.esl;

public final class UninitializedPropertyAccessException extends RuntimeException {
    public UninitializedPropertyAccessException(String str) {
        esl.j(str, "message");
        super(str);
    }

    public UninitializedPropertyAccessException(String str, Throwable th) {
        esl.j(str, "message");
        esl.j(th, "cause");
        super(str, th);
    }

    public UninitializedPropertyAccessException(Throwable th) {
        esl.j(th, "cause");
        super(th);
    }
}
