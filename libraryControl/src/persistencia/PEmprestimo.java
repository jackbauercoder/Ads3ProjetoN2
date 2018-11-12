/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import entidades.Emprestimo;
import entidades.Exemplar;
import entidades.Livro;
import java.util.ArrayList;
import interfaces.IEmprestimo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author repez
 */
public class PEmprestimo implements IEmprestimo {
    
    @Override
    public void incluir(Emprestimo emprestimo) throws Exception {
        String sql = "INSERT INTO emprestimo (data_emprestimo, data_devolucao, is_ativo, id_exemplar, id_cliente) "
                + "VALUES (?,?,?,?,?)";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setDate(1, emprestimo.getDataEmprestimo());
        prd.setDate(2, emprestimo.getDataDevolucao());
        prd.setBoolean(3, emprestimo.isAtivo());
        prd.setInt(4, emprestimo.getExemplar().getId());
        prd.setInt(5, emprestimo.getCliente().getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Emprestimo> listar() throws Exception {
        String sql = "SELECT * FROM emprestimo";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Emprestimo> retorno = new ArrayList();
        while (rs.next()) {
            Emprestimo emp = new Emprestimo();
            emp.setId(rs.getInt("id"));
            emp.setIsAtivo(rs.getBoolean("is_ativo"));
            emp.setDataDevolucao(rs.getDate("data_devolucao"));
            emp.setDataEmprestimo(rs.getDate("data_emprestimo"));
            emp.setId(rs.getInt("id"));
            emp.setId(rs.getInt("id"));
            
            PExemplar pe = new PExemplar();
            Exemplar ex = pe.consultar(rs.getInt("id_exemplar"));
            emp.setExemplar(ex);
            
            PCliente pc = new PCliente();
            Cliente cli = pc.consultar(rs.getInt("id_cliente"));
            emp.setCliente(cli);
            
            retorno.add(emp);
        }
        return retorno;
    }

    @Override
    public void alterar(Emprestimo emprestimo) throws Exception {
        String sql = "UPDATE exemplar set is_ativo = ?, data_devolucao = ?, data_emprestimo = ?, id_cliente = ?, id_exemplar where id = ?;";

        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setBoolean(1, emprestimo.isAtivo());
        prd.setDate(2, emprestimo.getDataDevolucao());
        prd.setDate(3, emprestimo.getDataEmprestimo());
        prd.setInt(4, emprestimo.getCliente().getId());
        prd.setInt(5, emprestimo.getExemplar().getId());
        prd.setInt(6, emprestimo.getId());
        
        prd.execute();
        cnn.close();
    }

    @Override
    public Emprestimo consultar(int parametro) throws Exception {
        String sql = " SELECT * FROM exemplar WHERE id = ?;";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        ResultSet rs = prd.executeQuery();
        Emprestimo retorno = new Emprestimo();
        if (rs.next()) {
            retorno.setId(rs.getInt("id"));
            retorno.setIsAtivo(rs.getBoolean("is_ativo"));
            retorno.setDataDevolucao(rs.getDate("data_devolucao"));
            retorno.setDataEmprestimo(rs.getDate("data_emprestimo"));
            
            PExemplar pe = new PExemplar();
            Exemplar ex = pe.consultar(rs.getInt("id_exemplar"));
            retorno.setExemplar(ex);
            
            PCliente pc = new PCliente();
            Cliente cli = pc.consultar(rs.getInt("id_cliente"));
            retorno.setCliente(cli);
        }
        return retorno;
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM emprestimo WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }
    
    
}
