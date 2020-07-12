package app;

import dagger.Component;
import di.NetworkModule;
import network.WeatherRepo;
import javax.inject.Singleton;
// application component
// add network module to the binding graph
@Component(modules = {NetworkModule.class})
@Singleton
public interface WeatherApp {
WeatherRepo repo();
}
