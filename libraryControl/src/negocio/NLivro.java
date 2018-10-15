/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Livro;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PLivro;

/**
 *
 * @author repez
 */
public class NLivro {
    
    PLivro persistencia;
    
    public NLivro() {
        persistencia = new PLivro();
    }
    
    public void salvar(Livro parametro) throws SQLException, Exception {

        if (parametro.getIsbn().isEmpty()) {
            throw new Exception("É necessário informar o ISBN");
        }
        
        if (parametro.getTitulo().isEmpty()) {
            throw new Exception("É necessário informar o título");
        }
        
        if (parametro.getEditora().getId() == 0) {
            throw new Exception("É necessário informar a editora");
        }
        
        if (parametro.getAutor().getId() == 0) {
            throw new Exception("É necessário informar o autor");
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

    public Livro consultar(int parametro) throws SQLException, Exception {
        return persistencia.consultar(parametro);        
    }

    public ArrayList<Livro> listar() throws SQLException, Exception {
        return persistencia.listar();
    }
}
