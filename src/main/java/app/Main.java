package app;

import base.BaseClass;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * The main class which is used to run the application
 */
public class Main  extends BaseClass {
    public static WeatherApp weatherApp;
    private double xOffset;
    private double yOffset;
    public static String screen_1Path="/weather_app_java.fxml";
    public static void main(String[] args) {
       weatherApp= initializeDaggerApplication();
       launch(args);
    }

  @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(screen_1Path));
      stage.initStyle(StageStyle.UTILITY);
      stage.setOpacity(0); // fully translucent
      stage.show();
      Stage secondaryStage=new Stage();
      secondaryStage.initStyle(StageStyle.UNDECORATED);
      secondaryStage.initOwner(stage);
      Scene scene=new Scene(root);
      secondaryStage.setScene(scene);
      secondaryStage.show();
      // get the bounds of the screen and store them in a 2d rectange
      // basically x, y coordinates
      // getMaxX()-> lower right corner
      // getMinY()-> upper right corner
      // then resize the stage according to the values
      Rectangle2D visualBounds= Screen.getPrimary().getVisualBounds();
      secondaryStage.setX(visualBounds.getMaxX()-25-scene.getWidth());
      secondaryStage.setY(visualBounds.getMinY()+25);
      // mouse location relative to the screen e.getScreenX()
      // store the mouse x, y coordinates with respect to the stage
      scene.setOnMousePressed(event -> {
          xOffset=secondaryStage.getX()-event.getScreenX();
          yOffset=secondaryStage.getY()-event.getScreenY();
      });
      // move the stage by the drag amount
      scene.setOnMouseDragged(event -> {
          secondaryStage.setX(event.getScreenX()+xOffset);
          secondaryStage.setY(event.getSceneY()+yOffset);
      });

  }
}
