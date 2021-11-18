package solidPrinciples.exercises.logger.factories;

import solidPrinciples.exercises.logger.appenders.ConsoleAppender;
import solidPrinciples.exercises.logger.appenders.FileAppender;
import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.Factory;
import solidPrinciples.exercises.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    @Override
    public Appender produce(String input) {
        LayoutFactory layoutFactory = new LayoutFactory();

        String[] tokens = input.split("\\s+");
        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = layoutFactory.produce(layoutType);
        Appender appender = null;

        switch (appenderType) {
            case "ConsoleAppender":
                appender = new ConsoleAppender(layout);
                break;
            case "FileAppender":
                appender = new FileAppender(layout);
                break;
        }

        if (tokens.length >= 3) {
            appender.setReportLevel(ReportLevel.valueOf(tokens[2].toUpperCase()));
        }

        return appender;
    }
}
