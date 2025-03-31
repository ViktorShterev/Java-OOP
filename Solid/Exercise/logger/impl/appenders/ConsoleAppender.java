package Solid.Exercise.logger.impl.appenders;

import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {

        if (canAppend(reportLevel)) {
            String formattedMessage = this.layout.format(date, reportLevel, message);
            increaseMessageCount();
            System.out.println(formattedMessage);
        }
    }
}
