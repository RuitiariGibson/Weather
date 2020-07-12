package di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  public NetworkModule_ProvideOkHttpClientFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(module);
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(NetworkModule module) {
    return new NetworkModule_ProvideOkHttpClientFactory(module);
  }

  public static OkHttpClient provideOkHttpClient(NetworkModule instance) {
    return Preconditions.checkNotNull(instance.provideOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
