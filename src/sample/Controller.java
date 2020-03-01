package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import richard.color.model.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    //  RED

    @FXML
    private Label redLabel;

    @FXML
    private TextField redField;

    @FXML
    private Slider redSlide;

    //  GREEN

    @FXML
    private Label greenLabel;

    @FXML
    private TextField greenField;

    @FXML
    private Slider greenSlide;

    //  BLUE

    @FXML
    private Label blueLabel;

    @FXML
    private TextField blueField;

    @FXML
    private Slider blueSlide;

    //  HEX

    @FXML
    private Label hexLabel;

    @FXML
    private TextField hexField;

    //  COLOR

    @FXML
    private Pane mainColor;

    private Color color;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        color = new Color(0, 0, 0);

        update();

        //  r
        redSlide.setValue(color.getRed());
        redSlide.valueProperty().addListener(e -> updateRed());

        //  g
        greenSlide.setValue(color.getGreen());
        greenSlide.valueProperty().addListener(e -> updateGreen());

        //  b
        blueSlide.setValue(color.getBlue());
        blueSlide.valueProperty().addListener(e -> updateBlue());
    }

    //  RED

    private void updateRed() {
        color.setRed((int) redSlide.getValue());
        update();
    }

    //  GREEN

    private void updateGreen() {
        color.setGreen((int) greenSlide.getValue());
        update();
    }

    //  BLUE

    private void updateBlue() {
        color.setBlue((int) blueSlide.getValue());
        update();
    }

    private void update() {
        redField.setText(String.valueOf(color.getRed()));
        greenField.setText(String.valueOf(color.getGreen()));
        blueField.setText(String.valueOf(color.getBlue()));
        hexField.setText(color.getHexValue());
        mainColor.setStyle("-fx-background-color: " + color.getHexValue());
    }
}
