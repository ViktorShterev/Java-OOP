package Solid.Exercise.logger.impl.layouts;


import Solid.Exercise.logger.enums.ReportLevel;
import Solid.Exercise.logger.interfaces.Layout;

public class XmlLayout implements Layout {

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", date, reportLevel, message);
    }
}
