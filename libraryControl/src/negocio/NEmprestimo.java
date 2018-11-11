/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Emprestimo;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PEmprestimo;

/**
 *
 * @author repez
 */
public class NEmprestimo {
    
    PEmprestimo persistencia;
    
    public NEmprestimo() {
        persistencia = new PEmprestimo();
    }
    
    public void salvar(Emprestimo parametro) throws SQLException, Exception {

        if (parametro.getExemplar().getLivro().getTitulo().isEmpty()) {
            throw new Exception("É necessário informar o exemplar");
        }
        
        if (parametro.getCliente().getNome().isEmpty()) {
            throw new Exception("É necessário informar o cliente");
        }
        
        if (parametro.getId() == 0) {
            persistencia.incluir(parametro);
        } else {
            persistencia.alterar(parametro);
        }

    }

    public void excluir(int parametro) throws SQLException, Exception {
        persistencia.excluir(parametro);
    }

    public Emprestimo consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }
    
    public ArrayList<Emprestimo> listar() throws SQLException, Exception {
        return persistencia.listar();
    }
}
