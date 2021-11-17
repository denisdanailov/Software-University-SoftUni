package solidPrinciples.exercises.logger.layouts;

import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String time, String message, ReportLevel reportLevel) {
        return String.format("%s - %s - %s", time, reportLevel.name(), message);
    }
}
