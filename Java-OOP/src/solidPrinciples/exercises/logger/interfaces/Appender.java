package solidPrinciples.exercises.logger.interfaces;

import solidPrinciples.exercises.logger.enums.ReportLevel;

import java.util.Collection;
import java.util.List;

public interface Appender {

    void append(String time, String message, ReportLevel reportLevel);
    void setReportLevel(ReportLevel reportLevel);
    Layout getLayout();
    ReportLevel getReportLevel();
    List<String> getMsgAppended();
}
