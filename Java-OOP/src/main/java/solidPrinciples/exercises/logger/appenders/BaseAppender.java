package solidPrinciples.exercises.logger.appenders;

import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.Layout;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseAppender implements Appender {
    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private Layout layout;
    private ReportLevel reportLevel;
    protected List<String> msgAppended;

    protected BaseAppender (Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.msgAppended = new ArrayList<>();
    }

    protected BaseAppender (Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    public Layout getLayout() {
        return layout;
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    public boolean canAppend(ReportLevel reportLevel) {
        if (this.reportLevel.getLevel() == 0) {
            return true;
        } else if (reportLevel.getLevel() >= this.reportLevel.getLevel()) {
            return true;
        }
        return false;
    }

    public List<String> getMsgAppended() {
        return msgAppended;
    }
}
