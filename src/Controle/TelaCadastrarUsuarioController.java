
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author mateu
 */
public class TelaCadastrarUsuarioController implements Initializable {

    @FXML
    private Label labelCadastro;
    @FXML
    private Label labelNome;
    @FXML
    private Label labelTel;
    @FXML
    private Label labelCpf;
    @FXML
    private Label labelEmail;
    @FXML
    private Label labelSenha;
    @FXML
    private Label labelCSenha;
    @FXML
    private TextField Nome;
    @FXML
    private TextField Cpf;
    @FXML
    private TextField Telefone;
    @FXML
    private TextField Email;
    @FXML
    private PasswordField Senha;
    @FXML
    private PasswordField ConfirmaSenha;
    @FXML
    private Button ButtonCadastrar;
    @FXML
    private Button ButtonVoltar;

    public static String nomeText, emailText, senhaText, cpfText;

  
    /**
     * Initializes the controller class.
     */
    private boolean verificarDados() {
        boolean nomeInvalido = "".equals(Nome.getText().trim());
        boolean cpfInvalido = "".equals(Cpf.getText().trim()) || !cpfValido();
        // boolean emailInvalido = "".equals(email.getText().trim()) || !emailUnico();
        boolean senhaInvalida = "".equals(Senha.getText().trim()) || Senha.getText().length() < 6 || Senha.getText().contains(" ");
        boolean confirmacaoSenhaErrada = ConfirmaSenha.equals(Senha);

        if (nomeInvalido) {
            alerta("Dados inválidos", "Campo Nome é obrigatório");
            return false;
        } else if (cpfInvalido) {
            alerta("Dados inválidos", "CPF inválido");
            return false;
            //        } else if (emailInvalido) {
            //          alerta("Dados inválidos", "Email inválido");
            //        return false;
        } else if (senhaInvalida) {
            alerta("Dados inválidos", "Senha inválida");
            return false;
        } else if (confirmacaoSenhaErrada) {
            alerta("Confirmação de Senha inválida", "Senhas não equivalentes");
            return false;
        } else {
            return true;
        }

    }

    private boolean cpfValido() {
        String cpfTexto = Cpf.getText();
        float soma = 0;

        for (int i = 0; i < cpfTexto.length(); i++) {
            soma += Integer.parseInt(cpfTexto.charAt(i) + "");
        }

        float valido = soma / (int) (soma / 10);

        if (valido == 11.0) {
            return true;
        }

        return false;
    }

    private void alerta(String titulo, String mensagem) {
        Alert confirmacao = new Alert(Alert.AlertType.INFORMATION);
        confirmacao.setTitle(titulo);
        confirmacao.setHeaderText("");
        confirmacao.setContentText(mensagem);
        confirmacao.setResult(ButtonType.OK);
        confirmacao.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        ButtonCadastrar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (!verificarDados()) {
                    return;
                }

                nomeText = Nome.getText();
                emailText = Email.getText();
                senhaText = Senha.getText();
                cpfText = Cpf.getText();

                Stage stage = new Stage();
                Parent root = null;

                Clientes cliente = new Clientes();

                cliente.setNome(Nome.getText());
                cliente.setCpf(Cpf.getLength());
                cliente.setTel(Telefone.getLength());
                cliente.setEmail(Email.getText());
                cliente.setSenha(Senha.getText());
                cliente.setCsenha(ConfirmaSenha.getText());

                JOptionPane.showMessageDialog(null, cliente.salvar());

                Nome.setText("");
                Cpf.setText("");
                Telefone.setText("");
                Email.setText("");
                Senha.setText("");
                ConfirmaSenha.setText("");

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));

                } catch (IOException ex) {
                    Logger.getLogger(TelaLoginController.class
                            .getName()).log(Level.SEVERE, null, ex);

                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    stage.setTitle("Cadastro Efetuado com Sucesso !");

                    stage.setScene(scene);
                    stage.show();

                    //fechar a tela quando abrir a outra
                    ButtonCadastrar.getScene().getWindow().hide();
                }
            }
        });

        ButtonVoltar.setOnAction(new EventHandler<ActionEvent>() {

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
                ButtonVoltar.getScene().getWindow().hide();
            }
        });

    }
}
