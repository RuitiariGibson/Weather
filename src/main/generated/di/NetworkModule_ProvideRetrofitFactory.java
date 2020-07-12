package di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class NetworkModule_ProvideRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> clientProvider;

  public NetworkModule_ProvideRetrofitFactory(NetworkModule module,
      Provider<OkHttpClient> clientProvider) {
    this.module = module;
    this.clientProvider = clientProvider;
  }

  @Override
  public Retrofit get() {
    return provideRetrofit(module, clientProvider.get());
  }

  public static NetworkModule_ProvideRetrofitFactory create(NetworkModule module,
      Provider<OkHttpClient> clientProvider) {
    return new NetworkModule_ProvideRetrofitFactory(module, clientProvider);
  }

  public static Retrofit provideRetrofit(NetworkModule instance, OkHttpClient client) {
    return Preconditions.checkNotNull(instance.provideRetrofit(client), "Cannot return null from a non-@Nullable @Provides method");
  }
}
