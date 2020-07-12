package model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class WoeidResponse {
    @SerializedName("title")
    private final String title;
    @SerializedName("location_type")
    private final String locationType;
    @SerializedName("woeid")
    private final int woeid;
}
