/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Exemplar;
import entidades.Livro;
import java.util.ArrayList;
import interfaces.IExemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author repez
 */
public class PExemplar implements IExemplar {

    @Override
    public void incluir(Exemplar exemplar) throws Exception {
        String sql = "INSERT INTO exemplar (is_disponivel, is_exemplar_reserva, disponivel_em, id_livro) "
                + "VALUES (?,?,?,?)";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setBoolean(1, exemplar.IsDisponivel());
        prd.setBoolean(2, exemplar.isExemplarReserva());
        prd.setDate(3, exemplar.getDisponivelAPartirDe());
        prd.setInt(4, exemplar.getLivro().getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Exemplar> listar() throws Exception {
        String sql = "SELECT * FROM exemplar";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Exemplar> retorno = new ArrayList();
        while (rs.next()) {
            Exemplar ex = new Exemplar();
            ex.setId(rs.getInt("id"));
            ex.setDisponivel(rs.getBoolean("is_disponivel"));
            ex.setDisponivelAPartirDe(rs.getDate("disponivel_em"));
            ex.setExemplarReserva(rs.getBoolean("is_exemplar_reserva"));
            
            PLivro pl = new PLivro();
            Livro livro = pl.consultar(rs.getInt("id_livro"));
            ex.setLivro(livro);
            
            retorno.add(ex);
        }
        return retorno;
    }

    @Override
    public void alterar(Exemplar exemplar) throws Exception {
        String sql = "UPDATE exemplar set is_disponivel = ?, is_exemplar_reserva = ?, disponivel_em = ?, id_livro = ? where id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setBoolean(1, exemplar.IsDisponivel());
        prd.setBoolean(2, exemplar.isExemplarReserva());
        prd.setDate(3, exemplar.getDisponivelAPartirDe());
        prd.setInt(4, exemplar.getLivro().getId());
        prd.setInt(5, exemplar.getId());
        
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM exemplar WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }

    public Exemplar consultar(int parametro) throws SQLException, Exception {
        String sql = " SELECT * FROM exemplar WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Exemplar retorno = new Exemplar();
        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setDisponivel(rs.getBoolean("is_disponivel"));
            retorno.setExemplarReserva(rs.getBoolean("is_exemplar_reserva"));
            retorno.setDisponivelAPartirDe(rs.getDate("disponivel_em"));
            PLivro pl = new PLivro();
            Livro l = pl.consultar(rs.getInt("id_livro"));
            retorno.setLivro(l);
        }
        return retorno;
    }
}
