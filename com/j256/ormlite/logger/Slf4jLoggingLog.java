package com.j256.ormlite.logger;

import com.j256.ormlite.logger.Log.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLoggingLog implements Log {
    private final Logger logger;

    public Slf4jLoggingLog(String str) {
        this.logger = LoggerFactory.getLogger(str);
    }

    public boolean isLevelEnabled(Level level) {
        switch (level) {
            case TRACE:
                return this.logger.isTraceEnabled();
            case DEBUG:
                return this.logger.isDebugEnabled();
            case INFO:
                return this.logger.isInfoEnabled();
            case WARNING:
                return this.logger.isWarnEnabled();
            case ERROR:
                return this.logger.isErrorEnabled();
            case FATAL:
                return this.logger.isErrorEnabled();
            default:
                return this.logger.isInfoEnabled();
        }
    }

    public void log(Level level, String str) {
        switch (level) {
            case TRACE:
                this.logger.trace(str);
                return;
            case DEBUG:
                this.logger.debug(str);
                return;
            case INFO:
                this.logger.info(str);
                return;
            case WARNING:
                this.logger.warn(str);
                return;
            case ERROR:
                this.logger.error(str);
                return;
            case FATAL:
                this.logger.error(str);
                return;
            default:
                this.logger.info(str);
                return;
        }
    }

    public void log(Level level, String str, Throwable th) {
        switch (level) {
            case TRACE:
                this.logger.trace(str, th);
                return;
            case DEBUG:
                this.logger.debug(str, th);
                return;
            case INFO:
                this.logger.info(str, th);
                return;
            case WARNING:
                this.logger.warn(str, th);
                return;
            case ERROR:
                this.logger.error(str, th);
                return;
            case FATAL:
                this.logger.error(str, th);
                return;
            default:
                this.logger.info(str, th);
                return;
        }
    }
}
