/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import model.*;
import static Controle.TelaCadastrarProdutoController.arquivoImagem;
import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class TelaPrincipalController implements Initializable {

    @FXML
    private Hyperlink LinkEntrarHome;
    @FXML
    private Hyperlink LinkCadastrarHome;
    @FXML
    private Label labelBuilding;
    @FXML
    private Label LabelBemVindo;
    @FXML
    private Hyperlink LinkAnunciarHome;
    @FXML
    private Button buttonSearch;
    @FXML
    private ImageView imageProduto;

    public void alterarImagem(Image imgProd) {
        imageProduto.setImage(imgProd);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        //Instancia da classe cadastrar Produto
        TelaCadastrarProdutoController cadastroProdutos = new TelaCadastrarProdutoController();

        cadastroProdutos.setControlador(this);

        LinkEntrarHome.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaLogin.fxml"));

                } catch (IOException ex) {

                    Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //fechar a tela quando abrir a outra
                LinkEntrarHome.getScene().getWindow().hide();
            }

            private Parent TelaCadastro(URL resource) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        LinkCadastrarHome.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaCadastrarUsuario.fxml"));

                } catch (IOException ex) {

                    Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //fechar a tela quando abrir a outra
                LinkCadastrarHome.getScene().getWindow().hide();
            }

            private Parent TelaCadastro(URL resource) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });

        LinkAnunciarHome.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {

            @Override
            public void handle(javafx.event.ActionEvent event) {

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaCadastrarProduto.fxml"));

                } catch (IOException ex) {

                    Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //fechar a tela quando abrir a outra
                LinkAnunciarHome.getScene().getWindow().hide();
            }

            private Parent TelaCadastro(URL resource) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        ;;
    }

    void alterarImagem(File arquivoImagem) {

    }

}
