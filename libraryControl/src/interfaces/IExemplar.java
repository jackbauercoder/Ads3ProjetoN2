/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Exemplar;
import java.util.ArrayList;

/**
 *
 * @author repez
 */
public interface IExemplar {
    public void incluir(Exemplar exemplar) throws Exception;
    public ArrayList<Exemplar> listar() throws Exception;
    public void alterar(Exemplar exemplar) throws Exception;
}
