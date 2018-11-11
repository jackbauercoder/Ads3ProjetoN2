/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Emprestimo;
import java.util.ArrayList;

/**
 *
 * @author repez
 */
public interface IEmprestimo {
    public void incluir(Emprestimo emprestimo) throws Exception;
    public ArrayList<Emprestimo> listar() throws Exception;
    public void alterar(Emprestimo emprestimo) throws Exception;
    public Emprestimo consultar(int parametro) throws Exception;
    public void excluir(int parametro) throws Exception;
}
