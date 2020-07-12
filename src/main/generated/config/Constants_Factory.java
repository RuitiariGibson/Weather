package config;

import dagger.internal.Factory;
import javax.annotation.processing.Generated;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Constants_Factory implements Factory<Constants> {
  @Override
  public Constants get() {
    return newInstance();
  }

  public static Constants_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Constants newInstance() {
    return new Constants();
  }

  private static final class InstanceHolder {
    private static final Constants_Factory INSTANCE = new Constants_Factory();
  }
}
