package di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import network.ApiService;
import retrofit2.Retrofit;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final NetworkModule module;

  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideApiServiceFactory(NetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    this.module = module;
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public ApiService get() {
    return provideApiService(module, retrofitProvider.get());
  }

  public static NetworkModule_ProvideApiServiceFactory create(NetworkModule module,
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideApiServiceFactory(module, retrofitProvider);
  }

  public static ApiService provideApiService(NetworkModule instance, Retrofit retrofit) {
    return Preconditions.checkNotNull(instance.provideApiService(retrofit), "Cannot return null from a non-@Nullable @Provides method");
  }
}
