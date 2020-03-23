package nl.timo.store;

//import com.mysql.jdbc.log.Log;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */
public class LoginController {
    @FXML
    private TextField user;
    @FXML
    private TextField password;
    @FXML
    private Button submit;

    public void submit(){
          String username = user.getText();
       String pass = password.getText();
        System.out.println(username + pass);
       LoginDataAccessObject ldao = new LoginDataAccessObject("noorderpoort","toets");
        Boolean user1 = ldao.getUser(username,pass);
        StoreController.loginText.setText("ingelogd");
        ExitLogin();
        System.out.println(user1);


    }

    public void ExitLogin() {
        try {
            Stage stage = (Stage) submit.getScene().getWindow();
         //   StoreController.loginText.setText("ingelogd");
            stage.close();
        } catch (Exception e) {

        }

    }




}
