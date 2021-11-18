package solidPrinciples.exercises.logger.loggers;

import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.Logger;

import java.util.Arrays;

public class MessageLogger implements Logger {

    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    private void log(String time, String message, ReportLevel reportLevel) {
        Arrays.stream(appenders).forEach(appender -> appender.append(time, message, reportLevel));
    }

    @Override
    public void logInfo(String time, String message) {
        log(time, message, ReportLevel.INFO);
    }

    @Override
    public void logWarning(String time, String message) {
        log(time, message, ReportLevel.WARNING);
    }

    @Override
    public void logError(String time, String message) {
        log(time, message, ReportLevel.ERROR);
    }

    @Override
    public void logCritical(String time, String message) {
        log(time, message, ReportLevel.CRITICAL);
    }

    @Override
    public void logFatal(String time, String message) {
        log(time, message, ReportLevel.FATAL);
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("Logger info").append(System.lineSeparator());
        for (Appender appender : appenders) {
            strBuild.append(appender).append(System.lineSeparator());
        }
        return strBuild.toString().trim();
    }
}
