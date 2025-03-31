package Solid.Exercise.logger.interfaces;


import Solid.Exercise.logger.enums.ReportLevel;

public interface Layout {

    String format(String date, ReportLevel reportLevel, String message);
}
