/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Emprestimo;
import entidades.Exemplar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import interfaces.IEmprestimo;

/**
 *
 * @author repez
 */
public class PEmprestimo implements IEmprestimo {
    
    private String nomeDoArquivo = "";
    private String reserva_db = "./src/arquivos/Reservas.csv";
    private String exemplar_db = "./src/arquivos/Livros.csv";
    private String livro_db = "./src/arquivos/Exemplares.csv";
    
    
    public PEmprestimo(String nomeDoArquivo){
        this.nomeDoArquivo = nomeDoArquivo;
    }

    @Override
    public void incluir(Emprestimo emprestimo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Emprestimo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Emprestimo emprestimo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
