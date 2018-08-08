package forms;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import animation.Shake;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField passworld_field;

    @FXML
    private Button authSignButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button loginSignUpButton1;

    @FXML
    private Button tempForRoom;

    private User currentUser;

    @FXML
    void initialize() {
        authSignButton.setOnAction(event -> {
            String loginText = login_field.getText().trim();
            String loginPassword = passworld_field.getText().trim();
            if (isValidate(loginText, loginPassword)) {

                currentUser = User.getUserControl().avtorization(loginText, loginPassword);
                if (currentUser != null) {
                    openNewScene("/forms/app.fxml", authSignButton);
                } else {
                    Shake userLoginAnim = new Shake(login_field);
                    Shake userPassAnim = new Shake(passworld_field);
                    userLoginAnim.playAnim();
                    userPassAnim.playAnim();
                }

                //  loginUser(loginText, loginPassword);
                // loginTeacher(loginText, loginPassword);
            } else
                System.out.println("Login and password is empty");

        });
/////////////////////// Почему 2 кнопки
        loginSignUpButton.setOnAction((ActionEvent event) -> {
            openNewScene("/forms/signUp.fxml", loginSignUpButton);
        });

        loginSignUpButton1.setOnAction((ActionEvent event) -> {
            openNewScene("/forms/signUpTeacher.fxml", loginSignUpButton1);
        });

        tempForRoom.setOnAction((ActionEvent event) -> {
            openNewScene("/forms/formRoom.fxml", tempForRoom);
        });


    }

    private boolean isValidate(String login, String password) {
        return !login.equals("") && !password.equals("");
    }

    public void openNewScene(String window, Button btn) {
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


//        private void loginUser (String loginText, String loginPassword) throws SQLException {
////        DatabaseHandler dbHandler = new DatabaseHandler();
//        User user = new User();
//        user.setUsername(loginText);
//        user.setPassword(loginPassword);
//        ResultSet result = dbHandler.getUser(user);
//
//        int counter =0;
//        while(result.next()){
//            counter++;
//        }
//        if(counter >=1){
//            openNewScene("/sample/app.fxml", authSignButton);
//        }
//        else{
//            Shake userLoginAnim = new Shake(login_field);
//            Shake userPassAnim = new Shake(passworld_field);
//            userLoginAnim.playAnim();
//            userPassAnim.playAnim();
//        }
//    }
//
//    private void loginTeacher (String loginText, String loginPassword) throws SQLException {
//        DatabaseHandler dbHandler = new DatabaseHandler();
//        Teacher user = new Teacher();
//        user.setUsername(loginText);
//        user.setPassword(loginPassword);
//        ResultSet result = dbHandler.getTeacher(user);
//
//        int counter =0;
//        while(result.next()){
//            counter++;
//        }
//        if(counter >=1){
//            openNewScene("/sample/appForTeacher.fxml", authSignButton);
//        }
//        else{
//            Shake userLoginAnim = new Shake(login_field);
//            Shake userPassAnim = new Shake(passworld_field);
//            userLoginAnim.playAnim();
//            userPassAnim.playAnim();
//        }
//    }

}
