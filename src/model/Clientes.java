package model;

import Controle.*;
import model.*;
import buildingappprojeto.BuildingAppProjeto;
import buildingappprojeto.BuildingAppProjeto;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Clientes extends BuildingAppProjeto {

    public static void add(String linha) {

    }

    private String nome;
    private long cpf;
    private long tel;
    private String senha;
    private String csenha;
    private String email;

    public Clientes(){
        
    }
    //Contrutor
    public Clientes(String nome, long cpf, long tel, int num, String senha, String email, String csenha) {
        this.nome = nome;
        this.tel = tel;
        this.cpf = cpf;
        this.senha = senha;
        this.csenha = csenha;
        this.email = email;
    }


    Clientes(TextField Nome, TextField Endereco) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Clientes(TextField Nome, TextField Endereco, TextField Telefone, TextField Cpf, TextField Bairro, TextField Cidade, TextField Num, TextField Email, PasswordField Senha, PasswordField ConfirmaSenha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Clientes(String clientesdat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Getter e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getSenha() {
        return senha;
    }

    public String getCsenha() {
        return csenha;
    }

    public void setCsenha(String csenha) {
        this.csenha = csenha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String salvar() {

        try {

            FileWriter fw = new FileWriter("clientes.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("Nome :" + this.nome);
            pw.println("Cpf :" + this.cpf);
            pw.println("Telefone " + this.tel);
            pw.println("Email :" + this.email);
            pw.println("Senha :" + this.senha);
            pw.println("Confirma Senha :" + this.csenha);
            pw.flush();
            pw.close();
            fw.close();

        } catch (IOException ex) {

            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Cadastrado com Sucesso ! ";
    }

    String ReadLine() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
