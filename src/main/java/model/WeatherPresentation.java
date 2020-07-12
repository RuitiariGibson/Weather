package model;

import lombok.Data;

@Data
public class WeatherPresentation {
    private String weatherStateName;
    private  String applicableDate;
    private  double maxTemp;
    private  double minTemp;
    private  double temp;
    private  double humidity;
    private  double predictability;
    private  double airPressure;
    private  String locationText;
}
