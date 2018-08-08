package forms;


import java.io.IOException;
        import java.net.URL;
        import java.util.ResourceBundle;

        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.PasswordField;
        import javafx.scene.control.TextField;
        import javafx.stage.Stage;

public class SignUpTeacher {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field_tea;

    @FXML
    private PasswordField passworld_field_tea;

    @FXML
    private Button signUpButton;

    @FXML
    void initialize() {
        signUpButton.setOnAction((ActionEvent event) ->{

            signUpNewUserr();
            openNewScene("/forms/sample.fxml", signUpButton);

        });
    }

    private void signUpNewUserr() {
//        DatabaseHandler dbHandler = new DatabaseHandler();
//
//        String username = login_field_tea.getText();
//        String password = passworld_field_tea.getText();
//
//        Teacher user = new Teacher(username, password);
//
//        dbHandler.signUpTeacher(user);

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
}
