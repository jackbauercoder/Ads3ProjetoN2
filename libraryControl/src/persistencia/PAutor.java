/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import interfaces.IAutor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author repez
 */
public class PAutor implements IAutor {

    @Override
    public void incluir(Autor autor) throws Exception {
        String sql = "INSERT INTO autor (nome) VALUES (?)";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setString(1, autor.getNome());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Autor> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Autor autor) throws Exception {
        String sql = "UPDATE autor SET nome = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setString(1, autor.getNome());
        prd.setInt(2, autor.getId());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int parametro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Autor consultar(int parametro) throws SQLException {

        String sql = " SELECT * FROM autor WHERE id = ?;";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();
        Autor retorno = new Autor();
        if (rs.next()) {

            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));

        }

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
        return retorno;
    }
}


