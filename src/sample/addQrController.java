package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import static sample.CreateExcel.WriterExcel;

public class addQrController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup activity;

    @FXML
    private Button answer;

    @FXML
    private Label label;

    @FXML
    private Label label2;

    @FXML
    private ToggleGroup music;

    @FXML
    private RadioButton noActivity;

    @FXML
    private RadioButton noMusic;

    @FXML
    private RadioButton noSport;

    @FXML
    private RadioButton soSoActivity;

    @FXML
    private RadioButton soSoMusic;

    @FXML
    private RadioButton soSoSport;

    @FXML
    private ToggleGroup sport;

    @FXML
    private RadioButton yesActivity;

    @FXML
    private RadioButton yesMusic;

    @FXML
    private RadioButton yesSport;

    @FXML
    private Label text1;

    @FXML
    private Label text2;

    @FXML
    private Label text3;

    @FXML
    void initialize() {
        label2.setText("Ответьте, пожалуйста, на несколько вопросов.  \n " +
                " Мы подберем для вас самое выгодное предложение");

        answer.setOnMouseClicked(mouseEvent -> {

            RadioButton selection = (RadioButton) activity.getSelectedToggle();
            String activityBaby = selection.getText();
            CreateExcel.data[6]=activityBaby;
            selection = (RadioButton) music.getSelectedToggle();
            String musicBaby = selection.getText();
            CreateExcel.data[7]=musicBaby;
            selection = (RadioButton) sport.getSelectedToggle();
            String sportBaby = selection.getText();
            CreateExcel.data[8]=sportBaby;

            isHidden();
            label2.setText("Благодарим за предоставленную информацию! Вы можете воспользоваться 20% скидкой на услуги нашего " +
                    "центра! Также в ближайшее время с Вами свяжется менеждер, чтобы предложить вам услугу, " +
                    "исходя из ваших ответов на вопросы");
            WriterExcel();


        });


    }
    public void isHidden(){
        //text1.setVisible(false);
       // text2.setVisible(false);
       // text3.setVisible(false);
        yesSport.setVisible(false);
        noSport.setVisible(false);
        soSoSport.setVisible(false);
        yesMusic.setVisible(false);
        noMusic.setVisible(false);
        soSoMusic.setVisible(false);
        yesActivity.setVisible(false);
        noActivity.setVisible(false);
        soSoActivity.setVisible(false);
        label2.setVisible(false);
    }

}
