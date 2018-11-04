/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author repez
 */
public class Exemplar {

    private int id = 0;
    private boolean disponivel = false;
    private Livro livro = null;
    private boolean exemplarReserva = true;
    private Date disponivelAPartirDe = null;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the disponivel
     */
    public boolean IsDisponivel() {
        return disponivel;
    }

    /**
     * @param disponivel the isDisponivel to set
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    
    /**
     * @return the exemplarFixo
     */
    public boolean isExemplarReserva() {
        return exemplarReserva;
    }

    /**
     * @param exemplarReserva the exemplarFixo to set
     */
    public void setExemplarReserva(boolean exemplarReserva) {
        this.exemplarReserva = exemplarReserva;
    }

    /**
     * @return the disponivelAPartirDe
     */
    public Date getDisponivelAPartirDe() {
        return disponivelAPartirDe;
    }

    /**
     * @param disponivelAPartirDe the disponivelEm to set
     */
    public void setDisponivelAPartirDe(Date disponivelAPartirDe) {
        this.disponivelAPartirDe = disponivelAPartirDe;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

}
