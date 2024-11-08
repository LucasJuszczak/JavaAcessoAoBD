package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        // Configurações de acesso ao banco
        String url = "jdbc:mysql://localhost:3306/poo";
        String usuario = "root";
        String senha = "";

        // Comando SQL
        String sql = "INSERT INTO aluno (nome, endereco) VALUES (?, ?)";

        try{
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            // Prepara uma instrução SQL
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, "Rolando Caio da Rocha");
            statement.setString(2, "Rua dos Bobos, número 0");

            int linhasAfetadas = statement.executeUpdate();
            if(linhasAfetadas > 0){
                System.out.println("Linhas inseridas com sucesso!");
            }
            statement.close();
            conexao.close();
        }catch (SQLException erro){

        }

    }
}