package solidPrinciples.exercises.logger.interfaces;

import solidPrinciples.exercises.logger.enums.ReportLevel;

public interface Layout {

    String format(String time, String message, ReportLevel reportLevel);
}
