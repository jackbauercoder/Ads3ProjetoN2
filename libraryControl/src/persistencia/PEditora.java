/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Editora;
import java.util.ArrayList;
import interfaces.IEditora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author repez
 */
public class PEditora implements IEditora {

    @Override
    public void incluir(Editora editora) throws Exception {
        String sql = "INSERT INTO editora (nome) VALUES (?)";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setString(1, editora.getNome());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Editora> listar() throws Exception {
        String sql = "SELECT * FROM editora";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Editora> retorno = new ArrayList();
        
        while (rs.next()) {
            Editora ed = new Editora();

            ed.setId(rs.getInt("id"));
            ed.setNome(rs.getString("nome"));
            retorno.add(ed);
        }

        return retorno;
    }

    @Override
    public void alterar(Editora editora) throws Exception {
        String sql = "UPDATE editora SET nome = ? WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();

        // cria o procedimento para a execução "contra" o banco de dados
        PreparedStatement prd = cnn.prepareStatement(sql);

        // trocando os valores das ? por valores recebido no método
        prd.setString(1, editora.getNome());
        prd.setInt(2, editora.getId());

        //executa todo o comando e grava no banco de dados
        prd.execute();
        cnn.close();
    }

    @Override
    public Editora consultar(int parametro) throws Exception {
        String sql = "SELECT id, nome "
                + " FROM editora WHERE id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setInt(1, parametro);

        ResultSet rs = prd.executeQuery();

        Editora retorno = new Editora();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            
        }

        return retorno;
    }
    
    public Editora consultar(String parametro) throws Exception {
        String sql = "SELECT id, nome "
                + " FROM editora WHERE nome = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);

        prd.setString(1, parametro);

        ResultSet rs = prd.executeQuery();

        Editora retorno = new Editora();

        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setNome(rs.getString("nome"));
            
        }

        return retorno;
    }

    @Override
    public void excluir(int parametro) throws Exception {
        //Cria a instrução sql para a inserção de registros
        String sql = "DELETE FROM editora "
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

}
