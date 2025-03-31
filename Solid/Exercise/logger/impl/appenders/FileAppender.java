package Solid.Exercise.logger.impl.appenders;

import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.interfaces.File;
import Solid.Exercise.logger.interfaces.Layout;

public class FileAppender extends BaseAppender {

    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }
    public FileAppender(Layout layout, String fileName) {
        this(layout);
        this.file = new LogFile(fileName);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {

        if (canAppend(reportLevel)) {
            String output = this.layout.format(date, reportLevel, message);
            increaseMessageCount();
            file.append(output);
        }
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
