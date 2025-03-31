package Solid.Exercise.logger.impl.factories;

import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.impl.appenders.ConsoleAppender;
import Solid.Exercise.logger.impl.appenders.FileAppender;
import Solid.Exercise.logger.interfaces.Appender;
import Solid.Exercise.logger.interfaces.Factory;
import Solid.Exercise.logger.interfaces.Layout;

public class AppenderFactory implements Factory<Appender> {

    private LayoutFactory layoutFactory;

    public AppenderFactory() {
        this.layoutFactory = new LayoutFactory();
    }

    @Override
    public Appender produce(String input) {
        String[] tokens = input.split("\\s+");

        String appenderType = tokens[0];
        String layoutType = tokens[1];

        Layout layout = this.layoutFactory.produce(layoutType);

        Appender appender = null;

        if (appenderType.equals("ConsoleAppender")) {
            appender = new ConsoleAppender(layout);
        } else if (appenderType.equals("FileAppender")) {
            appender = new FileAppender(layout);
        }

        if (tokens.length == 3) {
            appender.setReportLevel(ReportLevel.valueOf(tokens[2]));
        }
        return appender;
    }
}
