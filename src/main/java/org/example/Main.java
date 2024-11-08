package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Configurações de acesso ao banco
        String url = "jdbc:mysql://localhost:3306/poo";
        String usuario = "root";
        String senha = "";

        // Comando SQL
        String sql = "SELECT * FROM aluno";

        try{
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão estabelecida com sucesso!");

            // Prepara uma instrução SQL
            PreparedStatement statement = conexao.prepareStatement(sql);
            //statement.setString(1, "Rolando Caio da Rocha");
            //statement.setString(2, "Rua dos Bobos, número 0");

            //int linhasAfetadas = statement.executeUpdate();
            //if(linhasAfetadas > 0){
            //    System.out.println("Linhas inseridas com sucesso!");
            //}

            ResultSet alunos = statement.executeQuery();

            while(alunos.next()){
                int id = alunos.getInt("id");
                String nome = alunos.getString("nome");
                String endereco = alunos.getString("endereco");
                System.out.println("ID: " + id + " - Nome: " + nome + " - Endereco: " + endereco);
            }

            statement.close();
            conexao.close();
        }catch (SQLException erro){
            System.out.println("Erro ao executar SQL! Entre em contato com o admin!");
            erro.printStackTrace();
        }
    }
}