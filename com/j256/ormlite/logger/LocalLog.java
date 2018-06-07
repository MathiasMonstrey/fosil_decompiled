package com.j256.ormlite.logger;

import android.support.v8.renderscript.Allocation;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.misc.IOUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class LocalLog implements Log {
    private static final Level DEFAULT_LEVEL = Level.DEBUG;
    public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
    public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
    public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
    private static final List<PatternLevel> classLevels = readLevelResourceFile(LocalLog.class.getResourceAsStream(LOCAL_LOG_PROPERTIES_FILE));
    private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new C44241();
    private static PrintStream printStream;
    private final String className;
    private final Level level;

    static class C44241 extends ThreadLocal<DateFormat> {
        C44241() {
        }

        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        }
    }

    static class PatternLevel {
        Level level;
        Pattern pattern;

        public PatternLevel(Pattern pattern, Level level) {
            this.pattern = pattern;
            this.level = level;
        }
    }

    static {
        openLogFile(System.getProperty(LOCAL_LOG_FILE_PROPERTY));
    }

    public LocalLog(String str) {
        Level level;
        this.className = LoggerFactory.getSimpleClassName(str);
        Level level2 = null;
        if (classLevels != null) {
            for (PatternLevel patternLevel : classLevels) {
                if (!patternLevel.pattern.matcher(str).matches() || (level2 != null && patternLevel.level.ordinal() >= level2.ordinal())) {
                    level = level2;
                } else {
                    level = patternLevel.level;
                }
                level2 = level;
            }
            level = level2;
        } else {
            level = null;
        }
        if (level == null) {
            String property = System.getProperty(LOCAL_LOG_LEVEL_PROPERTY);
            if (property == null) {
                level = DEFAULT_LEVEL;
            } else {
                try {
                    level = Level.valueOf(property.toUpperCase());
                } catch (IllegalArgumentException e) {
                    try {
                        level = Level.valueOf(property.toUpperCase(Locale.ENGLISH));
                    } catch (Throwable e2) {
                        throw new IllegalArgumentException("Level '" + property + "' was not found", e2);
                    }
                }
            }
        }
        this.level = level;
    }

    public static void openLogFile(String str) {
        if (str == null) {
            printStream = System.out;
            return;
        }
        try {
            printStream = new PrintStream(new File(str));
        } catch (Throwable e) {
            throw new IllegalArgumentException("Log file " + str + " was not found", e);
        }
    }

    public boolean isLevelEnabled(Level level) {
        return this.level.isEnabled(level);
    }

    public void log(Level level, String str) {
        printMessage(level, str, null);
    }

    public void log(Level level, String str, Throwable th) {
        printMessage(level, str, th);
    }

    void flush() {
        printStream.flush();
    }

    static List<PatternLevel> readLevelResourceFile(InputStream inputStream) {
        List<PatternLevel> list = null;
        if (inputStream != null) {
            try {
                list = configureClassLevels(inputStream);
            } catch (IOException e) {
                System.err.println("IO exception reading the log properties file '/ormliteLocalLog.properties': " + e);
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        return list;
    }

    private static List<PatternLevel> configureClassLevels(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        List<PatternLevel> arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            if (!(readLine.length() == 0 || readLine.charAt(0) == '#')) {
                String[] split = readLine.split(SimpleComparison.EQUAL_TO_OPERATION);
                if (split.length != 2) {
                    System.err.println("Line is not in the format of 'pattern = level': " + readLine);
                } else {
                    try {
                        arrayList.add(new PatternLevel(Pattern.compile(split[0].trim()), Level.valueOf(split[1].trim())));
                    } catch (IllegalArgumentException e) {
                        System.err.println("Level '" + split[1] + "' was not found");
                    }
                }
            }
        }
    }

    private void printMessage(Level level, String str, Throwable th) {
        if (isLevelEnabled(level)) {
            StringBuilder stringBuilder = new StringBuilder(Allocation.USAGE_SHARED);
            stringBuilder.append(((DateFormat) dateFormatThreadLocal.get()).format(new Date()));
            stringBuilder.append(" [").append(level.name()).append("] ");
            stringBuilder.append(this.className).append(' ');
            stringBuilder.append(str);
            printStream.println(stringBuilder.toString());
            if (th != null) {
                th.printStackTrace(printStream);
            }
        }
    }
}
