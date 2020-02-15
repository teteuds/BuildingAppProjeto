/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class TelaLoginController implements Initializable {

    @FXML
    private Button buttonLogin;
    @FXML
    private AnchorPane anchorPaneLogin;
    @FXML
    private AnchorPane anchorPaneLogin2;
    @FXML
    private Label labelLogin;
    @FXML
    private Label LabelEmail;
    @FXML
    private Label LabelSenha;
    @FXML
    private Hyperlink linkCadastrar;
    @FXML
    private TextField textEmail;
    @FXML
    private PasswordField textSenha;
    @FXML
    private Button buttonVoltar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (textEmail.getText().equals("mateus") && textSenha.getText().equals("1234")) {

                    Stage stage = new Stage();
                    Parent root = null;

                    try {
                        root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
                    } catch (IOException ex) {
                        Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("Bem vindo ao Building App");

                    //fechar a tela quando abrir a outra
                    buttonLogin.getScene().getWindow().hide();

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Building App");
                    alert.setHeaderText("Bem vindo ao Building");
                    alert.show();

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Building App");
                    alert.setHeaderText("Senha ou Email Invalido ");
                    alert.show();
                }
            }
        });

        linkCadastrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaCadastrarUsuario.fxml"));

                } catch (IOException ex) {

                    Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //fechar a tela quando abrir a outra
                linkCadastrar.getScene().getWindow().hide();
            }

            private Parent TelaCadastro(URL resource) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        buttonVoltar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
                stage.setTitle("");

                //fechar a tela quando abrir a outra
                buttonVoltar.getScene().getWindow().hide();
            }
        });

    }
}
