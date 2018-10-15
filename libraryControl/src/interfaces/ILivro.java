/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Livro;
import java.util.ArrayList;

/**
 *
 * @author repez
 */
public interface ILivro {
    public void incluir(Livro livro) throws Exception;
    public ArrayList<Livro> listar() throws Exception;
    public void alterar(Livro livro) throws Exception;
    public Livro consultar(int parametro) throws Exception;
    public void excluir(int parametro) throws Exception;
}
