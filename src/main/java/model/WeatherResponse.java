package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;
@Data
public class WeatherResponse {

    @SerializedName("consolidated_weather")
    private final List<WeatherUpdateClass>weatherUpdateClassList;
}
