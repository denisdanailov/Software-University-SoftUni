package solidPrinciples.exercises.logger.appenders;

import solidPrinciples.exercises.logger.enums.ReportLevel;
import solidPrinciples.exercises.logger.file.LogFile;
import solidPrinciples.exercises.logger.interfaces.Appender;
import solidPrinciples.exercises.logger.interfaces.File;
import solidPrinciples.exercises.logger.interfaces.Layout;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    @Override
    public void append(String time, String message, ReportLevel reportLevel) {
        if (super.canAppend(reportLevel)) {
            String output = this.getLayout().format(time, message, reportLevel);
            super.msgAppended.add(output);
            file.append(output);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return String.format("Appender type: FileAppender, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d",
                this.getLayout().getClass().getSimpleName(),
                this.getReportLevel().name(),
                this.getMsgAppended().size(),
                this.file.getSize());
    }
}
