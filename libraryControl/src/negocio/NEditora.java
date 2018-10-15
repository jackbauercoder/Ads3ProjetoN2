/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Editora;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PEditora;

/**
 *
 * @author repez
 */
public class NEditora {
    
    PEditora persistencia;

    public NEditora() {
        persistencia = new PEditora();
    }
    
    public void salvar(Editora parametro) throws SQLException, Exception {

        if (parametro.getNome().isEmpty()) {
            throw new Exception("É necessário informar o nome");
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

    public Editora consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }

    public ArrayList<Editora> listar() throws SQLException, Exception {
        return persistencia.listar();
    }
}
