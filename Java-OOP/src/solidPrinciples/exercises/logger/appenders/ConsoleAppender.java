package solidPrinciples.exercises.logger.appenders;

import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.Layout;

import java.util.List;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.canAppend(reportLevel)) {
            String formattedMessage = super.getLayout().format(time, message, reportLevel);
            super.msgAppended.add(formattedMessage);
            System.out.println(formattedMessage);
        }
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        super.setReportLevel(reportLevel);
    }

    @Override
    public List<String> getMsgAppended() {
        return super.getMsgAppended();
    }

    @Override
    public String toString() {
        return String.format("Appender type: ConsoleAppender, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(),
                this.getMsgAppended().size());
    }
}
