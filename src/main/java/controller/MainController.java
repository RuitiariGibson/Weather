package controller;

import app.Main;
import app.WeatherApp;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import model.WeatherUpdateClass;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class MainController implements Initializable {
    public Pane loadingPane;
    public Pane weatherPane;
    public Text locationText;
    public Text timeText;
    public Text todayTemp;
    public ImageView todayImg;
    public Text weatherStateName;
    public Text maxTmpToday;
    public Text minTempToday;
    public Text tomorrowTemp;
    public Text tomorrowWeatherState;
    public Text todayHumidity;
    public Text todayPressure;
    public Text dayAfWeatherStateName;
    public Text tomorrowPressure;
    public Text dayAfterTomorrowDate;
    public ImageView DafImg;
    public Text dayAfterTemp;
    public Text dayAfterPressure;
    public ImageView tomorrowImg;
    public StackPane rootPane;
    public Pane errorPane;
    public Text errorText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadingPane.setOpacity(1.0);
        try {
            loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        initializeMenu();

    }

    private void loadData() throws FileNotFoundException {
        WeatherApp weatherApp= Main.weatherApp;
        ConcurrentHashMap<String, Object> concurrentHashMap = weatherApp.repo().fetchWeatherUpdates();
        System.out.println(concurrentHashMap.size());
        if (concurrentHashMap.get("today")!=null && concurrentHashMap.get("tomorrow") != null && concurrentHashMap.get("dayAf") != null){
            WeatherUpdateClass weatherResponse = (WeatherUpdateClass) concurrentHashMap.get("today");
            WeatherUpdateClass tomorrow = (WeatherUpdateClass) concurrentHashMap.get("tomorrow");
            WeatherUpdateClass dayAf = (WeatherUpdateClass) concurrentHashMap.get("dayAf");
            System.out.println(weatherResponse.getWeatherStateName());
            System.out.println(tomorrow.getWeatherStateName());
            System.out.println(dayAf.getWeatherStateName());
            todayPressure.setText(String.format("%d mph", Math.round(weatherResponse.getAirPressure())));
            todayTemp.setText(String.format("%d C", Math.round(weatherResponse.getTemp())));
            minTempToday.setText(String.format("%d C", Math.round(weatherResponse.getMinTemp())));
            maxTmpToday.setText(String.format("%d C", Math.round(weatherResponse.getMaxTemp())));
            todayHumidity.setText(String.format("%d C", Math.round(weatherResponse.getHumidity())));
            locationText.setText("Nairobi");
            setImage(todayImg, weatherResponse.getWeatherStateName());
            weatherStateName.setText(weatherResponse.getWeatherStateName());

            tomorrowPressure.setText(String.format("%d mph", Math.round(weatherResponse.getAirPressure())));
            tomorrowTemp.setText(String.format("%d/%d", Math.round(tomorrow.getMaxTemp()), Math.round(tomorrow.getMinTemp())));
            setImage(tomorrowImg, tomorrow.getWeatherStateName());
            tomorrowWeatherState.setText(tomorrow.getWeatherStateName());

            dayAfterPressure.setText(String.format("%d mph", Math.round(dayAf.getAirPressure())));
            dayAfterTemp.setText(String.format("%d/%d", Math.round(dayAf.getMaxTemp()), Math.round(dayAf.getMinTemp())));
            setImage(DafImg, dayAf.getWeatherStateName());
            dayAfWeatherStateName.setText(dayAf.getWeatherStateName());
            dayAfterTomorrowDate.setText(dayAf.getApplicableDate());
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(6), loadingPane);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.0);
            fadeTransition.setOnFinished(event -> {
                loadingPane.setVisible(false);
                weatherPane.setVisible(true);
            });
            fadeTransition.play();
        }else showInternetError();



    }
private void showInternetError(){
    errorText.setText("An error occurred. Please check your internet connection and try again.");
    FadeTransition fadeTransition = new FadeTransition(Duration.seconds(6), loadingPane);
    fadeTransition.setFromValue(1.0);
    fadeTransition.setToValue(0.0);
    fadeTransition.play();
    FadeTransition fadeIn = new FadeTransition(Duration.seconds(6), errorPane);
    fadeIn.setFromValue(0.0);
    fadeIn.setToValue(1.0);
    fadeIn.play();
    SequentialTransition sequentialTransition = new SequentialTransition();
    sequentialTransition.getChildren().addAll(fadeTransition, fadeIn);
    sequentialTransition.setOnFinished(event -> {
        loadingPane.setVisible(false);
        errorPane.setVisible(true);
    });
    sequentialTransition.play();
}
    private void setImage(ImageView imageNode, String weatherStateName) throws FileNotFoundException {
        Image image;
        String path;
        switch (weatherStateName) {
            case "Light Cloud":
            case "Clear":
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/clear.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
                break;
            case "Hail":
            case "Snow":
            case "Sleet":
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/snow.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
                break;
            case "Heavy Cloud":
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/cloudy.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
                break;
            case "Heavy Rain":
            case "Light Rain":
            case "Showers":
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/rainy.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
                break;
            case "Thunderstorm":
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/thunderstorm.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
                break;
            default:
                path=System.getProperty("user.dir")+"/src/main/resources/pictures/clear.png";
                image = new Image(new FileInputStream(path));
                imageNode.setImage(image);
        }
    }

    private void initializeMenu() {
        MenuItem menuItem = new MenuItem();
        menuItem.setText("Exit");
        menuItem.setOnAction(event -> System.exit(0));
        MenuItem refreshItem = new MenuItem();
        refreshItem.setText("Refresh");
        refreshItem.setOnAction(event -> {
            try {
                loadData();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });
        final ContextMenu contextMenu =
                new ContextMenu(menuItem, refreshItem);
        rootPane.addEventFilter(MouseEvent.MOUSE_PRESSED,
                mouseEvent -> {
                    if (mouseEvent.isSecondaryButtonDown()) {
                        contextMenu.show(rootPane,
                                mouseEvent.getScreenX(),
                                mouseEvent.getSceneY());

                    } else {
                        if (contextMenu.isShowing()) {
                            contextMenu.hide();
                        }
                    }
                });
    }
}
