/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author repez
 */
public class Exemplar {

    private int id = 0;
    private boolean disponivel = false;
    private int livroID = 0;
    private boolean exemplarReserva = true;
    private Date disponivelAPartirDe = null;

    public Exemplar() {

    }

    public Exemplar(int id, int livroID, Date disponivelAPartirDe) {
        this.id = id;
        this.livroID = livroID;
        this.disponivelAPartirDe = disponivelAPartirDe;
    }

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
     * @return the livro
     */
    public int getLivroID() {
        return livroID;
    }

    /**
     * @param livroID
     */
    public void setLivroID(int livroID) {
        this.livroID = livroID;
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

}
