package network;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WeatherRepo_Factory implements Factory<WeatherRepo> {
  private final Provider<ApiService> apiServiceProvider;

  public WeatherRepo_Factory(Provider<ApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public WeatherRepo get() {
    return newInstance(apiServiceProvider.get());
  }

  public static WeatherRepo_Factory create(Provider<ApiService> apiServiceProvider) {
    return new WeatherRepo_Factory(apiServiceProvider);
  }

  public static WeatherRepo newInstance(ApiService apiService) {
    return new WeatherRepo(apiService);
  }
}
