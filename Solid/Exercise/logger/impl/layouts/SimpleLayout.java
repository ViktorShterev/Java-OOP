package Solid.Exercise.logger.impl.layouts;


import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.interfaces.Layout;

public class SimpleLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", date, reportLevel, message);
    }
}
