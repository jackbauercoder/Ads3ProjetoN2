/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Exemplar;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PExemplar;

/**
 *
 * @author repez
 */
public class NExemplar {
    
    PExemplar persistencia;

    public NExemplar() {
        persistencia = new PExemplar();
    }
    
    public void salvar(Exemplar parametro) throws SQLException, Exception {

        if (parametro.getLivro().getTitulo().isEmpty()) {
            throw new Exception("É necessário informar o livro");
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

    public Exemplar consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }
    
    public ArrayList<Exemplar> listar() throws SQLException, Exception {
        return persistencia.listar();
    }
}
