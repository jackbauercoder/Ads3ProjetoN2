/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidades.Autor;
import java.sql.SQLException;
import java.util.List;
import persistencia.PAutor;

/**
 *
 * @author jhene
 */
public class NAutor {
    PAutor persistencia;

    public NAutor() {
        persistencia = new PAutor();
    }

    public void salvar(Autor parametro) throws SQLException, Exception {

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

    public Autor consultar(int parametro) throws SQLException {
        return persistencia.consultar(parametro);        
    }
    
    public Autor consultar(String parametro) throws SQLException {
        return persistencia.consultar(parametro);        
    }

    public List<Autor> listar() throws SQLException, Exception {
        return persistencia.listar();
    }
    
}
