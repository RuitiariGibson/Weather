package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WeatherUpdateClass {
    @SerializedName("weather_state_name")
 private final String weatherStateName;
    @SerializedName("applicable_date")
 private final String applicableDate;
    @SerializedName("max_temp")
 private final double maxTemp;
    @SerializedName("min_temp")
    private final double minTemp;
    @SerializedName("the_temp")
 private final double temp;
    @SerializedName("humidity")
 private final double humidity;
    @SerializedName("predictability")
 private final double predictability;
    @SerializedName("air_pressure")
 private final double airPressure;
}
