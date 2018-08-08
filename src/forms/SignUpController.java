package forms;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SignUpController{

    @FXML
    private Button  exitButton;

    @FXML
    private Button checkIn;

    @FXML
    private TextField surnameF;

    @FXML
    private TextField nameF;

    @FXML
    private TextField patronymicF;      //po bat`kovi

    @FXML
    private DatePicker date;

    @FXML
    private TextField placeOfBirthdayF;

    @FXML
    private TextField citizenshipF;

    @FXML
    private TextField endedU;

    @FXML
    private TextField placeOfB;

    @FXML
    private TextField placeR;

    @FXML
    void initialize() {
        checkIn.setOnAction((ActionEvent event) ->{

            //signUpNewUserr();
            openNewScene("/forms/sample.fxml", checkIn);

        });
    }

    public void openNewScene(String window, Button btn){
        btn.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public  void showDate(ActionEvent event){
        String surname = surnameF.getText().trim();
        String name = nameF.getText().trim();
        String patronymic = patronymicF.getText().trim();
        String dateB = date.getEditor().getText().trim();
        String placeOfBirthday = placeOfBirthdayF.getText().trim();
        String citizenship=citizenshipF.getText().trim();
        String endedUn=endedU.getText().trim();
        String placeOfResidence=placeOfB.getText().trim();
        String placeReg=placeR.getText().trim();
//        LocalDate date=dateF.getValue();

        System.out.println("Прізвище: "+surname+"\nІм'я: " +name +"\nПо батькові: "+patronymic+"\nДата народження: "
                +"\nДата народження: " + dateB +"\nМісце народження: "+placeOfBirthday+"\nГромадянство: "
                +citizenship+"\nЗакінчив(ла): " +endedUn+"\nмісце проживання: "+placeOfResidence+"\nМісце реєстрації: "+placeReg);
    }

    public void onExit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
