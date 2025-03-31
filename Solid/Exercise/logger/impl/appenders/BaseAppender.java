package Solid.Exercise.logger.impl.appenders;

import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.interfaces.Appender;
import Solid.Exercise.logger.interfaces.Layout;

public abstract class BaseAppender implements Appender {

    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    Layout layout;
    private ReportLevel reportLevel;
    private int messageCount;

    public BaseAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    public BaseAppender(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.messageCount = 0;
    }
    public boolean canAppend(ReportLevel reportLevel) {
        return this.reportLevel.ordinal() <= reportLevel.ordinal();
    }

    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }
    public void increaseMessageCount() {
        this.messageCount++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(),
                this.reportLevel, this.messageCount);
    }
}
