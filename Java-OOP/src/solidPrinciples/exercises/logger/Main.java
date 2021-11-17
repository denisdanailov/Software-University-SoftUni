package solidPrinciples.exercises.logger;

import solidPrinciples.exercises.logger.appenders.ConsoleAppender;
import solidPrinciples.exercises.logger.appenders.FileAppender;
import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.Layout;
import solidPrinciples.exercises.logger.interfaces.Logger;
import solidPrinciples.exercises.logger.layouts.SimpleLayout;
import solidPrinciples.exercises.logger.layouts.XmlLayout;
import solidPrinciples.exercises.logger.loggers.MessageLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Logger> loggerList = new ArrayList<>();
        List<Appender> appenderList = new ArrayList<>();

        int numAppenders = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < numAppenders; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String appenderType = tokens[0];
            switch (appenderType) {
                case "ConsoleAppender":
                    if (tokens.length == 2) {
                        String layoutType = tokens[1];
                        switch (layoutType) {
                            case "SimpleLayout":
                                SimpleLayout layout = new SimpleLayout();
                                ConsoleAppender appender = new ConsoleAppender(layout);
                                appenderList.add(appender);
                                Logger logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                            case "XmlLayout":
                                 XmlLayout xmlLayout = new XmlLayout();
                                 appender = new ConsoleAppender(xmlLayout);
                                appenderList.add(appender);
                                logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                        }
                    } else if (tokens.length == 3) {
                        String layoutType = tokens[1];
                        String reportLevel = tokens[2];
                        switch (layoutType) {
                            case "SimpleLayout":
                                SimpleLayout layout = new SimpleLayout();
                                ConsoleAppender appender = new ConsoleAppender(layout, ReportLevel.valueOf(reportLevel.toUpperCase()));
                                appenderList.add(appender);
                                Logger logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                            case "XmlLayout":
                                XmlLayout xmlLayout = new XmlLayout();
                                appender = new ConsoleAppender(xmlLayout, ReportLevel.valueOf(reportLevel.toUpperCase()));
                                appenderList.add(appender);
                                logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                        }
                    }
                    break;
                case "FileAppender":
                    if (tokens.length == 2) {
                        String layoutType = tokens[1];
                        switch (layoutType) {
                            case "SimpleLayout":
                                SimpleLayout layout = new SimpleLayout();
                                FileAppender appender = new FileAppender(layout);
                                appenderList.add(appender);
                                Logger logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                            case "XmlLayout":
                                XmlLayout xmlLayout = new XmlLayout();
                                appender = new FileAppender(xmlLayout);
                                appenderList.add(appender);
                                logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                        }
                    } else if (tokens.length == 3) {
                        String layoutType = tokens[1];
                        String reportLevel = tokens[2];
                        switch (layoutType) {
                            case "SimpleLayout":
                                SimpleLayout layout = new SimpleLayout();
                                FileAppender appender = new FileAppender(layout, ReportLevel.valueOf(reportLevel.toUpperCase()));
                                appenderList.add(appender);
                                Logger logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                            case "XmlLayout":
                                XmlLayout xmlLayout = new XmlLayout();
                                appender = new FileAppender(xmlLayout, ReportLevel.valueOf(reportLevel.toUpperCase()));
                                appenderList.add(appender);
                                logger = new MessageLogger(appender);
                                loggerList.add(logger);
                                break;
                        }
                    }
                    break;
            }
        }

        String input = scan.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(tokens[0].toUpperCase());
            String time = tokens[1];
            String message = tokens[2];
            switch (reportLevel) {
                case INFO:
                    loggerList.stream().forEach(logg -> logg.logInfo(time,message));
                    break;
                case WARNING:
                    loggerList.stream().forEach(logg -> logg.logWarning(time,message));
                    break;
                case ERROR:
                    loggerList.stream().forEach(logg -> logg.logError(time,message));
                    break;
                case CRITICAL:
                    loggerList.stream().forEach(logg -> logg.logCritical(time,message));
                    break;
                case FATAL:
                    loggerList.stream().forEach(logg -> logg.logFatal(time,message));
                    break;
            }
            input = scan.nextLine();
        }

        System.out.println("Logger info");

        appenderList.forEach(System.out::println);



//        System.out.println(consoleAppender.getClass().getSimpleName());
//        System.out.println(consoleAppender.getLayout().getClass().getSimpleName());
//        System.out.println(consoleAppender.getReportLevel().name());
//        System.out.println(consoleAppender.getMsgAppended().size());
    }
}
