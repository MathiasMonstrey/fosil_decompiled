package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log.Level;
import java.lang.reflect.Array;

public class Logger {
    private static final String ARG_STRING = "{}";
    private static final int DEFAULT_FULL_MESSAGE_LENGTH = 128;
    private static final Object UNKNOWN_ARG = new Object();
    private final Log log;

    public Logger(Log log) {
        this.log = log;
    }

    public boolean isLevelEnabled(Level level) {
        return this.log.isLevelEnabled(level);
    }

    public void trace(String str) {
        logIfEnabled(Level.TRACE, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void trace(String str, Object obj) {
        logIfEnabled(Level.TRACE, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void trace(String str, Object obj, Object obj2) {
        logIfEnabled(Level.TRACE, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.TRACE, null, str, obj, obj2, obj3, null);
    }

    public void trace(String str, Object[] objArr) {
        logIfEnabled(Level.TRACE, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void trace(Throwable th, String str) {
        logIfEnabled(Level.TRACE, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void trace(Throwable th, String str, Object obj) {
        logIfEnabled(Level.TRACE, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.TRACE, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void trace(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.TRACE, th, str, obj, obj2, obj3, null);
    }

    public void trace(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.TRACE, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void debug(String str) {
        logIfEnabled(Level.DEBUG, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(String str, Object obj) {
        logIfEnabled(Level.DEBUG, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(String str, Object obj, Object obj2) {
        logIfEnabled(Level.DEBUG, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.DEBUG, null, str, obj, obj2, obj3, null);
    }

    public void debug(String str, Object[] objArr) {
        logIfEnabled(Level.DEBUG, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void debug(Throwable th, String str) {
        logIfEnabled(Level.DEBUG, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(Throwable th, String str, Object obj) {
        logIfEnabled(Level.DEBUG, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.DEBUG, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void debug(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.DEBUG, th, str, obj, obj2, obj3, null);
    }

    public void debug(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.DEBUG, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void info(String str) {
        logIfEnabled(Level.INFO, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(String str, Object obj) {
        logIfEnabled(Level.INFO, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(String str, Object obj, Object obj2) {
        logIfEnabled(Level.INFO, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.INFO, null, str, obj, obj2, obj3, null);
    }

    public void info(String str, Object[] objArr) {
        logIfEnabled(Level.INFO, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void info(Throwable th, String str) {
        logIfEnabled(Level.INFO, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(Throwable th, String str, Object obj) {
        logIfEnabled(Level.INFO, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.INFO, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void info(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.INFO, th, str, obj, obj2, obj3, null);
    }

    public void info(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.INFO, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void warn(String str) {
        logIfEnabled(Level.WARNING, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void warn(String str, Object obj) {
        logIfEnabled(Level.WARNING, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void warn(String str, Object obj, Object obj2) {
        logIfEnabled(Level.WARNING, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.WARNING, null, str, obj, obj2, obj3, null);
    }

    public void warn(String str, Object[] objArr) {
        logIfEnabled(Level.WARNING, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void warn(Throwable th, String str) {
        logIfEnabled(Level.WARNING, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void warn(Throwable th, String str, Object obj) {
        logIfEnabled(Level.WARNING, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.WARNING, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void warn(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.WARNING, th, str, obj, obj2, obj3, null);
    }

    public void warn(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.WARNING, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void error(String str) {
        logIfEnabled(Level.ERROR, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void error(String str, Object obj) {
        logIfEnabled(Level.ERROR, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void error(String str, Object obj, Object obj2) {
        logIfEnabled(Level.ERROR, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.ERROR, null, str, obj, obj2, obj3, null);
    }

    public void error(String str, Object[] objArr) {
        logIfEnabled(Level.ERROR, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void error(Throwable th, String str) {
        logIfEnabled(Level.ERROR, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void error(Throwable th, String str, Object obj) {
        logIfEnabled(Level.ERROR, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.ERROR, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void error(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.ERROR, th, str, obj, obj2, obj3, null);
    }

    public void error(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.ERROR, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void fatal(String str) {
        logIfEnabled(Level.FATAL, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void fatal(String str, Object obj) {
        logIfEnabled(Level.FATAL, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void fatal(String str, Object obj, Object obj2) {
        logIfEnabled(Level.FATAL, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.FATAL, null, str, obj, obj2, obj3, null);
    }

    public void fatal(String str, Object[] objArr) {
        logIfEnabled(Level.FATAL, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void fatal(Throwable th, String str) {
        logIfEnabled(Level.FATAL, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void fatal(Throwable th, String str, Object obj) {
        logIfEnabled(Level.FATAL, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(Level.FATAL, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void fatal(Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(Level.FATAL, th, str, obj, obj2, obj3, null);
    }

    public void fatal(Throwable th, String str, Object[] objArr) {
        logIfEnabled(Level.FATAL, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void log(Level level, String str) {
        logIfEnabled(level, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void log(Level level, String str, Object obj) {
        logIfEnabled(level, null, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void log(Level level, String str, Object obj, Object obj2) {
        logIfEnabled(level, null, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Level level, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(level, null, str, obj, obj2, obj3, null);
    }

    public void log(Level level, String str, Object[] objArr) {
        logIfEnabled(level, null, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    public void log(Level level, Throwable th, String str) {
        logIfEnabled(level, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void log(Level level, Throwable th, String str, Object obj) {
        logIfEnabled(level, th, str, obj, UNKNOWN_ARG, UNKNOWN_ARG, null);
    }

    public void log(Level level, Throwable th, String str, Object obj, Object obj2) {
        logIfEnabled(level, th, str, obj, obj2, UNKNOWN_ARG, null);
    }

    public void log(Level level, Throwable th, String str, Object obj, Object obj2, Object obj3) {
        logIfEnabled(level, th, str, obj, obj2, obj3, null);
    }

    public void log(Level level, Throwable th, String str, Object[] objArr) {
        logIfEnabled(level, th, str, UNKNOWN_ARG, UNKNOWN_ARG, UNKNOWN_ARG, objArr);
    }

    private void logIfEnabled(Level level, Throwable th, String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        if (this.log.isLevelEnabled(level)) {
            String buildFullMessage = buildFullMessage(str, obj, obj2, obj3, objArr);
            if (th == null) {
                this.log.log(level, buildFullMessage);
            } else {
                this.log.log(level, buildFullMessage, th);
            }
        }
    }

    private String buildFullMessage(String str, Object obj, Object obj2, Object obj3, Object[] objArr) {
        int i = 0;
        StringBuilder stringBuilder = null;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(ARG_STRING, i);
            if (indexOf == -1) {
                break;
            }
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder(128);
            }
            stringBuilder.append(str, i, indexOf);
            i = ARG_STRING.length() + indexOf;
            if (objArr == null) {
                if (i2 == 0) {
                    appendArg(stringBuilder, obj);
                } else if (i2 == 1) {
                    appendArg(stringBuilder, obj2);
                } else if (i2 == 2) {
                    appendArg(stringBuilder, obj3);
                }
            } else if (i2 < objArr.length) {
                appendArg(stringBuilder, objArr[i2]);
            }
            i2++;
        }
        if (stringBuilder == null) {
            return str;
        }
        stringBuilder.append(str, i, str.length());
        return stringBuilder.toString();
    }

    private void appendArg(StringBuilder stringBuilder, Object obj) {
        if (obj != UNKNOWN_ARG) {
            if (obj == null) {
                stringBuilder.append("null");
            } else if (obj.getClass().isArray()) {
                stringBuilder.append('[');
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    if (i > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(Array.get(obj, i));
                }
                stringBuilder.append(']');
            } else {
                stringBuilder.append(obj.toString());
            }
        }
    }
}
