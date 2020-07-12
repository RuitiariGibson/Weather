package network;


import io.reactivex.rxjava3.core.Single;
import model.WeatherResponse;
import model.WoeidResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import java.util.List;

public interface ApiService {
@GET("/api/location/search/")
Single<List<WoeidResponse>> getWoeid(@Query("query") String query);
@GET("api/location/{woeid}/")
    Single<WeatherResponse>getWeatherUpdates(@Path("woeid") int woeid);

}
