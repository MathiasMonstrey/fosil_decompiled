package org.apache.commons.lang;

import com.fossil.euf;
import java.io.PrintStream;
import java.io.PrintWriter;
import org.apache.commons.lang.exception.NestableDelegate;

public class NotImplementedException extends UnsupportedOperationException implements euf {
    private static final long serialVersionUID = -6894122266938754088L;
    private Throwable cause;
    private NestableDelegate delegate;

    public NotImplementedException() {
        super("Code is not implemented");
        this.delegate = new NestableDelegate(this);
    }

    public NotImplementedException(String str) {
        if (str == null) {
            str = "Code is not implemented";
        }
        super(str);
        this.delegate = new NestableDelegate(this);
    }

    public NotImplementedException(Throwable th) {
        super("Code is not implemented");
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    public NotImplementedException(String str, Throwable th) {
        if (str == null) {
            str = "Code is not implemented";
        }
        super(str);
        this.delegate = new NestableDelegate(this);
        this.cause = th;
    }

    public NotImplementedException(Class cls) {
        String str;
        if (cls == null) {
            str = "Code is not implemented";
        } else {
            str = new StringBuffer().append("Code is not implemented in ").append(cls).toString();
        }
        super(str);
        this.delegate = new NestableDelegate(this);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public String getMessage() {
        if (super.getMessage() != null) {
            return super.getMessage();
        }
        if (this.cause != null) {
            return this.cause.toString();
        }
        return null;
    }

    public String getMessage(int i) {
        if (i == 0) {
            return super.getMessage();
        }
        return this.delegate.getMessage(i);
    }

    public String[] getMessages() {
        return this.delegate.getMessages();
    }

    public Throwable getThrowable(int i) {
        return this.delegate.getThrowable(i);
    }

    public int getThrowableCount() {
        return this.delegate.getThrowableCount();
    }

    public Throwable[] getThrowables() {
        return this.delegate.getThrowables();
    }

    public int indexOfThrowable(Class cls) {
        return this.delegate.indexOfThrowable(cls, 0);
    }

    public int indexOfThrowable(Class cls, int i) {
        return this.delegate.indexOfThrowable(cls, i);
    }

    public void printStackTrace() {
        this.delegate.printStackTrace();
    }

    public void printStackTrace(PrintStream printStream) {
        this.delegate.printStackTrace(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        this.delegate.printStackTrace(printWriter);
    }

    public final void printPartialStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
    }
}
