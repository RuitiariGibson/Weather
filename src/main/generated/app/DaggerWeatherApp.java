package app;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import di.NetworkModule;
import di.NetworkModule_ProvideApiServiceFactory;
import di.NetworkModule_ProvideOkHttpClientFactory;
import di.NetworkModule_ProvideRetrofitFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import network.ApiService;
import network.WeatherRepo;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerWeatherApp implements WeatherApp {
  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<Retrofit> provideRetrofitProvider;

  private Provider<ApiService> provideApiServiceProvider;

  private DaggerWeatherApp(NetworkModule networkModuleParam) {

    initialize(networkModuleParam);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static WeatherApp create() {
    return new Builder().build();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final NetworkModule networkModuleParam) {
    this.provideOkHttpClientProvider = DoubleCheck.provider(NetworkModule_ProvideOkHttpClientFactory.create(networkModuleParam));
    this.provideRetrofitProvider = DoubleCheck.provider(NetworkModule_ProvideRetrofitFactory.create(networkModuleParam, provideOkHttpClientProvider));
    this.provideApiServiceProvider = DoubleCheck.provider(NetworkModule_ProvideApiServiceFactory.create(networkModuleParam, provideRetrofitProvider));
  }

  @Override
  public WeatherRepo repo() {
    return new WeatherRepo(provideApiServiceProvider.get());}

  public static final class Builder {
    private NetworkModule networkModule;

    private Builder() {
    }

    public Builder networkModule(NetworkModule networkModule) {
      this.networkModule = Preconditions.checkNotNull(networkModule);
      return this;
    }

    public WeatherApp build() {
      if (networkModule == null) {
        this.networkModule = new NetworkModule();
      }
      return new DaggerWeatherApp(networkModule);
    }
  }
}
