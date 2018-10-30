/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Cliente;
import java.util.ArrayList;
import interfaces.ICliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author aluno
 */
public class PCliente implements ICliente{

    @Override
    public void incluir(Cliente cliente) throws Exception {
        String sql = "INSERT INTO cliente (nome, email, cpf, saldo_devedor, endereco, telefone, tipo_cliente) "
                + "VALUES (?,?,?,?,?,?)";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, cliente.getNome());
        prd.setString(2, cliente.getEmail());
        prd.setString(3, cliente.getCpf());
        prd.setString(4, String.valueOf(cliente.getSaldoDevedor()));
        prd.setString(5, cliente.getEndereco());
        prd.setString(6, cliente.getTelefone());
        prd.setString(7, cliente.getTipoCliente());
        prd.execute();
        cnn.close();
    }

    @Override
    public ArrayList<Cliente> listar() throws Exception {
        String sql = "SELECT * FROM cliente";
        Connection cnn = util.Conexao.getConexao();
        Statement st = cnn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Cliente> retorno = new ArrayList();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setEmail(rs.getString("email"));
            c.setCpf(rs.getString("cpf"));
            c.setSaldoDevedor(rs.getFloat("saldo_devedor"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            c.setTipoCliente(rs.getString("tipo_cliente"));
            retorno.add(c);
        }
        return retorno;
    }

    @Override
    public void alterar(Cliente cliente) throws Exception {
        String sql = "UPDATE cliente SET nome = ?,"
                + "set email = ?,"
                + "set telefone = ?,"
                + "set endereco = ?,"
                + "set cpf = ?,"
                + "set tipo_cliente = ?,"
                + "set saldo_devedor = ? "
                + " WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, cliente.getNome());
        prd.setString(2, cliente.getEmail());
        prd.setString(3, cliente.getTelefone());
        prd.setString(4, cliente.getEndereco());
        prd.setString(5, cliente.getCpf());
        prd.setString(6, cliente.getTipoCliente());
        prd.setFloat(7, cliente.getSaldoDevedor());
        prd.setInt(8, cliente.getId());
        prd.execute();
        cnn.close();
    }

    @Override
    public void excluir(int parametro) throws Exception {
        String sql = "DELETE FROM cliente WHERE id = ?";
        Connection cnn = util.Conexao.getConexao();
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);
        prd.execute();
        cnn.close();
    }

}


