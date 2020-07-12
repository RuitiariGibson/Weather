package base;

import app.DaggerWeatherApp;
import app.WeatherApp;
import javafx.application.Application;

/**
 * This provides a high-level abstraction do not modify this.
 */
abstract public class BaseClass extends Application {
   public static WeatherApp initializeDaggerApplication(){
       return DaggerWeatherApp.create();
   }
}
