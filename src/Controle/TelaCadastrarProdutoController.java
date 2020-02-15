package Controle;

import model.*;
import model.Categoria;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mateu
 */
public class TelaCadastrarProdutoController implements Initializable {

    @FXML
    private Label LabelAnunciar;
    @FXML
    private Button buttonCarregaImagem;
    @FXML
    private Button buttonEnviar;
    @FXML
    private Label LabelProduto;
    @FXML
    private TextArea tfDescricaoProduto;
    @FXML
    private Label LabelCategoria;
    @FXML
    private TextField tfNomeProduto;
    @FXML
    private Label LabelValor;
    @FXML
    private TextField tfValorProduto;
    @FXML
    private TextField tfEndereco;
    private SplitMenuButton CategoriaProduto;
    @FXML
    private Label labelTelefone;
    @FXML
    private Label labelEndereco;
    @FXML
    private TextField tfCidade;
    @FXML
    private Label labelNum;
    @FXML
    private Label labelCidade;
    @FXML
    private Label labelBairro;
    @FXML
    private TextField tfNumero;
    @FXML
    private TextField tfBairro;
    @FXML
    private TextField tfTelefone;
    @FXML
    private Button buttonVoltar;
    @FXML
    private ImageView imagem;

    TelaPrincipalController control;
    @FXML
    private ComboBox<Categoria> cbCategorias;

    @FXML
    private void maskCelular(KeyEvent event) {
    }

    /*@FXML
    private void tfTelefone() {
        TextFieldFormater tff = new TextFieldFormater();
        tff.setMask("(##)#####-####");
        tff.setCaracteresValidos("0,1,2,3,4,5,6,7,8,9");
        tff.setTf(tfTelefone);
        tff.formatter();
    }
    **/
    private List<Categoria> categorias = new ArrayList<>();

    private ObservableList<Categoria> obsCategorias;

    //Metodos
    public void carregarCategorias() {
        Categoria categoria1 = new Categoria(1, "Contrução");
        Categoria categoria2 = new Categoria(2, "Eletricos");
        Categoria categoria3 = new Categoria(3, "Ferramentas");
        Categoria categoria4 = new Categoria(4, "Hidraulicos");
        Categoria categoria5 = new Categoria(5, "Pisos e Revestimentos");
        Categoria categoria6 = new Categoria(6, "Tintas");

        categorias.add(categoria1);
        categorias.add(categoria2);
        categorias.add(categoria3);
        categorias.add(categoria4);
        categorias.add(categoria5);
        categorias.add(categoria6);

        obsCategorias = FXCollections.observableArrayList(categorias);
        cbCategorias.setItems(obsCategorias);
        
    }

    public void setControlador(TelaPrincipalController controlador) {
        this.control = controlador;
    }

    public static File arquivoImagem = new File("C:\\Users\\mateu\\Desktop\\BuildingAppProjeto\\src\\buildingappprojeto\\img");

    //Declaração do selecionador de arquivo
    FileChooser fc = new FileChooser();

    //Metodo que seleciona uma imagem em algum diretório do computador
    private void adicionarImagem() {
        fc = new FileChooser();
        arquivoImagem = fc.showOpenDialog(null);

        if (arquivoImagem == null) {
            arquivoImagem = new File("src/imagens/usuario.png");
            System.out.println("ihh");
            return;
        }

        try {
            BufferedImage bi = ImageIO.read(arquivoImagem);
            Image image = SwingFXUtils.toFXImage(bi, null);
            imagem.setImage(image);
        } catch (IOException ex) {
            Logger.getLogger(TelaCadastrarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Tudo e aqui ...

        carregarCategorias();//chamando metodo

        buttonCarregaImagem.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                adicionarImagem();

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(TelaLoginController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Scene scene = new Scene(root);

                //stage.setScene(scene);
                //stage.show();
                //stage.setTitle("");
                //fechar a tela quando abrir a outra
                //buttonCarregaImagem.getScene().getWindow().hide();
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

        System.out.println("Aqui");

        buttonEnviar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                Produto produtos = new Produto();

                produtos.setNome(tfNomeProduto.getText());
                produtos.setDescricao(tfDescricaoProduto.getText());
                produtos.setCategoria(CategoriaProduto.getText());
                produtos.setValor(tfValorProduto.getLength());
                produtos.setTelefone(tfTelefone.getText());
                produtos.setCidade(tfCidade.getText());
                produtos.setEndereco(tfEndereco.getText());
                produtos.setBairro(tfBairro.getText());
                produtos.setNumero(tfNumero.getLength());

                JOptionPane.showMessageDialog(null, produtos.salvar());

                // control.alterarImagem(arquivoImagem);
                tfNomeProduto.setText("");
                tfDescricaoProduto.setText("");
                CategoriaProduto.setText("");
                tfValorProduto.setText("");
                tfTelefone.setText("");
                tfCidade.setText("");
                tfEndereco.setText("");
                tfBairro.setText("");
                tfNumero.setText("");

                Stage stage = new Stage();
                Parent root = null;

                try {
                    root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));

                } catch (IOException ex) {

                    Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                }

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

                //fechar a tela quando abrir a outra
                buttonEnviar.getScene().getWindow().hide();
            }

        });

    }

}
