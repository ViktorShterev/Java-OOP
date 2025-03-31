package Solid.Exercise.logger.interfaces;

import Solid.Exercise.logger.enums.ReportLevel;


public interface Appender {

    void append(String date, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);

}
