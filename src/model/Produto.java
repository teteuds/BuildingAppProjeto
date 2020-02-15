package model;

import buildingappprojeto.BuildingAppProjeto;
import model.Clientes;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controle.*;
import model.*;

/**
 *
 * @author mateu
 */
public class Produto extends BuildingAppProjeto {

    private String nome;
    private String descricao;
    private String categoria;
    private float valor;
    private String telefone;
    private String cidade;
    private String bairro;
    private String endereco;
    private int numero;

    //Construtor
    public Produto(String nome, String descricao, String categoria, float valor, String cidade, String endereco, String bairro, int numero, String telefone) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.telefone = telefone;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
    }

    public Produto() {

    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    //METODO COPIAR URL
    public final void copia(File fonte, File destino) throws IOException {
        OutputStream out;
        try (InputStream in = new FileInputStream(fonte)) {
            out = new FileOutputStream(destino);
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        out.close();
    }

    public String salvar() {

        try {

            FileWriter fw = new FileWriter("produtos.dat", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Nome :" + this.nome);
            pw.println("Descrição :" + this.descricao);
            pw.println("Categoria " + this.categoria);
            pw.println("Telefone :" + this.telefone);
            pw.println("Valor :" + this.valor);
            pw.println("Cidade :" + this.cidade);
            pw.println("Bairro :" + this.bairro);
            pw.println("Endereço :" + this.endereco);
            pw.println("Numero :" + this.numero);
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex) {

            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Produto Cadastrado com Sucesso ! ";
    }
}
