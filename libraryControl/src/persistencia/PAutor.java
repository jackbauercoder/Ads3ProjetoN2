/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import interfaces.IAutor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        String sql = "SELECT * FROM autor";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Autor> retorno = new ArrayList();
        
        while (rs.next()) {
            Autor au = new Autor();

            au.setId(rs.getInt("id"));
            au.setNome(rs.getString("nome"));
            retorno.add(au);
        }

        return retorno;
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
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM autor "
                + " WHERE id = ?";

        //Cria a conexao a partir dos métodos da fábrica de conexões
        Connection cnn = util.Conexao.getConexao();

        //cria o procedimento para a execução "contra" o BD
        PreparedStatement prd = cnn.prepareStatement(sql);

        //Trocando os valores da ? por valores recebidos no método
        prd.setInt(1, parametro);
                
        prd.execute();
        cnn.close();
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
    
    public Autor consultar(String parametro) throws SQLException {
        
        String sql = " SELECT * FROM autor WHERE nome = ?;";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setString(1, parametro);

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

