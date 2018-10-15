/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Autor;
import entidades.Editora;
import entidades.Livro;
import java.util.ArrayList;
import interfaces.ILivro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author repez
 */
public class PLivro implements ILivro {

    @Override
    public void incluir(Livro livro) throws Exception {
        String sql = "INSERT INTO livro (isbn, titulo, img_capa, id_autor, id_editora) VALUES (?,?,?,?,?)";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, livro.getIsbn());
        prd.setString(2, livro.getTitulo());
        prd.setString(3, livro.getFotoDaCapa());
        prd.setInt(4, livro.getAutor().getId());
        prd.setInt(5, livro.getEditora().getId());

        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Livro> listar() throws Exception {
        String sql = "SELECT * FROM livro";

        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();

        ResultSet rs = st.executeQuery(sql);
        ArrayList<Livro> retorno = new ArrayList();
        
        while (rs.next()) {
            Livro livro = new Livro();

            livro.setId(rs.getInt("id"));
            livro.setIsbn(rs.getString("isbn"));
            livro.setTitulo(rs.getString("titulo"));
            livro.setFotoDaCapa(rs.getString("img_capa"));
            
            PAutor pa = new PAutor();
            Autor autor = pa.consultar(rs.getInt("id_autor"));
            livro.setAutor(autor);
            
            PEditora pe = new PEditora();
            Editora  ed = pe.consultar(rs.getInt("id_editora"));
            livro.setEditora(ed);
            
            retorno.add(livro);
        }

        return retorno;
    }

    @Override
    public void alterar(Livro livro) throws Exception {
        String sql = "UPDATE livro SET isbn = ?,"
                + "set titulo = ?,"
                + "set img_capa = ?"
                + "set id_autor = ?"
                + "set id_editora = ?"
                + " WHERE id = ?";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, livro.getIsbn());
        prd.setString(2, livro.getTitulo());
        prd.setString(3, livro.getFotoDaCapa());
        prd.setInt(4, livro.getAutor().getId());
        prd.setInt(5, livro.getEditora().getId());
        prd.setInt(6, livro.getId());

        prd.execute();
        cnn.close();
    }

    @Override
    public Livro consultar(int parametro) throws Exception {
        String sql = " SELECT * FROM livro WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Livro retorno = new Livro();
        
        if (rs.next()) {

            retorno.setId(rs.getInt("id"));
            retorno.setIsbn(rs.getString("isbn"));
            retorno.setTitulo(rs.getString("titulo"));
            retorno.setFotoDaCapa(rs.getString("img_capa"));
            
            PAutor pa = new PAutor();
            Autor a = pa.consultar(rs.getInt("id_autor"));
            retorno.setAutor(a);
            
            PEditora pe = new PEditora();
            Editora e = pe.consultar(rs.getInt("id_editora"));
            retorno.setEditora(e);

        }
        
        prd.execute();
        cnn.close();
        return retorno;
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM livro WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }

}
